package com.sorashu.aircraftwar.prop;

public class BulletPropFactory implements PropFactory{
    @Override
    public Prop createProp(float locationX, float locationY, float speedX, float speedY) {
        return new BulletProp(locationX, locationY, speedX, speedY);
    }
}
