package com.sorashu.aircraftwar.prop;

import com.sorashu.aircraftwar.aircraft.HeroAircraft;
import com.sorashu.aircraftwar.basic.FlyingObject;

public abstract class Prop extends FlyingObject {

    public Prop(float locationX, float locationY, float speedX, float speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    public abstract void takeEffect(HeroAircraft heroAircraft);
}
