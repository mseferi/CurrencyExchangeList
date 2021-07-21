package com.example.currencyexchangelist.database;

import com.example.currencyexchangelist.model.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetData {

    String BASE_URL = "http://api.hnb.hr/";

    @GET("tecajn/v1")
    Call<List<Currency>> getCurrency();

    @GET("tecajn/v1?")
    Call<List<Currency>> getCurrenciesForDate(@Query("datum") String date);

}
