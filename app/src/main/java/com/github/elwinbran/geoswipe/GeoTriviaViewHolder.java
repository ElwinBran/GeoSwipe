package com.github.elwinbran.geoswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class GeoTriviaViewHolder extends RecyclerView.ViewHolder
{
    final private ImageView scene;
    public View view;

    public GeoTriviaViewHolder(View itemView)
    {
        super(itemView);
        this.view = itemView;
        scene = this.view.findViewById(R.id.imageView);
    }

    public ImageView getScene()
    {
        return this.scene;
    }
}
