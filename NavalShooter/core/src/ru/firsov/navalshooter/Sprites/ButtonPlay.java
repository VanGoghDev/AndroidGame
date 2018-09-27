package ru.firsov.navalshooter.sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.firsov.navalshooter.base.ActionListener;
import ru.firsov.navalshooter.base.ScaledTouchUpButton;
import ru.firsov.navalshooter.math.Rect;

public class ButtonPlay extends ScaledTouchUpButton {
    public ButtonPlay(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("ButtonStart"), actionListener, 0.9f);
        setHeightProportion(0.25f);
    }

    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setLeft(worldBounds.getLeft());
    }
}
