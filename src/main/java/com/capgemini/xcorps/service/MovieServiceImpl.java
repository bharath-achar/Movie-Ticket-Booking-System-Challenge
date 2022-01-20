package com.capgemini.xcorps.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import com.capgemini.xcorps.entity.Movie;
import com.capgemini.xcorps.entity.Theatre;
import com.capgemini.xcorps.util.MovieConstants;

public class MovieServiceImpl implements MovieService {

	Scanner scanner;

	List<TreeMap<String, Set<String>>> arraylistObject;

	TreeMap<String, Set<String>> cityTheatresList = new TreeMap<>();
	TreeMap<String, Set<String>> movieTheatresList = new TreeMap<>();
	TreeMap<String, Set<String>> theatreMoviesList = new TreeMap<>();
	TreeMap<String, TreeMap<String, List<String>>> cityTheatreMoviesList = new TreeMap<>();
	TreeMap<String, TreeMap<String, List<String>>> theatreMoviesShowsList = new TreeMap<>();

	public TreeMap<String, Set<String>> cityTheatres() throws FileNotFoundException {

		scanner = new Scanner(new File(MovieConstants.FILE_PATH));
		while (scanner.hasNextLine()) {
			String[] database = scanner.nextLine().split(",");

			for (String city : Arrays.asList(database[0])) {
				cityTheatresList.put(city, new TreeSet<>());
				for (String theatre : Arrays.asList(database[1])) {
					Theatre newTheatre = new Theatre(theatre);
					cityTheatresList.get(city).add(newTheatre.getTheatreName());
				}

			}

		}

		return cityTheatresList;
	}

	public List<TreeMap<String, Set<String>>> particularCityTheatres(String city) throws FileNotFoundException {

		TreeMap<String, Set<String>> cityTheatresMap = new TreeMap<>();
		arraylistObject = new ArrayList<>();

		if (city == null) {
			throw new NullPointerException("Please enter valid values");
		} else {
			for (Entry<String, Set<String>> entry : cityTheatresList.entrySet()) {
				String key = entry.getKey();
				if (key.toLowerCase().contains(city.toLowerCase())) {
					cityTheatresMap.put(entry.getKey(), new TreeSet<>());
					cityTheatresMap.get(key).addAll(entry.getValue());
					if (!arraylistObject.contains(cityTheatresMap)) {
						arraylistObject.add(cityTheatresMap);
					}
				}
			}
		}
		return arraylistObject;
	}

	public TreeMap<String, Set<String>> movieTheatres() throws FileNotFoundException {

		scanner = new Scanner(new File(MovieConstants.FILE_PATH));
		while (scanner.hasNextLine()) {
			String[] database1 = scanner.nextLine().split(",");
			for (String movie : Arrays.asList(database1[2])) {
				movieTheatresList.put(movie, new TreeSet<>());
				for (String theatre : Arrays.asList(database1[1])) {

					Theatre newTheatre = new Theatre(theatre);
					movieTheatresList.get(movie).add(newTheatre.getTheatreName());

				}
			}
		}

		return movieTheatresList;

	}

	public List<TreeMap<String, Set<String>>> particularMovieTheatres(String movie) throws FileNotFoundException {

		TreeMap<String, Set<String>> movieTheatresMap = new TreeMap<>();
		arraylistObject = new ArrayList<>();

		for (Entry<String, Set<String>> entry : movieTheatresList.entrySet()) {
			String key = entry.getKey();
			if (key.toLowerCase().contains(movie.toLowerCase())) {
				movieTheatresMap.put(key, new TreeSet<>());
				movieTheatresMap.get(key).addAll(entry.getValue());
				if (!arraylistObject.contains(movieTheatresMap)) {
					arraylistObject.add(movieTheatresMap);
				}
			}
		}
		return arraylistObject;
	}

	public TreeMap<String, Set<String>> theatreMovies() throws FileNotFoundException {

		scanner = new Scanner(new File(MovieConstants.FILE_PATH));
		while (scanner.hasNextLine()) {
			String[] database2 = scanner.nextLine().split(",");
			for (String theatre : Arrays.asList(database2[1])) {
				theatreMoviesList.put(theatre, new TreeSet<>());
				for (String movie : Arrays.asList(database2[2])) {

					Movie newMovie = new Movie(movie);
					theatreMoviesList.get(theatre).add(newMovie.getMovieTitle());
				}

			}
		}
		return theatreMoviesList;
	}

	public List<TreeMap<String, Set<String>>> particularTheatreMovies(String theatre) throws FileNotFoundException {

		TreeMap<String, Set<String>> theatreMoviesMap = new TreeMap<>();
		arraylistObject = new ArrayList<>();

		for (Entry<String, Set<String>> entry : theatreMoviesList.entrySet()) {
			String key = entry.getKey();
			if (key.toLowerCase().contains(theatre.toLowerCase())) {
				theatreMoviesMap.put(key, new TreeSet<>());
				theatreMoviesMap.get(key).addAll(entry.getValue());
				if (!arraylistObject.contains(theatreMoviesMap)) {
					arraylistObject.add(theatreMoviesMap);
				}
			}
		}
		return arraylistObject;
	}

	public TreeMap<String, TreeMap<String, List<String>>> cityTheatreMovies() throws FileNotFoundException {

		scanner = new Scanner(new File(MovieConstants.FILE_PATH));
		while (scanner.hasNextLine()) {
			String[] database3 = scanner.nextLine().split(",");

			for (String city : Arrays.asList(database3[0])) {
				cityTheatreMoviesList.put(city, new TreeMap<>());

				for (String theatre : Arrays.asList(database3[1])) {
					cityTheatreMoviesList.get(city).put(theatre, new ArrayList<>());

					for (String movie : Arrays.asList(database3[2])) {
						if (!cityTheatreMoviesList.get(city).get(theatre).contains(movie)) {
							Movie newMovie = new Movie(movie);
							cityTheatreMoviesList.get(city).get(theatre).add(newMovie.getMovieTitle());

						}
					}
				}
			}

		}

		return cityTheatreMoviesList;

	}

	public List<String> particularCityTheatreMovies(String city) throws FileNotFoundException {

		List<String> arraylistObject1 = new ArrayList<>();

		for (Entry<String, TreeMap<String, List<String>>> entry : cityTheatreMoviesList.entrySet()) {

			String key = entry.getKey();
			if (key.toLowerCase().contains(city.toLowerCase()) && !arraylistObject1.contains(entry.getKey())) {
				arraylistObject1.add(entry.getKey() + " : " + entry.getValue());
			}
		}
		return arraylistObject1;
	}

	public Set<String> listMoviesWithRating(Double rating) throws FileNotFoundException {

		TreeMap<Double, List<String>> ratingMoviesList = new TreeMap<>();

		Set<String> moviesRatingList = new TreeSet<>();

		scanner = new Scanner(new File(MovieConstants.FILE_PATH));
		while (scanner.hasNextLine()) {
			String[] database4 = scanner.nextLine().split(",");

			for (String rating1 : Arrays.asList(database4[4])) {
				if (!ratingMoviesList.containsKey(Double.parseDouble(rating1))) {
					ratingMoviesList.put(Double.parseDouble(rating1), new ArrayList<>());
				}

				for (String movie : Arrays.asList(database4[2])) {

					Movie newMovie = new Movie(movie);
					ratingMoviesList.get(Double.parseDouble(rating1)).add(newMovie.getMovieTitle());
				}

			}
		}

		for (Entry<Double, List<String>> entry : ratingMoviesList.entrySet()) {
			if (rating == null) {
				throw new NullPointerException("Please enter proper values!!!");
			}
			Double key = entry.getKey();
			if (key >= rating) {
				moviesRatingList.addAll(entry.getValue());
			}
		}
		return moviesRatingList;
	}

	public TreeMap<String, TreeMap<String, List<String>>> theatreMovieShowTimes() throws FileNotFoundException {

		scanner = new Scanner(new File(MovieConstants.FILE_PATH));
		while (scanner.hasNextLine()) {
			String[] database5 = scanner.nextLine().split(",");

			for (String theatre : Arrays.asList(database5[1])) {
				theatreMoviesShowsList.put(theatre, new TreeMap<>());

				for (String movie : Arrays.asList(database5[2])) {
					theatreMoviesShowsList.get(theatre).put(movie, new ArrayList<>());

					for (String show : Arrays.asList(database5[5])) {
						if (!theatreMoviesShowsList.get(theatre).get(movie).contains(show)) {
							theatreMoviesShowsList.get(theatre).get(movie).add(show);

						}
					}
				}
			}
		}
		return theatreMoviesShowsList;
	}

	public List<String> particluarTheatreMovieShowTimes(String theatre) throws FileNotFoundException {

		List<String> arraylistObject1 = new ArrayList<>();

		for (Entry<String, TreeMap<String, List<String>>> entry : theatreMoviesShowsList.entrySet()) {
			String key = entry.getKey();
			if (key.toLowerCase().contains(theatre.toLowerCase())) {
				arraylistObject1.add(entry.getKey() + " : " + entry.getValue());
			}
		}
		return arraylistObject1;
	}

}
