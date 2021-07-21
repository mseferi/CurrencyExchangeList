package com.example.currencyexchangelist.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.currencyexchangelist.model.Currency;

@Database(entities = {Currency.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static final String RETROFIT_APP_DB_NAME = "RetrofitAppDb";

    public abstract CurrencyDao currencyDao();

}
