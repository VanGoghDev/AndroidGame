package ru.firsov.navalshooter.pool;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.base.SpritesPool;
import ru.firsov.navalshooter.math.Rect;
import ru.firsov.navalshooter.sprites.Enemy;
import ru.firsov.navalshooter.sprites.Explosion;
import ru.firsov.navalshooter.sprites.MainShip;

public class EnemyPool extends SpritesPool {

    private Rect worldBounds;

    private BulletPool bulletPool;
    private ExplosionPool explosionPool;
    private Sound shootSound;
    private MainShip mainShip;
    private Sound sound;

    public EnemyPool(BulletPool bulletPool, ExplosionPool explosionPool, Sound shootSound, MainShip mainShip, Sound sound) {
        this.bulletPool = bulletPool;
        this.explosionPool = explosionPool;
        this.shootSound = shootSound;
        this.worldBounds = worldBounds;
        this.mainShip = mainShip;
        this.sound = sound;
    }

    @Override
    protected Sprite newObject() {
        return new Enemy(bulletPool, explosionPool, shootSound, mainShip);
    }
}
