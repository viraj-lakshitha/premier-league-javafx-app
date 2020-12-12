package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import java.io.Serializable;

public class MatchUpdate implements Serializable {

    private String teamOneName;
    private String teamTwoName;
    private String matchDate;
    private int teamOneScore;
    private int teamTwoScore;

    //To Ensure that same class used for the Serialization and Deserialization
    private static final long serialVersionUID = 1L;

    //Constructor (Default)
    public MatchUpdate() { }

    //Constructor (Parameterized Constructor)
    public MatchUpdate(String teamOneName, String teamTwoName, String matchDate, int teamOneScore, int teamTwoScore) {
        this.teamOneName = teamOneName;
        this.teamTwoName = teamTwoName;
        this.matchDate = matchDate;
        this.teamOneScore = teamOneScore;
        this.teamTwoScore = teamTwoScore;
    }

    //Getters & Setters
    public String getTeamOneName() {
        return teamOneName;
    }

    public void setTeamOneName(String teamOneName) {
        this.teamOneName = teamOneName;
    }

    public String getTeamTwoName() {
        return teamTwoName;
    }

    public void setTeamTwoName(String teamTwoName) {
        this.teamTwoName = teamTwoName;
    }

    public String getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(String matchDate) {
        this.matchDate = matchDate;
    }

    public int getTeamOneScore() {
        return teamOneScore;
    }

    public void setTeamOneScore(int teamOneScore) {
        this.teamOneScore = teamOneScore;
    }

    public int getTeamTwoScore() {
        return teamTwoScore;
    }

    public void setTeamTwoScore(int teamTwoScore) {
        this.teamTwoScore = teamTwoScore;
    }
}
