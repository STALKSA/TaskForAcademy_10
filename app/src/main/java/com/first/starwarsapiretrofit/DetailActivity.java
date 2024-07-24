package com.first.starwarsapiretrofit;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private TextView name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = findViewById(R.id.name);
        height = findViewById(R.id.height);
        mass = findViewById(R.id.mass);
        hairColor = findViewById(R.id.hairColor);
        skinColor = findViewById(R.id.skinColor);
        eyeColor = findViewById(R.id.eyeColor);
        birthYear = findViewById(R.id.birthYear);
        gender = findViewById(R.id.gender);

        Character character = (Character) getIntent().getSerializableExtra("character");

        if (character != null) {
            name.setText(character.getName());
            height.setText(character.getHeight());
            mass.setText(character.getMass());
            hairColor.setText(character.getHairColor());
            skinColor.setText(character.getSkinColor());
            eyeColor.setText(character.getEyeColor());
            birthYear.setText(character.getBirthYear());
            gender.setText(character.getGender());
        }
    }
}
