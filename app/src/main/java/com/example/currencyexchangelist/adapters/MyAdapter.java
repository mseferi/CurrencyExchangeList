package com.example.currencyexchangelist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchangelist.R;
import com.example.currencyexchangelist.model.Currency;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CustomViewHolder> {

    private List<Currency> dataList;

    public void setDataList(List<Currency> dataList) {
        this.dataList = dataList;
    }

    public MyAdapter(List<Currency> dataList) {
        this.dataList = dataList;
    }


    static class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View myView;

        TextView textUser;

        CustomViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            textUser = myView.findViewById(R.id.tvCurrency);
        }
    }


    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_layout, parent, false);
        return new CustomViewHolder(view);
    }


    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        holder.textUser.setText(dataList.get(position).toString());
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
