package com.courseWork.FinalFormativeSub;

import java.io.Serializable;
import java.util.Objects;

public class FootballClub extends SportClub implements Serializable, Comparable<FootballClub> {

	//To Ensure that same class used for the Serialization and Deserialization
	private static final long serialVersionUID = 1L;

	private int numberOfClubWins; //Number of Wins
	private int numberOfClubDraw; //Number of Draws
	private int numberOfClubDefeat; //Number of Defeats
	private int numberOfGoalRecived; //Number of Goal Received
	private int numberOfGoalScored; //Number of Goal Scored
	private int numberOfPoints; //Number of Points
	private int numberOfMatchesPlayed; //Number of Matches Played
	private int scoreDifferOfMatchesPlayed; //Date of the Match

	//Constructor (Default)
	public FootballClub() { }

	//Constructor (Parameterized Constructor)
	public FootballClub(String nameSportClub, String locationSportClub,
						int numberOfClubWins, int numberOfClubDraw, int numberOfClubDefeat,
						int numberOfGoalRecived, int numberOfGoalScored, int numberOfPoints,
						int numberOfMatchesPlayed,int matchDate) {
		super(nameSportClub, locationSportClub);
		this.numberOfClubWins = numberOfClubWins;
		this.numberOfClubDraw = numberOfClubDraw;
		this.numberOfClubDefeat = numberOfClubDefeat;
		this.numberOfGoalRecived = numberOfGoalRecived;
		this.numberOfGoalScored = numberOfGoalScored;
		this.numberOfPoints = numberOfPoints;
		this.numberOfMatchesPlayed = numberOfMatchesPlayed;
		this.scoreDifferOfMatchesPlayed = matchDate;
	}

	//Getters & Setter


	public int getNumberOfClubWins() {
		return numberOfClubWins;
	}

	public void setNumberOfClubWins(int numberOfClubWins) {
		this.numberOfClubWins = numberOfClubWins;
	}

	public int getNumberOfClubDraw() {
		return numberOfClubDraw;
	}

	public void setNumberOfClubDraw(int numberOfClubDraw) {
		this.numberOfClubDraw = numberOfClubDraw;
	}

	public int getNumberOfClubDefeat() {
		return numberOfClubDefeat;
	}

	public void setNumberOfClubDefeat(int numberOfClubDefeat) {
		this.numberOfClubDefeat = numberOfClubDefeat;
	}

	public int getNumberOfGoalRecived() {
		return numberOfGoalRecived;
	}

	public void setNumberOfGoalRecived(int numberOfGoalRecived) {
		this.numberOfGoalRecived = numberOfGoalRecived;
	}

	public int getNumberOfGoalScored() {
		return numberOfGoalScored;
	}

	public void setNumberOfGoalScored(int numberOfGoalScored) {
		this.numberOfGoalScored = numberOfGoalScored;
	}

	public int getNumberOfPoints() {
		return numberOfPoints;
	}

	public void setNumberOfPoints(int numberOfPoints) {
		this.numberOfPoints = numberOfPoints;
	}

	public int getNumberOfMatchesPlayed() {
		return numberOfMatchesPlayed;
	}

	public void setNumberOfMatchesPlayed(int numberOfMatchesPlayed) {
		this.numberOfMatchesPlayed = numberOfMatchesPlayed;
	}

	public int getScoreDifferOfMatchesPlayed() {
		return scoreDifferOfMatchesPlayed;
	}

	public void setScoreDifferOfMatchesPlayed(int scoreDifferOfMatchesPlayed) {
		this.scoreDifferOfMatchesPlayed = scoreDifferOfMatchesPlayed;
	}

	//Equal Method
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof FootballClub)) return false;
		FootballClub that = (FootballClub) o;
		return numberOfClubWins == that.numberOfClubWins &&
				numberOfClubDraw == that.numberOfClubDraw &&
				numberOfClubDefeat == that.numberOfClubDefeat &&
				numberOfGoalRecived == that.numberOfGoalRecived &&
				numberOfGoalScored == that.numberOfGoalScored &&
				numberOfPoints == that.numberOfPoints &&
				numberOfMatchesPlayed == that.numberOfMatchesPlayed;
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(numberOfClubWins, numberOfClubDraw, numberOfClubDefeat, numberOfGoalRecived, numberOfGoalScored, numberOfPoints, numberOfMatchesPlayed);
	}

	@Override
	public int compareTo(FootballClub footballClub) {
		if (this.getNumberOfPoints() == footballClub.getNumberOfPoints()){
			if (this.getScoreDifferOfMatchesPlayed() > footballClub.getScoreDifferOfMatchesPlayed()) {
				return -1;
			}else {
			    return 1;
			}
		}else if (this.getNumberOfPoints() > footballClub.getNumberOfPoints()) {
			return -1;
		}else {
		    return 1;
		}
	}
}
