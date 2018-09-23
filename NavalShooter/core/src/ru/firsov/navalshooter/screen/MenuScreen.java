package ru.firsov.navalshooter.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.firsov.navalshooter.base.Base2DScreen;
import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.math.Rect;

public class MenuScreen extends Base2DScreen{


    Background background;
    Texture bg;
    Vector2 pos;

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show(){
        super.show();
        bg = new Texture("bg.jpg");
        pos = new Vector2(0f,0f);
        background = new Background(new TextureRegion(bg));
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.3f, 0.4f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        background.draw(batch);
        batch.end();
    }

    @Override
    protected void resize(Rect worldBounds) {
        background.resize(worldBounds);
    }

    @Override
    public void dispose() {
        bg.dispose();
        super.dispose();
    }

}
