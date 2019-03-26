package com.example.mobile_application;

import com.example.mobile_application.model.Movie;

import java.util.List;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> {
    private final MainActivity activity;
    private List<Movie> listValues;

    public class CelluleJava extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public ImageView image;
        public View layout;

        public CelluleJava(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
            image = v.findViewById(R.id.icon);
        }
    }

    public MyAdapter(List<Movie> listValues, MainActivity a) {
        this.listValues = listValues;
        this.activity = a;
    }

    @Override
    public CelluleJava onCreateViewHolder(ViewGroup parent,
                                          int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);
        CelluleJava vh = new CelluleJava(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(CelluleJava holder, final int position) {
        Movie currentMovie = listValues.get(position);
        final String title = currentMovie.getTitle();
        final String director = currentMovie.getDirector();
        final Integer release_date = currentMovie.getRelease_date();
        Log.d("TAGG", "dazdaz"+currentMovie.getId());
        holder.txtHeader.setTag(currentMovie.getId());
        holder.txtHeader.setText(title);
        holder.txtHeader.setOnClickListener(activity);
        holder.txtFooter.setText(release_date+"");
    }

    @Override
    public int getItemCount() {
        return listValues.size();
    }

}
