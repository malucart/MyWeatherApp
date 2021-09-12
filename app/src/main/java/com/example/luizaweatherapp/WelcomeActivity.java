/*
 Welcome screen
*/

package com.example.luizaweatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.luizaweatherapp.animation.TypeWriter;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // changing color on status bar
        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(this.getResources().getColor(R.color.mainBlue));

        // animation on textview
        final TypeWriter tw = (TypeWriter) findViewById(R.id.tvTitle);
        tw.setText("");
        tw.setCharacterDelay(130);
        tw.animateText(getString(R.string.howIsToday));

        Button btnGo = findViewById(R.id.btnGo);

        btnGo.setOnClickListener(v -> {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
            finish();
        });
    }
}
