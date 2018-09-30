package ru.firsov.navalshooter.pool;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import ru.firsov.navalshooter.base.SpritesPool;
import ru.firsov.navalshooter.sprites.Explosion;

public class ExplosionPool extends SpritesPool<Explosion> {

    private final TextureRegion textureRegion;

    public ExplosionPool(TextureAtlas atlas) {
        this.textureRegion = atlas.findRegion("explosion");
    }

    @Override
    protected Explosion newObject() {
        return new Explosion(textureRegion, 9, 9, 74);
    }
}
