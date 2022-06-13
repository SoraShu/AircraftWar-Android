package com.sorashu.aircraftwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.sorashu.aircraftwar.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.playbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DifficultyActivity.class);
                startActivity(intent);
            }
        });


    }
}