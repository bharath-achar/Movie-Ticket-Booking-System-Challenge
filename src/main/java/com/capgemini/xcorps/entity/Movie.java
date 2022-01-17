package com.capgemini.xcorps.entity;
import java.util.ArrayList;

public class Movie {

	private String movieName;

	private ArrayList<Theatre> theatres;

	private ArrayList<String> showTimes;

	private double rating;

	public Movie() {

	}

	public Movie(String movieName) {
		this.movieName = movieName;
		theatres = new ArrayList<Theatre>();
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public ArrayList<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(ArrayList<Theatre> theatres) {
		this.theatres = theatres;
	}

	public ArrayList<String> getShowTimes() {
		return showTimes;
	}

	public void setShowTimes(ArrayList<String> showTimes) {
		this.showTimes = showTimes;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", theatres=" + theatres + ", showTimes=" + showTimes + ", rating="
				+ rating + "]";
	}

}
