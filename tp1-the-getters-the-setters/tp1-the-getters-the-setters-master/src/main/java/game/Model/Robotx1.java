package game.Model;

public class Robotx1 extends Robot {
    public Robotx1(Position pos) {
        super(pos);
    }

    @Override
    protected int speed() {
        return 1;
    }

    @Override
    public void accept(EntityVisitor visitor) {
        visitor.visit(this);
    }
}