package com.sorashu.aircraftwar.bullet;

public class HeroBulletFactory extends BulletFactory {
    public HeroBulletFactory(int power) {
        super(power);
    }

    @Override
    public AbstractBullet createBullet(float locationX, float locationY, float speedX, float speedY) {
        return new HeroBullet(locationX, locationY, speedX, speedY, power);
    }
}
