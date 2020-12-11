package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import com.courseWork.submissionFour.SportClub;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class TournamentManagerGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        /*
        * TODO : Implementation on Button
        * Add Club , Delete , Two Tables , Display Clubs , Reset Button on Add Club ,
        * Calendar Button on Match Date , Matches and Exit Button and All Sorting
         * */

        //Main Pane
        Pane rootPane = new Pane();

        //UI Design
        Separator separatorOne = new Separator();
        separatorOne.setOrientation(Orientation.VERTICAL);
        separatorOne.setPrefHeight(680);
        separatorOne.setLayoutY(10);
        separatorOne.setLayoutX(450);

        Separator separatorTwo = new Separator();
        separatorTwo.setOrientation(Orientation.VERTICAL);
        separatorTwo.setPrefHeight(680);
        separatorTwo.setLayoutY(10);
        separatorTwo.setLayoutX(1350);

        Separator separatorThree = new Separator();
        separatorThree.setOrientation(Orientation.HORIZONTAL);
        separatorThree.setPrefWidth(350);
        separatorThree.setLayoutY(130);
        separatorThree.setLayoutX(1400);

        //Add Background Image
        Image bgImage = new Image("file:app-bg.png");
        ImageView bgImageView = new ImageView(bgImage);
        bgImageView.setLayoutX(0);
        bgImageView.setLayoutY(0);
        //bgImageView.setPreserveRatio(true);
        //bgImageView.setFitWidth(300);

        //Welcome Note
        Label welcomeLabel1 = new Label("Welcome");
        welcomeLabel1.setFont(Font.font("Tahoma", FontWeight.BOLD, FontPosture.REGULAR, 30));
        welcomeLabel1.setLayoutY(80);
        welcomeLabel1.setLayoutX(150);

        Label welcomeLabel2 = new Label("Premier League Dashboard");
        welcomeLabel2.setFont(Font.font("Tahoma", FontPosture.ITALIC, 20));
        welcomeLabel2.setLayoutY(140);
        welcomeLabel2.setLayoutX(100);

        //Add Premier League Logo
        Image logoImage = new Image("file:logo.png");
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setLayoutX(70);
        logoImageView.setLayoutY(520);
        logoImageView.setPreserveRatio(true);
        logoImageView.setFitWidth(300);

        //Add Member-Form
        Label clubNameLabel = new Label("Club Name");
        clubNameLabel.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        clubNameLabel.setLayoutX(40);
        clubNameLabel.setLayoutY(200);

        TextField clubNameTextField = new TextField();
        clubNameTextField.setLayoutX(200);
        clubNameTextField.setLayoutY(200);

        Label clubLocationLabel = new Label("Club Location");
        clubLocationLabel.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        clubLocationLabel.setLayoutX(40);
        clubLocationLabel.setLayoutY(250);

        TextField clubLocationTextField = new TextField();
        clubLocationTextField.setLayoutX(200);
        clubLocationTextField.setLayoutY(250);

        Label clubTypeLabel = new Label("Select Club Type");
        clubTypeLabel.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        clubTypeLabel.setLayoutX(40);
        clubTypeLabel.setLayoutY(300);

        ComboBox clubTypeComboBox = new ComboBox();
        clubTypeComboBox.setPrefWidth(185);
        clubTypeComboBox.getItems().addAll("School Club","University Club");
        clubTypeComboBox.setLayoutX(200);
        clubTypeComboBox.setLayoutY(300);

        //Variable Parameters
        Label clubParamOne = new Label();
        clubParamOne.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextField clubParamOneTextField = new TextField();

        Label clubParamTwo = new Label();
        clubParamTwo.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextField clubParamTwoTextField = new TextField();

        //Add Club Button Properties
        Button addMemberButton = new Button("Add Club");
        addMemberButton.setPrefSize(180,30);

        //Add Member Button Functionalities
        addMemberButton.setOnAction( e -> {
            if (clubTypeComboBox.getValue() == "School Club") {
                //Add Member to the Array List

            }else if (clubTypeComboBox.getValue() == "University Club") {

            }
        });

        clubParamOne.setVisible(false);
        clubParamOneTextField.setVisible(false);
        clubParamTwo.setVisible(false);
        clubParamTwoTextField.setVisible(false);
        addMemberButton.setLayoutX(140);
        addMemberButton.setLayoutY(370);

        clubTypeComboBox.setOnAction(e -> {
            if (clubTypeComboBox.getValue() == "School Club") {
                clubParamOne.setText("Name of School");
                clubParamTwo.setText("Master In-Charge");
                clubParamOne.setLayoutX(40);
                clubParamOne.setLayoutY(350);
                clubParamTwo.setLayoutX(40);
                clubParamTwo.setLayoutY(400);
                clubParamOne.setVisible(true);
                clubParamOneTextField.setVisible(true);
                clubParamTwo.setVisible(true);
                clubParamTwoTextField.setVisible(true);
                clubParamOneTextField.setLayoutX(200);
                clubParamOneTextField.setLayoutY(350);
                clubParamTwoTextField.setLayoutX(200);
                clubParamTwoTextField.setLayoutY(400);
                addMemberButton.setLayoutX(140);
                addMemberButton.setLayoutY(470);

            }else if (clubTypeComboBox.getValue() == "University Club") {
                clubParamOne.setText("Name of University");
                clubParamTwo.setText("University Reg. No.");
                clubParamOne.setLayoutX(40);
                clubParamOne.setLayoutY(350);
                clubParamTwo.setLayoutX(40);
                clubParamTwo.setLayoutY(400);
                clubParamOne.setVisible(true);
                clubParamOneTextField.setVisible(true);
                clubParamTwo.setVisible(true);
                clubParamTwoTextField.setVisible(true);
                clubParamOneTextField.setLayoutX(200);
                clubParamOneTextField.setLayoutY(350);
                clubParamTwoTextField.setLayoutX(200);
                clubParamTwoTextField.setLayoutY(400);
                addMemberButton.setLayoutX(140);
                addMemberButton.setLayoutY(470);
            }
        });
        //TODO : Find a Solution to the Code Duplication
        //TODO : Add Vertical LineSeparator and Background Image

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
        tableViewListClub.setLayoutX(500);
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
        tableViewListMatch.setLayoutX(500);
        tableViewListMatch.setLayoutY(100);

        //Adding Club Search TextField
        TextField searchClubInput = new TextField();
        searchClubInput.setPromptText("Eg: Barcelona");
        searchClubInput.setVisible(false);

        //Club Search Button
        Button searchClubButton = new Button("Search Club");
        searchClubButton.setVisible(false);

        //Adding Match Search TextField
        TextField searchMatchInput = new TextField();
        searchMatchInput.setPromptText("Eg: 2020/12/10");
        searchMatchInput.setVisible(false);

        //Match Search Button
        Button searchMatchButton = new Button("Search Matches");
        searchMatchButton.setVisible(false);

        //Adding Delete Search TextField
        TextField deleteInput = new TextField();
        deleteInput.setPromptText("Eg: Barcelona");
        deleteInput.setVisible(false);

        //Delete Search Button
        Button deleteButton = new Button("Delete Club");
        deleteButton.setVisible(false);

        //Select the Options
        ComboBox selectOption = new ComboBox();
        selectOption.setPrefWidth(200);
        selectOption.getSelectionModel().select("About and Help");
        selectOption.getItems().addAll("About and Help","Delete Club","Display Club","Search Matches");
        selectOption.setLayoutX(1475);
        selectOption.setLayoutY(50);

        //ComboBox--> SelectOption Properties
        selectOption.setOnAction(e -> {
            if (selectOption.getValue() == "About and Help" ) {
                //Make Invisible Other Labels and TextFields
                searchClubInput.setVisible(false);
                searchClubButton.setVisible(false);
                searchMatchButton.setVisible(false);
                searchMatchInput.setVisible(false);
                deleteInput.setVisible(false);
                deleteButton.setVisible(false);
            }else if (selectOption.getValue() == "Delete Club") {
                //Delete Club TextField Properties
                deleteInput.setVisible(true);
                deleteInput.setLayoutX(1425);
                deleteInput.setLayoutY(150);
                //Delete Club Button Properties
                deleteButton.setVisible(true);
                deleteButton.setLayoutX(1625);
                deleteButton.setLayoutY(150);
                //Make Invisible Other Labels and TextFields
                searchClubInput.setVisible(false);
                searchClubButton.setVisible(false);
                searchMatchButton.setVisible(false);
                searchMatchInput.setVisible(false);
            }else if (selectOption.getValue() == "Display Club" ) {
                //Display Club TextField Properties
                searchClubInput.setVisible(true);
                searchClubInput.setLayoutX(1425);
                searchClubInput.setLayoutY(150);
                //Display CLub Button Properties
                searchClubButton.setVisible(true);
                searchClubButton.setLayoutX(1625);
                searchClubButton.setLayoutY(150);
                //Make Invisible Other Labels and TextFields
                searchMatchButton.setVisible(false);
                searchMatchInput.setVisible(false);
                deleteInput.setVisible(false);
                deleteButton.setVisible(false);
            }else if (selectOption.getValue() == "Search Matches") {
                //Search Match TextField Properties
                searchMatchInput.setVisible(true);
                searchMatchInput.setLayoutX(1425);
                searchMatchInput.setLayoutY(150);
                //Search Match Button Properties
                searchMatchButton.setVisible(true);
                searchMatchButton.setLayoutX(1625);
                searchMatchButton.setLayoutY(150);
                //Make Invisible Other Labels and TextFields
                deleteInput.setVisible(false);
                deleteButton.setVisible(false);
                searchClubInput.setVisible(false);
                searchClubButton.setVisible(false);
            }
        });

        //Display All Matches Played Button
        Button displayMatch = new Button("Display All Matches");
        displayMatch.setPrefSize(150,30);
        displayMatch.setLayoutY(600);
        displayMatch.setLayoutX(500);

        //Display All Clubs Played Button
        Button displayAllClub = new Button("Display All Clubs");
        displayAllClub.setVisible(false);
        displayAllClub.setPrefSize(150,30);
        displayAllClub.setLayoutY(600);
        displayAllClub.setLayoutX(500);

        //Sort to Number of Wins Button
        Button sortWins = new Button("Sort to Wins");
        sortWins.setLayoutY(600);
        sortWins.setLayoutX(675);

        //Sort to Goal Scored Button
        Button sortGoal = new Button("Sort to Goal Scored");
        sortGoal.setLayoutY(600);
        sortGoal.setLayoutX(800);

        //Random Club Generate Button
        Button generateButton = new Button("Generate New Club");
        generateButton.setLayoutY(600);
        generateButton.setLayoutX(980);
        generateButton.setDisable(true);

        //Save to Local Database Button
        Button saveLocal = new Button("Save to Database");
        saveLocal.setLayoutY(600);
        saveLocal.setLayoutX(1155);

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
        rootPane.getChildren().add(bgImageView);
        rootPane.getChildren().add(separatorOne);
        rootPane.getChildren().add(separatorTwo);
        rootPane.getChildren().add(separatorThree);
        rootPane.getChildren().add(logoImageView);
        rootPane.getChildren().add(welcomeLabel1);
        rootPane.getChildren().add(welcomeLabel2);
        rootPane.getChildren().add(clubNameLabel);
        rootPane.getChildren().add(clubLocationLabel);
        rootPane.getChildren().add(clubNameTextField);
        rootPane.getChildren().add(clubLocationTextField);
        rootPane.getChildren().add(clubTypeComboBox);
        rootPane.getChildren().add(selectOption);
        rootPane.getChildren().add(clubTypeLabel);
        rootPane.getChildren().add(clubParamOne);
        rootPane.getChildren().add(clubParamOneTextField);
        rootPane.getChildren().add(clubParamTwo);
        rootPane.getChildren().add(clubParamTwoTextField);
        rootPane.getChildren().add(addMemberButton);
        rootPane.getChildren().add(tableViewListClub);
        rootPane.getChildren().add(tableViewListMatch);
        rootPane.getChildren().add(searchClubButton);
        rootPane.getChildren().add(searchClubInput);
        rootPane.getChildren().add(searchMatchButton);
        rootPane.getChildren().add(searchMatchInput);
        rootPane.getChildren().add(deleteButton);
        rootPane.getChildren().add(deleteInput);
        rootPane.getChildren().add(generateButton);
        rootPane.getChildren().add(displayMatch);
        rootPane.getChildren().add(displayAllClub);
        rootPane.getChildren().add(sortWins);
        rootPane.getChildren().add(sortGoal);
        rootPane.getChildren().add(saveLocal);


        primaryStage.setResizable(false); //Disable Resizing Window
        primaryStage.setTitle("Dashboard - Premier League");
        primaryStage.setAlwaysOnTop(true); //Set Conditions --> setAlwaysOnTop = true
        primaryStage.setScene(new Scene(rootPane, 1800, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
