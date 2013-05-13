package com.undeadstudio.returners.model;

import com.badlogic.gdx.math.Vector2;

public class Walker extends MovableEnemy {

	protected float health = 2;

	public Walker(float SPEED, float width, float height, Vector2 position) {
		super(SPEED, width, height, position);

	}

	@Override
	public boolean advance(float delta, Player ship) {
		if (position.x > getStoppingDistance())
			return super.advance(delta, ship);
		else
			return false;
	}

	@Override
	public float getStoppingDistance() {

		return 4;
	}

	@Override
	public void isHit() {
		health -= 1;
	}

	@Override
	public float getHealth() {

		return health;
	}

	@Override
	public TYPE getType() {

		return TYPE.WALKER;
	}

	@Override
	public void attack(World world) {
		world.getWall().health -= attack;

	}

}
