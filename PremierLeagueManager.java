package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    static List<FootballClub> listOfSportClubs = new ArrayList<>();
    static List<MatchUpdate> listMatchDates = new ArrayList<>();
    private static int numberOfDaysForMonth[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};
    static String teamOneGUI,teamTwoGUI,matchDateGUI;
    static int teamOneScoreGUI,teamTwoScoreGUI;

    @Override
    public void addFootballClub(FootballClub sportClub) {
        //Validate the User Inputs ; Whether club already exit or not
        if(listOfSportClubs.contains(sportClub)) {
            System.out.println("Club Already Registered ! Please Check Details"); //If exist pass the error message
        } else {
            listOfSportClubs.add(sportClub); //If not , added to the arraylist
        }
    }

    @Override
    public void deleteFootballClub(String name) {
        boolean found = false;

        for (FootballClub sportClub : listOfSportClubs) {
            if(sportClub.getNameSportClub().equals(name)) { //If club found, remove from the ArrayList
                found = true;
                listOfSportClubs.remove(sportClub);
                System.out.println("Sport Club removed successfully !");
                break;
            }
        }
        if (!found) { //If club not found , pass the error message
            System.out.println("No any existing sport club, Please Check !");
        }
    }

    @Override
    public void displayClubDetails(String name) {
        boolean clubFound = false;

        for (FootballClub sportClub : listOfSportClubs) {
            if(sportClub.getNameSportClub().equals(name)) { //If club found, remove from the ArrayList
                clubFound = true;
                System.out.println("Club Name : "+sportClub.getNameSportClub()+"\nNo. of Matches Played : "+((FootballClub) sportClub).getNumberOfMatchesPlayed()+"\nNo. of Matches Win : "+
                        ((FootballClub) sportClub).getNumberOfClubWins()+"\nNo. of Matches Draw : "+((FootballClub) sportClub).getNumberOfClubDraw()+"\nNo. of Matches Loss : "+
                        ((FootballClub) sportClub).getNumberOfClubDefeat()+"\nNo. of Goals Recived : "+((FootballClub) sportClub).getNumberOfGoalRecived()+"\nNo. of Matches Goal Score : "+
                        ((FootballClub) sportClub).getNumberOfGoalScored()+"\nNo. of Match Points : "+((FootballClub) sportClub).getNumberOfPoints()+"\n");
                break;
            }
        }
        if (!clubFound) { //If club not found , pass the error message
            System.out.println("No any existing sport club, Please Check !");
        }
    }

    @Override
    public void displayAllClubDetails() {
        if(listOfSportClubs.isEmpty()) { //Checking the ArrayList is Empty
            System.out.println("No any club registered !");
        } else { //If list contain club details , then print all clubs

            /*
            * Reference : Java Documentation (https://docs.oracle.com/javase/tutorial/java/data/numberformat.html)
            * Reference Code : System.out.format("%tB %te, %tY%n", c, c, c); // -->  "May 29, 2006"
            * */
            System.out.println("+-------------------------------------------------------------------------+");
            System.out.format("%-15s%8s%8s%8s%8s%10s%10s%7s","Club Name","Played","Wins","Draws","Loss","Recived","Score","Points");
            System.out.println("\n"+"+-------------------------------------------------------------------------+");

            //Sort List According to Number of Points if Points Equal Then consider the Score Difference
            Collections.sort(listOfSportClubs);

            for (FootballClub sportClub : listOfSportClubs) {
                System.out.printf("%-15s%8s%8s%8s%8s%10s%10s%7s",sportClub.getNameSportClub(),((FootballClub) sportClub).getNumberOfMatchesPlayed(),
                        ((FootballClub) sportClub).getNumberOfClubWins(),((FootballClub) sportClub).getNumberOfClubDraw(),
                        ((FootballClub) sportClub).getNumberOfClubDefeat(),((FootballClub) sportClub).getNumberOfGoalRecived(),
                        ((FootballClub) sportClub).getNumberOfGoalScored(),((FootballClub) sportClub).getNumberOfPoints());
                System.out.println("\n");
            }
            System.out.println("***-----------------------------End of table----------------------------***");

        }
    }

    @Override
    public void updateMatchDetails(String teamOneName, String teamTwoName,String dateMatch,int teamOneScore,int teamTwoScore) {
        FootballClub homeSportClub = null;
        FootballClub visitorSportClub =  null;

        boolean homeTeamFound = false, visitorTeamFound = false;

        for (FootballClub sp1 : listOfSportClubs) {
            if (sp1.getNameSportClub().equals(teamOneName)) {
                homeSportClub = (FootballClub) sp1;
                homeTeamFound = true;
            }
        }

        for (FootballClub sp2 : listOfSportClubs){
            if(sp2.getNameSportClub().equals(teamTwoName)) {
                visitorSportClub = (FootballClub) sp2;
                visitorTeamFound=true;
            }
        }

        if (homeTeamFound==true && visitorTeamFound==true) {
            try {
                //Updating Statistics using Getter and Setters
                homeSportClub.setNumberOfMatchesPlayed(homeSportClub.getNumberOfMatchesPlayed() + 1);
                visitorSportClub.setNumberOfMatchesPlayed(visitorSportClub.getNumberOfMatchesPlayed() + 1);
                homeSportClub.setNumberOfGoalScored(homeSportClub.getNumberOfGoalScored() + teamOneScore);
                visitorSportClub.setNumberOfGoalScored(visitorSportClub.getNumberOfGoalScored() + teamTwoScore);
                homeSportClub.setNumberOfGoalRecived(homeSportClub.getNumberOfGoalRecived() + teamTwoScore);
                visitorSportClub.setNumberOfGoalRecived(visitorSportClub.getNumberOfGoalRecived() + teamOneScore);

                if (teamOneScore > teamTwoScore) { //homeSportClub Wins and visitorSportClub Loss

                    homeSportClub.setNumberOfPoints(homeSportClub.getNumberOfPoints() + 3);
                    homeSportClub.setNumberOfClubWins(homeSportClub.getNumberOfClubWins() + 1);
                    visitorSportClub.setNumberOfClubDefeat(visitorSportClub.getNumberOfClubDefeat() + 1);
                    homeSportClub.setScoreDifferOfMatchesPlayed(homeSportClub.getScoreDifferOfMatchesPlayed() + (teamOneScore-teamTwoScore));
                    visitorSportClub.setScoreDifferOfMatchesPlayed(visitorSportClub.getScoreDifferOfMatchesPlayed() + (teamOneScore-teamTwoScore));

                } else if (teamOneScore < teamTwoScore) { //homeSportClub Loss and visitorSportClub Wins

                    visitorSportClub.setNumberOfPoints(visitorSportClub.getNumberOfPoints() + 3);
                    visitorSportClub.setNumberOfClubWins(visitorSportClub.getNumberOfClubWins() + 1);
                    homeSportClub.setNumberOfClubDefeat(homeSportClub.getNumberOfClubDefeat() + 1);
                    homeSportClub.setScoreDifferOfMatchesPlayed(homeSportClub.getScoreDifferOfMatchesPlayed() + (teamTwoScore-teamOneScore));
                    visitorSportClub.setScoreDifferOfMatchesPlayed(visitorSportClub.getScoreDifferOfMatchesPlayed() + (teamTwoScore-teamOneScore));

                } else if (teamOneScore == teamTwoScore) { //Both Teams Draws
                    homeSportClub.setNumberOfPoints(homeSportClub.getNumberOfPoints() + 1);
                    visitorSportClub.setNumberOfPoints(visitorSportClub.getNumberOfPoints() + 1);
                    homeSportClub.setNumberOfClubDraw(homeSportClub.getNumberOfClubDraw() + 1);
                    visitorSportClub.setNumberOfClubDraw(visitorSportClub.getNumberOfClubDraw() + 1);
                }
            }catch (Exception e) { }

            listMatchDates.add(new MatchUpdate(teamOneName, teamTwoName, dateMatch, teamOneScore, teamTwoScore));
            System.out.println("List Updated !\n");
        } else {
            System.out.println("Please Check Again ! Team Not Found\n");
        }
    }

    /*Method to Save Data Locally
    * In here I used two file handling for Club Details and Match Updates separately
    * */
    @Override
    public void saveDataLocal() throws IOException {
        FileOutputStream fileOutputStreamClub = new FileOutputStream("ClubDetails.txt");
        //Create new ObjectOutputStream
        ObjectOutputStream objectOutputStreamClub = new ObjectOutputStream(fileOutputStreamClub);

        for (FootballClub saveSportClub : listOfSportClubs) {
            objectOutputStreamClub.writeObject(saveSportClub); //writeObject
        }
        objectOutputStreamClub.close(); //Close ObjectOutputStream
        fileOutputStreamClub.close(); //Close fileOutputStream

        //Save Match Details
        FileOutputStream fileOutputStreamMatch = new FileOutputStream("MatchDetails.txt");
        //Create new ObjectOutputStream
        ObjectOutputStream objectOutputStreamMatch = new ObjectOutputStream(fileOutputStreamMatch);

        for (MatchUpdate matchUpdate : listMatchDates) {
            objectOutputStreamMatch.writeObject(matchUpdate); //writeObject
        }
        objectOutputStreamMatch.close(); //Close ObjectOutputStream
        fileOutputStreamMatch.close(); //Close fileOutputStream

    }

    //Method to Update the List
    @Override
    public void updateListFromData() {

        //Update List - listOfSportClubs
        try {
            FileInputStream fileInputStreamClub = new FileInputStream("ClubDetails.txt");
            ObjectInputStream objectInputStreamClub = new ObjectInputStream(fileInputStreamClub);

            for (;;) {
                try {
                    FootballClub existClub = (FootballClub) objectInputStreamClub.readObject();
                    listOfSportClubs.add(existClub);
                }catch (EOFException e) {
                    break;
                }
            }

            objectInputStreamClub.close();
            fileInputStreamClub.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFound) {
            System.out.println("Class not found");
        }

        //Update List - listMatchDates
        try {
            FileInputStream fileInputStreamMatch = new FileInputStream("MatchDetails.txt");
            ObjectInputStream objectInputStreamMatch = new
                    ObjectInputStream(fileInputStreamMatch);

            for (;;) {
                try {
                    MatchUpdate existClub = (MatchUpdate) objectInputStreamMatch.readObject();
                    listMatchDates.add(existClub);
                }catch (EOFException e) {
                    break;
                }
            }

            objectInputStreamMatch.close();
            fileInputStreamMatch.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (ClassNotFoundException classNotFound) {
            System.out.println("Class not found");
        }

    }

    //Validate the Match Date Input
    @Override
    public boolean validateDate(String dateIn) {
        if (validateDateFormat(dateIn) == true) {
            return true;
        } else {
            System.out.println("Invalid Date Format or Date !");
            return false;
        }
    }

    //Generate Random Matches
    @Override
    public void randomMatchGenerator() {
        String teamOneName; String teamTwoName; String dateMatch; int teamOneScore; int teamTwoScore;
        //Validate the listOfSportClubs Array lit, whether there are two or more group to generate the Match among two teamOneScore
        if (listOfSportClubs.isEmpty() || listOfSportClubs.size() < 2 ) {
            //Cannot Generate Matches Please Check the List
        } else {
            Random randomGen = new Random();

            List<String> clubNames = new ArrayList<>();

            for (FootballClub sportClub : listOfSportClubs) {
                clubNames.add(sportClub.getNameSportClub());
            }

            teamOneName = clubNames.get(randomGen.nextInt(clubNames.size()));
            clubNames.remove(teamOneName); // Remove added Club Name , Because Club can be repeated
            teamTwoName = clubNames.get(randomGen.nextInt(clubNames.size()));
            teamOneScore = randomScore(0,99);
            teamTwoScore = randomScore(0,99);
            dateMatch = randomDate(2000,2020);

            //Update the MatchDetails
            updateMatchDetails(teamOneName,teamTwoName,dateMatch,teamOneScore,teamTwoScore);
        }
    }

    //Method to search played matches
    @Override
    public void searchMatches(String matchDate) {
        for (MatchUpdate matchUpdate : listMatchDates) {
            if (matchUpdate.getMatchDate().equals(matchDate)) {
                //Match Details
                System.out.println("Team 1 Name : "+matchUpdate.getTeamOneName());
                System.out.println("Team 1 Score : "+matchUpdate.getTeamOneScore());
                System.out.println("Team 2 Name : "+matchUpdate.getTeamTwoName());
                System.out.println("Team 2 Score : "+matchUpdate.getTeamTwoScore());
                System.out.println("Match Date : "+matchUpdate.getMatchDate()+"\n");

                teamOneGUI = matchUpdate.getTeamOneName();
                teamTwoGUI = matchUpdate.getTeamTwoName();
                teamOneScoreGUI = matchUpdate.getTeamOneScore();
                teamTwoScoreGUI = matchUpdate.getTeamTwoScore();
                matchDateGUI = matchUpdate.getMatchDate();
            }
        }
    }

    //Method to return the search result of the match played
    @Override
    public String returnSearchMatches() {
        return "Team One : "+teamOneGUI+"\nTeam One Score : "+teamOneScoreGUI+"\nTeam Two : "+teamTwoGUI+"\nTeam Two Score : "+teamTwoScoreGUI+"\nMatch Date : "+matchDateGUI;
    }

    //Display All the Matches Played
    @Override
    public void displayAllPlayedMatches() {
        if(listMatchDates.isEmpty()) {
            System.out.println("No any matches played !");
        } else { //If list contain played matches , then print all the matches played
            System.out.println("+-------------------------------------------------------------------------------------------+");
            System.out.format("%-18s%18s%18s%18s%15s","Club One Name","Club One Score","Club Two Name","Club Two Score","Match Date");
            System.out.println("\n+-------------------------------------------------------------------------------------------+");

            //Sort by Match Date
            sortDateFunction(listMatchDates);

            for (MatchUpdate matchUpdate : listMatchDates) {
                System.out.printf("%-18s%18s%18s%18s%15s",matchUpdate.getTeamOneName(),matchUpdate.getTeamOneScore(),matchUpdate.getTeamTwoName(),matchUpdate.getTeamTwoScore(),matchUpdate.getMatchDate());
                System.out.println("\n");
            }
            System.out.println("+----------------------------------End of Table----------------------------------------+");
        }
    }

    //Sorting According to the Match Date
    @Override
    public void sortDateFunction(List<MatchUpdate> dateList) {
        Collections.sort(dateList, new Comparator<MatchUpdate>() {

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            @Override
            public int compare(MatchUpdate matchUpdate1, MatchUpdate matchUpdate2) {
                try {
                    return dateFormat.parse(matchUpdate1.getMatchDate()).compareTo(dateFormat.parse(matchUpdate2.getMatchDate()));
                } catch (ParseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        });
    }

    //Generate Random Score from given range
    public static int randomScore(int startInt,int endInt) {
        int clubScore = startInt + (int) Math.round(Math.random() * (endInt - startInt));
        return clubScore;
    }

    //Generate random date from given startYear and endYear
    public static String randomDate(int startYear, int endYear) {
        int year = startYear + (int) Math.round(Math.random() * (endYear - startYear));
        int month = 1 + (int) Math.round(Math.random() * (12 - 1));
        int day = 1 + (int) Math.round(Math.random() * (28 - 1));
        return year+"/"+month+"/"+day;
    }

    /*
     * Validate the Date Format
     * Reference : StackOverFlow (https://stackoverflow.com/questions/48246650/valid-date-format-check-in-java)
     * */
    public static boolean validateDateFormat(String userInputDate) {
        DateFormat validateMatchDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date checkFormat = null;
        validateMatchDateFormat.setLenient(false);
        int dd,mm,yyyy = 0;

        while (true) {
            //Validate the Date Format
            try {
                checkFormat = validateMatchDateFormat.parse(userInputDate);

                String[] array = userInputDate.split("/");
                dd=Integer.parseInt(array[2]);
                mm=Integer.parseInt(array[1]);
                yyyy=Integer.parseInt(array[0]);

                //Validate the Date, Month and Year
                try {
                    if(isValidDate(dd,mm,yyyy)) {
                        return true;
                    }else {
                        return false;
                    }
                }catch (Exception e) {
                    return false;
                }

            } catch (Exception e) {
                return false;
            }
        }

    }

    //Checking the the Year (is Leap year or not)
    private static boolean checkLeapYear(int YYYY) {
        if (YYYY % 400 == 0) {
            return true;
        }
        else if (YYYY %100 == 0) {
            return false;
        }
        else {
            return YYYY % 4 ==  0;
        }
    }

    //Validate the Number of Days for the Month and Number Month for the Year
    private static boolean isValidDate(int DD, int MM,int YYYY) {
        if (DD < 1 || MM < 1 || YYYY < 1 || MM > 12 ) {
            return false;
        } else if ( MM == 2 && checkLeapYear(YYYY) ) {
            return DD <= 29;
        } else {
            //Retrieve the Number of Date for a Month
            return DD <= numberOfDaysForMonth[MM];
        }
    }


}