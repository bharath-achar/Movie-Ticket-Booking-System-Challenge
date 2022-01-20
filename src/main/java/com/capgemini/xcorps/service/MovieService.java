package com.capgemini.xcorps.service;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public interface MovieService {

	public SortedMap<String, Set<String>> cityTheatres() throws FileNotFoundException;

	public List<TreeMap<String, Set<String>>> particularCityTheatres(String city) throws FileNotFoundException;

	public SortedMap<String, Set<String>> movieTheatres() throws FileNotFoundException;

	public List<TreeMap<String, Set<String>>> particularMovieTheatres(String movie) throws FileNotFoundException;

	public SortedMap<String, Set<String>> theatreMovies() throws FileNotFoundException;

	public List<TreeMap<String, Set<String>>> particularTheatreMovies(String theatre) throws FileNotFoundException;

	public SortedMap<String, TreeMap<String, List<String>>> cityTheatreMovies() throws FileNotFoundException;

	public List<String> particularCityTheatreMovies(String city) throws FileNotFoundException;

	public Set<String> listMoviesWithRating(Double rating) throws FileNotFoundException;

	public SortedMap<String, TreeMap<String, List<String>>> theatreMovieShowTimes() throws FileNotFoundException;

	public List<String> particluarTheatreMovieShowTimes(String theatre) throws FileNotFoundException;

}
