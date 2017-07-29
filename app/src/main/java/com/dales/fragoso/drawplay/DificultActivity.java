package com.dales.fragoso.drawplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DificultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificult);


        android.support.v7.app.ActionBar bar = getSupportActionBar();

        bar.hide();

        View decorView = getWindow().getDecorView();

        // Escondendo a barra de navegação e a barra de status .
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
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

        //Implementar
    }
}
