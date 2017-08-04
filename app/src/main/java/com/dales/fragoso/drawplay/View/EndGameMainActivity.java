package com.dales.fragoso.drawplay.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.dales.fragoso.drawplay.Controller.EndGameController;
import com.dales.fragoso.drawplay.Model.ImageSrc;
import com.dales.fragoso.drawplay.R;

public class EndGameMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game_main);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        EndGameController endGameController = new EndGameController(null);
        ImageView endImage = (ImageView) findViewById(R.id.endImageView);
        ImageSrc imgAtual = endGameController.getRandImage();
        endImage.setBackgroundResource(imgAtual.getDrawableNum());

    }
}
