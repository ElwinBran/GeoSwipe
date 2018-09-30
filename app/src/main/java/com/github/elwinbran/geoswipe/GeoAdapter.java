package com.github.elwinbran.geoswipe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

public class GeoAdapter extends RecyclerView.Adapter<GeoAdapter.DataObjectHolder>
{
    public static class DataObjectHolder extends RecyclerView.ViewHolder
            implements OnSwipeTouchListener
    {
        final private ImageView scene;
        private final GestureDetector gestureDetector;

        public DataObjectHolder(View itemView, GestureListener listener) {
            super(itemView);
            scene = new ImageView(itemView.getContext());
            scene.setImageDrawable(itemView.getResources().getDrawable(R.drawable.img1_yes_denmark));
            //scene.setImageResource(R.drawable.img1_yes_denmark);
            Log.d("none", "DataObjectHolder: stiekem");
            listener.setListener(this);
            gestureDetector = new GestureDetector(itemView.getContext(), listener);
            Log.d("none", "DataObjectHolder: bub");
            //itemView.setOnClickListener(this);
        }

        @Override
        public void onSwipeRight() {
            Log.d("None", "onSwipeRight: wup");
        }

        @Override
        public void onSwipeLeft() {
            Log.d("None", "onSwipeLeft: wup");
        }

        @Override
        public void onSwipeTop() {

        }

        @Override
        public void onSwipeBottom() {

        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return gestureDetector.onTouchEvent(motionEvent);
        }

        public ImageView getScene()
        {
            return this.scene;
        }
    }

    private final List<Integer> imageReference;

    public GeoAdapter(List<Integer> imageReference)
    {
        this.imageReference = imageReference;
    }


    @NonNull
    @Override
    public DataObjectHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Log.d("None", "onCreateViewHolder: check");
        return new DataObjectHolder(viewGroup, new GestureListener());
    }

    @Override
    public void onBindViewHolder(@NonNull DataObjectHolder dataObjectHolder, int i) {
        Log.d("none", "onBindViewHolder: first");
        dataObjectHolder.getScene().setImageResource(this.imageReference.get(i));
        Log.d("none", "onBindViewHolder: second");
    }

    @Override
    public int getItemCount() {
        return this.imageReference.size();
    }
}
