package com.courseWork.FinalFormativeSub;

import java.io.Serializable;
import java.util.Objects;

public class SchoolFootballClub extends FootballClub implements Serializable {

	//To Ensure that same class used for the Serialization and Deserialization
	private static final long serialVersionUID = 1L;

	private String schoolName; //Name of the School
	private String masterInCharge; //Every School Football Categories into A,B,C Divisions
	
	//Constructor (using fields)
	public SchoolFootballClub() { }

	//Constructor (Parameterized Constructor)


	public SchoolFootballClub(String nameSportClub, String locationSportClub,
							  int numberOfClubWins, int numberOfClubDraw, int numberOfClubDefeat,
							  int numberOfGoalRecived, int numberOfGoalScored, int numberOfPoints,
							  int numberOfMatchesPlayed, int scoreDifferOfMatchesPlayed, String schoolName, String masterInCharge) {
		super(nameSportClub, locationSportClub, numberOfClubWins, numberOfClubDraw, numberOfClubDefeat,
				numberOfGoalRecived, numberOfGoalScored, numberOfPoints, numberOfMatchesPlayed, scoreDifferOfMatchesPlayed);
		this.schoolName = schoolName;
		this.masterInCharge = masterInCharge;
	}

	//Getters & Setter
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getMasterInCharge() {
		return masterInCharge;
	}

	public void setMasterInCharge(String masterInCharge) {
		this.masterInCharge = masterInCharge;
	}

	//Equal Method
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SchoolFootballClub)) return false;
		SchoolFootballClub that = (SchoolFootballClub) o;
		return Objects.equals(schoolName, that.schoolName) &&
				Objects.equals(masterInCharge, that.masterInCharge);
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(schoolName, masterInCharge);
	}

}
