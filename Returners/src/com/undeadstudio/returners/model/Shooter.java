package com.undeadstudio.returners.model;

import com.badlogic.gdx.math.Vector2;
import com.undeadstudio.returners.screens.SettingsScreen;

public class Shooter extends MovableEnemy {

	// private static final float bulSpeed = 1;
	protected float health = 1;
	protected float counter = 50;
	protected float i = 0;

	public Shooter(float SPEED, float width, float height, Vector2 position) {
		super(SPEED, width, height, position);
		// TODO Auto-generated constructor stub
	}

	@Override
	public float getStoppingDistance() {
		// TODO Auto-generated method stub
		return (SettingsScreen.GAME_WIDTH / 4) * 3;
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
	public boolean advance(float delta, Player player) {
		if (position.x > getStoppingDistance())
			return super.advance(delta, player);
		else
			return false;

	}

	@Override
	public TYPE getType() {
		// TODO Auto-generated method stub
		return TYPE.SHOOTER;
	}

	@Override
	public void attack(World world) {

		// Gdx.app.log(Returners.LOG,
		// "Enemy attack has been fired!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		if (i >= counter) {
			world.addEnemyBullet(new Bullet(Bullet.getSpeed(), 0, .1f, 8 / 20f,
					new Vector2(position.x + bounds.getWidth() / 2, position.y
							+ bounds.getHeight() / 2), new Vector2(-2, 0),
					Bullet.TYPE.FRIEND));
			i = 0;
		} else {
			i++;
		}

	}

}
