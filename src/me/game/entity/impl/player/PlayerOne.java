package me.game.entity.impl.player;

import static me.game.utils.RenderUtil.*;
import static org.lwjgl.glfw.GLFW.*;

import me.game.utils.Facing;
import me.game.utils.InputHandler;
import me.game.utils.Vector2;

import java.awt.*;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class PlayerOne extends EntityPlayer {

    public PlayerOne(Vector2 pos) {
        super(pos);
    }

    private Facing direction = Facing.STATIC;

    @Override
    public void preUpdate() {
        super.preUpdate();
        if (InputHandler.keyDown(GLFW_KEY_W)) {
            direction = Facing.UP;
        }

        if (InputHandler.keyDown(GLFW_KEY_S)) {
            direction = Facing.DOWN;
        }

        if (InputHandler.keyDown(GLFW_KEY_A)) {
            direction = Facing.LEFT;
        }

        if (InputHandler.keyDown(GLFW_KEY_D)) {
            direction = Facing.RIGHT;
        }
    }

    @Override
    public void postUpdate() {
        super.postUpdate();
        position.addX(direction.dX);
        position.addY(direction.dY);
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
