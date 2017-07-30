package com.dales.fragoso.drawplay.Controller;

import com.dales.fragoso.drawplay.Model.Team;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dales on 30/07/2017.
 */

public class TeamsController {

    private List<Team> teamList;
    private static TeamsController teamsInstance;

    private TeamsController() {
        teamList = new LinkedList<>();
    }

    public static synchronized TeamsController getTeamsInstance() {
        if(teamsInstance == null) {
            teamsInstance = new TeamsController();
        }

        return teamsInstance;
    }

    public void addTeam(String teamName, String[] teamMembers) {
        Team team = new Team(teamName, teamMembers);
        addTeam(team);
    }

    private void addTeam(Team team) {
        teamList.add(team);
    }

    public boolean removeTeam(String teamName) {
        Team team = getTeam(teamName);

        return this.teamList.remove(team);
    }

    public Team getTeam(String teamName) {
        for (Team team :
             this.teamList) {

            if(team.getTeamName().equals(teamName)) {
                return team;
            }
        }

        return null;
    }
}
