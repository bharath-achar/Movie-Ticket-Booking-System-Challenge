import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MovieDatabase {

	Scanner scanner;

	private ArrayList<Theatre> theatreList;
	private ArrayList<Movie> movieList;

	public MovieDatabase() {
		theatreList = new ArrayList<Theatre>();
		movieList = new ArrayList<Movie>();
	}

	public void setTheatreList(ArrayList<Theatre> theatreList) {
		this.theatreList = theatreList;
	}

	public void setMovieList(ArrayList<Movie> movieList) {
		this.movieList = movieList;
	}

	public ArrayList<Theatre> getTheatreList() {
		return theatreList;
	}

	public ArrayList<Movie> getMovieList() {
		return movieList;
	}

	public HashMap<String, ArrayList<String>> cityTheatres() throws FileNotFoundException {

		HashMap<String, ArrayList<String>> cityTheatresList = new HashMap<String, ArrayList<String>>();

		scanner = new Scanner(new File("Movie-Database.csv"));
		while (scanner.hasNextLine()) {
			String[] database = scanner.nextLine().split(",");

			for (String city : Arrays.asList(database[0])) {
				if (!cityTheatresList.containsKey(city)) {
					cityTheatresList.put(city, new ArrayList<String>());
				}
				for (String theatre : Arrays.asList(database[1])) {
					if (!cityTheatresList.containsValue(theatre)) {
						Theatre newTheatre = new Theatre(theatre);
						cityTheatresList.get(city).add(newTheatre.getTheatreName());
					}
				}
			}

		}
		return cityTheatresList;
	}

	public HashMap<String, ArrayList<String>> movieTheatres() throws FileNotFoundException {
		HashMap<String, ArrayList<String>> movieTheatresList = new HashMap<String, ArrayList<String>>();

		scanner = new Scanner(new File("Movie-Database.csv"));
		while (scanner.hasNextLine()) {
			String[] database1 = scanner.nextLine().split(",");
			for (String movie : Arrays.asList(database1[2])) {
				if (!movieTheatresList.containsKey(movie)) {
					movieTheatresList.put(movie, new ArrayList<String>());
				}
				for (String theatre : Arrays.asList(database1[1])) {
					if (!movieTheatresList.containsValue(theatre)) {
						Theatre newTheatre = new Theatre(theatre);
						movieTheatresList.get(movie).add(newTheatre.getTheatreName());
					}
				}
			}

		}
		return movieTheatresList;

	}

	public HashMap<String, ArrayList<String>> theatreMovies() throws FileNotFoundException {

		HashMap<String, ArrayList<String>> theatreMoviesList = new HashMap<String, ArrayList<String>>();

		scanner = new Scanner(new File("Movie-Database.csv"));
		while (scanner.hasNextLine()) {
			String[] database2 = scanner.nextLine().split(",");
			for (String theatre : Arrays.asList(database2[1])) {
				if (!theatreMoviesList.containsKey(theatre)) {
					theatreMoviesList.put(theatre, new ArrayList<String>());
				}
				for (String movie : Arrays.asList(database2[2])) {
					if (!theatreMoviesList.containsValue(movie)) {
						Movie newMovie = new Movie(movie);
						theatreMoviesList.get(theatre).add(newMovie.getMovieName());
					}
				}
			}
		}
		return theatreMoviesList;
	}

	public HashMap<String, HashMap<String, ArrayList<String>>> cityTheatreMovies() throws FileNotFoundException {

		HashMap<String, HashMap<String, ArrayList<String>>> cityTheatreMoviesList = new HashMap<String, HashMap<String, ArrayList<String>>>();

		MovieDatabase movieDatabase = new MovieDatabase();

		HashMap<String, ArrayList<String>> theatreMoviesList = movieDatabase.theatreMovies();
		scanner = new Scanner(new File("Movie-Database.csv"));
		while (scanner.hasNextLine()) {
			String[] database3 = scanner.nextLine().split(",");

			for (String city : Arrays.asList(database3[0])) {
				if (!cityTheatreMoviesList.containsKey(city)) {
					cityTheatreMoviesList.put(city, theatreMoviesList);
				}
			}

		}

		return cityTheatreMoviesList;
	}

//	public HashMap<String, List<String>> listMoviesWithRating(double rating) throws FileNotFoundException {
//
//		HashMap<String, List<String>> ratingMoviesList = new HashMap<String, List<String>>();
//
//		scanner = new Scanner(new File("Movie-Database.csv"));
//		while (scanner.hasNextLine()) {
//			String[] database4 = scanner.nextLine().split(",");
//
//			for (String rating1 : Arrays.asList(database4[4])) {
//				if (!ratingMoviesList.containsKey(rating1)) {
//					ratingMoviesList.put(rating1, new ArrayList<String>());
//				}
//
//				for (String movie : Arrays.asList(database4[3])) {
//					if (!ratingMoviesList.containsValue(movie)) {
//						Movie newMovie = new Movie(movie);
//						ratingMoviesList.get(rating1).add(newMovie.getMovieName());
//					}
//				}
//			}
//		}
//
//		return ratingMoviesList;
//	}

	public void ratingMoviesList(Double r) throws FileNotFoundException {

		HashMap<String, List<String>> ratingMovies = new HashMap<String, List<String>>();

		scanner = new Scanner(new File("Movie-Database.csv"));
		while (scanner.hasNextLine()) {
			String[] database4 = scanner.nextLine().split(",");
//			System.out.println(database4[4].indexOf("8.7"));
			for (String rating : Arrays.asList(database4[4])) {
				if (Double.parseDouble(rating) > r) {
					if (!ratingMovies.containsKey(rating)) {
						ratingMovies.put(rating, new ArrayList<String>());
					}

				}
				for (String movie1 : Arrays.asList(database4[2])) {
					if (!ratingMovies.containsValue(movie1)) {
						Movie movie = new Movie(movie1);
						ratingMovies.get(rating).add(movie.getMovieName());
					}
				}
			}
		}

		System.out.println(ratingMovies);

	}

	public static void main(String[] args) throws IOException {

		MovieDatabase movieDatabase = new MovieDatabase();

		HashMap<String, ArrayList<String>> movieTheatres = movieDatabase.movieTheatres();

		HashMap<String, ArrayList<String>> cityTheatres = movieDatabase.cityTheatres();

		HashMap<String, ArrayList<String>> theatreMovies = movieDatabase.theatreMovies();

		HashMap<String, HashMap<String, ArrayList<String>>> cityTheatreMovies = movieDatabase.cityTheatreMovies();

//		HashMap<String, ArrayList<String>> ratingMoviesList = movieDatabase.listMoviesWithRating(rating)

		movieDatabase.ratingMoviesList(7.2);

		System.out.println(cityTheatreMovies);

	}
}
