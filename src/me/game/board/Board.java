package me.game.board;

import me.game.Game;
import me.game.entity.IEntity;
import me.game.entity.impl.player.EntityPlayer;
import me.game.utils.Movement;
import me.game.utils.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.lwjgl.glfw.GLFW.*;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class Board {

    private ArrayList<EntityPlayer> entities;
    private ArrayList<Vector2> boardTiles;
    public final int bitSize = 8;
    private final int size = 800 / bitSize;


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
        /**
         * Might make EntityPlayer not abstract to reduce this to 2 lines,
         * but was thinking of something else.
         * TODO:
         */
        entities.add(new EntityPlayer(new Vector2(0, size / 2), new Color(40, 60, 20), new Color(20, 60, 40)) {
            Movement movement = new Movement(this, GLFW_KEY_W, GLFW_KEY_S, GLFW_KEY_A, GLFW_KEY_D);

            @Override
            public void preUpdate() {
                movement.update();
            }
        });
        entities.add(new EntityPlayer(new Vector2(size - 1, size / 2), new Color(61, 23, 6), new Color(86, 34, 225)) {
            Movement movement = new Movement(this, GLFW_KEY_UP, GLFW_KEY_DOWN, GLFW_KEY_LEFT, GLFW_KEY_RIGHT);

            @Override
            public void preUpdate() {
                if (!isDead)
                    movement.update();
            }
        });
    }

    public void stop() {
        entities.stream().filter(EntityPlayer::isDead).forEach(a -> {
            boardTiles.forEach(b -> b.getPreviousEntity().ifPresent(c -> {
                if (c == a)
                    b.setPreviousEntity(Optional.empty());
            }));
            a.setDead(false);
        });
    }

    public void preUpdate() {
        entities.forEach(EntityPlayer::preUpdate);
    }

    public void postUpdate() {
        entities.forEach(IEntity::postUpdate);
        entities.forEach(a -> {
            Optional<Vector2> vec = findTile(a.getPosition());
            vec.ifPresent(b -> b.setPreviousEntity(Optional.of(a)));
            if (!vec.isPresent()) {
                a.setDead(true);
                Game.get().stop();
            }
        });
    }

    public void render() {
        boardTiles.forEach(a -> a.getPreviousEntity().ifPresent(b -> b.renderTrail(a)));
        entities.forEach(IEntity::renderBody);
    }

    public Optional<Vector2> findTile(Vector2 pos) {
        return boardTiles.stream().filter(a -> a.equals(pos)).findFirst();
    }
}
