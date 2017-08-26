package unkownman.mainapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

import static unkownman.mainapp.R.id.Score;

public class MainActivity extends AppCompatActivity {

    int scoreCount;
    TextView scoreView;
    String filename = "deviceScore" ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Integer scoreCount = sharedPref.getInt("Score", 0);

        //scoreCount = 0;
        this.scoreView = (TextView) findViewById(Score);
        scoreView.setPaintFlags(View.INVISIBLE);
        scoreView.setText("My Dudes " + scoreCount);

    }

    @Override
    public void onBackPressed(){
        int pid = android.os.Process.myPid();
        android.os.Process.killProcess(pid);
        System.exit(0);
    }
    public void TapTap(View view) {


        final MediaPlayer mp = MediaPlayer.create(this, R.raw.yeboi);
        Button playsound = (Button) this.findViewById(R.id.button);
        playsound.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
               // mp.start();

                if(mp.isPlaying())
                {
                    mp.stop();
                }

                try {
                    mp.reset();
                    AssetFileDescriptor afd;
                    afd = getAssets().openFd("yeboi.mp3");
                    mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
                    mp.prepare();
                    mp.start();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
                Integer scoreCount = sharedPref.getInt("Score", 0);

                scoreCount++;
                scoreView.setPaintFlags(View.INVISIBLE);
                scoreView.setText("My Dudes " + scoreCount);
                //Saving Score on every tap
                sharedPref = getSharedPreferences("mypref", 0);
                SharedPreferences.Editor editor= sharedPref.edit();
                editor.putInt("Score", scoreCount);
                editor.commit();

            }
        });

        SharedPreferences sharedPref= getSharedPreferences("mypref", 0);
        Integer scoreCount = sharedPref.getInt("Score", 0);

        scoreCount++;
        scoreView.setPaintFlags(View.INVISIBLE);
        scoreView.setText("My Dudes " + scoreCount);
        //Saving Score on every tap
        sharedPref = getSharedPreferences("mypref", 0);
        SharedPreferences.Editor editor= sharedPref.edit();
        editor.putInt("Score", scoreCount);
        editor.commit();
    }
}

