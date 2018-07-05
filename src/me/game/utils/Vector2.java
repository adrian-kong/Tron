package me.game.utils;

import me.game.Game;
import me.game.entity.IEntity;
import me.game.entity.impl.player.EntityPlayer;

import java.util.Optional;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class Vector2 {

    private int posX;
    private int posY;

    private Optional<IEntity> previousEntity = Optional.empty();

    public Vector2(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Optional<IEntity> getPreviousEntity() {
        return previousEntity;
    }

    public void addX(int posX) {
        this.posX += posX;
    }

    public void addY(int posY) {
        this.posY += posY;
    }

    public void setPreviousEntity(IEntity previousEntity) {
        this.previousEntity.ifPresent(a -> {
            if (!(a instanceof EntityPlayer && ((EntityPlayer) a).getDirection() == Facing.STATIC))
                Game.get().stop();
        });
        this.previousEntity = Optional.of(previousEntity);
    }

    @Override
    public String toString() {
        return "[ " + getPosX() + ":" + getPosY() + " ]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vector2 ? ((Vector2) obj).posX == posX && ((Vector2) obj).posY == posY : super.equals(obj);
    }
}
