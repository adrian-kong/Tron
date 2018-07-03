package me.game.utils;

import java.awt.*;

import static org.lwjgl.opengl.GL11.*;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class RenderUtil {

    public static void drawTile(Vector2 pos, Color colour) {
        drawQuad(pos.getPosX() * 10, pos.getPosY() * 10, pos.getPosX() * 10 + 10, pos.getPosY() * 10 + 10, colour);
    }

    public static void drawQuad(int x1, int y1, float x2, float y2, Color colour) {
        glColor4f(colour.getRed() / 255f, colour.getGreen() / 255f, colour.getBlue() / 255f, colour.getAlpha() / 255f);
        glBegin(GL_QUADS);
        glVertex2f(x1, y1);
        glVertex2f(x1, y2);
        glVertex2f(x2, y2);
        glVertex2f(x2, y1);
        glEnd();
    }
}
