package com.example.ricknmorty.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.view.MenuItem;

import com.example.ricknmorty.R;
import com.example.ricknmorty.databinding.ActivityMainBinding;
import com.example.ricknmorty.ui.fragments.characters.CharactersFragment;
import com.example.ricknmorty.ui.fragments.episodes.EpisodesFragment;
import com.example.ricknmorty.ui.fragments.locations.LocationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private NavController navController;
    AppBarConfiguration appBarConfiguration;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setupNavigation();
    }

    private void setupNavigation() {
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(binding.bottomNavigation,navController );

        appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.charactersFragment,
                R.id.locationsFragment,
                R.id.episodesFragment
        ).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration) || super.onSupportNavigateUp();
    }















}