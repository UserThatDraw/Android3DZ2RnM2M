package com.example.ricknmorty.ui.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricknmorty.OnClick;
import com.example.ricknmorty.databinding.ItemCharacterBinding;
import com.example.ricknmorty.databinding.ItemLocationBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LocationAdapter extends RecyclerView.Adapter <LocationAdapter.LocationViewHolder> {
    private List<RnMLocations> list =  new ArrayList<>();
    private ItemLocationBinding binding;

    public void setIn(List<RnMLocations> lif){
        list = lif;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new LocationViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull LocationViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder{

        public LocationViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

        }

        public void onBind(RnMLocations rnMLocations) {
            binding.textItemLocation.setText(rnMLocations.name);
            binding.textItemLocationD.setText(rnMLocations.dimension);
            binding.textItemLocationT.setText(rnMLocations.type);
        }
    }
}







