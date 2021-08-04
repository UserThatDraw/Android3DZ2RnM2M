package com.example.ricknmorty.ui.fragments.locations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricknmorty.OnClick;
import com.example.ricknmorty.R;
import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentEpisodesBinding;
import com.example.ricknmorty.databinding.FragmentLocationsBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.ui.adapters.LocationAdapter;
import com.example.ricknmorty.ui.fragments.characters.CharacterViewModel;
import com.example.ricknmorty.ui.fragments.characters.CharactersFragmentDirections;

public class LocationsFragment extends BaseFragment<FragmentLocationsBinding, LocationViewModel> {

    LocationAdapter adapter = new LocationAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLocationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    protected void setupViews() {
        super.setupViews();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        binding.rvLock.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvLock.setAdapter(adapter);
    }

    @Override
    protected void setupRequests() {
        super.setupRequests();
        viewModel.getLock().observe(getViewLifecycleOwner(), new Observer<RnMRespons<RnMLocations>>() {
            @Override
            public void onChanged(RnMRespons<RnMLocations> rnMLocationsRnMRespons) {
                adapter.setIn(rnMLocationsRnMRespons.getResults());
            }
        });
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
    }
}