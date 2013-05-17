package com.undeadstudio.returners.view;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;
import com.undeadstudio.returners.Returners;
import com.undeadstudio.returners.model.Bullet;
import com.undeadstudio.returners.model.Enemy;
import com.undeadstudio.returners.model.Enemy.TYPE;
import com.undeadstudio.returners.model.Player;
import com.undeadstudio.returners.model.Wall;
import com.undeadstudio.returners.model.World;
import com.undeadstudio.returners.screens.SettingsScreen;

public class WorldRenderer {

	World world;
	SpriteBatch batch;
	Player player;
	Wall wall;
	OrthographicCamera cam;
	Texture playerTexture, followerTexture, shooterTexture, bulletTexture;
	BitmapFont white, black;
	float width, height;
	ShapeRenderer sr;
	TextureAtlas atlas;

	Enemy e;
	Array<Enemy> enemies;
	Iterator<Enemy> eIter;

	Bullet b;
	Array<Bullet> bullets;
	Iterator<Bullet> bIter;

	Bullet enemyBullet;
	Array<Bullet> enemyBullets = new Array<Bullet>();
	Iterator<Bullet> enemyBulletIterator;

	public WorldRenderer(World world) {
		this.world = world;
		world.setRenderer(this);

		width = SettingsScreen.GAME_WIDTH;
		height = SettingsScreen.GAME_HEIGHT;

		playerTexture = new Texture("data/imgs/bow.png");
		playerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		followerTexture = new Texture("data/imgs/follower.png");
		followerTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		shooterTexture = new Texture("data/imgs/shooter.png");
		shooterTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		bulletTexture = new Texture("data/imgs/bullet.png");
		bulletTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);

		black = new BitmapFont(Gdx.files.internal("data/imgs/font.fnt"), false);
		white = new BitmapFont(Gdx.files.internal("data/imgs/whitefont.fnt"),
				false);

		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();

		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);

		sr = new ShapeRenderer();

	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void render() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

		// if (Gdx.app.getType() == ApplicationType.Android) {
		//
		// }

		// Get objects from world
		player = world.getPlayer();
		wall = world.getWall();
		enemies = world.getEnemies();
		bullets = world.getBullets();
		enemyBullets = world.getEnemyBullets();

		// Commence rendering

		// Draw the Heads-Up-Display(HUD)

		batch.begin();

		// Drawing the ship
		batch.draw(playerTexture, player.getPosition().x,
				player.getPosition().y, player.getWidth() / 2,
				player.getHeight() / 2, player.getWidth(), player.getHeight(),
				1, 1, player.getRotation(), 0, 0, playerTexture.getWidth(),
				playerTexture.getHeight(), false, false);

		// Get an iterator and use it to draw the enemies
		eIter = enemies.iterator();
		while (eIter.hasNext()) {
			e = eIter.next();
			if (e.getType() == TYPE.SHOOTER)
				batch.draw(shooterTexture, e.getPosition().x,
						e.getPosition().y, e.getWidth() / 2, e.getHeight() / 2,
						e.getWidth(), e.getHeight(), 1, 1, e.getRotation(), 0,
						0, followerTexture.getWidth(),
						followerTexture.getHeight(), false, false);
			else if (e.getType() == TYPE.WALKER)
				batch.draw(followerTexture, e.getPosition().x,
						e.getPosition().y, e.getWidth() / 2, e.getHeight() / 2,
						e.getWidth(), e.getHeight(), 1, 1, e.getRotation(), 0,
						0, followerTexture.getWidth(),
						followerTexture.getHeight(), false, false);

			else
				batch.draw(followerTexture, e.getPosition().x,
						e.getPosition().y, e.getWidth() / 2, e.getHeight() / 2,
						e.getWidth(), e.getHeight(), 1, 1, e.getRotation(), 0,
						0, followerTexture.getWidth(),
						followerTexture.getHeight(), false, false);

		}

		// Get an iterator and use it to draw the bullets
		bIter = bullets.iterator();
		while (bIter.hasNext()) {
			b = bIter.next();
			batch.draw(bulletTexture, b.getPosition().x, b.getPosition().y,
					b.getWidth() / 2, b.getHeight() / 2, b.getWidth(),
					b.getHeight(), 1, 1, b.getRotation(), 0, 0,
					bulletTexture.getWidth(), bulletTexture.getHeight(), false,
					false);
		}

		// Get an iterator and use it to draw the bullets
		enemyBulletIterator = enemyBullets.iterator();
		while (enemyBulletIterator.hasNext()) {
			enemyBullet = enemyBulletIterator.next();
			batch.draw(bulletTexture, enemyBullet.getPosition().x,
					enemyBullet.getPosition().y, enemyBullet.getWidth() / 2,
					enemyBullet.getHeight() / 2, enemyBullet.getWidth(),
					enemyBullet.getHeight(), 1, 1, enemyBullet.getRotation(),
					0, 0, bulletTexture.getWidth(), bulletTexture.getHeight(),
					false, false);
		}

		if (Returners.DEBUG) {
			black.setColor(Color.WHITE);
			black.draw(batch, "Debug enabled", Gdx.graphics.getWidth() / 2,
					Gdx.graphics.getHeight() / 2);
		}

		// Done rendering
		batch.end();

		// If we're debugging, draw collision boxes
		if (Returners.DEBUG) {

			sr.begin(ShapeType.Line);

			// Draw the wall bounds
			sr.setProjectionMatrix(cam.combined);
			sr.setColor(Color.CYAN);

			sr.rect(wall.getBounds().x, wall.getBounds().y,
					wall.getBounds().width, wall.getBounds().height);

			sr.setColor(Color.CYAN);
			sr.rect(player.getBounds().x, player.getBounds().y,
					player.getBounds().width, player.getBounds().height);

			bIter = bullets.iterator();
			while (bIter.hasNext()) {
				b = bIter.next();
				sr.rect(b.getBounds().x, b.getBounds().y, b.getBounds().width,
						b.getBounds().height);
			}

			sr.setColor(Color.RED);

			enemyBulletIterator = enemyBullets.iterator();
			while (enemyBulletIterator.hasNext()) {
				enemyBullet = enemyBulletIterator.next();
				sr.rect(enemyBullet.getBounds().x, enemyBullet.getBounds().y,
						enemyBullet.getBounds().width,
						enemyBullet.getBounds().height);
			}

			eIter = enemies.iterator();
			while (eIter.hasNext()) {
				e = eIter.next();
				sr.rect(e.getBounds().x, e.getBounds().y, e.getBounds().width,
						e.getBounds().height);
			}

			sr.end();

		}

		// Draw our stage
		world.stage.draw();
	}

	public OrthographicCamera getCamera() {
		return cam;
	}

	public void dispose() {
		sr.dispose();
		batch.dispose();
		playerTexture.dispose();
		followerTexture.dispose();
		bulletTexture.dispose();

	}
}
