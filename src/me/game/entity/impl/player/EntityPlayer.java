package me.game.entity.impl.player;

import me.game.entity.IEntity;
import me.game.utils.Facing;
import me.game.utils.Vector2;

/**
 * @author Adrian
 * @since 19/06/18
 */
public abstract class EntityPlayer implements IEntity {

    protected Vector2 position;

    protected Facing direction = Facing.STATIC;

    protected Facing prevDirection = direction;

    public EntityPlayer(Vector2 position) {
        this.position = position;
    }

    @Override
    public void preUpdate() {
    }

    @Override
    public void postUpdate() {
    }

    @Override
    public void renderBody() {
    }

    public Vector2 getPosition() {
        return position;
    }

    public Facing getDirection() {
        return direction;
    }

    public void setDirection(Facing direction) {
        this.direction = direction;
    }

    public Facing getPrevDirection() {
        return prevDirection;
    }

    public void setPrevDirection(Facing prevDirection) {
        this.prevDirection = prevDirection;
    }
}
