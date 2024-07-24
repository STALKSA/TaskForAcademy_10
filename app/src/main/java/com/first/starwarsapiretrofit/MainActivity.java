package com.first.starwarsapiretrofit;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CharacterAdapter adapter;
    private EditText searchInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        searchInput = findViewById(R.id.searchInput);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        fetchCharacters("");

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                fetchCharacters(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }

    private void fetchCharacters(String searchQuery) {
        StarWarsApi api = RetrofitInstance.getRetrofitInstance().create(StarWarsApi.class);
        api.getCharacters(searchQuery).enqueue(new Callback<SWAPIResponse>() {
            @Override
            public void onResponse(Call<SWAPIResponse> call, Response<SWAPIResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Character> characters = response.body().getResults();
                    adapter = new CharacterAdapter(characters, MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<SWAPIResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load characters", Toast.LENGTH_SHORT).show();
            }
        });
    }
}