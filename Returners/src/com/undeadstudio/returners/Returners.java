package com.undeadstudio.returners;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.undeadstudio.returners.persistence.Settings;
import com.undeadstudio.returners.screens.GameOverScreen;

public class Returners extends Game {

	public static final String VERSION = "0.1.3 Pre-Alpha";
	public static final String LOG = "Returners " + VERSION;
	public static boolean DEBUG = true;

	Settings settings;

	@Override
	public void create() {
		if (Returners.DEBUG) {
			Gdx.app.log(LOG, "Returners " + VERSION + " initialized!");
		}

		settings = new Settings();

		setScreen(new GameOverScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public Settings getSettings() {
		return settings;
	}

}
