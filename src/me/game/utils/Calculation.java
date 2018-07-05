package me.game.utils;

import me.game.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Adrian
 * @since
 */
public class Calculation {

    public Queue<Vector2> queue = new ConcurrentLinkedDeque();
    public List<Vector2> checked = new CopyOnWriteArrayList();
    public Vector2 first;

    public void floodFill(Vector2 starting) {
        queue.add(starting);
        while (!queue.isEmpty()) {
            first = queue.remove();
            checked.add(first);
            for (Facing facing : Facing.values()) {
                Optional<Vector2> temp = Game.get().getBoard().findTile(new Vector2(first.getPosX() + facing.dX, first.getPosY() + facing.dY));
                if (temp.isPresent() && !temp.get().getPreviousEntity().isPresent() && !queue.contains(temp.get()) && !checked.contains(temp.get())) {
                    queue.add(temp.get());
                }
            }
        }
        checked.remove(starting);
        System.out.println(checked.size());
    }
}
