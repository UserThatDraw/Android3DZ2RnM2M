package com.example.ricknmorty.ui.adapters;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricknmorty.databinding.ItemCharacterBinding;
import com.example.ricknmorty.databinding.ItemEpisodeBinding;
import com.example.ricknmorty.databinding.ItemLocationBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMEpisodes;
import com.example.ricknmorty.models.RnMLocations;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class EpisodeAdapter extends ListAdapter<RnMEpisodes, EpisodeAdapter.EpisodeViewHolder> {

    public EpisodeAdapter() {
        super(new EpisodeDiffUtil());
    }

    public static class EpisodeDiffUtil extends DiffUtil.ItemCallback<RnMEpisodes>{

        @Override
        public boolean areItemsTheSame(@NonNull RnMEpisodes oldItem, @NonNull RnMEpisodes newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull RnMEpisodes oldItem, @NonNull RnMEpisodes newItem) {
            return oldItem == newItem;
        }
    }

    @NonNull
    @Override
    public EpisodeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EpisodeAdapter.EpisodeViewHolder(
                ItemEpisodeBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull EpisodeViewHolder holder, int position) {
        holder.onBind(getItem(position));
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder{

        private ItemEpisodeBinding binding;

        public EpisodeViewHolder(ItemEpisodeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(RnMEpisodes rnMEpisodes) {
            binding.textItemEpisode.setText(rnMEpisodes.name);
            binding.textItemEpisodeD.setText(rnMEpisodes.date);
            binding.textItemEpisodeE.setText(rnMEpisodes.episode);
        }
    }
}
