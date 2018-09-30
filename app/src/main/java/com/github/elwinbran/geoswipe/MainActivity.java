package com.github.elwinbran.geoswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Integer> imageReferences = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageReferences.add(R.drawable.img1_yes_denmark);
        imageReferences.add(R.drawable.img2_no_canada);
        imageReferences.add(R.drawable.img3_no_bangladesh);
        imageReferences.add(R.drawable.img4_yes_kazachstan);
        imageReferences.add(R.drawable.img5_no_colombia);
        imageReferences.add(R.drawable.img6_yes_poland);
        imageReferences.add(R.drawable.img7_yes_malta);
        imageReferences.add(R.drawable.img8_no_thailand);
        Log.d("none", "onCreate: size = "+ imageReferences.size());
        Log.d("none", "onCreate: " + imageReferences.get(0));
        RecyclerView muhView = findViewById(R.id.recyclerView);
        muhView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        RecyclerView.Adapter<GeoAdapter.DataObjectHolder> geoAdapter = new GeoAdapter(imageReferences);
        muhView.setAdapter(geoAdapter);
        Log.d("none", "onCreate: check1");
        geoAdapter.notifyDataSetChanged();
        Log.d("none", "onCreate: check2");
    }
}
