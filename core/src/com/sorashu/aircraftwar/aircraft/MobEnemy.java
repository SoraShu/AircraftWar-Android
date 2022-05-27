package com.sorashu.aircraftwar.aircraft;

import com.sorashu.aircraftwar.prop.AbstractProp;
import com.sorashu.aircraftwar.shoot.NullShoot;

import java.util.LinkedList;
import java.util.List;

public class MobEnemy extends EnemyAircraft{
    public MobEnemy(float locationX, float locationY, float speedX, float speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        score = 10;
        shootNum = 0;
        power = 0;
        direction = 0;
        this.setShootStrategy(new NullShoot());
    }

    @Override
    public List<AbstractProp> leftProp() {
        return new LinkedList<>();
    }
}
