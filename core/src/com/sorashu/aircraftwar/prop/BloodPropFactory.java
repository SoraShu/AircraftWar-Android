package com.sorashu.aircraftwar.prop;

public class BloodPropFactory implements PropFactory{
    @Override
    public Prop createProp(float locationX, float locationY, float speedX, float speedY) {
        return new BloodProp(locationX, locationY, speedX, speedY);
    }
}
