package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.dales.fragoso.drawplay.Controller.DificultyController;
import com.dales.fragoso.drawplay.Model.Dificulty;
import com.dales.fragoso.drawplay.R;

public class DificultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificult);


        android.support.v7.app.ActionBar bar = getSupportActionBar();

        bar.hide();
    }

    public void easySelected(View view) {
        goToTeam(view, Dificulty.FACIL);
    }

    public void mediumSelected(View view) {
        goToTeam(view, Dificulty.MEDIO);
    }

    public void hardSelected(View view) {
        goToTeam(view, Dificulty.DIFICIL);
    }

    public void trollSelected(View view) {
        goToTeam(view, Dificulty.TROLL);
    }

    private void goToTeam(View view, Dificulty dificulty) {
        DificultyController dificultyController = DificultyController.getDificultyInstance();

        dificultyController.setDificulty(dificulty);
        Intent it = new Intent(DificultActivity.this, TeamsActivity.class);
        startActivity(it);
    }
}
