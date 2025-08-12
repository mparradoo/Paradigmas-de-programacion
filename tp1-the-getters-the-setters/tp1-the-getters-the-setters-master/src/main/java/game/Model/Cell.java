package game.Model;

public class Cell {
    private final Position position;
    private boolean onFire;
    private boolean hasResources;
    private Entity entity;

    public Cell(Position position) {
        this.position = position;
    }

    public boolean isOnFire() {
        return onFire;
    }

    public void setOnFire(boolean onFire) {
        this.onFire = onFire;
    }

    public boolean isHasResources() {
        return hasResources;
    }

    public void setHasResources(boolean hasResources) {
        this.hasResources = hasResources;
    }

    public void collectResource() {
        this.hasResources = false;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public void deleteEntity() {
        entity = null;
    }

    public boolean hasEntity() {
        return entity != null;
    }

    public Position getPosition() {
        return position;
    }
}
