package game.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private final List<GameObserver> observers = new ArrayList<>();
    private Board board;
    private State state = State.PLAYING;
    private int currentLevel = 1;
    private int totalScore;

    /* ============================   Init Game   ============================= */
    public void startLevel(int cols, int rows, int numRobots, int numResources) {
        board = new Board(cols, rows);
        initPlayer(cols, rows);
        initRobots(numRobots);
        initResources(numResources);
        state = State.PLAYING;

    }

    public void nextLevel(int cols, int rows, int numRobots, int numResources) {
        currentLevel++;

        // Stores the current player
        Player oldPlayer = board.getPlayer();

        board = new Board(cols, rows);

        // Reuse the old player, but reset its position
        oldPlayer.setPosition(new Position(cols / 2, rows / 2));
        board.setPlayer(oldPlayer);

        oldPlayer.addSafeTeleport(); // Increments the number of safe teleports

        initRobots(numRobots);
        initResources(numResources);

        state = State.PLAYING;
    }

    private void initPlayer(int cols, int rows) {
        Position pos = new Position(cols / 2, rows / 2);
        board.setPlayer(new Player(pos));
    }

    private Robot randomRobot(Position pos) {
        double probabilityX2 = Math.min(0.1 * currentLevel, 0.9); // Max 90% of x2
        if (Math.random() < probabilityX2) {
            return new Robotx2(pos);
        } else {
            return new Robotx1(pos);
        }
    }

    private void initRobots(int amount) {
        for (int i = 0; i < amount; i++) {
            Position p = board.randomEmpty();
            board.addRobot(randomRobot(p));
        }
    }

    private void blockNearbyCells(Position p, boolean[][] blocked) {
        int x = p.getX(), y = p.getY();
        for (int dx = -3; dx <= 3; dx++) {
            for (int dy = -3; dy <= 3; dy++) {
                int nx = x + dx;
                int ny = y + dy;

                if (nx >= 0 && ny >= 0 &&
                        nx < board.getCols() && ny < board.getRows() &&
                        Math.abs(dx) + Math.abs(dy) <= 3) {
                    blocked[nx][ny] = true;
                }
            }
        }
    }

    private Position findValidResourcePosition(boolean[][] blocked) {
        Random rand = new Random();
        int x, y;
        int attempts = 0;
        int maxAttempts = 100;
        while (attempts < maxAttempts) {
            x = rand.nextInt(board.getCols());
            y = rand.nextInt(board.getRows());
            Position p = new Position(x, y);
            if (!board.getCell(p).hasEntity()
                    && !board.getCell(p).isHasResources()
                    && !blocked[x][y]) {
                return p;
            }
            attempts++;
        }
        return null;
    }

    private boolean placeResource(boolean[][] blocked) {
        Position p = findValidResourcePosition(blocked);
        if (p != null) {
            board.addResource(p);
            blockNearbyCells(p, blocked);
            return true;
        }
        return false;
    }

    private void initResources(int amount) {
        boolean[][] blocked = new boolean[board.getCols()][board.getRows()];
        int placedResources = 0;

        while (placedResources < amount) {
            if (!placeResource(blocked)) {
                // Cannot place more resources
                break;
            }
            placedResources++;
        }
    }

    /* ============================   Game States   =========================== */
    public enum State {PLAYING, LEVEL_COMPLETED, GAME_OVER}

    private void processPlayerActions() {
        board.getPlayer().act(board);
    }

    private void processRobotsActions() {
        for (Robot r : new ArrayList<>(board.getRobots())) {
            r.act(board);
        }
    }

    private void setGameOver() {
        this.state = State.GAME_OVER;
        this.totalScore = 0;
    }

    private void checkPlayerOnFire() {
        if (board.getCell(board.getPlayerPos()).isOnFire()) {
            setGameOver();
        }
    }

    private void checkLevelCompleted() {
        if (board.getRobots().isEmpty() || board.getResources() == 0) {
            state = State.LEVEL_COMPLETED;
        }
    }

    /* ============================   Game Cicle   ============================ */
    public void nextTurn() {
        // 1°) Procesar el movimiento del jugador
        processPlayerActions();
        // 2°) Permitir a los robot actuar
        processRobotsActions();
        // 3°) Comprobar si el jugador está en la misma posición que un robot
        if (isPlayerInRobotPosition()) {
            setGameOver();
            return;
        }
        // 4°) Chequeo de colisiones después de que todos han actuado
        board.resolveCollisions();
        // 5°) Chequear si el jugador está en fuego
        checkPlayerOnFire();
        // 6°) Comprobar si se han recolectado todos los recursos o si no hay más robots
        checkLevelCompleted();


        totalScore += board.getScore();
        board.resetScore();
        // Notificar a los observadores para actualizar la UI
        notifyObservers();
    }

    private boolean isPlayerInRobotPosition() {
        Position playerPos = board.getPlayerPos();
        for (Robot robot : board.getRobots()) {
            if (robot.getPosition().equals(playerPos)) {
                return true; // The player is in the same position as a robot
            }
        }
        return false;
    }

    /* =============================   UI API   =============================== */
    public void queuePlayerMove(Direction d) {
        board.getPlayer().queueMove(d);
    }

    public void queuePlayerTeleport(TeleportType tp) {
        Player player = board.getPlayer();
        player.queueTeleport(tp);
        player.act(board);
    }

    public State getState() {
        return state;
    }

    public Board getBoard() {
        return board;
    }

    public int getLevel() {
        return currentLevel;
    }

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (GameObserver obs : observers) {
            obs.onModelUpdate();
        }
    }

    public int getTotalScore() {
        return totalScore;
    }
}