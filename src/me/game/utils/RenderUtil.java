package me.game.utils;

import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class RenderUtil {

    public static void drawTile(Vector2 pos) {
        drawQuad(pos.getPosX() * 10, pos.getPosY() * 10, pos.getPosX() * 10 + 10, pos.getPosY() * 10 + 10);
    }

    public static void drawQuad(int x1, int y1, float x2, float y2) {
        GL11.glColor3f(0, 255, 255);
        glBegin(GL_QUADS);
        glVertex2f(x1, y1);
        glVertex2f(x1, y2);
        glVertex2f(x2, y2);
        glVertex2f(x2, y1);
        glEnd();
    }
}
