package com.mesut.beyaztas.cat.facts.service;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Created by Mesut on 02/11/2017.
 */

public class CatFactsService {

    private static final String BASE_URL = "https://catfact.ninja";

    public interface CatFactsAPI {
        @GET("facts")
        @Headers("Accept: application/json")
        Call<CatFactsResponse> getCatFacts(@Query("limit") Integer limit, @Query("max_length") Integer maxLength);
    }

    public CatFactsAPI getAPI() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(CatFactsAPI.class);
    }

}
