package com.sorashu.aircraftwar.shoot;

import com.sorashu.aircraftwar.aircraft.AbstractAircraft;
import com.sorashu.aircraftwar.bullet.AbstractBullet;
import com.sorashu.aircraftwar.bullet.BulletFactory;
import com.sorashu.aircraftwar.bullet.EnemyBullet;
import com.sorashu.aircraftwar.bullet.EnemyBulletFactory;
import com.sorashu.aircraftwar.bullet.HeroBullet;
import com.sorashu.aircraftwar.bullet.HeroBulletFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SoraShu
 */
public class StraightShoot implements Shoot {
    @Override
    public List<AbstractBullet> doShootAction(AbstractAircraft aircraft) {
        List<AbstractBullet> res = new LinkedList<>();
        BulletFactory factory;
        AbstractBullet abstractBullet;
        int shootNum = aircraft.getShootNum();
        float speedY;

        switch (aircraft.getDirection()) {
            case 1:
                factory = new HeroBulletFactory(aircraft.getPower());
                speedY = 100;
                break;
            case 2:
                factory = new EnemyBulletFactory(aircraft.getPower());
                speedY = 250;
                break;
            default:
                return res;
        }

        for (int i = 0; i < shootNum; i++) {
            res.add(factory.createBullet(
                    aircraft.getCenterX() + (i * 2 - shootNum + 1) * 10,
                    aircraft.getCenterY(),
                    0,
                    speedY
            ));
        }

        return res;
    }
}