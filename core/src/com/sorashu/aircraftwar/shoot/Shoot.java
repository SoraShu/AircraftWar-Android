package com.sorashu.aircraftwar.shoot;

import com.sorashu.aircraftwar.aircraft.Aircraft;
import com.sorashu.aircraftwar.bullet.Bullet;

import java.util.List;

/**
 * @author SoraShu
 */
public interface Shoot {
    /**
     * 工厂方法
     *
     * @param aircraft 传入调用者
     * @return 子弹列表: list
     */
    List<Bullet> doShootAction(Aircraft aircraft);
}