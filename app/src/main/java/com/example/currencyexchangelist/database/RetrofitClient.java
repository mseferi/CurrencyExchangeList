package com.example.currencyexchangelist.database;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.currencyexchangelist.database.GetData.BASE_URL;

public final class RetrofitClient {

    private static Retrofit retrofit;

    private RetrofitClient(){}

    public static synchronized Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
