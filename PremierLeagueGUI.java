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
    public void start(Stage primaryStage) throws Exception {

        //TODO First Try to do all the sorting and after that try other TODO mention

        //Main Pane
        Pane rootPane = new Pane();

        //Scroll Pane
        Pane matchDisplayPane = new Pane();
        matchDisplayPane.setLayoutX(965);
        matchDisplayPane.setLayoutY(200);
        matchDisplayPane.setPrefWidth(320);
        matchDisplayPane.setPrefHeight(300);

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
        played.setCellValueFactory(new PropertyValueFactory("numberOfMatchesPlayed"));

        TableColumn wins = new TableColumn("Won");
        wins.setCellValueFactory(new PropertyValueFactory("numberOfClubWins"));

        TableColumn draws = new TableColumn("Draw");
        draws.setCellValueFactory(new PropertyValueFactory("numberOfClubDraw"));

        TableColumn loss = new TableColumn("Loss");
        loss.setCellValueFactory(new PropertyValueFactory("numberOfClubDefeat"));

        TableColumn recived = new TableColumn("Recived");
        recived.setCellValueFactory(new PropertyValueFactory("numberOfGoalRecived"));

        TableColumn score = new TableColumn("Score");
        score.setCellValueFactory(new PropertyValueFactory("numberOfGoalScored"));

        TableColumn points = new TableColumn("Points");
        points.setCellValueFactory(new PropertyValueFactory("numberOfPoints"));

        //Table Properties
        tableViewListClub.setItems(listObserver);
        tableViewListClub.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewListClub.getColumns().addAll(clubName,played,wins,draws,loss,recived,score,points);
        tableViewListClub.setLayoutX(50);
        tableViewListClub.setLayoutY(150);

        //Adding Table to Display the List of Match Details
        TableView<MatchUpdate> tableViewListMatch = new TableView<>();
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

//        TableColumn winClubName = new TableColumn("Won Team");
//        winClubName.setMinWidth(150);
//        winClubName.setCellValueFactory(new PropertyValueFactory("numberOfGoalRecived"));

        //Table Properties
        tableViewListMatch.setItems(listObserverMatches);
        tableViewListMatch.setVisible(false);
        tableViewListMatch.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewListMatch.getColumns().addAll(clubOneMatch,clubOneMatchScore,clubTwoMatch,clubTwoMatchScore,matchDateColumn);
        tableViewListMatch.setLayoutX(50);
        tableViewListMatch.setLayoutY(150);

        //Adding Match Search TextField
        TextField searchMatchInput = new TextField();
        searchMatchInput.setPromptText("Eg: 2020/12/10");
        searchMatchInput.setLayoutY(150);
        searchMatchInput.setLayoutX(965);

        //Match Search Button
        Button searchMatchButton = new Button("Search Matches");
        searchMatchButton.setLayoutY(150);
        searchMatchButton.setLayoutX(1165);

        //Search Result
        Label searchResult = new Label();
        searchResult.setVisible(false);
        searchResult.setLayoutX(20);
        searchResult.setLayoutY(20);

        searchMatchButton.setOnAction(e -> { //TODO
            //Passing Date Parameter
            leagueManager.searchMatches(searchMatchInput.getText());
            //TODO Check How to Pass the Parameters
            searchResult.setVisible(true);
            MatchUpdate matchUpdate = new MatchUpdate();

            if (leagueManager.validateDate(searchMatchInput.getText())) {
                searchResult.setText(leagueManager.returnSearchMatches());
            } else {
                //Return Invalid Input or Something
            }
        });

        //Display All Matches Played Button
        Button displayMatch = new Button("Display All Matches");
        displayMatch.setPrefSize(150,30);
        displayMatch.setLayoutY(600);
        displayMatch.setLayoutX(50);

        //Display All Clubs Played Button
        Button displayAllClub = new Button("Display All Clubs");
        displayAllClub.setVisible(false);
        displayAllClub.setPrefSize(150,30);
        displayAllClub.setLayoutY(600);
        displayAllClub.setLayoutX(50);

        //Sort to Number of Wins Button
        Button sortWins = new Button("Sort to Wins");
        sortWins.setLayoutY(600);
        sortWins.setLayoutX(225);

        //Sort to Goal Scored Button
        Button sortGoal = new Button("Sort to Goal Scored");
        sortGoal.setLayoutY(600);
        sortGoal.setLayoutX(350);

        //Random Club Generate Button
        Button generateButton = new Button("Generate New Club");
        generateButton.setLayoutY(600);
        generateButton.setLayoutX(530);
        generateButton.setDisable(true);

        //generateButton Actions
        generateButton.setOnAction(e -> { //TODO : Real-Time Update or Try Another Method
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
        });

        //Display All Club Button Properties
        displayAllClub.setOnAction(e -> {
            generateButton.setDisable(true);
            tableViewListMatch.setVisible(false);
            tableViewListClub.setVisible(true);
            displayMatch.setVisible(true);
            displayAllClub.setVisible(false);
        });

        //Adding Elements to the ScrollPane
        matchDisplayPane.getChildren().add(searchResult);

        //Adding Elements to the Pane
        rootPane.getChildren().add(bgImageView);
        rootPane.getChildren().add(separatorOne);
        rootPane.getChildren().add(separatorTwo);
        rootPane.getChildren().add(logoImageView);
        rootPane.getChildren().add(welcomeLabel1);
        rootPane.getChildren().add(matchDisplayPane);
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
