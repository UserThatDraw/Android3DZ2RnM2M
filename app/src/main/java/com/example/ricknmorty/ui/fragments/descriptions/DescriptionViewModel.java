package com.example.ricknmorty.ui.fragments.descriptions;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.repository.RnMRepository;

public class DescriptionViewModel extends ViewModel {

    RnMRepository repository = new RnMRepository();

    public MutableLiveData<RnMCharacters> charRnM(int id){
        return repository.addDescription(id);
    }

}
