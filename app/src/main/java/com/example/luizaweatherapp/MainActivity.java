package com.example.luizaweatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luizaweatherapp.retrofit.ClientAPI;
import com.example.luizaweatherapp.retrofit.Example;
import com.example.luizaweatherapp.retrofit.InterfaceAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ImageView ivSearch;
    TextView tvCelsius, tvFeelsLike, tvHumidity;
    EditText textField;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivSearch = findViewById(R.id.ivSearch);
        tvCelsius = findViewById(R.id.tvCelsius);
        tvFeelsLike = findViewById(R.id.tvFeelsLike);
        tvHumidity = findViewById(R.id.tvHumidity);
        textField = findViewById(R.id.textField);
        btnLogout = findViewById(R.id.btnLogout);

        ivSearch.setOnClickListener(v -> getWeatherData(textField.getText().toString().trim()));

        btnLogout.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(i);
            finish();
        });
    }

    // communication with the API
    private void getWeatherData(String name) {

        InterfaceAPI interfaceAPI = ClientAPI.getClient().create(InterfaceAPI.class);
        Call<Example> call = interfaceAPI.getWeatherData(name);

        call.enqueue(new Callback<Example>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                if (response.isSuccessful()) {
                    tvCelsius.setText(response.body().getMain().getTemp() + " °C");
                    tvFeelsLike.setText("Feels Like: " + response.body().getMain().getFeels_like() + " °C");
                    tvHumidity.setText("Humidity: " + response.body().getMain().getHumidity());
                } else {
                    Toast.makeText(MainActivity.this, getString(R.string.error), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

            }
        });
    }
}