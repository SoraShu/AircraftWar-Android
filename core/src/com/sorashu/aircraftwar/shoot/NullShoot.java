package com.sorashu.aircraftwar.shoot;

import com.sorashu.aircraftwar.aircraft.AbstractAircraft;
import com.sorashu.aircraftwar.bullet.AbstractBullet;

import java.util.LinkedList;
import java.util.List;

public class NullShoot implements Shoot{
    @Override
    public List<AbstractBullet> doShootAction(AbstractAircraft aircraft) {
        return new LinkedList<>();
    }
}
