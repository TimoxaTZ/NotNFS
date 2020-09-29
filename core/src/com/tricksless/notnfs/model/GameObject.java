package com.tricksless.notnfs.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Rectangle;

abstract class GameObject {
    Polygon bounds;
    Sprite object;

    GameObject(Texture texture, float x, float y, float width, float height) {
        bounds = new Polygon(new float[]{0f, 0f, width, height, 0f, height});
        object = new Sprite(texture);
    }

    public void draw(SpriteBatch batch) {
        object.setBounds(bounds.getX(), bounds.getY(), bounds.getWidth(), bounds.getHeight());
        object.draw(batch);
    }
}
