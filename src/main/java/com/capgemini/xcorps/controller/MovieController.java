package com.capgemini.xcorps.controller;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

import com.capgemini.xcorps.service.MovieService;
import com.capgemini.xcorps.service.MovieServiceImpl;

public class MovieController {

	MovieService movieService = new MovieServiceImpl();

	// GET /allCityTheatres
	public Set<String> cityTheatres() throws FileNotFoundException {
		return movieService.cityTheatres().keySet();
	}

	// GET /cityTheatres/city
	public List<TreeMap<String, Set<String>>> particularCityTheatres(String city) throws FileNotFoundException {
		return movieService.particularCityTheatres(city);
	}

	// GET /allMovieTheatres
	public Set<String> movieTheatres() throws FileNotFoundException {
		return movieService.movieTheatres().keySet();
	}

	// GET /movieTheatres/movie
	public List<TreeMap<String, Set<String>>> particularMovieTheatres(String movie) throws FileNotFoundException {
		return movieService.particularMovieTheatres(movie);
	}

	// GET /allTheatreMovies
	public Set<String> theatreMovies() throws FileNotFoundException {
		return movieService.theatreMovies().keySet();
	}

	// GET /theatreMovies/theatre
	public List<TreeMap<String, Set<String>>> particularTheatreMovies(String theatre) throws FileNotFoundException {
		return movieService.particularTheatreMovies(theatre);
	}

	// GET /allCityTheatreMovies
	public SortedMap<String, TreeMap<String, List<String>>> cityTheatreMovies() throws FileNotFoundException {
		return movieService.cityTheatreMovies();
	}

	// GET /cityTheatreMovies/city
	public List<String> particularCityTheatreMovies(String city) throws FileNotFoundException {
		return movieService.particularCityTheatreMovies(city);
	}

	// GET /allMoviesWithRating/rating
	public Set<String> listMoviesWithRating(Double rating) throws FileNotFoundException {
		Set<String> listMoviesWithRating1 = new TreeSet<>();

		Set<String> listMoviesWithRating = movieService.listMoviesWithRating(rating);

		if (rating < 0) {
			System.err.println("Please enter proper values");
		}

		for (String movieRating : listMoviesWithRating) {
			if (!listMoviesWithRating1.contains(movieRating)) {
				listMoviesWithRating1.add(movieRating);

			}
		}
		return listMoviesWithRating1;

	}

	// GET allTheatreMovieShows
	public SortedMap<String, TreeMap<String, List<String>>> theatreMovieShowTimes() throws FileNotFoundException {

		return movieService.theatreMovieShowTimes();
		
	}

	// GET /theatreMovieShows/theatre
	public List<String> particluarTheatreMovieShowTimes(String theatre) throws FileNotFoundException {
		return movieService.particluarTheatreMovieShowTimes(theatre);
	}

}
