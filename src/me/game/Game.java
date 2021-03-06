package me.game;

import me.game.board.Board;
import me.game.utils.TimerUtil;

public class Game {

    public static Game INTANCE = new Game();
    private final TimerUtil gameTimer = new TimerUtil();

    private Board board;

    public static Game get() {
        return INTANCE;
    }

    public Game() {
        this.board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public void stop() {
        getBoard().stop();
    }

    public void update() {
        board.preUpdate();
        if (gameTimer.hasReachedMs(25)) {
            board.postUpdate();
            gameTimer.reset();
        }
    }

    public void render() {
        board.render();
    }

}
