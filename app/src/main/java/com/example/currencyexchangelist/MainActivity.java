package com.example.currencyexchangelist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.currencyexchangelist.adapters.MyAdapter;
import com.example.currencyexchangelist.database.AppDatabase;
import com.example.currencyexchangelist.database.GetData;
import com.example.currencyexchangelist.database.RetrofitClient;
import com.example.currencyexchangelist.model.Currency;
import com.example.currencyexchangelist.screens.ArchiveActivity;
import com.example.currencyexchangelist.utils.Constants;
import com.example.currencyexchangelist.utils.CurrencyApp;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private DatePicker datePicker;

    @BindView(R.id.btnGetCurrencies)
    Button btnGetCurrencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        datePicker = findViewById(R.id.datePicker);
        datePicker.setMaxDate(System.currentTimeMillis());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu); // inflate toolbar with our menu layout
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.btnArchive) {
            Intent mainIntent = new Intent(MainActivity.this, ArchiveActivity.class);
            startActivity(mainIntent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.btnGetCurrencies)
    public void getCurrency() {
        GetData service = RetrofitClient.getRetrofitInstance().create(GetData.class);
        Call<List<Currency>> call = service.getCurrenciesForDate(getCurrencyForDate());
        call.enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(@NonNull Call<List<Currency>> call, @NonNull Response<List<Currency>> response) {
                loadDataList(response.body());
                myAdapter.setDataList(response.body());
                myAdapter.notifyDataSetChanged();
                CurrencyApp.database.currencyDao().insertAll(response.body());
            }
            @Override
            public void onFailure(@NonNull Call<List<Currency>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, R.string.unable_to_load_currencies, Toast.LENGTH_SHORT).show();
            }
        });
    }


    public String getCurrencyForDate() {
        String year = String.valueOf(datePicker.getYear());
        String month = String.valueOf(datePicker.getMonth() + 1);
        String day = String.valueOf(datePicker.getDayOfMonth());

        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }
        if (Integer.parseInt(day) < 10) {
            day = "0" + day;
        }
        return year + "-" + month + "-" + day;
    }


    private void loadDataList(List<Currency> usersList) {
        RecyclerView myRecyclerView = findViewById(R.id.myRecyclerView);
        myAdapter = new MyAdapter(usersList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        myRecyclerView.setLayoutManager(layoutManager);
        myRecyclerView.setAdapter(myAdapter);
    }
}