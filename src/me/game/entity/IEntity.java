package me.game.entity;

import me.game.utils.Vector2;

public interface IEntity {

    void preUpdate();

    void postUpdate();

    void renderBody();

    void renderTrail(Vector2 pos);
}
