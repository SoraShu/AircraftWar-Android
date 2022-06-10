package com.sorashu.aircraftwar.bullet;

public class EnemyBulletFactory extends BulletFactory{
    public EnemyBulletFactory(int power) {
        super(power);
    }

    @Override
    public AbstractBullet createBullet(float locationX, float locationY, float speedX, float speedY) {
        return new EnemyBullet(locationX, locationY, speedX, speedY, power);
    }
}
