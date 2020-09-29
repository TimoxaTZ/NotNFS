package com.tricksless.notnfs;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.tricksless.notnfs.view.ActiveScreen;

public class Main extends Game {

	private Screen activeScreen;

	@Override
	public void create() {
		activeScreen = new ActiveScreen();
		setScreen(activeScreen);
	}
}
