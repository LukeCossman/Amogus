package com.hfad.scorekeeper_lc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * This app is a score keeper
 * The team names are adjustable, and there are
 * two buttons that can be used to increase their score
 */
public class MainActivity extends AppCompatActivity {

    private int score1 = 0; //Team 1's score
    private int score2 = 0; //Team 2's score

    //Keys for bundle
    public static final String SCORE1 = "score1";
    public static final String SCORE2 = "score2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get XML views (buttons and text views)
        Button btnTeam1 = findViewById(R.id.btn_team1);
        Button btnTeam2 = findViewById(R.id.btn_team2);
        TextView txtScore1 = findViewById(R.id.txt_score1);
        TextView txtScore2 = findViewById(R.id.txt_score2);

        //If the bundle has scores in it...
        if (savedInstanceState != null)
        {
            //...set the scores to the saved values and display them
            score1 = savedInstanceState.getInt(SCORE1);
            score2 = savedInstanceState.getInt(SCORE2);
            txtScore1.setText("" + score1);
            txtScore2.setText("" + score2);
        }

        //Add logic for team 1 score increase
        btnTeam1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                score1++;
                txtScore1.setText("" + score1);
            }
        });

        //Add logic for team 2 score increase
        btnTeam2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                score2++;
                txtScore2.setText("" + score2);
            }
        });
    }

    //Save scores upon rotate
    protected void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt(SCORE1, score1);
        savedInstanceState.putInt(SCORE2, score2);
    }


}