package me.game.entity.impl.player;

import me.game.entity.IEntity;
import me.game.utils.Facing;
import me.game.utils.Vector2;

import static me.game.utils.RenderUtil.*;

import java.awt.*;

public abstract class EntityPlayer implements IEntity {

    protected Vector2 position;

    protected Facing direction = Facing.STATIC;

    protected Facing prevDirection = direction;

    private Color bColour, tColour;

    public boolean isDead = false;

    private Vector2 initialPosition;

    public EntityPlayer(Vector2 position, Color bColour, Color tColour) {
        this.position = position;
        this.bColour = bColour;
        this.tColour = tColour;
        this.initialPosition = new Vector2(position.getPosX(), position.getPosY());
    }

    @Override
    public void postUpdate() {
        position.addX(direction.dX);
        position.addY(direction.dY);
        prevDirection = direction;
    }

    @Override
    public void renderBody() {
        drawTile(position, bColour);
    }

    @Override
    public void renderTrail(Vector2 pos) {
        drawTile(pos, tColour);
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

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        if (dead) {
            position.setPos(initialPosition);
            direction = Facing.STATIC;
        }
        isDead = dead;
    }
}
