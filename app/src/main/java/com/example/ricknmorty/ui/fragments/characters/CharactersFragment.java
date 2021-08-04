package com.example.ricknmorty.ui.fragments.characters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricknmorty.OnClick;
import com.example.ricknmorty.R;
import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentCharactersBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.ui.adapters.CharacterAdapter;

public class CharactersFragment extends BaseFragment<FragmentCharactersBinding, CharacterViewModel> {

    CharacterAdapter adapter = new CharacterAdapter();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCharactersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    protected void setupViews() {
        super.setupViews();
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rv.setAdapter(adapter);
    }

    @Override
    protected void setupListener() {
        super.setupListener();
        setupOnClickItem();
    }

    private void setupOnClickItem() {
        adapter.setOnClick(new OnClick() {
            @Override
            public void getSmt(int id, View view) {
                Navigation.findNavController(view).navigate(CharactersFragmentDirections.actionCharactersFragmentToDescriptionsFragment(id).setCharacterId(id));
            }
        });
    }

    @Override
    protected void setupRequests() {
        super.setupRequests();
        viewModel.getChar().observe(getViewLifecycleOwner(), new Observer<RnMRespons<RnMCharacters>>() {
            @Override
            public void onChanged(RnMRespons<RnMCharacters> rnMCharactersRnMRespons) {
                adapter.setIn(rnMCharactersRnMRespons.getResults());
            }
        });
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
    }
}