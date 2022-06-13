package com.sorashu.aircraftwar.prop;

public class BombPropFactory implements PropFactory{
    @Override
    public Prop createProp(float locationX, float locationY, float speedX, float speedY) {
        return new BombProp(locationX, locationY, speedX, speedY);
    }
}
