package com.dales.fragoso.drawplay.Model;

/**
 * Created by dales on 30/07/2017.
 */

public class Team {

    private String teamName;
    private String[] teamMembers;
    private int points;

    public Team(String teamName, String[] teamMembers) {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String[] getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(String[] teamMembers) {
        this.teamMembers = teamMembers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team equipe = (Team) o;

        return teamName.equals(equipe.teamName);

    }

    @Override
    public int hashCode() {
        return teamName.hashCode();
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int points) {
        this.points += points;
    }
}
