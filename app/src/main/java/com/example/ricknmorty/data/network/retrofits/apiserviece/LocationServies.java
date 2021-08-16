package com.example.ricknmorty.data.network.retrofits.apiserviece;

import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.http.GET;

public interface LocationServies {
    @GET("api/location")
    Call<RnMRespons<RnMLocations>> fetchLocations();

}
