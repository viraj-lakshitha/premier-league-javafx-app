package com.courseWork.FinalFormativeSub;/*File Author : Viraj Lakshitha Bandara*/

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;

public class TournamentManagerGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Main Pane
        Pane rootPane = new Pane();
        //Image bgImg = new Image("../PremierLeagueManagerBG.png"); TODO

        //UI Design
        Rectangle blueRect = new Rectangle(450,700);
        blueRect.setFill(Color.rgb(137,165,247));
//        blueRect.setFill(Color.CYAN);
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

        //Add Member Form
        Label clubNameLabel = new Label("Club Name");
        clubNameLabel.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        clubNameLabel.setLayoutX(80);
        clubNameLabel.setLayoutY(200);

        TextField clubNameTextField = new TextField();
        clubNameTextField.setLayoutX(200);
        clubNameTextField.setLayoutY(200);

        Label clubLocationLabel = new Label("Club Location");
        clubLocationLabel.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        clubLocationLabel.setLayoutX(80);
        clubLocationLabel.setLayoutY(250);

        TextField clubLocationTextField = new TextField();
        clubLocationTextField.setLayoutX(200);
        clubLocationTextField.setLayoutY(250);

        Label clubTypeLabel = new Label("Select Club Type");
        clubTypeLabel.setFont(Font.font("Tahoma",FontWeight.BOLD, FontPosture.ITALIC, 15));
        clubTypeLabel.setLayoutX(80);
        clubTypeLabel.setLayoutY(300);

        ComboBox clubTypeComboBox = new ComboBox();
        clubTypeComboBox.getItems().addAll("School Club","University Club");
        clubTypeComboBox.setLayoutX(200);
        clubTypeComboBox.setLayoutY(300);


        //Adding Elements to the Pane
        rootPane.getChildren().add(blueRect);
        rootPane.getChildren().add(welcomeLabel1);
        rootPane.getChildren().add(welcomeLabel2);
        rootPane.getChildren().add(clubNameLabel);
        rootPane.getChildren().add(clubLocationLabel);
        rootPane.getChildren().add(clubNameTextField);
        rootPane.getChildren().add(clubLocationTextField);
        rootPane.getChildren().add(clubTypeComboBox);

        //rootPane.getChildren().add(new ImageView(bgImg));

        primaryStage.setResizable(false); //Disable Resizing Window
        primaryStage.setTitle("Dashboard - Premier League");
        primaryStage.setAlwaysOnTop(true); //Set Conditions --> setAlwaysOnTop = true
        primaryStage.setScene(new Scene(rootPane, 1500, 700));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
