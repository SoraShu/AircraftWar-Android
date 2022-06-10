package com.sorashu.aircraftwar.prop;

import com.sorashu.aircraftwar.aircraft.HeroAircraft;

public class BloodProp extends Prop {
    public BloodProp(float locationX, float locationY, float speedX, float speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void takeEffect(HeroAircraft heroAircraft) {
        heroAircraft.increaseHp(30);
    }
}
