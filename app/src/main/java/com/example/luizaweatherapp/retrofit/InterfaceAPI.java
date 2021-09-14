package com.example.luizaweatherapp.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfaceAPI {

    // necessary head of the http to get the data
    @GET("weather?appid=41aff7eb72c24f219d27b1885b23b191&units=metric")
    Call<Example> getWeatherData(@Query("q") String name);
}
