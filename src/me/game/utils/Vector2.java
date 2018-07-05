package me.game.utils;

import me.game.Game;
import me.game.entity.IEntity;
import me.game.entity.impl.bot.EntityBot;
import me.game.entity.impl.player.EntityPlayer;

import java.util.Optional;

public class Vector2 {

    private int posX;
    private int posY;

    private Optional<IEntity> previousEntity;

    public Vector2(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        previousEntity = Optional.empty();
    }

    public void setPos(Vector2 position) {
        this.posX = position.posX;
        this.posY = position.posY;
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

    public void setPreviousEntity(Optional<IEntity> previousEntity) {
        this.previousEntity.ifPresent(a -> {
            if (!(a instanceof EntityPlayer && (((EntityPlayer) a).getDirection() == Facing.STATIC || ((EntityPlayer) a).isDead))) {
                ((EntityPlayer) a).setDead(true);
                Game.get().stop();
                System.out.println("stoped");
            }
        });
        this.previousEntity = previousEntity;
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
