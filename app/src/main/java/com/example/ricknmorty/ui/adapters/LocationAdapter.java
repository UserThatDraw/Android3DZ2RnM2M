package com.example.ricknmorty.ui.adapters;


import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ricknmorty.databinding.ItemLocationBinding;
import com.example.ricknmorty.models.RnMCharacters;
import com.example.ricknmorty.models.RnMLocations;

public class LocationAdapter extends ListAdapter<RnMLocations, LocationAdapter.LocationViewHolder> {

    public LocationAdapter() {
        super(new LocationDiffUtil());
    }

    public static class LocationDiffUtil extends DiffUtil.ItemCallback<RnMLocations>{

        @Override
        public boolean areItemsTheSame(@NonNull RnMLocations oldItem, @NonNull RnMLocations newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull RnMLocations oldItem, @NonNull RnMLocations newItem) {
            return oldItem == newItem;
        }
    }

    @NonNull
    @Override
    public LocationAdapter.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationAdapter.LocationViewHolder(
                ItemLocationBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationAdapter.LocationViewHolder holder, int position) {
        holder.onBind(getItem(position));

    }

    public class LocationViewHolder extends RecyclerView.ViewHolder{

        private ItemLocationBinding binding;

        public LocationViewHolder(ItemLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(RnMLocations rnMLocations) {
            binding.textItemLocation.setText(rnMLocations.name);
            binding.textItemLocationD.setText(rnMLocations.dimension);
            binding.textItemLocationT.setText(rnMLocations.type);
        }
    }
}







