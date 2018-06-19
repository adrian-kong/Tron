package me.game;

import me.game.board.Board;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class Game {

    public static Game INTANCE = new Game();
    private final Board board = new Board();

    public static Game get() {
        return INTANCE;
    }

    public Board getBoard() {
        return board;
    }

    public void stop() {
    }

    public void update() {
        board.update();
    }

    public void render() {
        board.render();
    }

}
