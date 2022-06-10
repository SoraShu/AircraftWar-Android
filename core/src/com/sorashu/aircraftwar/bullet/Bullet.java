package com.sorashu.aircraftwar.bullet;

import com.sorashu.aircraftwar.application.MainGame;
import com.sorashu.aircraftwar.basic.FlyingObject;

public abstract class Bullet extends FlyingObject {

    private int power;

    public Bullet(float locationX, float locationY, float speedX, float speedY, int power) {
        super(locationX, locationY, speedX, speedY);
        this.power = power;
    }

    @Override
    public void forward() {
        super.forward();
        if (collisionModel.x <= 0 || collisionModel.x + width >= MainGame.viewportWidth) {
            vanish();
        }
    }

    public int getPower() {
        return power;
    }


}
