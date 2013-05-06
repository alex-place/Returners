package com.undeadstudio.returners.model;

import java.util.Random;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.undeadstudio.returners.screens.SettingsScreen;

public class EnemyFactory {

	Random random = new Random();

	public static int WAVE_SHOOTER = 5;
	public static int WAVE_WALKER = 15;

	private final int WALKER_ZONES = 9;
	private final int SHOOTER_ZONES = 9;

	protected float speed = 1;

	public static final float WALKER_SPEED = 2;
	public static final float SHOOTER_SPEED = 1;

	public float randomSpawnZone(int zones) {
		float SPAWNZONE = MathUtils.random(1, zones);
		return (SettingsScreen.GAME_HEIGHT / zones) * SPAWNZONE - 1;
	}

	// public void newAllWave(Array<Enemy> enemies, int number) {}

	public Array<Enemy> newWalkerWave(Array<Enemy> enemies, int number) {

		for (int i = 0; i < number; ++i) {
			enemies.add(new Walker(WALKER_SPEED, 1, 1, new Vector2(
					SettingsScreen.GAME_WIDTH
							+ (MathUtils.random() * 3) + 1,
					randomSpawnZone(WALKER_ZONES))));
		}
		enemies.shrink();
		return enemies;
	}

	public Array<Enemy> newShooterWave(Array<Enemy> enemies, int number) {
		for (int i = 0; i < number; ++i) {
			enemies.add(new Shooter(SHOOTER_SPEED, 1, 1, new Vector2(
					SettingsScreen.GAME_WIDTH
							+ (MathUtils.random() * 3) + 3,
					randomSpawnZone(SHOOTER_ZONES))));
		}

		enemies.shrink();
		return enemies;
	}

}
