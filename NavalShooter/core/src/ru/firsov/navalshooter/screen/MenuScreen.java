package ru.firsov.navalshooter.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.firsov.navalshooter.Sprites.Background;
import ru.firsov.navalshooter.Sprites.ButtonPlay;
import ru.firsov.navalshooter.Sprites.ButtonQuit;
import ru.firsov.navalshooter.base.ActionListener;
import ru.firsov.navalshooter.base.Base2DScreen;
import ru.firsov.navalshooter.math.Rect;

public class MenuScreen extends Base2DScreen implements ActionListener{


    Background background;
    Texture bg;
    Vector2 pos;
    TextureAtlas atlas;

    ButtonPlay buttonPlay;
    ButtonQuit buttonQuit;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show(){
        super.show();
        bg = new Texture("bg.jpg");
        pos = new Vector2(0f,0f);
        background = new Background(new TextureRegion(bg));
        atlas = new TextureAtlas("buttonAtlas.pack");
        buttonPlay = new ButtonPlay(atlas, this);
        buttonQuit = new ButtonQuit(atlas, this);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.3f, 0.4f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        update(delta);
        draw();
        batch.end();
    }

    public void draw() {
        background.draw(batch);
        buttonPlay.draw(batch);
        buttonQuit.draw(batch);
    }

    public void update(float delta) {

    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
        buttonPlay.resize(worldBounds);
        buttonQuit.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer) {
        buttonPlay.touchDown(touch, pointer);
        buttonQuit.touchDown(touch, pointer);
        return super.touchDown(touch, pointer);
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer) {
        buttonPlay.touchUp(touch, pointer);
        buttonQuit.touchUp(touch, pointer);
        return super.touchUp(touch, pointer);
    }

    @Override
    public void actionPerformed(Object src) {
        if (src == buttonQuit) {
            Gdx.app.exit();
        } else if(src == buttonPlay) {
            game.setScreen(new GameScreen(game));
        }
    }
}
