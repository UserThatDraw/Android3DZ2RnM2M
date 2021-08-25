package com.example.ricknmorty.data.network.retrofits.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.ricknmorty.App;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RnMLocationRepository {

    public MutableLiveData<RnMRespons<RnMLocations>> fetchLocation(int locationPage) {
        MutableLiveData<RnMRespons<RnMLocations>> data = new MutableLiveData<>();
        App.locationServies.fetchLocations(locationPage).enqueue(new Callback<RnMRespons<RnMLocations>>() {
            @Override
            public void onResponse(Call<RnMRespons<RnMLocations>> call, Response<RnMRespons<RnMLocations>> response) {
                App.locationDao.insertAll(response.body().getResults());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMRespons<RnMLocations>> call, Throwable t) {

            }
        });
        return data;
    }
}
