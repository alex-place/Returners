package com.undeadstudio.returners.model;

import com.badlogic.gdx.math.Vector2;
import com.undeadstudio.returners.Returners;
import com.undeadstudio.returners.persistence.Settings;

public class Player extends MoveableEntity {

	float health = 100;
	float mana = 100;
	float rotation;
	float attack;

	public Player(Vector2 position, float width, float height, float rotation,
			float SPEED) {
		super(SPEED, rotation, width, height, position);
		this.rotation = rotation;
		attack = Settings.getAttack();

	}
	
	@Override
	public float getRotation(){
		return rotation;
	}
	
	@Override
	public void setRotation(float rotation){
		this.rotation = rotation;
	}
	

	/**
	 * @return the health
	 */
	public float getHealth() {
		return health;
	}

	/**
	 * @param health
	 *            the health to set
	 */
	public void setHealth(float health) {
		this.health = health;
	}

	/**
	 * @return the mana
	 */
	public float getMana() {
		return mana;
	}

	/**
	 * @param mana
	 *            the mana to set
	 */
	public void setMana(float mana) {
		this.mana = mana;
	}

	public void update() {
		

		bounds.x = position.x;
		bounds.y = position.y;

		if (Returners.DEBUG) {
//			Gdx.app.log(Returners.LOG, "Player located at " + position.x + " "
//					+ position.y);
		}
	}

	
}
