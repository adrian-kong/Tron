package me.game.entity.impl.player;

import static me.game.utils.RenderUtil.*;
import static org.lwjgl.glfw.GLFW.*;

import me.game.utils.Movement;
import me.game.utils.Vector2;

import java.awt.*;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class PlayerOne extends EntityPlayer {

    private Movement movement = new Movement(this, GLFW_KEY_W, GLFW_KEY_S, GLFW_KEY_A, GLFW_KEY_D);

    public PlayerOne(Vector2 pos) {
        super(pos);
    }

    @Override
    public void preUpdate() {
        super.preUpdate();
        movement.update();
    }

    @Override
    public void postUpdate() {
        super.postUpdate();
        position.addX(direction.dX);
        position.addY(direction.dY);
        prevDirection = direction;
    }

    @Override
    public void renderBody() {
        super.renderBody();
        drawTile(position, new Color(59, 59, 152));
    }

    @Override
    public void renderTrail(Vector2 position) {
        drawTile(position, new Color(24, 44, 97));
    }
}
