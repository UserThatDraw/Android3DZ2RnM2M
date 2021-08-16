package com.example.ricknmorty;

import android.app.Application;

import com.example.ricknmorty.data.network.retrofits.RetrofitClient;
import com.example.ricknmorty.data.network.retrofits.apiserviece.EpisodeServies;
import com.example.ricknmorty.data.network.retrofits.apiserviece.LocationServies;
import com.example.ricknmorty.data.network.retrofits.apiserviece.CharacterServies;

public class App extends Application {

    public static CharacterServies characterServies;
    public static LocationServies locationServies;
    public static EpisodeServies episodeServies;

    @Override
    public void onCreate() {
        super.onCreate();

        characterServies = new RetrofitClient().provideCharacterApiService();
        locationServies = new RetrofitClient().provideLocationApiService();
        episodeServies = new RetrofitClient().provideEpisodeApiService();
    }
}
