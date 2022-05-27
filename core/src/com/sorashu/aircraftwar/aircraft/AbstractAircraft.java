package com.sorashu.aircraftwar.aircraft;

import com.sorashu.aircraftwar.basic.AbstractFlyingObject;
import com.sorashu.aircraftwar.bullet.AbstractBullet;
import com.sorashu.aircraftwar.shoot.Shoot;

import java.util.List;

public abstract class AbstractAircraft extends AbstractFlyingObject {



    protected int hp;
    protected int maxHp;
    protected int shootNum;
    protected int direction;
    protected int power;
    protected Shoot shootStrategy;

    /* --------------------------------
                  getter
     ---------------------------------*/
    public int getShootNum() {
        return shootNum;
    }

    public int getDirection() {
        return direction;
    }

    public int getPower() {
        return power;
    }

    public void setShootStrategy(Shoot shootStrategy) {
        this.shootStrategy = shootStrategy;
    }

    /* --------------------------------
                  getter
     ---------------------------------*/
    public void setShootNum(int shootNum) {
        this.shootNum = shootNum;
    }

    public Shoot executeShootStrategy() {
        return shootStrategy;
    }



    public AbstractAircraft(float locationX, float locationY, float speedX, float speedY, int hp) {
        super(locationX, locationY, speedX, speedY);
        this.hp = hp;
        this.maxHp = hp;
    }

    public void decreaseHp(int decrease) {
        hp -= decrease;
        if (hp <= 0) {
            hp = 0;
            vanish();
        }
    }

    public void increaseHp(int increase) {
        hp += increase;
        if (hp >= maxHp) {
            hp = maxHp;
        }
    }

    public List<AbstractBullet> shoot() {
        return this.executeShootStrategy().doShootAction(this);
    }
}
