package com.example.ricknmorty;

import android.app.Application;

import com.example.ricknmorty.data.network.retrofits.RetrofitClient;
import com.example.ricknmorty.data.network.retrofits.apiserviece.RnMServies;

public class App extends Application {

    public static RnMServies rnMServies;

    @Override
    public void onCreate() {
        super.onCreate();

        rnMServies = new RetrofitClient().provideCharacterApiService();
    }
}
