package com.example.mobile_application.controller;

import com.example.mobile_application.vue.MainActivity;
import com.example.mobile_application.R;
import com.example.mobile_application.model.Movie;

import java.util.ArrayList;
import java.util.List;


import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CelluleJava> implements Filterable {
    private final MainActivity activity;
    private List<Movie> listValues;
    private List<Movie> listValuesFull;

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
        listValuesFull = new ArrayList<>(listValues);
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


    @Override
    public Filter getFilter() {
        return valuesFilter;
    }

    private Filter valuesFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Movie> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() ==0){
                filteredList.addAll(listValuesFull);

            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for(Movie item : listValuesFull){
                    if (item.getTitle().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listValues.clear();
            listValues.addAll((List) results.values);
            notifyDataSetChanged();

        }
    };
}

