package com.dales.fragoso.drawplay.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.dales.fragoso.drawplay.Controller.TeamsController;
import com.dales.fragoso.drawplay.Model.Team;
import com.dales.fragoso.drawplay.R;

import java.util.ArrayList;
import java.util.List;

public class TeamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        CheckBox[] boxes = getArrayOfCheckBox();
        List<Team> teams = TeamsController.getInstance().getTeamList();
        int indexOfBox = 0;

        for(Team team : teams) {
            System.out.println(team.getTeamName());
            boxes[indexOfBox].setText(team.getTeamName());
            indexOfBox++;
        }

        while (indexOfBox < boxes.length) {
            boxes[indexOfBox].setEnabled(false);
            indexOfBox++;
        }
    }

    public void register(View view) {
        Intent it = new Intent(TeamsActivity.this, RegisterActivity.class);
        startActivity(it);
    }

    private CheckBox[] getArrayOfCheckBox() {

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox cb6 = (CheckBox) findViewById(R.id.checkBox6);
        CheckBox cb7 = (CheckBox) findViewById(R.id.checkBox7);
        CheckBox cb8 = (CheckBox) findViewById(R.id.checkBox8);

        CheckBox[] boxes = new CheckBox[8];

        boxes[0] = cb1;
        boxes[1] = cb2;
        boxes[2] = cb3;
        boxes[3] = cb4;
        boxes[4] = cb5;
        boxes[5] = cb6;
        boxes[6] = cb7;
        boxes[7] = cb8;

        return boxes;
    }

    public void select(View view) {

        CheckBox[] cbs = getArrayOfCheckBox();
        List<Team> teams = new ArrayList<>();
        TeamsController teamsCtrl = TeamsController.getInstance();

        boolean hasOneOrMoreTeam = false;
        for(CheckBox cb : cbs) {
            if(cb.isChecked()) {
                Team tm = teamsCtrl.getTeam(cb.getText().toString());
                teams.add(tm);
                hasOneOrMoreTeam = true;
            }
        }

        if(teamsCtrl.getTeamList().size() == 0) {
            Toast toast = Toast.makeText(getApplicationContext(), "Primeiro, cadastre uma equipe ou mais.", Toast.LENGTH_SHORT);
            toast.show();

        }else if(!hasOneOrMoreTeam) {
            Toast toast = Toast.makeText(getApplicationContext(), "Selecione ao menos uma equipe para prosseguir!",
                    Toast.LENGTH_SHORT);
            toast.show();
        }else{
            teamsCtrl.setTeamsPlaying(teams);
            MainMenuActivity.mediaPlayer.stop();

            Intent it = new Intent(TeamsActivity.this, GameActivity.class);
            startActivity(it);
        }

    }
}
