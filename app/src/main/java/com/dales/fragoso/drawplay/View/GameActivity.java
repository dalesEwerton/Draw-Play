package com.dales.fragoso.drawplay.View;

import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import com.dales.fragoso.drawplay.R;

public class GameActivity extends AppCompatActivity {

    Chronometer crn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        crn = (Chronometer) findViewById(R.id.chronommeter);
        controlTimer(findViewById(R.id.chronommeter));
    }

    public String timeToString (int seconds) {

        String timeString = Integer.toString(seconds);

        if (timeString.length() == 1) {
            timeString = "0" + timeString;
        }

        return timeString;
    }

    public void updateTimer(int secondsLeft) {

        int minutes = (int) secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;


        crn.setText(timeToString(minutes) + ":" + timeToString(seconds));
    }

    public void controlTimer(View view) {

        new CountDownTimer(180000, 1000) {


            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {

                crn.setText("00:00");
            }
        }.start();

    }


}
