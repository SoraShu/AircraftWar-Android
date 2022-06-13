package com.sorashu.aircraftwar;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.sorashu.aircraftwar.application.MainGame;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

		int difficulty = getIntent().getIntExtra("difficulty", 0);
		boolean soundIsOn = getIntent().getBooleanExtra("isSoundOn", false);

		initialize(new MainGame(new CommunicationImpl(this),difficulty,soundIsOn), config);
	}
}
