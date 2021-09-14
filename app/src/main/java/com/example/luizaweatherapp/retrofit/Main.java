package com.example.luizaweatherapp.retrofit;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    String temp;

    @SerializedName("humidity")
    String humidity;

    @SerializedName("feels_like")
    String feels_like;

    // getter
    public String getTemp() { return temp; }
    public String getHumidity() { return humidity; }
    public String getFeels_like() { return feels_like; }

    // setter
    public void setTemp(String temp) { this.temp = temp; }
    public void setHumidity(String humidity) { this.humidity = humidity; }
    public void setFeels_like(String feels_like) { this.feels_like = feels_like; }
}
