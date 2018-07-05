package me;

import me.game.Game;

import static me.game.utils.InputHandler.*;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Main {

    private long window;

    private final int WIDTH = 800;
    private final int HEIGHT = 800;

    private Game game;

    public void run() {
        init();
        loop();
        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);
        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void init() {
        GLFWErrorCallback.createPrint(System.err).set();
        if (!glfwInit())
            throw new IllegalStateException("Unable to initialize GLFW");
        glfwDefaultWindowHints();
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        window = glfwCreateWindow(WIDTH, HEIGHT, "TRON", NULL, NULL);
        if (window == NULL)
            throw new RuntimeException("Failed to create the GLFW window");
        initInput(window);

        glfwSetKeyCallback(window, keyboard);
        glfwSetMouseButtonCallback(window, mouse);
        try (MemoryStack stack = stackPush()) {
            IntBuffer pWidth = stack.mallocInt(1);
            IntBuffer pHeight = stack.mallocInt(1);
            glfwGetWindowSize(window, pWidth, pHeight);
            GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
            glfwSetWindowPos(window, (vidmode.width() - pWidth.get(0)) / 2, (vidmode.height() - pHeight.get(0)) / 2);
        }
        glfwMakeContextCurrent(window);
        glfwSwapInterval(1);
        glfwShowWindow(window);
        game = Game.get();
    }

    private void loop() {
        GL.createCapabilities();
        glClearColor(0.15f, 0.15f, 0.15f, 0);
        while (!glfwWindowShouldClose(window)) {
            glMatrixMode(GL_MODELVIEW);
            glLoadIdentity();
            GL11.glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
            update();
            render();
        }
    }

    private void update() {
        updateHandler();
        game.update();
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
    }

    private void render() {
        game.render();
        glfwSwapBuffers(window);
    }

    public static void main(String[] args) {
        new Main().run();
    }
}