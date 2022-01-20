package com.capgemini.xcorps.entity;

public class Movie {

	private String movieId;

	private String movieTitle;

	private String genre;

	private String director;

	private String rating;

	public Movie(String movieTitle) {
		super();
		this.movieTitle = movieTitle;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", genre=" + genre + ", director="
				+ director + ", rating=" + rating + "]";
	}

}
