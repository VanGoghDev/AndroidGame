package ru.firsov.navalshooter.sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.firsov.navalshooter.base.Ship;
import ru.firsov.navalshooter.math.Rect;
import ru.firsov.navalshooter.pool.BulletPool;
import ru.firsov.navalshooter.pool.ExplosionPool;

public class Enemy extends Ship {

    private enum State {DESCENT, FIGHT}

    private MainShip mainShip;

    private Vector2 v0 = new Vector2();
    private Vector2 descentV = new Vector2(0, -0.15f);

    private State state;

    public Enemy(BulletPool bulletPool, ExplosionPool explosionPool, Sound shootSound, MainShip mainShip) {
        super(bulletPool, explosionPool, shootSound);
        this.mainShip = mainShip;
        this.v.set(v0);
    }

    @Override
    protected void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        switch (state) {
            case DESCENT:
                if (getTop() <= worldBounds.getTop()) {
                    v.set(v0);
                    state = State.FIGHT;
                }
                break;
            case FIGHT:
                reloadTimer += delta;
                if (reloadTimer >= reloadInterval) {
                    reloadTimer = 0f;
                    shoot();
                }
                if (getBottom() < worldBounds.getBottom()) {
                    boom();
                    destroy();
                }
                break;
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
            int hp,
            Rect worldBounds
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
        v.set(descentV);
        state = State.DESCENT;
        this.worldBounds = worldBounds;
    }
}
