package com.example.ricknmorty.data.network.retrofits.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.ricknmorty.App;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMRespons;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RnMCharacterRepository {

    public MutableLiveData<RnMRespons<RnMCharacters>> fetchCharacters(int page) {
        MutableLiveData<RnMRespons<RnMCharacters>> data = new MutableLiveData<>();
        App.characterServies.fetchCharacters(page).enqueue(new Callback<RnMRespons<RnMCharacters>>() {
            @Override
            public void onResponse(Call<RnMRespons<RnMCharacters>> call, Response<RnMRespons<RnMCharacters>> response) {
                App.characterDao.insertAll(response.body().getResults());
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMRespons<RnMCharacters>> call, Throwable t) {

            }
        });
        return data;
    }

    public MutableLiveData<RnMCharacters> addDescription(int id) {
        MutableLiveData<RnMCharacters> characterDescription = new MutableLiveData<>();
        App.characterServies.fetchCharacter(id).enqueue(new Callback<RnMCharacters>() {
            @Override
            public void onResponse(Call<RnMCharacters> call, Response<RnMCharacters> response) {
                characterDescription.setValue(response.body());
            }

            @Override
            public void onFailure(Call<RnMCharacters> call, Throwable t) {
                characterDescription.setValue(null);
            }
        });
        return characterDescription;
    }
}
