package com.example.ricknmorty.ui.fragments.locations;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.data.network.retrofits.repository.RnMRepository;

public class LocationViewModel extends ViewModel {

    RnMRepository repository = new RnMRepository();

    public MutableLiveData<RnMRespons<RnMLocations>> getLock(){
        return repository.fetchLocation();
    }
}
