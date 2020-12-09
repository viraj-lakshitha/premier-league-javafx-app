package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import com.courseWork.submissionFour.PremierLeagueManager;
import com.courseWork.submissionFour.SportClub;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.*;
import java.io.InputStream;

public class TournamentManagerGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Main Pane
        Pane rootPane = new Pane();
        //Image bgImg = new Image("../PremierLeagueManagerBG.png"); TODO

        //UI Design
        Rectangle blueRect = new Rectangle(450,700);
        blueRect.setFill(Color.rgb(137,165,247));
        blueRect.setLayoutX(0);
        blueRect.setLayoutY(0);

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

        //Adding Search TextField
        TextField searchInput = new TextField();
        searchInput.setPromptText("Search Club");
        searchInput.setLayoutX(500);
        searchInput.setLayoutY(50);

        //Search Button
        Button searchButton = new Button("Search Club");
        searchButton.setLayoutY(50);
        searchButton.setLayoutX(700);

        //Adding Search TextField
        TextField deleteInput = new TextField();
        deleteInput.setPromptText("Delete Club");
        deleteInput.setLayoutX(820);
        deleteInput.setLayoutY(50);

        //Search Button
        Button deleteButton = new Button("Delete Club");
        deleteButton.setLayoutY(50);
        deleteButton.setLayoutX(1020);

        //Random Club Generate Button
        Button generateButton = new Button("Generate New Club");
        generateButton.setLayoutY(50);
        generateButton.setLayoutX(1145);

        //Adding Elements to the Pane
        rootPane.getChildren().add(blueRect);
        rootPane.getChildren().add(welcomeLabel1);
        rootPane.getChildren().add(welcomeLabel2);
        rootPane.getChildren().add(clubNameLabel);
        rootPane.getChildren().add(clubLocationLabel);
        rootPane.getChildren().add(clubNameTextField);
        rootPane.getChildren().add(clubLocationTextField);
        rootPane.getChildren().add(clubTypeComboBox);
        rootPane.getChildren().add(clubTypeLabel);
        rootPane.getChildren().add(clubParamOne);
        rootPane.getChildren().add(clubParamOneTextField);
        rootPane.getChildren().add(clubParamTwo);
        rootPane.getChildren().add(clubParamTwoTextField);
        rootPane.getChildren().add(addMemberButton);
        rootPane.getChildren().add(logoImageView);
        rootPane.getChildren().add(tableViewListClub);
        rootPane.getChildren().add(searchInput);
        rootPane.getChildren().add(searchButton);
        rootPane.getChildren().add(deleteButton);
        rootPane.getChildren().add(deleteInput);
        rootPane.getChildren().add(generateButton);

        //rootPane.getChildren().add(new ImageView(bgImg));

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
