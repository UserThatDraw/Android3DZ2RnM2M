package com.example.ricknmorty.ui.fragments.locations;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.App;
import com.example.ricknmorty.data.network.retrofits.repository.RnMLocationRepository;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;

import java.util.List;

public class LocationViewModel extends ViewModel {

    public int locationPage = 1;
    RnMLocationRepository repository = new RnMLocationRepository();

    public MutableLiveData<RnMRespons<RnMLocations>> getLock(){
        return repository.fetchLocation(locationPage);
    }

    List<RnMLocations> getLocation(){
        return App.locationDao.getAll();
    }
}
