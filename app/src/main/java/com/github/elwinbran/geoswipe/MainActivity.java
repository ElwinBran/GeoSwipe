package com.github.elwinbran.geoswipe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<LocationTrivia> trivia = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        trivia.add(new LocationTrivia(R.drawable.img1_yes_denmark, true));
        trivia.add(new LocationTrivia(R.drawable.img2_no_canada, false));
        trivia.add(new LocationTrivia(R.drawable.img3_no_bangladesh, false));
        trivia.add(new LocationTrivia(R.drawable.img4_yes_kazachstan, true));
        trivia.add(new LocationTrivia(R.drawable.img5_no_colombia, false));
        trivia.add(new LocationTrivia(R.drawable.img6_yes_poland, true));
        trivia.add(new LocationTrivia(R.drawable.img7_yes_malta, true));
        trivia.add(new LocationTrivia(R.drawable.img8_no_thailand, false));
        RecyclerView geoRecyclerView = findViewById(R.id.recyclerView);
        geoRecyclerView.setLayoutManager(new LinearLayoutManager(this.getBaseContext()));
        final RecyclerView.Adapter<GeoTriviaViewHolder> geoAdapter = new GeoAdapter(trivia);
        geoRecyclerView.setAdapter(geoAdapter);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =

                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView,
                                          RecyclerView.ViewHolder viewHolder,
                                          RecyclerView.ViewHolder target)
                    {
                        return false;
                    }
                    //Called when a user swipes left or right on a ViewHolder
                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir)
                    {
                        //Get the index corresponding to the selected position
                        int position = (viewHolder.getAdapterPosition());
                        trivia.remove(position);
                        geoAdapter.notifyItemRemoved(position);
                        handleQuiz(position, swipeDir);
                    }
                };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(geoRecyclerView);
    }

    private void handleQuiz(int position, int swipeDir)
    {
        String text;
        final String winText = "Well done!";
        final String lossText = "No cigar";
        if(trivia.get(position).isInEurope())
        {
            if(swipeDir == ItemTouchHelper.LEFT)
            {
                text = winText;
            }
            else
            {
                text = lossText;
            }
        }
        else
        {
            if(swipeDir == ItemTouchHelper.RIGHT)
            {
                text = winText;
            }
            else
            {
                text = lossText;
            }
        }
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}
