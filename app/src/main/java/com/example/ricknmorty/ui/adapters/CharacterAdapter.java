package com.example.ricknmorty.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ricknmorty.interfaces.OnClick;
import com.example.ricknmorty.databinding.ItemCharacterBinding;
import com.example.ricknmorty.models.RnMCharacters;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter <CharacterAdapter.CharacterViewHolder> {
    private List<RnMCharacters> list =  new ArrayList<>();
    private ItemCharacterBinding binding;

    private OnClick onClick;

    public void setOnClick(OnClick onClick) {
      this.onClick = onClick;
    }

    public void setIn(List<RnMCharacters> lif){
        list = lif;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CharacterViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        holder.onBind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterViewHolder extends RecyclerView.ViewHolder{

        public CharacterViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);

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
