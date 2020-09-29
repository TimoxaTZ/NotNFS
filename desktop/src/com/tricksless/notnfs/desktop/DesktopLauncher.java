package com.tricksless.notnfs.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.tricksless.notnfs.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Main(), config);
		config.width = 1024;
		config.height = 768;
		config.foregroundFPS = 0;
		config.vSyncEnabled = false;
	}
}
