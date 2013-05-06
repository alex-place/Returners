package com.undeadstudio.returners.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.undeadstudio.returners.Returners;
import com.undeadstudio.returners.model.World;
import com.undeadstudio.returners.view.WorldRenderer;

public class GameScreen implements Screen {

	Returners game;
	World world;
	WorldRenderer renderer;

	public GameScreen(Returners game) {
		this.game = game;
		world = new World(game);
		renderer = new WorldRenderer(world);
		Gdx.graphics.setVSync(true);
	}

	@Override
	public void render(float delta) {

		if (SettingsScreen.GAME_PAUSED == false
				&& SettingsScreen.GAME_OVER == false)
			world.update(delta);

		renderer.render();
	}

	@Override
	public void resize(int width, int height) {

		world.resize(width, height);
	}

	@Override
	public void show() {

	}

	@Override
	public void hide() {
		dispose();
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		world.dispose();
	}

}
