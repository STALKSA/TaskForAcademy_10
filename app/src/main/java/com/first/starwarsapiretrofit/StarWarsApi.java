package com.first.starwarsapiretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StarWarsApi {
    @GET("people/")
    Call<SWAPIResponse> getCharacters(@Query("search") String search);
}

class SWAPIResponse {
    private List<Character> results;

    public List<Character> getResults() {
        return results;
    }
}