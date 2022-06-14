package com.sorashu.aircraftwar.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sorashu.aircraftwar.aircraft.Aircraft;
import com.sorashu.aircraftwar.aircraft.BossEnemy;
import com.sorashu.aircraftwar.aircraft.EliteEnemy;
import com.sorashu.aircraftwar.aircraft.EnemyAircraft;
import com.sorashu.aircraftwar.aircraft.HeroAircraft;
import com.sorashu.aircraftwar.aircraft.MobEnemy;
import com.sorashu.aircraftwar.basic.FlyingObject;
import com.sorashu.aircraftwar.bullet.Bullet;
import com.sorashu.aircraftwar.prop.Prop;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainGame extends ApplicationAdapter {

    public MainGame(CommunicationInterface communicationInterface, int difficulty, boolean isSoundOn, boolean isOnline, String username) {
        this.communicationInterface = communicationInterface;
        difficultyGen(difficulty);
        this.isOnline = isOnline;
        this.username = username;
        this.isSoundOn = isSoundOn;

    }

    private void difficultyGen(int diffIndex) {
        switch (diffIndex) {
            case 0:
                difficulty = Difficulty.EASY;
                break;
            case 1:
                difficulty = Difficulty.NORMAL;
                break;
            case 2:
                difficulty = Difficulty.DIFFICULT;
        }
        enemyMaxNum = difficulty.getEnemyMaxNum();
        bossScoreThereShould = difficulty.getBossScoreThereShould();

    }

    private CommunicationInterface communicationInterface;
    private SpriteBatch batch;
    private Texture backgroundTexture;
    //TODO viewport gen
    public static final int viewportWidth = 512;
    public static final int viewportHeight = 768;
    private Viewport viewport;

    /**
     * view camera
     */
    private OrthographicCamera camera;

    private BitmapFont font;

    private float backgroundTop;

    private Difficulty difficulty;
    private boolean isSoundOn;
    private boolean isOnline;
    private String username;


    private int enemyMaxNum = 5;
    private int heroSpeed = 1000;
    private long enemyGenDuration = 1000000000;
    private long heroShootGenDuration = 500000000;
    private long enemyShootGenDuration = 500000000;


    private HeroAircraft heroAircraft;
    private List<EnemyAircraft> enemyAircrafts;
    private List<EnemyAircraft> bossAircrafts;
    private List<Bullet> heroBullets;
    private List<Bullet> enemyBullets;
    private List<Prop> allProps;

    private int score = 0;
    private long time = 0;
    private long preTime = 0;
    private int bossCounter = 0;
    private int bossScoreThereShould = 100;


    @Override
    public void create() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, viewportWidth, viewportHeight);
        viewport = new ExtendViewport(viewportWidth, viewportHeight, camera);
        backgroundTexture = ImageManager.getBackground(difficulty);

        backgroundTop = viewportHeight;

        FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator(Gdx.files.internal("ttf/IBMPlexSans-Bold.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 24;
        parameter.color = Color.valueOf("e03131");
        font = fontGenerator.generateFont(parameter);
        fontGenerator.dispose();

        heroAircraft = new HeroAircraft(0,0,0,0,3000);
        heroAircraft.setLocation((float) viewportWidth / 2 - (float) heroAircraft.getWidth() / 2, 0);
        enemyAircrafts = new LinkedList<>();
        bossAircrafts = new LinkedList<>();
        heroBullets = new LinkedList<>();
        enemyBullets = new LinkedList<>();
        allProps = new LinkedList<>();
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        drawBackground();
        drawAllObjectAndRemove();
//        font.draw(batch, "SCORE: " + score + "\nLIFE:" + heroAircraft.getHp(), 5, viewportHeight - 10);
        drawFont();
        batch.end();

        /*--------------------------------------------
                       TODO:action
         ---------------------------------------------*/
        time = TimeUtils.nanoTime();
        if (newCycleJudge(enemyGenDuration)) {
            normalEnemyGen();
            bossEnemyGen();
        }
        if (newCycleJudge(enemyShootGenDuration)) {
            enemyShootAction();
        }
        if (newCycleJudge(heroShootGenDuration)) {
            heroShootAction();
        }

        moveAction();

        crashCheckAction();

        endGameCheck();

        preTime = time;

//        postProcessAction();
    }

    @Override
    public void dispose() {
        batch.dispose();
//        ImageManager.dipose();
    }

    /*--------------------------------------------
                       TODO:action 各部分
    ---------------------------------------------*/

    private void drawFont() {
        String info;
        if (isOnline) {
            info = "USER: " + username + "\nSCORE: " + score + "\nLIFE:" + heroAircraft.getHp();
        } else {
            info = "SCORE: " + score + "\nLIFE:" + heroAircraft.getHp();
        }
        font.draw(batch, info, 5, viewportHeight - 10);

    }

    private void normalEnemyGen() {
        if (enemyAircrafts.size() < enemyMaxNum) {
            if (MathUtils.random(1, 5) <= 1) {
                enemyAircrafts.add(
                        new EliteEnemy(
                                MathUtils.random(0F, (float) viewportWidth - ImageManager.ELITE_ENEMY_IMAGE.getWidth()),
                                MathUtils.random((float) (viewportHeight * 0.8), (float) viewportHeight),
                                100, -100, 20
                        ));
            } else {
                enemyAircrafts.add(
                        new MobEnemy(
                                MathUtils.random(0F, (float) viewportWidth - ImageManager.ELITE_ENEMY_IMAGE.getWidth()),
                                MathUtils.random((float) (viewportHeight * 0.8), (float) viewportHeight),
                                100, -100, 20
                        ));
            }
        }
    }

    private void bossEnemyGen() {
        if(bossCounter > 0 && bossAircrafts.isEmpty()) {
            bossAircrafts.add(new BossEnemy(
                    (viewportWidth - ImageManager.BOSS_ENEMY_IMAGE.getWidth()),
                    MathUtils.random((float) (viewportHeight * 0.7), (float) (viewportHeight * 0.8)),
                    70, 0, 500
            ));
        }
    }

    private boolean newCycleJudge(long duration) {
        return preTime / duration < time / duration;
    }

    private void enemyShootAction() {
        // enemy shoot
        for (EnemyAircraft enemy : enemyAircrafts) {
            enemyBullets.addAll(enemy.shoot());
        }
        // boss shoot
        for (EnemyAircraft boss : bossAircrafts) {
            enemyBullets.addAll(boss.shoot());
        }
    }

    private void heroShootAction() {
        heroBullets.addAll(heroAircraft.shoot());
    }

    private void moveAction() {
        bulletsMoveAction();
        enemyMoveAction();
        propMoveAction();
        heroMoveAction();
    }

    private void bulletsMoveAction() {
        for (Bullet bullet : heroBullets) {
            bullet.forward();
        }
        for (Bullet bullet : enemyBullets) {
            bullet.forward();
        }
    }

    private void enemyMoveAction() {
        for (Aircraft enemy : enemyAircrafts) {
            enemy.forward();
        }
        for (Aircraft boss : bossAircrafts) {
            boss.forward();
        }
    }

    private void propMoveAction() {
        for (Prop prop : allProps) {
            prop.forward();
        }
    }

    private void heroMoveAction() {
        Vector3 touchPos = new Vector3();
        touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touchPos);
        float deltaX = heroAircraft.getLocationX() - (touchPos.x - heroAircraft.getWidth() / 2.0f);
        float deltaY = heroAircraft.getLocationY() - (touchPos.y - heroAircraft.getHeight() / 2.0f);
        if (Math.abs(deltaX) < heroAircraft.getWidth() / 4.0 && Math.abs(deltaY) < heroAircraft.getHeight() / 4.0) {
            heroAircraft.setLocation(touchPos.x - heroAircraft.getWidth() / 2.0f, touchPos.y - heroAircraft.getWidth() / 2.0f);
        } else {
            float speedXRate = (float) Math.sqrt(deltaX * deltaX / (deltaX * deltaX + deltaY * deltaY));
            float speedYRate = (float) Math.sqrt(deltaY * deltaY / (deltaX * deltaX + deltaY * deltaY));
            if (deltaX > 0) {
                heroAircraft.setSpeedX(-speedXRate * heroSpeed);
            } else {
                heroAircraft.setSpeedX(speedXRate * heroSpeed);
            }
            if (deltaY > 0) {
                heroAircraft.setSpeedY(-speedYRate * heroSpeed);
            } else {
                heroAircraft.setSpeedY(speedYRate * heroSpeed);
            }
            if (Math.abs(deltaX) > heroAircraft.getWidth() / 4.0 || Math.abs(deltaY) > heroAircraft.getHeight() / 4.0) {
                heroAircraft.forward();
            }
        }
    }

    private void crashCheckAction() {
        // check if enemy bullets hit hero
        for (Bullet bullet : enemyBullets) {
            if (bullet.notValid()) {
                continue;
            }
            if (heroAircraft.notValid()) {
                continue;
            }
            if (heroAircraft.crash(bullet)) {
                heroAircraft.decreaseHp(bullet.getPower());
                bullet.vanish();
            }
        }

        // check whether hero bullets or hero hit enemy or boss
        for (Bullet bullet : heroBullets) {
            // hit enemy
            if (shootEnemy(bullet, enemyAircrafts)) {
                continue;
            }
            // hit boss
            shootEnemy(bullet, bossAircrafts);
        }

        for (Prop prop : allProps) {
            if (prop.notValid()) {
                continue;
            }
            if (heroAircraft.notValid()) {
                continue;
            }
            if (heroAircraft.crash(prop)) {
                prop.takeEffect(heroAircraft);
                prop.vanish();
            }
        }
    }

    /**
     * 子弹射向敌机
     *
     * @param bullet 子弹
     * @return 是否跳过循环
     */
    private boolean shootEnemy(Bullet bullet, List<EnemyAircraft> enemys) {
        if (bullet.notValid()) {
            return true;
        }

        for (EnemyAircraft enemy : enemys) {
            int preScore = score;
            if (enemy.notValid()) {
                continue;
            }
            if (enemy.crash(bullet)) {
                enemy.decreaseHp(bullet.getPower());
                bullet.vanish();
                if (enemy.notValid()) {
                    score += 20;//todo 改成获取属性
                    allProps.addAll(enemy.leftProp());
                }
            }
            // hero crash enemy
            if (enemy.crash(heroAircraft) || heroAircraft.crash(enemy)) {
                enemy.vanish();
                heroAircraft.decreaseHp(Integer.MAX_VALUE);
                heroAircraft.notValid();
            }
            if (preScore / bossScoreThereShould < score / bossScoreThereShould) {
                bossCounter++;
            }
        }
        return false;
    }

    private void endGameCheck() {
        if (heroAircraft.notValid()) {
            communicationInterface.goRankListActivity(score);
            communicationInterface.endGame();
        }
    }

    private void drawAllObjectAndRemove() {
        drawAndRemove(heroBullets);
        drawAndRemove(enemyBullets);
        drawAndRemove(enemyAircrafts);
        drawAndRemove(bossAircrafts);
        batch.draw(
                heroAircraft.getImage(),
                heroAircraft.getLocationX(),
                heroAircraft.getLocationY(),
                heroAircraft.getWidth(),
                heroAircraft.getHeight()
        );
        drawAndRemove(allProps);
    }

    private void drawAndRemove(List<? extends FlyingObject> flyingObjects) {
        for (Iterator<? extends FlyingObject> iterator = flyingObjects.iterator(); iterator.hasNext();) {
            FlyingObject flyingObject = iterator.next();
            if (flyingObject.notValid()) {
                iterator.remove();
            } else {
                batch.draw(
                        flyingObject.getImage(),
                        flyingObject.getLocationX(),
                        flyingObject.getLocationY(),
                        flyingObject.getWidth(),
                        flyingObject.getHeight()
                );
            }
        }
    }

    private void drawBackground() {
        batch.draw(backgroundTexture, 0, backgroundTop - backgroundTexture.getHeight());
        batch.draw(backgroundTexture, 0, backgroundTop);

        backgroundTop -= 100 * Gdx.graphics.getDeltaTime();
        if (backgroundTop <= 0) {
            backgroundTop = viewportHeight;
        }
    }

//    private void drawObject() {
//        drawList(heroBullets);
//        drawList(enemyBullets);
//        drawList(enemyAircrafts);
//        drawList(bossAircrafts);
//        batch.draw(
//                heroAircraft.getImage(),
//                heroAircraft.getLocationX(),
//                heroAircraft.getLocationY(),
//                heroAircraft.getWidth(),
//                heroAircraft.getHeight()
//        );
//        drawList(allProps);
//    }

    private void drawList(List<? extends FlyingObject> flyingObjects) {
        for (FlyingObject flyingObject : flyingObjects) {
            batch.draw(
                    flyingObject.getImage(),
                    flyingObject.getLocationX(),
                    flyingObject.getLocationY(),
                    flyingObject.getWidth(),
                    flyingObject.getHeight()
            );
        }
    }


    private void endGame() {

    }
}
