package com.first.starwarsapiretrofit;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder> {

    private List<Character> characterList;
    private Context context;

    public CharacterAdapter(List<Character> characterList, Context context) {
        this.characterList = characterList;
        this.context = context;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_character, parent, false);
        return new CharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        Character character = characterList.get(position);
        holder.name.setText(character.getName());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("character", character);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return characterList.size();
    }

    static class CharacterViewHolder extends RecyclerView.ViewHolder {
        TextView name;

        public CharacterViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.characterName);
        }
    }
}