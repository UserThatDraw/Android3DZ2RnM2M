package com.example.ricknmorty.ui.fragments.locations;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentLocationsBinding;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.ui.adapters.LocationAdapter;

import java.util.List;

public class LocationsFragment extends BaseFragment<FragmentLocationsBinding, LocationViewModel> {

    LocationAdapter adapter = new LocationAdapter();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

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
        binding.rvLock.setLayoutManager(linearLayoutManager);
        binding.rvLock.setAdapter(adapter);
    }

    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisibleItem;

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
            Toast.makeText(getContext(), "Loaded from cash", Toast.LENGTH_SHORT).show();
            List<RnMLocations> list = viewModel.getLocation();
            adapter.setIn(list);
        }

        binding.rvLock.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0){
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisibleItem) >= totalItemCount){
                        viewModel.locationPage = 2;
                        viewModel.getLock().observe(getViewLifecycleOwner(), rnMLocationsRnMRespons ->
                                adapter.setIn(rnMLocationsRnMRespons.getResults()));
                    }
                }
            }
        });
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(LocationViewModel.class);
    }
}