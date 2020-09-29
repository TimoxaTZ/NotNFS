package com.tricksless.cardrive;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.tricksless.cardrive.view.ActiveScreen;

public class Main extends Game {

	private Screen activeScreen;

	@Override
	public void create() {
		activeScreen = new ActiveScreen();
		setScreen(activeScreen);
	}
}
