package me.game.entity.impl.bot;

import me.game.Game;
import me.game.entity.IEntity;
import me.game.utils.Facing;
import me.game.utils.Vector2;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adrian
 * @since
 */
public class EntityBot implements IEntity {

    protected Vector2 position;

    protected Facing direction;

    private ArrayList<Node> openNodes;

    public EntityBot(Vector2 position) {
        this.position = position;
        openNodes = new ArrayList();
    }

    @Override
    public void preUpdate() {
        openNodes.clear();
        for (Facing facing : Facing.values()) {
            Optional<Vector2> tile = Game.get().getBoard().findTile(new Vector2(position.getPosX() + facing.dX, position.getPosY() + facing.dY));
            tile.ifPresent(vec -> {
                if (!vec.getPreviousEntity().isPresent())
                    openNodes.add(new Node(vec));
            });
        }

    }

    @Override
    public void postUpdate() {

    }

    @Override
    public void renderBody() {

    }

    @Override
    public void renderTrail(Vector2 pos) {

    }
}
