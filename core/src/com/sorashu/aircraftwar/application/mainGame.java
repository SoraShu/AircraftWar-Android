package com.sorashu.aircraftwar.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class mainGame extends ApplicationAdapter {
    private int score=0;


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




    @Override
    public void create () {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        camera.setToOrtho(false,viewportWidth,viewportHeight);
        viewport = new ExtendViewport(viewportWidth, viewportHeight, camera);

    }

    @Override
    public void render () {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        //batch.draw(img, 0, 0);
        batch.end();
    }

    @Override
    public void dispose () {
        batch.dispose();
        //img.dispose();
    }
}
