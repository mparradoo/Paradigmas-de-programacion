package game.View;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class Sprite {
    private final Image spritesheet;
    private final int rows;
    private final int cols;
    private final long delay;
    private int currentFrame;
    private long lastUpdate;

    public Sprite(Image spritesheet, int rows, int cols, long delay) {
        this.spritesheet = spritesheet;
        this.rows = rows;
        this.cols = cols;
        this.delay = delay;
        this.currentFrame = 0;
        this.lastUpdate = System.nanoTime();
    }

    public void update() {
        long now = System.nanoTime();
        if (now - lastUpdate >= delay) {
            currentFrame++;
            if (currentFrame >= rows * cols) {
                currentFrame = 0;
            }
            lastUpdate = now;
        }
    }

    public void draw(GraphicsContext gc, int spriteIndex, int cellSize, double x, double y) {
        int frameWidth = (int) (spritesheet.getWidth() / cols);
        int frameHeight = (int) (spritesheet.getHeight());

        gc.drawImage(
                spritesheet,
                spriteIndex * frameWidth, 0, frameWidth, frameHeight,
                x, y, cellSize, cellSize
        );
    }
}