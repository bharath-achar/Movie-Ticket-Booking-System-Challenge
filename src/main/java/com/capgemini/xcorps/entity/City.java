package com.capgemini.xcorps.entity;
import java.util.ArrayList;

public class City {

	private String cityName;

	private ArrayList<Theatre> theatres;

	public City() {
	}

	public City(String cityName) {
		this.cityName = cityName;
		theatres = new ArrayList();
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public ArrayList<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(ArrayList<Theatre> theatres) {
		this.theatres = theatres;
	}



}
