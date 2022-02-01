package com.capgemini.xcorps.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

public class MovieControllerTest {

	MovieController movieController = new MovieController();

//	 Test case for fetching all theaters in a city
	@Test
	public void cityTheatresTest() throws FileNotFoundException {
		Set<String> cityTheatres = movieController.cityTheatres();
		assertEquals(13, cityTheatres.size());
	}

//	 Test case for fetching all theaters in a city - Not null
	@Test
	public void cityTheatresNotNullTest() throws FileNotFoundException {
		Set<String> cityTheatres = movieController.cityTheatres();
		assertNotNull(cityTheatres);
	}

//	 Test case for fetching all theaters in a city - Value check
	@Test
	public void cityTheatresValueCheckTest() throws FileNotFoundException {
		Set<String> cityTheatres = movieController.cityTheatres();
		assertTrue(cityTheatres.contains("Bangalore"));
	}

	// Test case for null argument
	@Test(expected = NullPointerException.class)
	public void particularCityTheatresNotNullTest() throws FileNotFoundException {
		movieController.particularCityTheatres(null);
	}

	// Test case for fetching theaters with input city
	@Test
	public void particularCityTheatresTest() throws FileNotFoundException {
		String inputCity = "Ch";

		List<TreeMap<String, Set<String>>> cityTheatres = movieController.particularCityTheatres(inputCity);
		for (TreeMap<String, Set<String>> city : cityTheatres) {
			assertEquals(city.containsKey("Chikmagalur"), true);
		}
	}

	// Test case for fetching theaters with input city
	@Test
	public void particularCityTheatresTest1() throws FileNotFoundException {
		String inputCity = "Ch";

		List<TreeMap<String, Set<String>>> cityTheatres = movieController.particularCityTheatres(inputCity);
		for (TreeMap<String, Set<String>> city : cityTheatres) {
			assertEquals(city.containsKey("Bangalore"), false);
		}
	}

//	 Test case for fetching all movies in a particular theater
	@Test
	public void theaterMoviesTest() throws FileNotFoundException {
		Set<String> theatreMovies = movieController.theatreMovies();
		assertEquals(15, theatreMovies.size());
	}

//	 Test case for fetching all movies in a particular theater - Not null
	@Test
	public void theatreMoviesNotNullTest() throws FileNotFoundException {
		Set<String> theatreMovies = movieController.theatreMovies();
		assertNotNull(theatreMovies);
	}

//	 Test case for fetching all theaters for a particular movie - Value check
	@Test
	public void theatreMoviesValueCheckTest() throws FileNotFoundException {
		Set<String> theatreMovies = movieController.theatreMovies();
		assertTrue(theatreMovies.contains("Arjun-theatre"));
	}

	// Test case for fetching theaters for input Movie
	@Test
	public void particularTheatreMoviesTest() throws FileNotFoundException {
		String inputTheatre = "Arjun";

		List<TreeMap<String, Set<String>>> theatreMovies = movieController.particularTheatreMovies(inputTheatre);
		for (TreeMap<String, Set<String>> theatre : theatreMovies) {
			assertEquals(theatre.containsKey("Arjun theatre"), true);
		}
	}

	// Test case for fetching theaters for input Movie
	@Test
	public void particularTheatreMoviesTest1() throws FileNotFoundException {
		String inputTheatre = "Arjun";

		List<TreeMap<String, Set<String>>> theatreMovies = movieController.particularTheatreMovies(inputTheatre);
		for (TreeMap<String, Set<String>> theatre : theatreMovies) {
			assertEquals(theatre.containsKey("Ashwini-theatre"), false);
		}
	}

//	 Test case for fetching all theaters has particular movie
	@Test
	public void movieTheatresTest() throws FileNotFoundException {
		Set<String> movieTheatres = movieController.movieTheatres();
		assertEquals(17, movieTheatres.size());
	}

//	 Test case for fetching all theaters for a particular movie - Not null
	@Test
	public void movieTheatresNotNullTest() throws FileNotFoundException {
		Set<String> movieTheatres = movieController.movieTheatres();
		assertNotNull(movieTheatres);
	}

//	 Test case for fetching all theaters for a particular movie - Value check
	@Test
	public void movieTheatresValueCheckTest() throws FileNotFoundException {
		Set<String> movieTheatres = movieController.movieTheatres();
		assertTrue(movieTheatres.contains("KGF"));
	}

	// Test case for fetching theaters for input Movie
	@Test
	public void particularMovieTheatresTest() throws FileNotFoundException {
		String inputMovie = "K";

		List<TreeMap<String, Set<String>>> movieTheatres = movieController.particularMovieTheatres(inputMovie);

		for (TreeMap<String, Set<String>> movie : movieTheatres) {

			assertEquals(movie.containsKey("KGF"), true);
		}
	}

	// Test case for fetching theaters for input Movie
	@Test
	public void particularMovieTheatresTest1() throws FileNotFoundException {
		String inputMovie = "K";

		List<TreeMap<String, Set<String>>> movieTheatres = movieController.particularMovieTheatres(inputMovie);
		for (TreeMap<String, Set<String>> movie : movieTheatres) {
			assertEquals(movie.containsKey("Bahubali"), false);
		}
	}

//	 Test case for fetching all theaters has particular movie in a city
	@Test
	public void cityTheatreMoviesTest() throws FileNotFoundException {
		TreeMap<String, TreeMap<String, List<String>>> cityTheatreMovies = movieController.cityTheatreMovies();
		assertEquals(13, cityTheatreMovies.size());
	}

//	 Test case for fetching all theaters for a particular movie in a city - Not null
	@Test
	public void cityTheatreMoviesNotNullTest() throws FileNotFoundException {
		TreeMap<String, TreeMap<String, List<String>>> cityTheatreMovies = movieController.cityTheatreMovies();
		assertNotNull(cityTheatreMovies);
	}

//	 Test case for fetching all theaters for a particular movie in a city - Value check
	@Test
	public void cityTheatreMoviesValueCheckTest() throws FileNotFoundException {
		TreeMap<String, TreeMap<String, List<String>>> cityTheatreMovies = movieController.cityTheatreMovies();
		assertTrue(cityTheatreMovies.containsKey("Bangalore"));
	}

	// Test case for fetching theaters for input Movie
	@Test
	public void particularCityTheatreMoviesTest1() throws FileNotFoundException {
		String inputMovie = "M";

		List<String> cityTheatreMovies = movieController.particularCityTheatreMovies(inputMovie);
		assertEquals(cityTheatreMovies.contains("ABCD"), false);

	}

//	 Test case for fetching all movies above certain rating
	@Test
	public void movieRatingTest() throws FileNotFoundException {
		Set<String> moviesWithRating = movieController.listMoviesWithRating(8.0);
		assertEquals(13, moviesWithRating.size());
	}

//	 Test case for fetching all movies above certain rating - Not null
	@Test
	public void moviesRatingNotNullTest() throws FileNotFoundException {
		Set<String> movieWithRating = movieController.listMoviesWithRating(9.0);
		assertNotNull(movieWithRating);
	}

//	 Test case for fetching all movies above certain rating 
	@Test
	public void moviesRatingValueCheckTest() throws FileNotFoundException {
		Set<String> cityTheatreMovies = movieController.listMoviesWithRating(8.2);
		assertTrue(cityTheatreMovies.contains("KGF"));
	}

	// Test case for null argument
	@Test(expected = NullPointerException.class)
	public void movieRatingNotNullTest() throws FileNotFoundException {
		movieController.listMoviesWithRating(null);
	}

//	 Test case for fetching all movies above certain rating
	@Test
	public void movieShowTimesTest() throws FileNotFoundException {
		TreeMap<String, TreeMap<String, List<String>>> movieShowTimes = movieController.theatreMovieShowTimes();
		assertEquals(15, movieShowTimes.size());
	}

}
