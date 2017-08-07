package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dales.fragoso.drawplay.Controller.DificultyController;
import com.dales.fragoso.drawplay.Controller.EndGameController;
import com.dales.fragoso.drawplay.Controller.ImagesController;
import com.dales.fragoso.drawplay.Controller.TeamsController;
import com.dales.fragoso.drawplay.Model.Dificulty;
import com.dales.fragoso.drawplay.Model.ImageSrc;
import com.dales.fragoso.drawplay.Model.Team;
import com.dales.fragoso.drawplay.R;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity {

    public static Chronometer crn;
    private Team champion;
    private long champPoints = 0;
    private long atualTeamPoints = 0;
    final Handler handler = new Handler();
    private static CountDownTimer countDownTimer;
    private static CountDownTimer musicTimmer;
    int numberOfTeamPLaying = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        crn = (Chronometer) findViewById(R.id.chronommeter);

        TeamsController teamsController = TeamsController.getInstance();
        Team initialTeam = teamsController.getTeamsPlaying().get(numberOfTeamPLaying);
        makeSingleGame(initialTeam);

        playEffectSongs();
    }


    public void feito(View view) {

        final TeamsController teamsController =TeamsController.getInstance();
        Team atualTeam = teamsController.getTeamsPlaying().get(numberOfTeamPLaying);

        long timePoints = atualTeamPoints;
        atualTeam.addPoints(timePoints);

        countDownTimer.cancel();
        atualTeamPoints = 0;

        if(timePoints > champPoints) {
            champion = atualTeam;
            champPoints = timePoints;
        }

        if(numberOfTeamPLaying < teamsController.getTeamsPlaying().size() - 1){

            numberOfTeamPLaying++;

            Toast toast = Toast.makeText(getApplication(), "A proxima equipe iniciará em 10 segundos", Toast.LENGTH_LONG);
            toast.show();

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Team nextTeam = teamsController.getTeamsPlaying().get(numberOfTeamPLaying);
                    makeSingleGame(nextTeam);
                }
            }, 10000);


        }else {
            EndGameController endGame = EndGameController.getInstance();
            endGame.setTeamWinner(champion);
            Intent it = new Intent(GameActivity.this, EndGameMainActivity.class);
            musicTimmer.cancel();
            startActivity(it);
        }

    }

    private void makeSingleGame(Team team) {
        ImageView img = (ImageView) findViewById(R.id.imageInGame);
        TextView resposta = (TextView) findViewById(R.id.respostaTextView);
        TextView teamName = (TextView) findViewById(R.id.EquipeNameTextView);

        controlTimer(findViewById(R.id.gamePlayLayout));

        Dificulty dificulty = DificultyController.getInstance().getDificulty();
        ImagesController imgController = new ImagesController(dificulty);

        ImageSrc imgAtual = imgController.getRandImage();
        img.setBackgroundResource(imgAtual.getDrawableNum());
        resposta.setText(imgAtual.getImageName());
        teamName.setText(team.getTeamName());
    }

    public String timeToString (int seconds) {

        String timeString = Integer.toString(seconds);

        if (timeString.length() == 1) {
            timeString = "0" + timeString;
        }

        return timeString;
    }

    public void updateTimer(int secondsLeft) {

        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - minutes * 60;


        crn.setText(timeToString(minutes) + ":" + timeToString(seconds));
    }

    public void controlTimer(View view) {

        countDownTimer = new CountDownTimer(180000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                updateTimer((int) millisUntilFinished / 1000);
                atualTeamPoints = millisUntilFinished/1000;

            }

            @Override
            public void onFinish() {

                Toast toast = Toast.makeText(getApplicationContext(),"Acabou o tempo!" , Toast.LENGTH_LONG);
                toast.show();
                Button btnFeito = (Button) findViewById(R.id.feitoBtn);
                btnFeito.setText("Continuar");
                crn.setText("00:00");
            }

        }.start();
    }


    private void playEffectSongs() {

        final List<MediaPlayer> musics = new LinkedList<>();

        musics.add(MediaPlayer.create(GameActivity.this, R.raw.ambulancia));
        musics.add(MediaPlayer.create(GameActivity.this, R.raw.bazinga));
        musics.add(MediaPlayer.create(GameActivity.this, R.raw.birl));
        musics.add(MediaPlayer.create(GameActivity.this, R.raw.evillaugh));
        musics.add(MediaPlayer.create(GameActivity.this, R.raw.moises));
        musics.add(MediaPlayer.create(GameActivity.this, R.raw.tacalhepau));

        musicTimmer = new CountDownTimer(180000 * TeamsController.getInstance().getTeamsPlaying().size(),35000) {
            @Override
            public void onTick(long l) {
                MediaPlayer mediaPlayer = changeRandonSong(musics);
                mediaPlayer.start();
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }


    private MediaPlayer changeRandonSong(List<MediaPlayer> musics) {
        Random rand = new Random();

        return musics.get(rand.nextInt(6));
    }
}
