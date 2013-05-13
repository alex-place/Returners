package com.undeadstudio.returners.model;

import com.badlogic.gdx.math.Vector2;

public class Boss extends Enemy {

	public Boss(float SPEED, float rotation, float width, float height,
			Vector2 position) {
		super(SPEED, rotation, width, height, position);

	}

	@Override
	public boolean advance(float delta, Player ship) {

		return false;
	}

	@Override
	public void isHit() {

	}

	@Override
	public float getHealth() {

		return 0;
	}

	@Override
	public void attack(World world) {

	}

	@Override
	public TYPE getType() {

		return null;
	}

}
