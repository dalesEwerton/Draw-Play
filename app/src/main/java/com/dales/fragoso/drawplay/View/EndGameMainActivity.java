package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dales.fragoso.drawplay.Controller.EndGameController;
import com.dales.fragoso.drawplay.Model.ImageSrc;
import com.dales.fragoso.drawplay.Model.Team;
import com.dales.fragoso.drawplay.R;

public class EndGameMainActivity extends AppCompatActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_main);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        EndGameController endGameController = EndGameController.getInstance();

        ImageView endImage = (ImageView) findViewById(R.id.endImageView);
        ImageSrc imgAtual = endGameController.getRandImage();
        endImage.setBackgroundResource(imgAtual.getDrawableNum());

        TextView congratulations = (TextView) findViewById(R.id.finalText);
        String teamChampion = endGameController.getTeamWinner().getTeamName();
        String parabens = "Parabéns " + teamChampion;
        congratulations.setText(parabens);

        TextView subCongratulations = (TextView) findViewById(R.id.subCongratulations);
        String subCongrats = "Vocês foram os menos pior dessa partida";
        subCongratulations.setText(subCongrats);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent it = new Intent(EndGameMainActivity.this, MainMenuActivity.class);
                startActivity(it);
            }
        }, 10000);

    }
}
