package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dales.fragoso.drawplay.R;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        android.support.v7.app.ActionBar bar = getSupportActionBar();

        bar.hide();

    }


    public void gameStart(View view) {
        Intent it = new Intent(MainMenuActivity.this, DificultActivity.class);
        startActivity(it);
    }

    public void goToRules(View view) {
        Intent it = new Intent(MainMenuActivity.this, RulesActivity.class);
        startActivity(it);
    }

    public void exit(View view) {
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
