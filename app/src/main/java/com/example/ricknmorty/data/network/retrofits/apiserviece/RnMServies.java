package com.example.ricknmorty.data.network.retrofits.apiserviece;

import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RnMServies {
    @GET("api/character")
    Call<RnMRespons<RnMCharacters>> fetchCharacters();

    @GET("api/character/{id}")
    Call<RnMCharacters> fetchCharacter(
            @Path("id") int id);
}
