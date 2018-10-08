package com.github.elwinbran.geoswipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class GeoAdapter extends RecyclerView.Adapter<GeoTriviaViewHolder>
{
    private final List<LocationTrivia> geoTrivia;

    public GeoAdapter(List<LocationTrivia> geoTrivia)
    {
        this.geoTrivia = geoTrivia;
    }


    @NonNull
    @Override
    public GeoTriviaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.image_view_item, viewGroup, false);
        return new GeoTriviaViewHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull GeoTriviaViewHolder geoTriviaViewHolder, int i)
    {
        geoTriviaViewHolder.getScene().setImageResource(this.geoTrivia.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return this.geoTrivia.size();
    }
}
