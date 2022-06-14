package com.sorashu.aircraftwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sorashu.aircraftwar.databinding.ActivityDifficultyBinding;

public class DifficultyActivity extends Activity {
    private ActivityDifficultyBinding binding;
    private int difficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDifficultyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.easybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficulty = 0;
                goGame();
            }
        });

        binding.normalbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficulty = 1;
                goGame();
            }
        });

        binding.difficultbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                difficulty = 2;
                goGame();
            }
        });
    }

    private void goGame() {
        boolean isOnline = binding.onlineswitch.isChecked();
        Intent intent;
        if(isOnline) {
            intent = new Intent(this, LoginActivity.class);
        }else {
            intent = new Intent(this, AndroidLauncher.class);
        }
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("isSoundOn",binding.soundswitch.isChecked());
        intent.putExtra("isOnline",isOnline);
        intent.putExtra("username", "");
        startActivity(intent);
    }
}