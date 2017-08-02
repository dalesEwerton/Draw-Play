package com.dales.fragoso.drawplay.Controller;

import com.dales.fragoso.drawplay.Model.Team;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dales on 30/07/2017.
 */

public final class TeamsController {

    private static List<Team> teamList = new ArrayList<>();
    private static final TeamsController teamsInstance = new TeamsController();

    private TeamsController() {
    }

    public static TeamsController getInstance() {
        return teamsInstance;
    }

    public static void addTeam(String teamName, String[] teamMembers) {
        Team team = new Team(teamName, teamMembers);
        addTeam(team);
    }

    private static void addTeam(Team team) {
        teamList.add(team);
    }

    public static boolean removeTeam(String teamName) {
        Team team = getTeam(teamName);

        return teamList.remove(team);
    }

    public static Team getTeam(String teamName) {
        for (Team team :
             teamList) {

            if(team.getTeamName().equals(teamName)) {
                return team;
            }
        }

        return null;
    }

    public static List<Team> getTeamList() {
        return teamList;
    }
}
