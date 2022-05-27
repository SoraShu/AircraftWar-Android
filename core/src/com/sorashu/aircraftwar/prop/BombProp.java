package com.sorashu.aircraftwar.prop;

import static java.rmi.server.LogStream.log;

import com.sorashu.aircraftwar.aircraft.HeroAircraft;

public class BombProp extends AbstractProp{
    public BombProp(float locationX, float locationY, float speedX, float speedY) {
        super(locationX, locationY, speedX, speedY);
    }

    @Override
    public void takeEffect(HeroAircraft heroAircraft) {

    }
}
