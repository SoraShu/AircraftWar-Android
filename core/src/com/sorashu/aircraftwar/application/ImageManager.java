package com.sorashu.aircraftwar.application;

import com.badlogic.gdx.graphics.Texture;
import com.sorashu.aircraftwar.aircraft.BossEnemy;
import com.sorashu.aircraftwar.aircraft.EliteEnemy;
import com.sorashu.aircraftwar.aircraft.HeroAircraft;
import com.sorashu.aircraftwar.aircraft.MobEnemy;
import com.sorashu.aircraftwar.bullet.EnemyBullet;
import com.sorashu.aircraftwar.bullet.HeroBullet;
import com.sorashu.aircraftwar.prop.BloodProp;
import com.sorashu.aircraftwar.prop.BombProp;
import com.sorashu.aircraftwar.prop.BulletProp;

import java.util.HashMap;
import java.util.Map;

import jdk.internal.org.jline.utils.Log;

public class ImageManager {

    private static Map<String, Texture> CLASSNAME_IMAGE_MAP = new HashMap<>();

    public static Texture BACKGROUND_IMAGE;
    public static Texture BACKGROUND_IMAGE2;
    public static Texture BACKGROUND_IMAGE3;
    public static Texture HERO_IMAGE;
    public static Texture HERO_BULLET_IMAGE;
    public static Texture ENEMY_BULLET_IMAGE;
    public static Texture MOB_ENEMY_IMAGE;
    public static Texture ELITE_ENEMY_IMAGE;
    public static Texture BOSS_ENEMY_IMAGE;
    public static Texture BLOOD_PROP_IMAGE;
    public static Texture BOMB_PROP_IMAGE;
    public static Texture BULLET_PROP_IMAGE;

//    public ImageManager() {
    static{
        BACKGROUND_IMAGE = new Texture("img/bg1.jpg");
        BACKGROUND_IMAGE2 = new Texture("img/bg2.jpg");
        BACKGROUND_IMAGE3 = new Texture("img/bg3.jpg");
        HERO_IMAGE = new Texture("img/hero.png");
        HERO_BULLET_IMAGE = new Texture("img/bullet_hero.png");
        ENEMY_BULLET_IMAGE = new Texture("img/bullet_enemy.png");
        MOB_ENEMY_IMAGE = new Texture("img/mob.png");
        ELITE_ENEMY_IMAGE = new Texture("img/elite.png");
        BOSS_ENEMY_IMAGE = new Texture("img/boss.png");
        BLOOD_PROP_IMAGE = new Texture("img/prop_blood.png");
        BOMB_PROP_IMAGE = new Texture("img/prop_bomb.png");
        BULLET_PROP_IMAGE = new Texture("img/prop_bullet.png");
        CLASSNAME_IMAGE_MAP.put(HeroAircraft.class.getName(), HERO_IMAGE);
        CLASSNAME_IMAGE_MAP.put(MobEnemy.class.getName(), MOB_ENEMY_IMAGE);
        CLASSNAME_IMAGE_MAP.put(EliteEnemy.class.getName(), ELITE_ENEMY_IMAGE);
        CLASSNAME_IMAGE_MAP.put(BossEnemy.class.getName(), BOSS_ENEMY_IMAGE);
        CLASSNAME_IMAGE_MAP.put(HeroBullet.class.getName(), HERO_BULLET_IMAGE);
        CLASSNAME_IMAGE_MAP.put(EnemyBullet.class.getName(), ENEMY_BULLET_IMAGE);
        CLASSNAME_IMAGE_MAP.put(BloodProp.class.getName(), BLOOD_PROP_IMAGE);
        CLASSNAME_IMAGE_MAP.put(BombProp.class.getName(), BOMB_PROP_IMAGE);
        CLASSNAME_IMAGE_MAP.put(BulletProp.class.getName(), BULLET_PROP_IMAGE);
    }





    public static Texture get(Object object) {
        if (object == null) {
            return null;
        }

        return CLASSNAME_IMAGE_MAP.get(object.getClass().getName());
    }



    public static void dipose() {
        HERO_IMAGE.dispose();
        HERO_BULLET_IMAGE.dispose();
        ENEMY_BULLET_IMAGE.dispose();
        MOB_ENEMY_IMAGE.dispose();
        BOSS_ENEMY_IMAGE.dispose();
        ELITE_ENEMY_IMAGE.dispose();
        BOMB_PROP_IMAGE.dispose();
        BLOOD_PROP_IMAGE.dispose();
        BULLET_PROP_IMAGE.dispose();
//        BACKGROUND_IMAGE1.dispose();
//        BACKGROUND_IMAGE2.dispose();
//        BACKGROUND_IMAGE3.dispose();
//        BACKGROUND_IMAGE4.dispose();
//        BACKGROUND_IMAGE5.dispose();
        BACKGROUND_IMAGE.dispose();
    }


}
