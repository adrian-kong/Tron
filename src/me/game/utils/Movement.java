package me.game.utils;

import me.game.entity.impl.player.EntityPlayer;
import me.game.utils.Facing;
import me.game.utils.InputHandler;

/**
 * @author Adrian
 * @since 05/07/18
 */
public class Movement {

    private int up, down, left, right;
    private EntityPlayer player;

    public Movement(EntityPlayer player, int up, int down, int left, int right) {
        this.player = player;
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
    }

    public void update() {
        if (InputHandler.keyPressed(up) && player.getPrevDirection() != Facing.DOWN)
            player.setDirection(Facing.UP);
        if (InputHandler.keyPressed(down) && player.getPrevDirection() != Facing.UP)
            player.setDirection(Facing.DOWN);
        if (InputHandler.keyPressed(left) && player.getPrevDirection() != Facing.RIGHT)
            player.setDirection(Facing.LEFT);
        if (InputHandler.keyPressed(right) && player.getPrevDirection() != Facing.LEFT)
            player.setDirection(Facing.RIGHT);
    }
}
