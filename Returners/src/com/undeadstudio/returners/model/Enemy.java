package com.undeadstudio.returners.model;

import com.badlogic.gdx.math.Vector2;

public abstract class Enemy extends MoveableEntity {
	public enum TYPE {
		WALKER, SHOOTER, BOSS, GENERIC;
	}

	TYPE type;

	protected boolean STOPPED = false;

	protected float health = 1;

	protected float attack = 1;

	public Enemy(float SPEED, float rotation, float width, float height,
			Vector2 position) {
		super(SPEED, rotation, width, height, position);
	}

	public abstract boolean advance(float delta, Player ship);

	public abstract void isHit();

	public abstract float getHealth();

	public abstract void attack(World world);

	public abstract TYPE getType();

}
