package com.sorashu.aircraftwar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.sorashu.aircraftwar.databinding.ActivityLoginBinding;

public class LoginActivity extends Activity {
    private ActivityLoginBinding binding;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userInfoGen();
                checkLogin();
                goGame();
            }
        });
    }

    private void userInfoGen() {
        username = binding.usernamefill.getText().toString();
        password = binding.passwordfill.getText().toString();
    }

    private void checkLogin() {
        Toast.makeText(this,"Login success !",Toast.LENGTH_SHORT).show();
    }

    private void goGame() {
        Intent intent = new Intent(this, AndroidLauncher.class);
        int difficulty = getIntent().getIntExtra("difficulty", 0);
        boolean isSoundOn = getIntent().getBooleanExtra("isSoundOn", false);
        boolean isOnline = getIntent().getBooleanExtra("isOnline", false);
        intent.putExtra("difficulty", difficulty);
        intent.putExtra("isSoundOn", isSoundOn);
        intent.putExtra("isOnline", isOnline);
        intent.putExtra("username", username);
        startActivity(intent);
    }
}