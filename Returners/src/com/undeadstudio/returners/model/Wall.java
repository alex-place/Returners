package com.undeadstudio.returners.model;

import com.badlogic.gdx.math.Vector2;

public class Wall extends Entity {
	Player player;

	public Wall(Player player, Vector2 position, float width, float height) {
		super(position, width, height);
		this.player = player;
	}
	
	protected float health = 1000;

	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	

}
