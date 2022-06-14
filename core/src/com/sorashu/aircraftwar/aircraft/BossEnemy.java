package com.sorashu.aircraftwar.aircraft;

import com.sorashu.aircraftwar.prop.BloodPropFactory;
import com.sorashu.aircraftwar.prop.BombPropFactory;
import com.sorashu.aircraftwar.prop.BulletPropFactory;
import com.sorashu.aircraftwar.prop.Prop;
import com.sorashu.aircraftwar.prop.PropFactory;
import com.sorashu.aircraftwar.shoot.StraightShoot;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class BossEnemy extends EnemyAircraft{
    public BossEnemy(float locationX, float locationY, float speedX, float speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        score = 100;
        shootNum = 3;
        power = 50;
        direction = -1;
        this.setShootStrategy(new StraightShoot());
    }

    @Override
    public List<Prop> leftProp() {
        List<Prop> list = new LinkedList<>();
        PropFactory[] propfactoryset = new PropFactory[3];
        propfactoryset[0] = new BloodPropFactory();
        propfactoryset[1] = new BombPropFactory();
        propfactoryset[2] = new BulletPropFactory();
        for (PropFactory propfactory : propfactoryset) {
            Random rnd = new Random();
            int propSpeedX = rnd.nextInt(100);
            list.add(propfactory.createProp(this.getCenterX(), this.getCenterY(), propSpeedX, -100));
        }
        return list;
    }
}
