package com.sorashu.aircraftwar.prop;

public interface PropFactory {
    Prop createProp(float locationX, float locationY, float speedX, float speedY);
}
