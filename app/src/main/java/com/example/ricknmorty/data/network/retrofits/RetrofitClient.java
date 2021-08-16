package com.example.ricknmorty.data.network.retrofits;

import com.example.ricknmorty.data.network.retrofits.apiserviece.EpisodeServies;
import com.example.ricknmorty.data.network.retrofits.apiserviece.LocationServies;
import com.example.ricknmorty.data.network.retrofits.apiserviece.CharacterServies;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    Retrofit retrofitClient = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public CharacterServies provideCharacterApiService(){
        return retrofitClient.create(CharacterServies.class);
    }

    public LocationServies provideLocationApiService(){
        return retrofitClient.create(LocationServies.class);
    }
    public EpisodeServies provideEpisodeApiService(){
        return retrofitClient.create(EpisodeServies.class);
    }

}
