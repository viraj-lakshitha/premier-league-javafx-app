package com.courseWork.FinalFormativeSub;

import java.io.IOException;
import java.util.List;

public interface LeagueManager {

    //To Implemented in JavaFx GUI
    void addFootballClub(FootballClub sportClub) throws IOException;
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
    void sortDateFunction(List<MatchUpdate> dateList);
    void sortWinFunction(List<FootballClub> sportClub);
    void sortScoreFunction(List<FootballClub> sportClub);
}
