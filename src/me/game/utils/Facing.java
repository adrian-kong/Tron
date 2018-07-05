package me.game.utils;

public enum Facing {

    STATIC(0, 0), UP(0, -1), DOWN(0, 1), LEFT(-1, 0), RIGHT(1, 0);

    public final int dX, dY;

    Facing(int dX, int dY) {
        this.dX = dX;
        this.dY = dY;
    }
}
