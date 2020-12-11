package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

//Console Graphical User Interface
public class ConsoleGUI {

    static final Scanner USER_IN = new Scanner(System.in);
    static LeagueManager leagueManager = new PremierLeagueManager();
    private static boolean checkType;
    static FootballClub footballClub = new FootballClub();
    static MatchUpdate newMatch;


    //Display Application Menu
    private static void consoleMenu() {
        System.out.println("------Welcome to the Premier League Manager------\n");
        System.out.println("1 : Create a new football club\n");
        System.out.println("2 : Delete existing football club\n");
        System.out.println("3 : Search existing football club\n");
        System.out.println("4 : View all club and their statistics\n");
        System.out.println("5 : Update match details\n");
        System.out.println("0 : Save and Terminate Application\n>>");
    }

    public static void main(String[] args) throws IOException {

        //Load Previous Records from the "ClubDetails.txt"
        leagueManager.updateListFromData();

        displayMenuLoop:
        // Creating WHILE loop to loop the program until exit by pressing "0"
        while (true) {
            consoleMenu();

            int selectOption;
            while (true) {
                try {
                    selectOption = USER_IN.nextInt();
                } catch (InputMismatchException | IllegalArgumentException e) {
                    System.out.print("Invalid Option ! ");
                    USER_IN.next();
                    continue;
                }
                break;
            }

            switch (selectOption) {
                case 1:
                    addFootballClub();
                    break;
                case 2:
                    deleteFootballClub();
                    break;
                case 3:
                    displayClubDetails();
                    break;
                case 4:
                    displayAllClubDetails();
                    break;
                case 5:
                    updateMatchDetails();
                    break;
                case 0:
                    System.out.println("Thank you using the Premier League Application ! ");
                    leagueManager.saveDataLocal();
                    break displayMenuLoop;
                default:
                    System.out.println("Invalid Option ! Please Check");
            }
        }

    }

    private static void updateMatchDetails() {

        System.out.println("Enter the Match Date (Format : YYYY/MM/DD) : ");
        String dateMatch = USER_IN.next();

        //Validate the Date Format and Date using validateDate() method in PremierLeagueManager
        boolean validity = leagueManager.validateDate(dateMatch);


        while (validity != true) {
            System.out.print(">> ");
            USER_IN.next();
            break;
        }

        System.out.println("Enter Team 1 Name : ");
        String inputTeamOne = USER_IN.next();
        String oneName = capitalizeFirstLetter(inputTeamOne);

        System.out.println("Enter Team 2 Name : ");
        String inputTeamTwo = USER_IN.next();
        String twoName = capitalizeFirstLetter(inputTeamTwo);

        System.out.println("Enter Team 1 Score : ");

        //Validate the Input
        int oneScore;
        while (true) {
            try {
                oneScore = USER_IN.nextInt();
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.print("Invalid! Please enter an integer ");
                USER_IN.next();
                continue;
            }
            break;
        }

        System.out.println("Enter Team 2 Score : ");

        //Validate the Input
        int twoScore;
        while (true) {
            try {
                twoScore = USER_IN.nextInt();
            } catch (InputMismatchException | IllegalArgumentException e) {
                System.out.println("Invalid! Please enter an integer");
                USER_IN.next();
                continue;
            }
            break;
        }

        //Add Match ClubDetails
        leagueManager.updateMatchDetails(oneName, twoName, dateMatch, oneScore, twoScore);
    }

    private static void displayAllClubDetails() {
        leagueManager.displayAllClubDetails();
    }

    private static void displayClubDetails() {
        System.out.println("Please Enter Club Name : ");
        String inputDisplay = USER_IN.next();
        String clubName = capitalizeFirstLetter(inputDisplay);

        //Calling Function in PremierLeagueManager
        leagueManager.displayClubDetails(clubName);
    }

    private static void deleteFootballClub() {
        System.out.println("Please Enter Club Name : ");
        String inputDelete = USER_IN.next();
        String clubName = capitalizeFirstLetter(inputDelete);

        //Calling Function in PremierLeagueManager
        leagueManager.deleteFootballClub(clubName);
    }

    private static void addFootballClub() throws IOException {
        System.out.println("Please Enter the Club Name : ");
        String inputOne = USER_IN.next();
        String nameSportClubInput = capitalizeFirstLetter(inputOne);

        System.out.println("Please Enter the Location of the Club : ");
        String inputTwo = USER_IN.next();
        String locationSportClubInput = capitalizeFirstLetter(inputTwo);

        String typeOfClub;
        do {
            System.out.println("Please Enter type of the Club (School/University) : ");
            typeOfClub = USER_IN.next().toLowerCase();
            checkType = typeOfClub.matches("university") || typeOfClub.matches("school");
        } while (!checkType);


        switch (typeOfClub) {
            case "university":
                System.out.println("Please Enter University Name : ");
                String inputThree = USER_IN.next();
                String uniName = capitalizeFirstLetter(inputThree);

                System.out.println("Please Enter University Registration Number : ");
                int uniRegNum; //TODO : Integer Validation

                while (true) {
                    try {
                        uniRegNum = USER_IN.nextInt();
                    } catch (InputMismatchException | IllegalArgumentException e) {
                        System.out.println("Invalid! Please enter an integer ");
                        USER_IN.next();
                        continue;
                    }
                    break;
                }

                FootballClub newUniClub = new UniversityFootballClub(nameSportClubInput, locationSportClubInput, 0, 0, 0, 0, 0, 0, 0, 0, uniName, uniRegNum);
                leagueManager.addFootballClub(newUniClub);
                break;
            case "school":
                System.out.println("Please Enter School Name : ");
                String inputFour = USER_IN.next();
                String schName = capitalizeFirstLetter(inputFour);

                System.out.println("Please Enter Name of the Master InCharge : ");
                String inputFive = USER_IN.next();
                String masterName = capitalizeFirstLetter(inputFive);

                FootballClub newSchClub = new SchoolFootballClub(nameSportClubInput, locationSportClubInput, 0, 0, 0, 0, 0, 0, 0, 0, schName, masterName);
                leagueManager.addFootballClub(newSchClub);
                break;
            default:
                System.out.println("Invalid Type Please Check");
        }
    }

    //Capitalize the First Letter
    /*
     * Reference : https://attacomsian.com/
     * Referred Code : String output = str.substring(0, 1).toUpperCase() + str.substring(1);
     * */
    private static String capitalizeFirstLetter(String name) {
        String outputWord = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        return outputWord;
    }

}
