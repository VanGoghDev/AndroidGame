package ru.firsov.navalshooter.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import javax.swing.SpinnerDateModel;

import ru.firsov.navalshooter.base.Base2DScreen;

public class MenuScreen extends Base2DScreen{

    SpriteBatch batch;
    Texture img;
    Vector2 pos;
    Vector2 v;
    Vector2 touch = new Vector2(0, 0);
    Vector2 way = new Vector2();

    public MenuScreen(Game game) {
        super(game);
    }

    @Override
    public void show(){
        super.show();
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        pos = new Vector2(0f,0f);
        v = new Vector2(2f,1f);

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0.3f, 0.4f, 0.7f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x, pos.y);
        batch.end();

        // difference between actual position of object and place on the screen where we clicked
        way = touch.cpy().sub(pos.cpy());

        //do it until waypoint
        if (pos.x != way.x && pos.y != way.y) {
            pos.add(way.nor().scl(3));
        }
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println("touchDown screenX = " + screenX + " screenY = "+ (Gdx.graphics.getHeight() - screenY));
        touch.set(screenX, (Gdx.graphics.getHeight() - screenY));
        return super.touchDown(screenX, screenY, pointer, button);
    }

}
