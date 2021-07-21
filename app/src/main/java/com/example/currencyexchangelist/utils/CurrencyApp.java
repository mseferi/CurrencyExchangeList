package com.example.currencyexchangelist.utils;

import android.app.Application;

import androidx.room.Room;

import com.example.currencyexchangelist.database.AppDatabase;

public class CurrencyApp extends Application {

    public static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, AppDatabase.RETROFIT_APP_DB_NAME)
                .allowMainThreadQueries()
                .build();
    }
}
