package unkownman.mainapp;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Game extends AppCompatActivity {
    public static final String PREFS_NAME = "MyPrefsFile";
    int scoreCount;
    TextView scoreView;
    SharedPreferences prefs;
    String dataName = "MyData";
    String intName = "MyInt";
    int defaultInt = 0;
    public static int hiScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        scoreCount = 0;

       // prefs = getSharedPreferences(dataName,MODE_PRIVATE);
       // hiScore = prefs.getInt(intName, defaultInt);

        this.scoreView = (TextView) findViewById(R.id.CurrentScore);
        scoreView.setText("Current Score: " + scoreCount);

        TextView textHiScore =(TextView) findViewById(R.id.TotalScore);
        textHiScore.setText("HighScore: "+ hiScore);

    }

    public void TapTap(View view) {
        // Do something in response to button
       // Intent intent = new Intent(this, Game.class);
       // startActivity(intent);
        scoreCount++;
        //hiScore = hiScore + scoreCount ;
        scoreView.setText("Score: " + scoreCount);
    }


}
