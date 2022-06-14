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
		boolean isSoundOn = getIntent().getBooleanExtra("isSoundOn", false);
		boolean isOnline = getIntent().getBooleanExtra("isOnline",false);
		String username = getIntent().getStringExtra("username");

		initialize(new MainGame(new CommunicationImpl(this),difficulty,isSoundOn,isOnline,username), config);
	}
}
