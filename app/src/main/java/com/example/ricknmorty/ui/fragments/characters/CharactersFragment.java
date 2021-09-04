package com.example.ricknmorty.ui.fragments.characters;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ricknmorty.App;
import com.example.ricknmorty.interfaces.OnClick;
import com.example.ricknmorty.base.BaseFragment;
import com.example.ricknmorty.databinding.FragmentCharactersBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMRespons;
import com.example.ricknmorty.ui.adapters.CharacterAdapter;

import java.util.List;

public class CharactersFragment extends BaseFragment<FragmentCharactersBinding, CharacterViewModel> {

    CharacterAdapter adapter = new CharacterAdapter();
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());

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
        binding.rv.setLayoutManager(linearLayoutManager);
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

    private int visibleItemCount;
    private int totalItemCount;
    private int pastVisibleItem;

    @Override
    protected void setupRequests() {
        super.setupRequests();
        ConnectivityManager cm =
                (ConnectivityManager) getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            viewModel.getChar().observe(getViewLifecycleOwner(), new Observer<RnMRespons<RnMCharacters>>() {
                @Override
                public void onChanged(RnMRespons<RnMCharacters> rnMCharactersRnMRespons) {
                    App.characterDao.insertAll(rnMCharactersRnMRespons.getResults());
                    adapter.submitList(rnMCharactersRnMRespons.getResults());
                }
            });
        } else {
            Toast.makeText(getContext(), "Loaded from cash", Toast.LENGTH_SHORT).show();
            List<RnMCharacters> list = viewModel.getCharacters();
            adapter.submitList(list);
        }

        binding.rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0) {
                    linearLayoutManager.getChildCount();
                    visibleItemCount = linearLayoutManager.getChildCount();
                    totalItemCount = linearLayoutManager.getItemCount();
                    pastVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();
                    if ((visibleItemCount + pastVisibleItem) >= totalItemCount) {
                        viewModel.charactersPage++;
                        viewModel.getChar().observe(getViewLifecycleOwner(), rnMCharactersRnMRespons ->
                                adapter.submitList(rnMCharactersRnMRespons.getResults()));
                    }
                }
            }
        });
    }

    @Override
    protected void initialize() {
        super.initialize();
        viewModel = new ViewModelProvider(this).get(CharacterViewModel.class);
    }
}