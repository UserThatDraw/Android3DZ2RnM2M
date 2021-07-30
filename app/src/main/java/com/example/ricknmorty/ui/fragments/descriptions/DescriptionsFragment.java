package com.example.ricknmorty.ui.fragments.descriptions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.renderscript.Script;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.ricknmorty.R;
import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentCharactersBinding;
import com.example.ricknmorty.databinding.FragmentDescriptionsBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.ui.fragments.characters.CharacterViewModel;

public class DescriptionsFragment extends BaseFragment<FragmentDescriptionsBinding, DescriptionViewModel> {

    int id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDescriptionsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(DescriptionViewModel.class);
        setupId();
    }

    private void setupId() {
        id = DescriptionsFragmentArgs.fromBundle(getArguments()).getCharacterId();
    }

    @Override
    protected void setupRequests() {
        super.setupRequests();
        viewModel.charRnM(id).observe(getViewLifecycleOwner(), new Observer<RnMCharacters>() {
            @Override
            public void onChanged(RnMCharacters rnMCharacters) {
                Glide
                        .with(binding.imageDescription)
                        .load(rnMCharacters.image)
                        .into(binding.imageDescription);
                binding.textNameDescription.setText(rnMCharacters.name);
            }
        });
    }
}