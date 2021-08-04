package com.example.ricknmorty.ui.adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricknmorty.databinding.ItemCharacterBinding;
import com.example.ricknmorty.databinding.ItemEpisodeBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter <EpisodeAdapter.EpisodeViewHolder> {
    private List<RnMEpisodes> list =  new ArrayList<>();
    private ItemEpisodeBinding binding;

    public void setIn(List<RnMEpisodes> lif){
        list = lif;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new EpisodeViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder{

        public EpisodeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
        }

        public void onBind(RnMEpisodes rnMEpisodes) {
            binding.textItemEpisode.setText(rnMEpisodes.name);
            binding.textItemEpisodeD.setText(rnMEpisodes.date);
            binding.textItemEpisodeE.setText(rnMEpisodes.episode);
        }
    }
}
