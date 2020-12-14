package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

import java.io.IOException;

public class PremierLeagueGUI extends Application {

    static LeagueManager leagueManager = new PremierLeagueManager();

    @Override
    public void start(Stage primaryStage) {

        //TODO : Validation Date and Only one date can have One Match ,, Sorting on compareTo and Check default

        //Main Pane
        Pane rootPane = new Pane();

        //Sub Pane - 1
        Pane matchDisplayPane = new Pane();
        matchDisplayPane.setLayoutX(965);
        matchDisplayPane.setLayoutY(200);
        matchDisplayPane.setPrefWidth(320);
        matchDisplayPane.setPrefHeight(300);

        //Sub Pane - 2
        Pane helpText = new Pane();
        helpText.setLayoutX(965);
        helpText.setLayoutY(200);
        helpText.setPrefWidth(320);
        helpText.setPrefHeight(500);

        //Add Background Image
        Image bgImage = new Image("file:app-bg-img.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setLayoutX(0);
        bgImageView.setLayoutY(0);

        //Welcome Note
        Label welcomeLabel1 = new Label("Welcome to Premier League Dashboard");
        welcomeLabel1.setFont(Font.font("Tahoma", FontPosture.ITALIC, 40));
        welcomeLabel1.setLayoutY(50);
        welcomeLabel1.setLayoutX(100);

        //Add Premier League Logo
        Image logoImage = new Image("file:logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setLayoutX(970);
        logoImageView.setLayoutY(520);
        logoImageView.setPreserveRatio(true);
        logoImageView.setFitWidth(300);

        Separator separatorOne = new Separator();
        separatorOne.setOrientation(Orientation.HORIZONTAL);
        separatorOne.setPrefWidth(350);
        separatorOne.setLayoutY(130);
        separatorOne.setLayoutX(950);

        Separator separatorTwo = new Separator();
        separatorTwo.setOrientation(Orientation.VERTICAL);
        separatorTwo.setPrefHeight(680);
        separatorTwo.setLayoutY(10);
        separatorTwo.setLayoutX(900);

        //Adding Table to Display the List of Clubs
        TableView<SportClub> tableViewListClub = new TableView<>();
        final ObservableList<SportClub> listObserver = FXCollections.observableArrayList(PremierLeagueManager.listOfSportClubs);

        TableColumn clubName = new TableColumn("Club Name");
        clubName.setMinWidth(150);
        clubName.setCellValueFactory(new PropertyValueFactory("nameSportClub"));

        TableColumn played = new TableColumn("Played");
        played.setMinWidth(75);
        played.setCellValueFactory(new PropertyValueFactory("numberOfMatchesPlayed"));

        TableColumn wins = new TableColumn("Won");
        wins.setMinWidth(75);
        wins.setCellValueFactory(new PropertyValueFactory("numberOfClubWins"));

        TableColumn draws = new TableColumn("Draw");
        draws.setMinWidth(75);
        draws.setCellValueFactory(new PropertyValueFactory("numberOfClubDraw"));

        TableColumn loss = new TableColumn("Loss");
        loss.setMinWidth(75);
        loss.setCellValueFactory(new PropertyValueFactory("numberOfClubDefeat"));

        TableColumn recived = new TableColumn("Recived");
        recived.setMinWidth(75);
        recived.setCellValueFactory(new PropertyValueFactory("numberOfGoalRecived"));

        TableColumn score = new TableColumn("Score");
        score.setMinWidth(75);
        score.setCellValueFactory(new PropertyValueFactory("numberOfGoalScored"));

        TableColumn points = new TableColumn("Points");
        points.setMinWidth(75);
        points.setCellValueFactory(new PropertyValueFactory("numberOfPoints"));

        //Table Properties
        /*
        * Reference : https://www.superglobals.net/remove-extra-column-tableview-javafx/
        * Referred Code : tableViewListClub.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        * */
        tableViewListClub.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableViewListClub.setItems(listObserver);
        tableViewListClub.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewListClub.getColumns().addAll(clubName,played,wins,draws,loss,recived,score,points);
        tableViewListClub.setLayoutX(100);
        tableViewListClub.setLayoutY(150);

        //Adding Table to Display the List of Match Details
        TableView<MatchUpdate> tableViewListMatch = new TableView<>();
        leagueManager.sortDateFunction(PremierLeagueManager.listMatchDates);
        final ObservableList<MatchUpdate> listObserverMatches = FXCollections.observableArrayList(PremierLeagueManager.listMatchDates);

        TableColumn clubOneMatch = new TableColumn("Club One");
        clubOneMatch.setMinWidth(150);
        clubOneMatch.setCellValueFactory(new PropertyValueFactory("teamOneName"));

        TableColumn clubOneMatchScore = new TableColumn("Club Score");
        clubOneMatchScore.setMinWidth(100);
        clubOneMatchScore.setCellValueFactory(new PropertyValueFactory("teamOneScore"));

        TableColumn clubTwoMatch = new TableColumn("Club Two");
        clubTwoMatch.setMinWidth(150);
        clubTwoMatch.setCellValueFactory(new PropertyValueFactory("teamTwoName"));

        TableColumn clubTwoMatchScore = new TableColumn("Club Score");
        clubTwoMatchScore.setMinWidth(100);
        clubTwoMatchScore.setCellValueFactory(new PropertyValueFactory("teamTwoScore"));

        TableColumn matchDateColumn = new TableColumn("MatchDate");
        matchDateColumn.setMinWidth(155);
        matchDateColumn.setCellValueFactory(new PropertyValueFactory("matchDate"));

        //Table Properties
        tableViewListMatch.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableViewListMatch.setItems(listObserverMatches);
        tableViewListMatch.setVisible(false);
        tableViewListMatch.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewListMatch.getColumns().addAll(clubOneMatch,clubOneMatchScore,clubTwoMatch,clubTwoMatchScore,matchDateColumn);
        tableViewListMatch.setLayoutX(120);
        tableViewListMatch.setLayoutY(150);

        //Adding Match Search TextField
        TextField searchMatchInput = new TextField();
        searchMatchInput.setPromptText("Eg: 2020/12/10");
        searchMatchInput.setLayoutY(150);
        searchMatchInput.setLayoutX(965);
        searchMatchInput.setStyle("-fx-border-color: #033280");

        //Match Search Button
        Button searchMatchButton = new Button("Search Matches");
        searchMatchButton.setLayoutY(150);
        searchMatchButton.setLayoutX(1165);
        searchMatchButton.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Search Result
        Label searchResult = new Label();
        searchResult.setVisible(false);
        searchResult.setLayoutX(20);
        searchResult.setLayoutY(20);

        searchMatchButton.setOnAction(e -> {
            //Passing Date Parameter
            searchResult.setVisible(true);

            if (leagueManager.validateDate(searchMatchInput.getText())) {
                //For Loop
                for (MatchUpdate matchUpdate : PremierLeagueManager.listMatchDates ) {
                    if (matchUpdate.getMatchDate().contains(searchMatchInput.getText())) {
                        searchResult.setText(leagueManager.returnSearchMatches());
                    } else {
                        searchMatchInput.setStyle("-fx-border-color: #ff0000");
                        searchResult.setText("Not Found");
                    }
                }
            } else {
                searchMatchInput.setStyle("-fx-border-color: #ff0000");
            }
        });

        //Title Label
        Label titleLabel = new Label();
        titleLabel.setLayoutY(90);
        titleLabel.setLayoutX(1020);
        titleLabel.setFont(Font.font("Tahoma", FontPosture.ITALIC, 20));
        titleLabel.setText("Search Played Matches");

        //Help Label
        Label helpInfoLabel = new Label();
//        helpInfoLabel.setLayoutY(90);
//        helpInfoLabel.setLayoutX(1020);
        helpInfoLabel.setFont(Font.font("Tahoma", FontPosture.ITALIC, 12));
        helpInfoLabel.setText("1.\tUser of Premier League Dashboard Can View all the Club\nDetails and Matches Played by the Teams (By Clicking the\n“Display All Matches” Button)\n\n" +
                "2.\tBy Clicking “Sort by Win” button, User can sort clubs\naccording to the clubs as they won matches.\n\n" +
                "3.\tBy Clicking “Sort by Score” button, User can sort clubs\naccording to the clubs as they goal scored in matches.\n\n" +
                "4.\tBy Clicking “Generate Matches” button, User can generate\nrandom matches among the existing teams\n\n" +
                "5.\tBy Clicking “Save to Database” button, User can save\ngenerated matches to the Database\n\n" +
                "6.\tUser can search matches by adding the year, month and\ndate of the match played but user should follow the Date Format.\n\n" +
                "7.\tFor one certain date, only can have one match.");
        helpInfoLabel.setVisible(false);

        //Display All Matches Played Button
        Button displayMatch = new Button("Display All Matches");
        displayMatch.setPrefSize(150,30);
        displayMatch.setLayoutY(600);
        displayMatch.setLayoutX(50);
        displayMatch.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Display All Clubs Played Button
        Button displayAllClub = new Button("Display All Clubs");
        displayAllClub.setVisible(false);
        displayAllClub.setPrefSize(150,30);
        displayAllClub.setLayoutY(600);
        displayAllClub.setLayoutX(50);
        displayAllClub.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Sort to Number of Wins Button
        Button sortWins = new Button("Sort by Wins");
        sortWins.setLayoutY(600);
        sortWins.setLayoutX(225);
        sortWins.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Sort by Wins Button Properties
        sortWins.setOnAction(e -> {
            tableViewListClub.setItems(listObserver);
            wins.setSortType(TableColumn.SortType.DESCENDING);
            tableViewListClub.getSortOrder().add(wins);
        });

        //Sort to Goal Scored Button
        Button sortGoal = new Button("Sort by Goal Scored");
        sortGoal.setLayoutY(600);
        sortGoal.setLayoutX(350);
        sortGoal.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Sort by Goals Scored Button Properties
        sortGoal.setOnAction(e -> {
            tableViewListClub.setItems(listObserver);
            score.setSortType(TableColumn.SortType.DESCENDING);
            tableViewListClub.getSortOrder().add(score);
        });

        //Random Club Generate Button
        Button generateButton = new Button("Generate Matches");
        generateButton.setLayoutY(600);
        generateButton.setLayoutX(530);
        generateButton.setDisable(true);
        generateButton.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //generateButton Actions
        generateButton.setOnAction(e -> {
            leagueManager.randomMatchGenerator();
            //Refresh
            tableViewListMatch.getItems().clear();

            for (MatchUpdate matchUpdate : PremierLeagueManager.listMatchDates) {
                tableViewListMatch.getItems().addAll(matchUpdate);
            }
        });

        //Save to Local Database Button
        Button saveLocal = new Button("Save to Database");
        saveLocal.setLayoutY(600);
        saveLocal.setLayoutX(705);
        saveLocal.setStyle("-fx-background-color:linear-gradient(#1366eb, #033280); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        saveLocal.setOnAction(e -> {
            try {
                leagueManager.saveDataLocal();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        //Display Matches Details Button Properties
        displayMatch.setOnAction(e -> {
            generateButton.setDisable(false);
            tableViewListMatch.setVisible(true);
            tableViewListClub.setVisible(false);
            displayMatch.setVisible(false);
            displayAllClub.setVisible(true);
            sortGoal.setDisable(true);
            sortWins.setDisable(true);
        });

        //Display All Club Button Properties
        displayAllClub.setOnAction(e -> {
            generateButton.setDisable(true);
            tableViewListMatch.setVisible(false);
            tableViewListClub.setVisible(true);
            displayMatch.setVisible(true);
            displayAllClub.setVisible(false);
            sortGoal.setDisable(false);
            sortWins.setDisable(false);
        });

        //Back Button
        Button backButton = new Button("Back");
        backButton.setLayoutX(1230);
        backButton.setLayoutY(660);
        backButton.setVisible(false);
        backButton.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00); -fx-background-radius: 20px; -fx-text-fill: #000; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Exit Button
        Button exitAppButton = new Button("Exit");
        exitAppButton.setLayoutX(1290);
        exitAppButton.setLayoutY(660);
        exitAppButton.setStyle("-fx-background-color:linear-gradient(#e64b40, #ff0000); -fx-background-radius: 20px; -fx-text-fill: fff; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Exit Button Properties
        exitAppButton.setOnAction(e -> {
            Stage javafxStage = (Stage) exitAppButton.getScene().getWindow();
            javafxStage.close();
        });

        //Help Button
        Button helpButton = new Button("Help");
        helpButton.setLayoutX(1230);
        helpButton.setLayoutY(660);
        helpButton.setStyle("-fx-background-color:linear-gradient(#f0ff35, #a9ff00); -fx-background-radius: 20px; -fx-text-fill: #000; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");

        //Back Button Properties
        backButton.setOnAction(e -> {
            helpButton.setVisible(true);
            backButton.setVisible(false);
            searchResult.setVisible(true);
            searchMatchButton.setVisible(true);
            searchMatchInput.setVisible(true);
            logoImageView.setVisible(true);
            titleLabel.setText("Search Played Matches");
            titleLabel.setLayoutY(90);
            titleLabel.setLayoutX(1020);
            helpInfoLabel.setVisible(false);
        });

        //Help Button Properties
        helpButton.setOnAction(e -> {
            helpButton.setVisible(false);
            searchResult.setVisible(false);
            searchMatchButton.setVisible(false);
            searchMatchInput.setVisible(false);
            logoImageView.setVisible(false);
            backButton.setVisible(true);
            titleLabel.setText("Help");
            titleLabel.setLayoutY(90);
            titleLabel.setLayoutX(1110);
            helpInfoLabel.setVisible(true);
        });

        //Adding Elements to the Sub Pane
        matchDisplayPane.getChildren().add(searchResult);
        helpText.getChildren().add(helpInfoLabel);

        //Adding Elements to the Pane
        rootPane.getChildren().add(bgImageView);
        rootPane.getChildren().add(separatorOne);
        rootPane.getChildren().add(separatorTwo);
        rootPane.getChildren().add(logoImageView);
        rootPane.getChildren().add(titleLabel);
        rootPane.getChildren().add(welcomeLabel1);
        rootPane.getChildren().add(matchDisplayPane);
        rootPane.getChildren().add(helpText);
        rootPane.getChildren().add(tableViewListClub);
        rootPane.getChildren().add(tableViewListMatch);
        rootPane.getChildren().add(searchMatchButton);
        rootPane.getChildren().add(searchMatchInput);
        rootPane.getChildren().add(generateButton);
        rootPane.getChildren().add(displayMatch);
        rootPane.getChildren().add(displayAllClub);
        rootPane.getChildren().add(sortWins);
        rootPane.getChildren().add(sortGoal);
        rootPane.getChildren().add(saveLocal);
        rootPane.getChildren().add(exitAppButton);
        rootPane.getChildren().add(helpButton);
        rootPane.getChildren().add(backButton);

        //Window Properties
        primaryStage.setResizable(false); //Disable Resizing Window
        primaryStage.setTitle("Dashboard - Premier League");
        primaryStage.setAlwaysOnTop(true); //Set Conditions --> setAlwaysOnTop = true
        primaryStage.setScene(new Scene(rootPane, 1350, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
