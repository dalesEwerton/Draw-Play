package com.dales.fragoso.drawplay.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.dales.fragoso.drawplay.Controller.TeamsController;
import com.dales.fragoso.drawplay.Model.Team;
import com.dales.fragoso.drawplay.R;

import java.util.LinkedList;
import java.util.List;

public class RankingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        android.support.v7.app.ActionBar bar = getSupportActionBar();
        bar.hide();

        setTeamsInRanked();
    }

    private Team[] getTeamsOrdered() {
        TeamsController teamsController = TeamsController.getInstance();
        Object[] teamsObj = teamsController.getTeamList().toArray();
        Team[] teams = new Team[teamsObj.length];

        for(int i = 0; i < teamsObj.length; i++) {
            teams[i] = (Team) teamsObj[i];
        }

        for(int i = 0; i < teams.length - 1 ; i++) {
            for( int j = teams.length - 1; j > 0 ; j--) {
                if(teams[i].getPoints() < teams[j].getPoints() ) {
                    Team aux = teams[i];
                    teams[i] = teams[j];
                    teams[j] = aux;
                }
            }
        }

        return teams;
    }

    private void setTeamsInRanked() {
        Team[] teams = getTeamsOrdered();
        List<TextView> rankedViews = new LinkedList<>();

        rankedViews.add((TextView) findViewById(R.id.pos1));
        rankedViews.add((TextView) findViewById(R.id.pos2));
        rankedViews.add((TextView) findViewById(R.id.pos3));
        rankedViews.add((TextView) findViewById(R.id.pos4));
        rankedViews.add((TextView) findViewById(R.id.pos5));
        rankedViews.add((TextView) findViewById(R.id.pos6));
        rankedViews.add((TextView) findViewById(R.id.pos7));
        rankedViews.add((TextView) findViewById(R.id.pos8));

        int i = 0;
        while(i < teams.length) {
            rankedViews.get(i).setText((i+1) + ". " + teams[i].getTeamName() + " - " + teams[i].getPoints() +"pts.");
            i++;
        }

        while (i < 8) {
            rankedViews.get(i).setText("");
            i++;
        }
    }
}
