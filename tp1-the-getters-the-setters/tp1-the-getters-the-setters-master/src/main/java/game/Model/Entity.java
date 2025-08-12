package game.Model;

public interface Entity {
    Position getPosition();

    void setPosition(Position p);

    void act(Environment env);

    boolean isDeadly();

    boolean isPlayable();

    void accept(EntityVisitor visitor);
}