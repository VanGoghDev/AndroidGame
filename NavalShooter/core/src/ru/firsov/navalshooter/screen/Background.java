package ru.firsov.navalshooter.screen;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.math.Rect;

public class Background extends Sprite {

    public Background(TextureRegion region) {
        super(region);
    }

    @Override
    protected void resize(Rect worldBounds) {
        setHeightProportion(worldBounds.getHeight());
        pos.set(worldBounds.pos);
    }
}
