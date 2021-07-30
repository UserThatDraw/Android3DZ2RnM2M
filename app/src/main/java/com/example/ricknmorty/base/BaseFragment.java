package com.example.ricknmorty.base;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ricknmorty.R;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment <Binding, ViewModel> extends Fragment {

    protected Binding binding;
    protected ViewModel viewModel;

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialize();
        setupListener();
        setupRequests();
        setupObserve();
        setupViews();
    }

    protected void setupRequests() {

    }

    protected void initialize() {

    }

    protected void setupListener() {

    }

    protected void setupObserve() {

    }

    protected  void setupViews() {

    }

}