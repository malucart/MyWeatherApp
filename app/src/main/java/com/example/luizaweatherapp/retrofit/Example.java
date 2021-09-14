package com.example.luizaweatherapp.retrofit;

import com.google.gson.annotations.SerializedName;

public class Example {

    @SerializedName("main")
    private Main main;

    // getter
    public Main getMain() {
        return main;
    }

    // setter
    public void setMain(Main main) {
        this.main = main;
    }
}
