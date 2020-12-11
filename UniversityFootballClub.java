package com.courseWork.FinalFormativeSub;

import java.io.Serializable;
import java.util.Objects;

public class UniversityFootballClub extends FootballClub implements Serializable {

	//To Ensure that same class used for the Serialization and Deserialization
	private static final long serialVersionUID = 1L;

	private String nameOfUniversity; // Name of the University
	private int universityRegNumber; // University Registration Number

	//Constructor (Default)
	public UniversityFootballClub() { }

	//Constructor (Parameterized Constructor)


	public UniversityFootballClub(String nameSportClub, String locationSportClub, int numberOfClubWins,
								  int numberOfClubDraw, int numberOfClubDefeat, int numberOfGoalRecived,
								  int numberOfGoalScored, int numberOfPoints, int numberOfMatchesPlayed,
								  int scoreDifferOfMatchesPlayed, String nameOfUniversity, int universityRegNumber) {
		super(nameSportClub, locationSportClub, numberOfClubWins, numberOfClubDraw, numberOfClubDefeat,
				numberOfGoalRecived, numberOfGoalScored, numberOfPoints, numberOfMatchesPlayed, scoreDifferOfMatchesPlayed);
		this.nameOfUniversity = nameOfUniversity;
		this.universityRegNumber = universityRegNumber;
	}

	//Getters & Setters
	public String getNameOfUniversity() {
		return nameOfUniversity;
	}

	public void setNameOfUniversity(String nameOfUniversity) {
		this.nameOfUniversity = nameOfUniversity;
	}

	public int getUniversityRegNumber() {
		return universityRegNumber;
	}

	public void setUniversityRegNumber(int universityRegNumber) {
		this.universityRegNumber = universityRegNumber;
	}

	//Equal Method
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof UniversityFootballClub)) return false;
		UniversityFootballClub that = (UniversityFootballClub) o;
		return universityRegNumber == that.universityRegNumber &&
				Objects.equals(nameOfUniversity, that.nameOfUniversity);
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(nameOfUniversity, universityRegNumber);
	}

}
