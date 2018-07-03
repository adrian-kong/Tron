package me.game.utils;

/**
 * @author Adrian
 * @since 19/06/18
 */
public class TimerUtil {

    private long lastMs;

    public void reset() {
        this.lastMs = System.currentTimeMillis();
    }

    public boolean hasReachedMs(long delay) {
        return System.currentTimeMillis() - lastMs > delay;
    }
}
