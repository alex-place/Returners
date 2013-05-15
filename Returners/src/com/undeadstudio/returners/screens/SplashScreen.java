package com.undeadstudio.returners.screens;

import aurelienribon.tweenengine.BaseTween;
import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenCallback;
import aurelienribon.tweenengine.TweenEquations;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Application.ApplicationType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.swarmconnect.Swarm;
import com.undeadstudio.returners.Returners;
import com.undeadstudio.returners.model.SpriteTween;

public class SplashScreen implements Screen {

	Texture splashTexture;
	Sprite splashSprite;
	SpriteBatch batch;

	TweenManager manager;

	Returners game;

	Input input;

	Skin buttonSkin;

	Button startGame;

	Button quit;

	public SplashScreen(Returners returners) {
		this.game = returners;
		if (Gdx.app.getType() == ApplicationType.WebGL)
			show();
	}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		manager.update(delta);
		Gdx.input.setInputProcessor(new InputProcessor() {

			@Override
			public boolean keyDown(int keycode) {
				if (keycode == Keys.ESCAPE) {
					callbackComplete();
				}
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDown(int screenX, int screenY, int pointer,
					int button) {
				callbackComplete();
				return true;
			}

			@Override
			public boolean touchUp(int screenX, int screenY, int pointer,
					int button) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean touchDragged(int screenX, int screenY, int pointer) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean mouseMoved(int screenX, int screenY) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean scrolled(int amount) {
				// TODO Auto-generated method stub
				return false;
			}

		});
		batch.begin();

		splashSprite.draw(batch);

		batch.end();

	}

	@Override
	public void show() {
		splashTexture = new Texture("data/imgs/splash.png");
		splashTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		splashSprite = new Sprite(splashTexture);
		splashSprite.setColor(1, 1, 1, 0);
		splashSprite
				.setPosition(
						(Gdx.graphics.getWidth() / 2)
								- (splashSprite.getWidth() / 2),
						(Gdx.graphics.getHeight() / 2)
								- (splashSprite.getHeight() / 2));

		batch = new SpriteBatch();

		Tween.registerAccessor(Sprite.class, new SpriteTween());

		manager = new TweenManager();

		TweenCallback callback = new TweenCallback() {

			@Override
			public void onEvent(int type, BaseTween<?> source) {
				callbackComplete();
			}

		};

		Tween.to(splashSprite, SpriteTween.ALPHA, 2f).target(1)
				.ease(TweenEquations.easeInQuad).repeatYoyo(1, 2.5f)
				.setCallback(callback)
				.setCallbackTriggers(TweenCallback.COMPLETE).start(manager);

		// Begin my code
		
		// End my code

	}

	public void callbackComplete() {

		if (Returners.DEBUG)
			Gdx.app.log(Returners.LOG, "Tween Completed");

		game.setScreen(new MainMenu(game));
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		splashTexture.dispose();
		batch.dispose();
	}

}
