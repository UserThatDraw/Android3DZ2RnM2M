package com.example.ricknmorty.ui.fragments.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricknmorty.R;
import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentCharactersBinding;
import com.example.ricknmorty.databinding.FragmentSettingsBinding;
import com.example.ricknmorty.interfaces.OnClick;
import com.example.ricknmorty.ui.fragments.characters.CharacterViewModel;
import com.example.ricknmorty.ui.fragments.characters.CharactersFragmentDirections;

public class SettingsFragment extends BaseFragment<FragmentSettingsBinding, CharacterViewModel> {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void setupListener() {
        super.setupListener();
        setupOnClickItem();
    }

    private void setupOnClickItem() {
        binding.darkThemeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        binding.lightThemeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}