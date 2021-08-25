package com.example.ricknmorty.ui.fragments.characters;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ricknmorty.App;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.data.network.retrofits.repository.RnMCharacterRepository;

import java.util.List;

public class CharacterViewModel extends ViewModel {

    public int charactersPage = 1;
    RnMCharacterRepository repository = new RnMCharacterRepository();

    public MutableLiveData<RnMRespons<RnMCharacters>> getChar(){
        return repository.fetchCharacters(charactersPage);
    }

    List<RnMCharacters> getCharacters(){
       return App.characterDao.getAll();
    }
}
