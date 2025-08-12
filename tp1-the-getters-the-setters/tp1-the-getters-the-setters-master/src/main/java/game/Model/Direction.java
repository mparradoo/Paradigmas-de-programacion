package game.Model;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    RIGHT(1, 0),
    LEFT(-1, 0),
    UP_LEFT(-1, -1),
    UP_RIGHT(1, -1),
    DOWN_LEFT(-1, 1),
    DOWN_RIGHT(1, 1),
    NONE(0, 0);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public static Direction toward(Position from, Position to) {
        int stepX = Integer.compare(to.getX(), from.getX());   // -1, 0 ó 1
        int stepY = Integer.compare(to.getY(), from.getY());

        for (Direction d : values()) {
            if (d.dx == stepX && d.dy == stepY) return d;
        }
        return NONE;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }
}