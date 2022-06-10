package com.sorashu.aircraftwar.shoot;

import com.sorashu.aircraftwar.aircraft.Aircraft;
import com.sorashu.aircraftwar.bullet.Bullet;
import com.sorashu.aircraftwar.bullet.BulletFactory;
import com.sorashu.aircraftwar.bullet.EnemyBulletFactory;
import com.sorashu.aircraftwar.bullet.HeroBulletFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SoraShu
 */
public class StraightShoot implements Shoot {
    @Override
    public List<Bullet> doShootAction(Aircraft aircraft) {
        List<Bullet> res = new LinkedList<>();
        BulletFactory factory;
        Bullet abstractBullet;
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