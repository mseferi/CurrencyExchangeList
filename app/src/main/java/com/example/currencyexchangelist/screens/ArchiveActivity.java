package com.example.currencyexchangelist.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchangelist.utils.Constants;
import com.example.currencyexchangelist.MainActivity;
import com.example.currencyexchangelist.R;
import com.example.currencyexchangelist.adapters.ArchiveAdapter;
import com.example.currencyexchangelist.adapters.ArchiveAdapterCallbacks;
import com.example.currencyexchangelist.utils.CurrencyApp;

import java.util.List;

public class ArchiveActivity extends AppCompatActivity implements ArchiveAdapterCallbacks {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        loadDataList(CurrencyApp.database.currencyDao().loadDate());
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


    private void loadDataList(List<String> dates) {
        RecyclerView myRecyclerView = findViewById(R.id.rvArchive);
        ArchiveAdapter archiveAdapter = new ArchiveAdapter(dates, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ArchiveActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(archiveAdapter);
    }


    @Override
    public void onShowSelected(String date) {
        Intent stringIntent = new Intent(ArchiveActivity.this, ShowForDateActivity.class);
        stringIntent.putExtra(Constants.KEY_DATE, date);
        startActivity(stringIntent);
        finish();
    }
}
