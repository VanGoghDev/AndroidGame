package ru.firsov.navalshooter.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.firsov.navalshooter.base.Ship;
import ru.firsov.navalshooter.math.Rect;
import ru.firsov.navalshooter.pool.BulletPool;

public class Enemy extends Ship {

    private MainShip mainShip;

    private Vector2 v0 = new Vector2();

    public Enemy(BulletPool bulletPool, Sound shootSound, MainShip mainShip, Rect worldBounds) {
        super(bulletPool, shootSound, worldBounds);
        this.mainShip = mainShip;
        this.v.set(v0);
    }

    @Override
    protected void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        reloadTimer += delta;
        if (reloadTimer >= reloadInterval) {
            reloadTimer = 0f;
            //shoot();
        }
    }

    public void set(
            TextureRegion[] regions,
            Vector2 v0,
            TextureRegion bulletRegion,
            float bulletHeight,
            float bulletVY,
            int bulletDamage,
            float reloadInterval,
            float height,
            int hp
    ) {
        this.regions = regions;
        this.v0.set(v0);
        this.bulletRegion = bulletRegion;
        this.bulletHeight = bulletHeight;
        this.bulletV.set(0f, bulletVY);
        this.bulletDamage = bulletDamage;
        this.reloadInterval = reloadInterval;
        this.hp = hp;
        setHeightProportion(height);
        reloadTimer = reloadInterval;
        v.set(v0);
    }
}
