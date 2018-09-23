package ru.firsov.navalshooter;

import com.badlogic.gdx.Game;

import ru.firsov.navalshooter.screen.MenuScreen;

public class NavalShooter2DGame extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }
}
