package com.example.ricknmorty.data.network.retrofits;

import com.example.ricknmorty.data.network.retrofits.apiserviece.RnMServies;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    Retrofit retrofitClient = new Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public RnMServies provideCharacterApiService(){
        return retrofitClient.create(RnMServies.class);
    }
}
