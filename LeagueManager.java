package com.courseWork.FinalFormativeSub;

import java.io.IOException;

public interface LeagueManager {

    //To Implemented in JavaFx GUI
    void addFootballClub(SportClub sportClub) throws IOException;
    void deleteFootballClub(String name);
    void displayClubDetails(String name);
    void displayAllClubDetails();
    void updateMatchDetails(String teamOneName, String teamTwoName,String dateMatch,int teamOneScore,int teamTwoScore);
    void saveDataLocal() throws IOException;
    void updateListFromData();
    boolean validateDate(String dateIn);

    //To Implemented in Both Console GUI and JavaFx GUI
    void randomMatchGenerator();
    void searchMatches(String matchDate);
    String returnSearchMatches();
    void displayAllPlayedMatches();
}
