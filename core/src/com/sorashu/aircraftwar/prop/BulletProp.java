package com.sorashu.aircraftwar.prop;

import com.sorashu.aircraftwar.aircraft.HeroAircraft;

public class BulletProp extends AbstractProp{
    public BulletProp(float locationX, float locationY, float speedX, float speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void takeEffect(HeroAircraft heroAircraft) {
        heroAircraft.setShootNum(heroAircraft.getShootNum() + 2);
    }
}
