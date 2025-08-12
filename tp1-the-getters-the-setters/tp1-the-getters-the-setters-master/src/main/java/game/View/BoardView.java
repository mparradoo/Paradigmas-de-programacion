package game.View;

import game.Model.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class BoardView extends Canvas implements GameObserver {
    private final Board board;
    private final GraphicsContext gc;
    private final int cellSize;
    private final Sprite spriteSheet;

    public BoardView(Board board) {
        this.board = board;
        this.gc = this.getGraphicsContext2D();
        Image sheet = new Image(getClass().getResource("/images/robots_con_diamante.png").toExternalForm());
        this.spriteSheet = new Sprite(sheet, 1, 15, 200_000_000);

        // Set a minimum cell size
        int maxCanvasSize = 500;
        this.cellSize = Math.max(20, maxCanvasSize / Math.max(board.getRows(), board.getCols()));

        // Set canvas dimension
        setWidth(board.getCols() * cellSize);
        setHeight(board.getRows() * cellSize);

        widthProperty().addListener((obs, oldVal, newVal) -> draw());
        heightProperty().addListener((obs, oldVal, newVal) -> draw());

        draw();
    }

    @Override
    public void onModelUpdate() {
        draw(); } // Redraw the Board when starting a new level

    private void drawCells() {
        for (int col = 0; col < board.getCols(); col++) {
            for (int row = 0; row < board.getRows(); row++) {
                drawCell(col, row);
            }
        }
    }

    private void drawRobots() {
        for (Robot robot : board.getRobots()) {
            drawEntity(robot);
        }
    }

    private void drawPlayer() {
        Player player = board.getPlayer();
        if (player != null) {
            drawEntity(player);
        }
    }

    public void draw() {
        gc.clearRect(0, 0, getWidth(), getHeight()); // Limpia el canvas

        drawCells();
        drawRobots();
        drawPlayer();
    }

    private void drawCellBackground(int col, int row) {
        gc.setFill((row + col) % 2 == 0 ? Color.LIGHTGRAY : Color.DARKGRAY);
        gc.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
    }

    private void drawSprite(int spriteIndex, int col, int row) {
        spriteSheet.draw(gc, spriteIndex, cellSize, col * cellSize, row * cellSize);
    }

    private void drawCellResources(Cell cell, int col, int row) {
        if (cell.isHasResources()) {
            int diamondIndex = 14;
            drawSprite(diamondIndex, col, row);
        }
    }

    private void drawCellFire(Cell cell, int col, int row) {
        if (cell.isOnFire()) {
            int fireIndex = 13;
            drawSprite(fireIndex, col, row);
        }
    }

    private void drawCell(int col, int row) {
        Cell cell = board.getCell(new Position(col, row));
        drawCellBackground(col, row);
        drawCellResources(cell, col, row);
        drawCellFire(cell, col, row);
    }

    private void drawEntity(Entity entity) {
        SpriteIndexVisitor visitor = new SpriteIndexVisitor();
        int spriteIndex = visitor.getSpriteIndex(entity);

        spriteSheet.update();

        double x = entity.getPosition().getX() * cellSize;
        double y = entity.getPosition().getY() * cellSize;

        spriteSheet.draw(gc, spriteIndex, cellSize, x, y);
    }

    public int getCellSize() {
        return cellSize;
    }
}