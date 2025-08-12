package game.View;

import game.Model.*;

public class SpriteIndexVisitor implements EntityVisitor {
    private int spriteIndex;

    public int getSpriteIndex(Entity entity) {
        entity.accept(this);
        return spriteIndex;
    }

    @Override
    public void visit(Player player) {
        spriteIndex = 0;
    }

    @Override
    public void visit(Robotx1 robot) {
        spriteIndex = 5;
    }

    @Override
    public void visit(Robotx2 robot) {
        spriteIndex = 10;
    }
}