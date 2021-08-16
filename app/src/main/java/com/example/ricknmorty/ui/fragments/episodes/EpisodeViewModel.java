package com.example.ricknmorty.ui.fragments.episodes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.data.network.retrofits.repository.RnMRepository;

public class EpisodeViewModel extends ViewModel {

    RnMRepository repository = new RnMRepository();

    public MutableLiveData<RnMRespons<RnMEpisodes>> getEpi(){
        return repository.fetchEpisode();
    }
}
