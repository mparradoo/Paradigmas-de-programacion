package game.Model;

public abstract class Robot implements Entity {
    protected Position position;
    protected abstract int speed();

    public Robot(Position pos) {
        this.position = pos;
    }

    private boolean moveOneStepTowardPlayer(Environment env) {
        Direction dir = getDirectionTowardPlayer(env);
        if (dir == Direction.NONE) return false;

        Position next = position.move(dir);
        return env.tryStep(this, next);
    }

    private Direction getDirectionTowardPlayer(Environment env) {
        return Direction.toward(position, env.getPlayerPos());
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position p) {
        this.position = p;
    }

    @Override
    public void act(Environment env) {
        for (int i = 0; i < speed(); i++) {
            if (!moveOneStepTowardPlayer(env)) {
                return;
            }
        }
    }

    @Override
    public boolean isDeadly() {
        return true;
    }

    @Override
    public boolean isPlayable() {
        return false;
    }
}