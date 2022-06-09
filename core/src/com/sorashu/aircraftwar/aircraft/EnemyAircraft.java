package com.sorashu.aircraftwar.aircraft;

import com.sorashu.aircraftwar.prop.AbstractProp;

import java.util.List;

public abstract class EnemyAircraft extends AbstractAircraft{

    protected int score;

    public EnemyAircraft(float locationX, float locationY, float speedX, float speedY, int hp) {
        super(locationX, locationY, speedX, speedY, hp);
    }

    public int getScore() {
        return score;
    }

    /**
     * 敌机死亡后生成道具
     *
     * @return List<AbstractProp>
     */
    public abstract List<AbstractProp> leftProp();
}
