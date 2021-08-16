package com.example.ricknmorty.data.network.retrofits.apiserviece;

import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EpisodeServies {

    @GET("api/episode")
    Call<RnMRespons<RnMEpisodes>> fetchEpisode();
}
