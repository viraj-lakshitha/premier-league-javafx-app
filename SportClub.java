package com.courseWork.FinalFormativeSub;

import java.io.Serializable;
import java.util.Objects;

public class SportClub implements Serializable {

	//To Ensure that same class used for the Serialization and Deserialization
	private static final long serialVersionUID = 1L;

	private String nameSportClub; //Name of the Sport CLub
	private String locationSportClub; //Location of the Sport Club
	
	//Constructor (Default)
	public SportClub() { }

	//Constructor (Parameterized Constructor)
	public SportClub(String nameSportClub, String locationSportClub) {
		this.nameSportClub = nameSportClub;
		this.locationSportClub = locationSportClub;
	}

	//Getters & Setters
	public String getNameSportClub() {
		return nameSportClub;
	}

	public void setNameSportClub(String nameSportClub) {
		this.nameSportClub = nameSportClub;
	}

	public String getLocationSportClub() {
		return locationSportClub;
	}

	public void setLocationSportClub(String locationSportClub) {
		this.locationSportClub = locationSportClub;
	}

	//Equal Method
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SportClub)) return false;
		SportClub sportClub = (SportClub) o;
		return nameSportClub.equals(sportClub.nameSportClub) &&
				locationSportClub.equals(sportClub.locationSportClub);
	}

	//HashCode Method
	@Override
	public int hashCode() {
		return Objects.hash(nameSportClub, locationSportClub);
	}

}
