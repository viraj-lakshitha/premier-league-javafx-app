package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import com.courseWork.submissionFour.SportClub;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PremierLeagueGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //TODO : X Y Coordinates & File Handling Part of MatchUpdate Class

        //Main Pane
        Pane rootPane = new Pane();

        //Add Background Image
        Image bgImage = new Image("file:app-bg-img.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setLayoutX(0);
        bgImageView.setLayoutY(0);

        //Welcome Note
        Label welcomeLabel1 = new Label("Welcome");
        welcomeLabel1.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 30));
        //welcomeLabel1.setLayoutY(80);
        //welcomeLabel1.setLayoutX(150);

        Label welcomeLabel2 = new Label("Premier League Dashboard");
        welcomeLabel2.setFont(Font.font("Tahoma", FontPosture.ITALIC, 20));
        //welcomeLabel2.setLayoutY(140);
        //welcomeLabel2.setLayoutX(100);

        //Add Premier League Logo
        Image logoImage = new Image("file:logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        //logoImageView.setLayoutX(70);
        //logoImageView.setLayoutY(520);
        //logoImageView.setPreserveRatio(true);
        //logoImageView.setFitWidth(300);

        Separator separatorTwo = new Separator();
        separatorTwo.setOrientation(Orientation.VERTICAL);
        separatorTwo.setPrefHeight(680);
        separatorTwo.setLayoutY(10);
        separatorTwo.setLayoutX(900);

        Separator separatorThree = new Separator();
        separatorThree.setOrientation(Orientation.HORIZONTAL);
        separatorThree.setPrefWidth(350);
        separatorThree.setLayoutY(130);
        separatorThree.setLayoutX(950);

        //Adding Table to Display the List of Clubs
        TableView<SportClub> tableViewListClub = new TableView<>();
        //final ObservableList<SportClub> listObserver = FXCollections.observableArrayList(PremierLeagueManager.listOfSportClubs);

        TableColumn clubName = new TableColumn("Club Name");
        clubName.setMinWidth(150);
        //clubName.setCellValueFactory(new PropertyValueFactory("nameSportClub"));

        TableColumn played = new TableColumn("Played");
        //played.setCellValueFactory(new PropertyValueFactory("numberOfMatchesPlayed"));

        TableColumn wins = new TableColumn("Won");
        //wins.setCellValueFactory(new PropertyValueFactory("numberOfClubWins"));

        TableColumn draws = new TableColumn("Draw");
        //draws.setCellValueFactory(new PropertyValueFactory("numberOfClubDraw"));

        TableColumn loss = new TableColumn("Loss");
        //loss.setCellValueFactory(new PropertyValueFactory("numberOfClubDefeat"));

        TableColumn recived = new TableColumn("Recived");
        //recived.setCellValueFactory(new PropertyValueFactory("numberOfGoalRecived"));

        TableColumn score = new TableColumn("Score");
        //score.setCellValueFactory(new PropertyValueFactory("numberOfGoalScored"));

        TableColumn points = new TableColumn("Points");
        //points.setCellValueFactory(new PropertyValueFactory("numberOfPoints"));

        TableColumn rank = new TableColumn("Rank");
        //points.setCellValueFactory(new PropertyValueFactory(null)); //TODO : Assign Value to the TableColumn

        //Table Properties
        //tableViewListClub
        //tableViewListClub.setItems(listObserver);
        tableViewListClub.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewListClub.getColumns().addAll(clubName,played,wins,draws,loss,recived,score,points,rank);
        tableViewListClub.setLayoutX(100);
        tableViewListClub.setLayoutY(100);

        //Adding Table to Display the List of Match Details
        TableView<SportClub> tableViewListMatch = new TableView<>();
        //final ObservableList<SportClub> listObserver = FXCollections.observableArrayList();

        TableColumn clubOneMatch = new TableColumn("Club One");
        clubOneMatch.setMinWidth(150);
        //clubOneMatch.setCellValueFactory(new PropertyValueFactory("nameSportClub"));

        TableColumn clubOneMatchScore = new TableColumn("Club Score");
        clubOneMatchScore.setMinWidth(100);
        //clubOneMatchScore.setCellValueFactory(new PropertyValueFactory("numberOfMatchesPlayed"));

        TableColumn clubTwoMatch = new TableColumn("Club Two");
        clubTwoMatch.setMinWidth(150);
        //clubTwoMatch.setCellValueFactory(new PropertyValueFactory("numberOfClubWins"));

        TableColumn clubTwoMatchScore = new TableColumn("Club Score");
        clubTwoMatchScore.setMinWidth(100);
        //clubTwoMatchScore.setCellValueFactory(new PropertyValueFactory("numberOfClubDraw"));

        TableColumn matchDateColumn = new TableColumn("MatchDate");
        matchDateColumn.setMinWidth(150);
        //matchDateColumn.setCellValueFactory(new PropertyValueFactory("numberOfClubDefeat"));

        TableColumn winClubName = new TableColumn("Won Team");
        winClubName.setMinWidth(150);
        //winClubName.setCellValueFactory(new PropertyValueFactory("numberOfGoalRecived"));

        //Table Properties
        //tableViewListClub.setItems(listObserver);
        tableViewListMatch.setVisible(false);
        tableViewListMatch.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableViewListMatch.getColumns().addAll(clubOneMatch,clubOneMatchScore,clubTwoMatch,clubTwoMatchScore,matchDateColumn,winClubName);
        tableViewListMatch.setLayoutX(100);
        tableViewListMatch.setLayoutY(100);

        //Adding Match Search TextField
        TextField searchMatchInput = new TextField();
        searchMatchInput.setPromptText("Eg: 2020/12/10");
        // X Y Coordinates

        //Match Search Button
        Button searchMatchButton = new Button("Search Matches");
        // X Y Coordinates

        //Display All Matches Played Button
        Button displayMatch = new Button("Display All Matches");
        displayMatch.setPrefSize(150,30);
//        displayMatch.setLayoutY(600);
//        displayMatch.setLayoutX(500);

        //Display All Clubs Played Button
        Button displayAllClub = new Button("Display All Clubs");
        displayAllClub.setVisible(false);
        displayAllClub.setPrefSize(150,30);
//        displayAllClub.setLayoutY(600);
//        displayAllClub.setLayoutX(500);

        //Sort to Number of Wins Button
        Button sortWins = new Button("Sort to Wins");
//        sortWins.setLayoutY(600);
//        sortWins.setLayoutX(675);

        //Sort to Goal Scored Button
        Button sortGoal = new Button("Sort to Goal Scored");
//        sortGoal.setLayoutY(600);
//        sortGoal.setLayoutX(800);

        //Random Club Generate Button
        Button generateButton = new Button("Generate New Club");
//        generateButton.setLayoutY(600);
//        generateButton.setLayoutX(980);
//        generateButton.setDisable(true);

        //Save to Local Database Button
        Button saveLocal = new Button("Save to Database");
//        saveLocal.setLayoutY(600);
//        saveLocal.setLayoutX(1155);

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

        //Adding Elements to the Pane
//        rootPane.getChildren().add(bgImageView);
//        rootPane.getChildren().add(separatorOne);
//        rootPane.getChildren().add(separatorTwo);
//        rootPane.getChildren().add(separatorThree);
//        rootPane.getChildren().add(logoImageView);
//        rootPane.getChildren().add(welcomeLabel1);
//        rootPane.getChildren().add(welcomeLabel2);

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
