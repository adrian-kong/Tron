package me.game.board;

import me.game.Game;
import me.game.entity.Entity;
import me.game.entity.impl.player.EntityPlayer;
import me.game.entity.impl.player.PlayerOne;
import me.game.utils.Vector2;

import java.util.ArrayList;
import java.util.Optional;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class Board {

    private ArrayList<EntityPlayer> entities;
    private ArrayList<Vector2> boardTiles;
    private final int size = 800 / 10;

    public Board() {
        reset();
    }

    public void reset() {
        entities = new ArrayList();
        boardTiles = new ArrayList();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boardTiles.add(new Vector2(i, j));
            }
        }

        entities.add(new PlayerOne(new Vector2(0, size / 2)));
    }

    public void update() {
        entities.forEach(a -> {
            Optional<Vector2> vec = findTile(a.getPosition());
            vec.ifPresent(b -> b.setPreviousEntity(a));
            if (!vec.isPresent())
                Game.get().stop();
        });
        entities.forEach(Entity::update);
    }

    public void render() {
        boardTiles.forEach(a -> a.getPreviousEntity().ifPresent(b -> b.render()));
        entities.forEach(Entity::render);
    }

    public Optional<Vector2> findTile(Vector2 pos) {
        return boardTiles.stream().filter(a -> a.equals(pos)).findFirst();
    }
}