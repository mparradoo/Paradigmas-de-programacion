package game.Model;

public interface EntityVisitor {
    void visit(Player player);

    void visit(Robotx1 robot);

    void visit(Robotx2 robot);
}