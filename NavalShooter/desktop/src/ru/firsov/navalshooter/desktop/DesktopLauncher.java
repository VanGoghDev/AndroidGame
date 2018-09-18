package ru.firsov.navalshooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.firsov.navalshooter.NavalShooter;
import ru.firsov.navalshooter.NavalShooter2DGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new NavalShooter2DGame(), config);
	}
}
