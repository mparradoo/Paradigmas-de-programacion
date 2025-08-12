package game.Model;

public class Robotx2 extends Robot {
    public Robotx2(Position pos) {
        super(pos);
    }

    @Override
    protected int speed() {
        return 2;
    }

    @Override
    public void accept(EntityVisitor visitor) {
        visitor.visit(this);
    }
}