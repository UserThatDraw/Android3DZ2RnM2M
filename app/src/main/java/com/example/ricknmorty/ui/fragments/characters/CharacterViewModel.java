package com.example.ricknmorty.ui.fragments.characters;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.data.network.retrofits.repository.RnMRepository;

public class CharacterViewModel extends ViewModel {

    RnMRepository repository = new RnMRepository();

    public MutableLiveData<RnMRespons<RnMCharacters>> getChar(){
        return repository.fetchCharacters();
    }
}
