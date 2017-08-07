package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dales.fragoso.drawplay.R;

public class MainMenuActivity extends AppCompatActivity {

    static MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.funksong);

        mediaPlayer.start();
        mediaPlayer.setLooping(true);

    }


    public void gameStart(View view) {
        Intent it = new Intent(MainMenuActivity.this, DificultActivity.class);
        startActivity(it);
    }

    public void goToRules(View view) {
        Intent it = new Intent(MainMenuActivity.this, RulesActivity.class);
        startActivity(it);
    }

    public void goToTutorial(View view) {
        Intent it = new Intent(MainMenuActivity.this, TutorialActivity.class);
        startActivity(it);
    }

    public void exit(View view) {
        mediaPlayer.stop();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void goToRanking(View view) {
        Intent it = new Intent(MainMenuActivity.this, RankingActivity.class);
        startActivity(it);
    }

}
