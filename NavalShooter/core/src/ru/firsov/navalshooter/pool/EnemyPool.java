package ru.firsov.navalshooter.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.base.SpritesPool;
import ru.firsov.navalshooter.math.Rect;
import ru.firsov.navalshooter.sprites.Enemy;
import ru.firsov.navalshooter.sprites.MainShip;

public class EnemyPool extends SpritesPool {

    private Rect worldBounds;

    private BulletPool bulletPool;
    private Sound shootSound;
    private MainShip mainShip;
    private Sound sound;

    public EnemyPool(BulletPool bulletPool, Sound shootSound, MainShip mainShip, Sound sound, Rect worldBounds) {
        this.bulletPool = bulletPool;
        this.shootSound = shootSound;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
        this.sound = sound;
    }

    @Override
    protected Sprite newObject() {
        return new Enemy(bulletPool, shootSound, mainShip, worldBounds);
    }
}
