package com.example.ricknmorty.ui.fragments.locations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentLocationsBinding;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.ui.adapters.LocationAdapter;

import java.util.List;

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
        ConnectivityManager cm =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            viewModel.getLock().observe(getViewLifecycleOwner(), new Observer<RnMRespons<RnMLocations>>() {
                @Override
                public void onChanged(RnMRespons<RnMLocations> rnMLocationsRnMRespons) {
                    adapter.setIn(rnMLocationsRnMRespons.getResults());
                }
            });
        }else {
            List<RnMLocations> list = viewModel.getLocation();
            adapter.setIn(list);
        }
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
    }
}