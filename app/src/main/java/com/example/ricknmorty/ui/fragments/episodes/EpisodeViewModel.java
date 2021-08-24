package com.example.ricknmorty.ui.fragments.episodes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.data.network.retrofits.repository.RnMEpisodeRepository;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMRespons;

public class EpisodeViewModel extends ViewModel {

    RnMEpisodeRepository repository = new RnMEpisodeRepository();

    public MutableLiveData<RnMRespons<RnMEpisodes>> getEpi(){
        return repository.fetchEpisode();
    }
}
