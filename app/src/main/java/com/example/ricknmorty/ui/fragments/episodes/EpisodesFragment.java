package com.example.ricknmorty.ui.fragments.episodes;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricknmorty.R;
import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentCharactersBinding;
import com.example.ricknmorty.databinding.FragmentEpisodesBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.ui.adapters.CharacterAdapter;
import com.example.ricknmorty.ui.adapters.EpisodeAdapter;
import com.example.ricknmorty.ui.fragments.locations.LocationViewModel;

import java.util.List;

public class EpisodesFragment extends BaseFragment<FragmentEpisodesBinding, EpisodeViewModel> {

    EpisodeAdapter adapter = new EpisodeAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }



    @Override
    protected void setupViews() {
        super.setupViews();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        binding.rvEpi.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvEpi.setAdapter(adapter);
    }

    @Override
    protected void setupRequests() {
        super.setupRequests();
        ConnectivityManager cm =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()){
            viewModel.getEpi().observe(getViewLifecycleOwner(), new Observer<RnMRespons<RnMEpisodes>>() {
                @Override
                public void onChanged(RnMRespons<RnMEpisodes> rnMEpisodesRnMRespons) {
                    adapter.setIn(rnMEpisodesRnMRespons.getResults());
                }
            });
        }else {
            List<RnMEpisodes> list = viewModel.getEpisode();
            adapter.setIn(list);
        }
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(EpisodeViewModel.class);
    }

}