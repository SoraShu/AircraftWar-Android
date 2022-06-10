package com.sorashu.aircraftwar.shoot;

import com.sorashu.aircraftwar.aircraft.Aircraft;
import com.sorashu.aircraftwar.bullet.Bullet;

import java.util.LinkedList;
import java.util.List;

public class NullShoot implements Shoot{
    @Override
    public List<Bullet> doShootAction(Aircraft aircraft) {
        return new LinkedList<>();
    }
}
