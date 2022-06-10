package com.sorashu.aircraftwar.aircraft;

import com.sorashu.aircraftwar.shoot.StraightShoot;

public class HeroAircraft extends Aircraft {

    //TODO heroAircraft gen
    private static HeroAircraft heroAircraft = new HeroAircraft(0,0,0,0,3000);

    public HeroAircraft(float locationX, float locationY, float speedX, float speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        shootNum = 1;
        power = 30;
        direction = 1;
        this.setShootStrategy(new StraightShoot());
    }

    public static HeroAircraft getHeroAircraft() {
        return heroAircraft;
    }

}
