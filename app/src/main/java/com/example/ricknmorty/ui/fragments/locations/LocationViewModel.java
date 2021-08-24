package com.example.ricknmorty.ui.fragments.locations;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.data.network.retrofits.repository.RnMLocationRepository;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;

public class LocationViewModel extends ViewModel {

    RnMLocationRepository repository = new RnMLocationRepository();

    public MutableLiveData<RnMRespons<RnMLocations>> getLock(){
        return repository.fetchLocation();
    }
}
