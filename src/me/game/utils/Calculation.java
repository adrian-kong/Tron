package me.game.utils;

import me.game.Game;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @author Adrian
 * @since
 */
public class Calculation {

    public Queue<Vector2> queue = new ConcurrentLinkedDeque();

    public void floodFill(Vector2 starting) {
        new Thread() {
            @Override
            public void run() {
                queue.add(starting);
                while (!queue.isEmpty()) {
                    Vector2 first = queue.remove();
                    for (Facing facing : Facing.values()) {
                        Optional<Vector2> temp = Game.get().getBoard().findTile(new Vector2(first.getPosX() + facing.dX, first.getPosY() + facing.dY));
                        if (temp.isPresent() && !temp.get().getPreviousEntity().isPresent() && !queue.contains(temp.get())) {
                            queue.add(temp.get());
                        }
                    }
                }
            }
        }.start();
    }
}
