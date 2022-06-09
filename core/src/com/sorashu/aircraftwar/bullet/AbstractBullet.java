package com.sorashu.aircraftwar.bullet;

import com.sorashu.aircraftwar.application.MainGame;
import com.sorashu.aircraftwar.basic.AbstractFlyingObject;

public abstract class AbstractBullet extends AbstractFlyingObject {

    private int power;

    public AbstractBullet(float locationX, float locationY, float speedX, float speedY,int power) {
        super(locationX, locationY, speedX, speedY);
        this.power = power;
    }

    @Override
    public void forward() {
        super.forward();
        if (collisionModel.x <= 0 || collisionModel.x >= MainGame.viewportWidth) {
            vanish();
        }
    }

    public int getPower() {
        return power;
    }


}
