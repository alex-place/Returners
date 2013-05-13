package com.undeadstudio.returners.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public abstract class MovableEnemy extends Enemy {

	public MovableEnemy(float SPEED, float width, float height, Vector2 position) {
		super(SPEED, 0, width, height, position);
	}

	Vector2 velocity = new Vector2(-1, 0);

	@Override
	public boolean advance(float delta, Player player) {
		// Gdx.app.log(Returners.LOG, "Speed: " + SPEED);
		position.add(velocity.tmp().mul(Gdx.graphics.getDeltaTime() * SPEED));

		bounds.x = position.x;
		bounds.y = position.y;

		return true;
	}

	public abstract float getStoppingDistance();
	
	@Override
	public TYPE getType() {
		// TODO Auto-generated method stub
		return TYPE.GENERIC;
	}

}
