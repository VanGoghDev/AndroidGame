package ru.firsov.navalshooter.Sprites;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.firsov.navalshooter.base.ActionListener;
import ru.firsov.navalshooter.base.ScaledTouchUpButton;
import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.math.Rect;

public class ButtonQuit extends ScaledTouchUpButton {


    public ButtonQuit(TextureAtlas atlas, ActionListener actionListener) {
        super(atlas.findRegion("ButtonQuit"), actionListener, 0.9f);
        setHeightProportion(0.25f);
    }

    public void resize(Rect worldBounds) {
        setBottom(worldBounds.getBottom());
        setRight(worldBounds.getRight());
    }
}
