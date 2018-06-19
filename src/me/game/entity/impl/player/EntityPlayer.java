package me.game.entity.impl.player;

import me.game.entity.Entity;
import me.game.utils.Vector2;

/**
 * @author Adrian
 * @since 19/06/18
 */
public abstract class EntityPlayer implements Entity {

    protected Vector2 position;

    public EntityPlayer(Vector2 position) {
        this.position = position;
    }

    @Override
    public void update() {
    }

    @Override
    public void render() {
    }

    public Vector2 getPosition() {
        return position;
    }
}
