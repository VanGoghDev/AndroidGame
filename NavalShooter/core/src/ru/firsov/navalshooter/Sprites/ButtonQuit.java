package ru.firsov.navalshooter.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.math.Rect;

public class ButtonQuit extends Sprite {


    public ButtonQuit(TextureRegion region) {
        super(region);
    }

    public void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight()/(float) 2);
        pos.set(worldBounds.pos);
    }
}
