package game.Model;

public class Player implements Entity {
    private Position position;
    private Direction queuedDir; // Pending movement
    private TeleportType queuedTp; // Pending teleport
    private int safeTeleports = 0;

    public Player(Position pos) {
        this.position = pos;
        this.queuedDir = null;
        this.queuedTp = null;
    }

    public void queueMove(Direction d) {
        queuedDir = d;
    }

    public void queueTeleport(TeleportType tp) {
        queuedTp = tp;
    }

    public void addSafeTeleport() {
        safeTeleports++;
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
        if (queuedTp != null) {
            switch (queuedTp) {
                case RANDOM_TELEPORT:
                    env.teleportRandom(this);
                    queuedTp = null;
                    queuedDir = null;
                    return;
                case SAFE_TELEPORT:
                    queuedTp = null;
                    return;
            }
        }

        if (queuedDir != null) {
            Position to = position.move(queuedDir);
            env.tryStep(this, to);
            queuedDir = null;
        }
    }

    @Override
    public boolean isDeadly() {
        return false;
    }

    @Override
    public boolean isPlayable() {
        return true;
    }

    public void teleportToPosition(Environment env, Position to) {
        if (safeTeleports > 0) {
            env.teleport(this, to);
            safeTeleports--;
        }
    }

    public int getSafeTeleports() {
        return safeTeleports;
    }

    @Override
    public void accept(EntityVisitor visitor) {
        visitor.visit(this);
    }
}