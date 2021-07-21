package com.example.currencyexchangelist.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.currencyexchangelist.R;

import java.util.List;

public class ArchiveAdapter extends RecyclerView.Adapter<ArchiveAdapter.ViewHolder> {

    private List<String> dates;
    private final ArchiveAdapterCallbacks callbacks;


    // data is passed into the constructor
    public ArchiveAdapter(List<String> dates, ArchiveAdapterCallbacks callbacks) {
        this.dates = dates;
        this.callbacks = callbacks;

    }


    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.archive_row, parent, false);
        return new ViewHolder(view);
    }


    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String date = dates.get(position);
        holder.tvArchive.setText(dates.get(position));
        holder.ibGet.setOnClickListener(v -> callbacks.onShowSelected(date));
    }


    // total number of rows
    @Override
    public int getItemCount() {
        return dates.size();
    }


    // stores and recycles views as they are scrolled off screen
    static class ViewHolder extends RecyclerView.ViewHolder {

        public final View myView;
        TextView tvArchive;
        ImageButton ibGet;

        ViewHolder(View itemView) {
            super(itemView);
            myView = itemView;
            tvArchive = myView.findViewById(R.id.tvArchiveDate);
            ibGet = myView.findViewById(R.id.ibGet);
        }
    }
}
