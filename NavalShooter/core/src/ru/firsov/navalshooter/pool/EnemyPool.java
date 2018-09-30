package ru.firsov.navalshooter.pool;

import com.badlogic.gdx.audio.Sound;

import ru.firsov.navalshooter.base.Sprite;
import ru.firsov.navalshooter.base.SpritesPool;
import ru.firsov.navalshooter.sprites.Enemy;
import ru.firsov.navalshooter.sprites.MainShip;

public class EnemyPool extends SpritesPool {

    private BulletPool bulletPool;
    private Sound shootSound;
    private MainShip mainShip;

    public EnemyPool(BulletPool bulletPool, Sound shootSound, MainShip mainShip) {
        this.bulletPool = bulletPool;
        this.shootSound = shootSound;
        this.mainShip = mainShip;
    }

    @Override
    protected Sprite newObject() {
        return new Enemy(bulletPool, shootSound, mainShip);
    }
}
