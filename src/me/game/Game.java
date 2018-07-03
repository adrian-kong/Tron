package me.game;

import me.game.board.Board;
import me.game.utils.TimerUtil;


/**
 * @author Adrian
 * @since 19/06/18
 */
public class Game {

    public static Game INTANCE = new Game();
    private final Board board = new Board();
    private final TimerUtil gameTimer = new TimerUtil();

    public static Game get() {
        return INTANCE;
    }

    public Board getBoard() {
        return board;
    }

    public void stop() {
    }

    public void update() {
        board.preUpdate();
            board.postUpdate();
    }

    public void render() {
        board.render();
    }

}
