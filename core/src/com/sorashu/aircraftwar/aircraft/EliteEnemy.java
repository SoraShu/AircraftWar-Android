package com.sorashu.aircraftwar.aircraft;

import com.sorashu.aircraftwar.prop.Prop;
import com.sorashu.aircraftwar.shoot.StraightShoot;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class EliteEnemy extends EnemyAircraft{

    public EliteEnemy(float locationX, float locationY, float speedX, float speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
        score = 20;
        shootNum = 1;
        power = 30;
        direction = -1;
        this.setShootStrategy(new StraightShoot());
    }

    @Override
    public List<Prop> leftProp() {
        Random rnd = new Random();
        int temp = rnd.nextInt(8);
        List<Prop> list = new LinkedList<>();

        //TODO
//        PropFactory propfactory = null;
//        switch (temp) {
//            case 5:
//                propfactory = new BloodPropFactory();
//                break;
//            case 6:
//                propfactory = new BombPropFactory();
//                break;
//            case 7:
//                propfactory = new BulletPropFactory();
//                break;
//            default:
//                break;
//        }
//        if (propfactory != null) {
//            list.add(propfactory.createProp(locationX, locationY, speedX, speedY));
//        }
        return list;
    }
}
