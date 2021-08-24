package com.example.ricknmorty;

import android.app.Application;

import com.example.ricknmorty.data.db.RoomClient;
import com.example.ricknmorty.data.db.daos.CharacterDao;
import com.example.ricknmorty.data.network.retrofits.RetrofitClient;
import com.example.ricknmorty.data.network.retrofits.apiserviece.EpisodeServies;
import com.example.ricknmorty.data.network.retrofits.apiserviece.LocationServies;
import com.example.ricknmorty.data.network.retrofits.apiserviece.CharacterServies;

public class App extends Application {

    protected static RetrofitClient retrofitClient = new RetrofitClient();
    public static CharacterServies characterServies;
    public static LocationServies locationServies;
    public static EpisodeServies episodeServies;
    public static CharacterDao characterDao;

    @Override
    public void onCreate() {
        super.onCreate();

        characterServies = retrofitClient.provideCharacterApiService();
        locationServies = retrofitClient.provideLocationApiService();
        episodeServies = retrofitClient.provideEpisodeApiService();
        RoomClient roomClient = new RoomClient();
        //characterDao = roomClient.
    }
}
