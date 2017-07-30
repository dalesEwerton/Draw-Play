package com.dales.fragoso.drawplay.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.dales.fragoso.drawplay.R;

public class TeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();
    }
}
