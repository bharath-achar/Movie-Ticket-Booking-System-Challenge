package com.capgemini.xcorps.entity;
import java.util.ArrayList;

public class Theatre {

	private String theatreName;

	private ArrayList<Movie> movies;

	public Theatre() {

	}

	public Theatre(String theatreName) {
		this.theatreName = theatreName;
		movies = new ArrayList<Movie>();
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public ArrayList<Movie> getMovies() {
		return movies;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.movies = movies;
	}


}
