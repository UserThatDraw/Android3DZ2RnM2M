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
import com.example.ricknmorty.interfaces.OnClick;
import com.example.ricknmorty.databinding.ItemCharacterBinding;
import com.example.ricknmorty.models.RnMCharacters;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends ListAdapter<RnMCharacters, CharacterAdapter.CharacterViewHolder> {

    private OnClick onClick;

    public CharacterAdapter() {
        super(new CharacterDiffUtil());
    }

    public static class CharacterDiffUtil extends DiffUtil.ItemCallback<RnMCharacters>{

        @Override
        public boolean areItemsTheSame(@NonNull RnMCharacters oldItem, @NonNull RnMCharacters newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull RnMCharacters oldItem, @NonNull RnMCharacters newItem) {
            return oldItem == newItem;
        }
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    @NonNull
    @Override
    public CharacterAdapter.CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CharacterAdapter.CharacterViewHolder(
                ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterAdapter.CharacterViewHolder holder, int position) {
        holder.onBind(getItem(position));

    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        private ItemCharacterBinding binding;

        public CharacterViewHolder(@NonNull ItemCharacterBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(RnMCharacters rnMCharacters) {
            Glide
                    .with(binding.imageItemCharacter)
                    .load(rnMCharacters.image)
                    .into(binding.imageItemCharacter);
            binding.textItemCharacter.setText(rnMCharacters.name);

            itemView.setOnClickListener(v -> onClick.getSmt(rnMCharacters.getId(), v));
        }
    }
}