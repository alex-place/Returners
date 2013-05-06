package com.undeadstudio.returners;

import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();
		cfg.title = "Returners " + Returners.VERSION;
		cfg.useGL20 = true;
		cfg.width = 1280;// 640
		cfg.height = 720;// 360
		cfg.fullscreen = false;
		cfg.addIcon("data/imgs/icon128.png", FileType.Internal);
		cfg.addIcon("data/imgs/icon32.png", FileType.Internal);

		LwjglApplicationConfiguration.disableAudio = true;

		new LwjglApplication(new Returners(), cfg);
	}
}
