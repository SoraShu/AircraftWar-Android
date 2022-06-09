package com.sorashu.aircraftwar.shoot;

import com.sorashu.aircraftwar.aircraft.AbstractAircraft;
import com.sorashu.aircraftwar.bullet.AbstractBullet;
import com.sorashu.aircraftwar.bullet.EnemyBullet;
import com.sorashu.aircraftwar.bullet.HeroBullet;

import java.util.LinkedList;
import java.util.List;

/**
 * @author SoraShu
 */
public class StraightShoot implements Shoot {
    @Override
    public List<AbstractBullet> doShootAction(AbstractAircraft aircraft) {
        List<AbstractBullet> res = new LinkedList<>();
        AbstractBullet abstractBullet;
        int shootNum = aircraft.getShootNum();

        switch (aircraft.getDirection()) {
            case 1:
                for (int i = 0; i < shootNum; i++) {
                    // 子弹发射位置相对飞机位置向前偏移
                    // 多个子弹横向分散
                    abstractBullet = new HeroBullet(
                            aircraft.getLocationX() + (i * 2 - shootNum + 1) * 10,
                            aircraft.getLocationY(),
                            0,
                            aircraft.getDirection() * 100,
                            aircraft.getPower());
                    res.add(abstractBullet);
                }
                break;
            case -1:
                for (int i = 0; i < shootNum; i++) {
                    // 子弹发射位置相对飞机位置向前偏移
                    // 多个子弹横向分散
                    abstractBullet = new EnemyBullet(
                            aircraft.getLocationX() + (i * 2 - shootNum + 1) * 10,
                            aircraft.getLocationY(),
                            0,
                            aircraft.getDirection() * 250,
                            aircraft.getPower());
                    res.add(abstractBullet);
                }
                break;
            default:
                throw new IllegalArgumentException("BulletFactory uninitialized !");
        }

        return res;
    }
}