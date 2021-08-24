package com.example.ricknmorty.ui.fragments.descriptions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.data.network.retrofits.repository.RnMCharacterRepository;

public class DescriptionViewModel extends ViewModel {

    RnMCharacterRepository repository = new RnMCharacterRepository();

    public MutableLiveData<RnMCharacters> charRnM(int id){
        return repository.addDescription(id);
    }

}
