package com.sorashu.aircraftwar.basic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.sorashu.aircraftwar.application.ImageManager;
import com.sorashu.aircraftwar.application.MainGame;

public abstract class AbstractFlyingObject {
    //locationX、locationY为图片中心位置坐标
    protected float speedX;
    protected float speedY;
    protected int width = -1;
    protected int height = -1;
    protected Texture image = null;
    protected Rectangle collisionModel = null;
    protected boolean isValid = true;

    public AbstractFlyingObject(float locationX,float locationY,float speedX,float speedY) {
        this.speedX = speedX;
        this.speedY = speedY;
        getImage();
        getWidth();
        getHeight();
        this.collisionModel = new Rectangle(locationX, locationY, width, height);

    }


    /*--------------------------------------
                      getter
     --------------------------------------*/
    public float getLocationX() {
        return collisionModel.x;
    }

    public float getLocationY() {
        return collisionModel.y;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public int getWidth() {
        if (width == -1) {
            width = ImageManager.get(this).getWidth();
        }
        return width;
    }

    public int getHeight() {
        if (height == -1) {
            height = ImageManager.get(this).getHeight();
        }
        return height;
    }

    public Texture getImage(){
        if (image == null) {
            image = ImageManager.get(this);
        }
        return image;
    }

    /*--------------------------------------
                      setter
     --------------------------------------*/
    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setLocation(float x, float y) {
        collisionModel.x = x;
        collisionModel.y = y;
    }




    public void forward() {
        collisionModel.x += speedX * Gdx.graphics.getDeltaTime();
        collisionModel.y += speedY * Gdx.graphics.getDeltaTime();
        if (collisionModel.x <= 0 || collisionModel.x >= MainGame.viewportWidth) {
            speedX = -speedX;
        }
        if (collisionModel.y + height < 0 || collisionModel.y-height> MainGame.viewportHeight) {
            vanish();
        }
    }

    public boolean crash(AbstractFlyingObject flyingObject) {
        return collisionModel.overlaps(flyingObject.collisionModel);
    }

    public void vanish() {
        isValid = false;
    }

    public boolean notValid() {
        return !this.isValid;
    }

}

