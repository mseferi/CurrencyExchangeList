package com.example.currencyexchangelist.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.currencyexchangelist.model.Currency;

import java.util.List;

@Dao
public interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Currency> currencies);

    @Delete
    void delete(Currency currency);

    @Query("SELECT * FROM currency")
    List<Currency> getAll();

    @Query("SELECT * FROM Currency WHERE datumPrimjene = :argDate")
    List<Currency> getAllForDate(String argDate);

    @Query("SELECT DISTINCT datumPrimjene FROM currency order by datumPrimjene desc")
    List<String> loadDate();
}
