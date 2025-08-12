package game.Model;

import java.util.*;

public class Board implements Environment {
    private final int rows;
    private final int cols;
    private final Cell[][] cells;
    private final List<Robot> robots = new ArrayList<>();
    private int numResources;
    private Player player;
    private int score;

    /* ===========================   Construction   =========================== */
    public Board(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        this.cells = new Cell[cols][rows];
        initCells();
    }

    private void initCells() {
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                cells[i][j] = new Cell(new Position(i, j));
            }
        }
    }

    public void addResource(Position p) {
        if (!isInRange(p)) return;
        cells[p.getX()][p.getY()].setHasResources(true);
        numResources++;
    }

    /* ====================   Environment implementation   ==================== */

    private void checkResourceCollection(Entity e, Cell dest) {
        if (e.isPlayable() && dest.isHasResources()) {
            dest.collectResource();
            numResources--;
            addToScore(1);
        }
    }

    // Moves the entity if possible
    @Override
    public boolean tryStep(Entity e, Position to) {
        if (!isInRange(to)) return false;

        Cell dest = cells[to.getX()][to.getY()];

        if (e.isDeadly() && dest.isHasResources()) return false;

        if (e.isDeadly() && getCell(e.getPosition()).isOnFire()) {
            return false;
        }

        // Update the entity's position in the cell
        Cell from = cells[e.getPosition().getX()][e.getPosition().getY()];
        from.deleteEntity();
        dest.setEntity(e);
        e.setPosition(to);

        // Collect resources if any
        checkResourceCollection(e, dest);
        return true;
    }

    @Override
    public Position getPlayerPos() {
        return player.getPosition();
    }

    @Override
    public Position randomEmpty() {
        Random rnd = new Random();
        Position p;
        do {
            p = new Position(rnd.nextInt(cols), rnd.nextInt(rows));
        } while (cells[p.getX()][p.getY()].hasEntity());
        return p;
    }

    @Override
    public void teleport(Entity e, Position to) {
        if (!isInRange(to)) return;

        Cell old = cells[e.getPosition().getX()][e.getPosition().getY()];
        old.deleteEntity();

        Cell dest = cells[to.getX()][to.getY()];
        dest.setEntity(e);
        e.setPosition(to);

        checkResourceCollection(e, dest);
    }

    @Override
    public void teleportRandom(Entity e) {
        teleport(e, randomEmpty());
    }


    /* =============================   Helpers   ============================== */
    private boolean isInRange(Position p) {
        return p.getX() >= 0 && p.getX() < cols &&
                p.getY() >= 0 && p.getY() < rows;
    }

    /* ====================   Environment implementation   ==================== */
    /* ==================   Setters/Getters to use in Game   ================== */
    public void setPlayer(Player p) {
        this.player = p;
        cells[p.getPosition().getX()][p.getPosition().getY()].setEntity(p);
    }

    public Player getPlayer() {
        return player;
    }

    public void addRobot(Robot r) {
        robots.add(r);
        cells[r.getPosition().getX()][r.getPosition().getY()].setEntity(r);
    }

    public List<Robot> getRobots() {
        return robots;
    }

    // Check collisions between robots
    public void resolveCollisions() {
        Map<Position, Integer> count = new HashMap<>();
        for (Robot r : robots) {
            count.merge(r.getPosition(), 1, Integer::sum);
        }

        Set<Position> boom = new HashSet<>();
        for (var entry : count.entrySet()) {
            if (entry.getValue() > 1) {
                Position pos = entry.getKey();
                boom.add(pos);
                cells[pos.getX()][pos.getY()].setOnFire(true);
            }
        }

        robots.removeIf(r -> boom.contains(r.getPosition()) || cells[r.getPosition().getX()][r.getPosition().getY()].isOnFire());
    }

    public void addToScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Cell getCell(Position p) {
        return cells[p.getX()][p.getY()];
    }

    public int getResources() {
        return numResources;
    }
}