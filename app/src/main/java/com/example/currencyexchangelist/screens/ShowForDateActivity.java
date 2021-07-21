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
import com.example.currencyexchangelist.R;
import com.example.currencyexchangelist.adapters.MyAdapter;
import com.example.currencyexchangelist.model.Currency;
import com.example.currencyexchangelist.utils.CurrencyApp;

import java.util.List;

public class ShowForDateActivity extends AppCompatActivity {

    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showfordate);

        Intent stringIntent = getIntent();
        String argDate = stringIntent.getStringExtra(Constants.KEY_DATE);

        loadDataList(CurrencyApp.database.currencyDao().getAllForDate(argDate));
        myAdapter.notifyDataSetChanged();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), ArchiveActivity.class);
        startActivityForResult(myIntent, 0);
        return true;
    }


    private void loadDataList(List<Currency> usersList) {
        RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ShowForDateActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }
}
