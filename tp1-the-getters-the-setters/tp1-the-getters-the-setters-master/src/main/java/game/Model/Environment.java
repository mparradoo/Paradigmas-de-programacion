package game.Model;

public interface Environment {

    /* ──────────── Movement ──────────── */
    /**
     * Tries to move the entity one step in the given direction.
     *
     * @return true if the entity performed the step, false otherwise.
     */
    boolean tryStep(Entity e, Position to);

    /* ─────────── Information ─────────── */
    Position getPlayerPos();

    Position randomEmpty();

    /* ──────────── Teleport ───────────── */
    void teleport(Entity e, Position to); // safe

    void teleportRandom(Entity e);

}