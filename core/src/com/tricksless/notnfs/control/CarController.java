package com.tricksless.notnfs.control;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Polygon;
import com.tricksless.notnfs.view.ActiveScreen;

public class CarController {

    private Polygon carBounds;
    private float rotationSpeed = 10f;

    public CarController(Polygon carBounds) {
        this.carBounds = carBounds;
    }

    float carSpeed, speedVelocity = 10f, speedLimit = 10f;

    public void handle() {

    // Speed logics

        if (Gdx.input.isKeyPressed(Input.Keys.W))
            carSpeed += speedVelocity * ActiveScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.S))
            carSpeed -= speedVelocity * ActiveScreen.deltaCff;

        // Reversing direction;
        else if (Gdx.input.isKeyPressed(Input.Keys.S) && carSpeed * ActiveScreen.deltaCff > 0)
            carSpeed -= 8f * ActiveScreen.deltaCff;
        else if (Gdx.input.isKeyPressed(Input.Keys.W) && carSpeed * ActiveScreen.deltaCff < 0)
            carSpeed += 8f * ActiveScreen.deltaCff;
        //

        else downSpeed();

        carSpeed = sliceSpeed();
    //

    // Rotating logics
        if (Gdx.input.isKeyPressed(Input.Keys.A))
            carBounds.rotate(rotationSpeed * carSpeed * ActiveScreen.deltaCff);
        else if (Gdx.input.isKeyPressed(Input.Keys.D))
            carBounds.rotate(- rotationSpeed * carSpeed * ActiveScreen.deltaCff);
    //

        carBounds.setPosition(
                carBounds.getX() + MathUtils.cosDeg(carBounds.getRotation() + 90) * carSpeed * ActiveScreen.deltaCff,
                carBounds.getY() + MathUtils.sinDeg(carBounds.getRotation() + 90) * carSpeed * ActiveScreen.deltaCff
        );
    }

    private float sliceSpeed() { // Limiting car speed
        if (carSpeed > speedLimit)
            return speedLimit;
        if (carSpeed < -speedLimit)
            return -speedLimit;

        return carSpeed;
    }

    private void downSpeed() { //  Nullifying car speed
        if (carSpeed > speedVelocity * ActiveScreen.deltaCff)
            carSpeed -= speedVelocity * ActiveScreen.deltaCff;
        else if (carSpeed < -speedVelocity * ActiveScreen.deltaCff)
            carSpeed += speedVelocity * ActiveScreen.deltaCff;
        else carSpeed = 0f;
    }
}
