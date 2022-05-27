package com.sorashu.aircraftwar.prop;

import com.sorashu.aircraftwar.aircraft.HeroAircraft;
import com.sorashu.aircraftwar.basic.AbstractFlyingObject;

public abstract class AbstractProp extends AbstractFlyingObject {

    public AbstractProp(float locationX, float locationY, float speedX, float speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    public abstract void takeEffect(HeroAircraft heroAircraft);
}
