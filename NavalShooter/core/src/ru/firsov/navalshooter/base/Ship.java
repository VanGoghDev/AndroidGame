package ru.firsov.navalshooter.base;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.firsov.navalshooter.math.Rect;
import ru.firsov.navalshooter.pool.BulletPool;
import ru.firsov.navalshooter.pool.ExplosionPool;
import ru.firsov.navalshooter.sprites.Bullet;
import ru.firsov.navalshooter.sprites.Explosion;

public class Ship extends Sprite{

    protected Vector2 v = new Vector2();

    protected Rect worldBounds;

    protected Vector2 bulletV = new Vector2();
    protected BulletPool bulletPool;
    protected ExplosionPool explosionPool;
    protected TextureRegion bulletRegion;
    protected float bulletHeight;
    protected int bulletDamage;

    private Sound shootSound;

    protected float reloadInterval;
    protected float reloadTimer;

    protected float damageAnimateInterval = 0.1f;
    protected float damageAnimateTimer;

    protected int hp;

    public Ship(TextureRegion region, int rows, int cols, int frames, BulletPool bulletPool, ExplosionPool explosionPool, Sound shootSound) {
        super(region, rows, cols, frames);
        this.bulletPool = bulletPool;
        this.shootSound = shootSound;
        this.bulletHeight = 0.01f;
        this.bulletDamage = 1;
        this.explosionPool = explosionPool;
    }

    public Ship(BulletPool bulletPool, ExplosionPool explosion, Sound shootSound) {
        this.bulletPool = bulletPool;
        this.shootSound = shootSound;
        this.explosionPool = explosion;
        long id = this.shootSound.play();
        this.shootSound.setVolume(id, 0.3f);
    }

    @Override
    public void update(float delta) {
        super.update(delta);
        damageAnimateTimer += delta;
        if (damageAnimateTimer >= damageAnimateInterval) {
            frame = 0;
        }
    }

    @Override
    public void resize(Rect worldBounds) {
        this.worldBounds = worldBounds;
    }

    public void shoot() {
        Bullet bullet = bulletPool.obtain();
        bullet.set(this, bulletRegion, pos, bulletV, bulletHeight, worldBounds, bulletDamage);
        shootSound.play();
    }

    public void boom() {
        Explosion explosion = explosionPool.obtain();
        explosion.set(getHeight(), pos);
        hp = 0;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void damage(int damage) {
        frame = 1;
        damageAnimateTimer = 0f;
        hp -= damage;
        if (hp <= 0) {
            boom();
            destroy();
        }
    }

    public int getBulletDamage() {
        return bulletDamage;
    }
}
