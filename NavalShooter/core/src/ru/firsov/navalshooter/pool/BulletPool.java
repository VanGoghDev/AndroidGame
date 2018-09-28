package ru.firsov.navalshooter.pool;

import ru.firsov.navalshooter.base.SpritesPool;
import ru.firsov.navalshooter.sprites.Bullet;

public class BulletPool extends SpritesPool<Bullet>{

    @Override
    protected Bullet newObject() {
        return new Bullet();
    }

    @Override
    protected void log() {
        System.out.println("Bullet active/free: " + activeObjects.size() + "/" + freeObjects.size());

    }
}
