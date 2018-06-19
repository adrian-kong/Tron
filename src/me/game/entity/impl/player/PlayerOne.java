package me.game.entity.impl.player;

import static me.game.utils.RenderUtil.*;
import static org.lwjgl.glfw.GLFW.*;

import me.game.utils.InputHandler;
import me.game.utils.Vector2;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class PlayerOne extends EntityPlayer {

    public PlayerOne(Vector2 pos) {
        super(pos);
    }

    @Override
    public void update() {
        super.update();

        if (InputHandler.keyPressed(GLFW_KEY_W)) {
            position.addY(-1);
        }

        if (InputHandler.keyPressed(GLFW_KEY_A)) {
            position.addX(-1);
        }

        if (InputHandler.keyPressed(GLFW_KEY_S)) {
            position.addY(1);
        }

        if (InputHandler.keyPressed(GLFW_KEY_D)) {
            position.addX(1);
        }
    }

    @Override
    public void render() {
        super.render();
        drawTile(position);
    }
}
