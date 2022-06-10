package com.sorashu.aircraftwar.bullet;

public abstract class BulletFactory {
    protected float locationX;
    protected float locationY;
    protected int power;

    public BulletFactory(int power) {
        this.power = power;
    }
    public abstract AbstractBullet createBullet(float locationX, float locationY, float speedX, float speedY);
}
