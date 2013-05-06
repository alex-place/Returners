package com.undeadstudio.returners.model;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Bullet extends MoveableEntity {
	public enum TYPE {
		FRIEND, FOE;
	}

	TYPE type;

	private static float SPEED = 10;

	public Bullet(float SPEED, float rotation, float width, float height,
			Vector2 position, Vector2 velocity, TYPE type) {
		super(SPEED, rotation, width, height, position);
		this.velocity = velocity;
		this.type = type;
	}

	public TYPE getType() {
		return type;
	}

	@Override
	public void update(Player player) {
		position.add(velocity.tmp().mul(Gdx.graphics.getDeltaTime() * SPEED));
		rotation = velocity.angle() - 90;

		if (getType() == TYPE.FRIEND)
			player.setRotation(velocity.angle() - 90);

		bounds.x = position.x;
		bounds.y = position.y;

		super.update(player);
	}

	public static float getSpeed() {
		// TODO Auto-generated method stub
		return SPEED;
	}
}