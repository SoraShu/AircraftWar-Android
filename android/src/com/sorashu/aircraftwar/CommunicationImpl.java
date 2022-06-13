package com.sorashu.aircraftwar;

import android.app.Activity;
import android.content.Intent;

import com.sorashu.aircraftwar.application.CommunicationInterface;

public class CommunicationImpl implements CommunicationInterface {
    private Activity currentActivity;
    public CommunicationImpl(Activity currentActivity) {
        this.currentActivity = currentActivity;
    }

    @Override
    public void goRankListActivity(int score) {
        //Intent intent = new Intent(currentActivity,RankListActivity.class);
    }

    @Override
    public void endGame() {
        currentActivity.finish();
    }
}
