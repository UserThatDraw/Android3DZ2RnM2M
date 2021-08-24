package com.example.ricknmorty.data.network.retrofits.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.ricknmorty.App;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RnMEpisodeRepository {

    public MutableLiveData<RnMRespons<RnMEpisodes>> fetchEpisode() {
        MutableLiveData<RnMRespons<RnMEpisodes>> data = new MutableLiveData<>();
        App.episodeServies.fetchEpisode().enqueue(new Callback<RnMRespons<RnMEpisodes>>() {
            @Override
            public void onResponse(Call<RnMRespons<RnMEpisodes>> call, Response<RnMRespons<RnMEpisodes>> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMRespons<RnMEpisodes>> call, Throwable t) {

            }
        });
        return data;
    }

}
