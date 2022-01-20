package com.capgemini.xcorps.movie;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.capgemini.xcorps.controller.MovieController;

public class MovieApplication {

	public static void main(String[] args) throws IOException {

		MovieController movieController = new MovieController();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nWelcome to Online Movie Ticket System.\nPlease choose one of the methods!!!");
			System.out.println(
					"1. Display list of theaters in a particular city\n2. Display list of theaters playing a particular movie\n3. Display list of movies played in a particular theater\n4. Display list of movies played in all the theaters in a particular city\n5. Display list of movies above certain rating\n6. Display all the show times for a particular movie in a particular theater\n0. Exit\n");

			try {
				int userInput = scanner.nextInt();
				System.out.println();

				switch (userInput) {
				case 1:
					System.out.println("List of cities available in Database are : " + movieController.cityTheatres());
					System.out.println("\nPlease select city to view theatres");
					String cityInput = scanner.next();
					System.out.println();
					if (!movieController.particularCityTheatres(cityInput).isEmpty()) {
						System.out.println("Result : " + movieController.particularCityTheatres(cityInput));
					} else
						System.err.println("Results not found!!!");

					continue;
				case 2:
					System.out.println("List of movies available in the database : " + movieController.movieTheatres());
					System.out.println("\nPlease select movie to view theatres");
					String movieInput = scanner.next();
					System.out.println();
					if (!movieController.particularMovieTheatres(movieInput).isEmpty()) {
						System.out.println("Result : " + movieController.particularMovieTheatres(movieInput));
					} else {
						System.err.println("Results not found!!!");
					}
					continue;
				case 3:
					System.out
							.println("List of theatres available in the Database : " + movieController.theatreMovies());
					System.out.println("\nPlease select theatre to view Movies");
					String theatreInput = scanner.next();
					System.out.println();
					if (!movieController.particularTheatreMovies(theatreInput).isEmpty()) {
						System.out.println("Result : " + movieController.particularTheatreMovies(theatreInput));
					} else {
						System.err.println("Results not found!!!");
					}
					continue;

				case 4:
					System.out.println("List of cities available in the Database : "
							+ movieController.cityTheatreMovies().keySet());
					System.out.println("\nPlease select city to view theatre with movies played");
					String cityInput1 = scanner.next();
					if (movieController.particularCityTheatreMovies(cityInput1) != null) {
						System.out.println("Result : " + movieController.particularCityTheatreMovies(cityInput1));
					} else {
						System.err.println("Results not found!!!");
					}
					continue;

				case 5:
					System.out.println("Please enter the average rating to view best movies");
					Double ratingInput = null;
					try {
						ratingInput = scanner.nextDouble();
						System.out.println();
						if (!movieController.listMoviesWithRating(ratingInput).isEmpty()) {
							System.out.println("Result : " + movieController.listMoviesWithRating(ratingInput));
						} else {
							System.err.println("Results not found!!!");
						}

					} catch (InputMismatchException e) {
						System.err.println("Please enter proper value");
						break;
					}
					continue;

				case 6:
					System.out.println(movieController.theatreMovieShowTimes().keySet());
					System.out.println("\nPlease select theatre to view movie with the show timings");
					String theatreInput1 = scanner.next();
					System.out.println();
					if (movieController.particluarTheatreMovieShowTimes(theatreInput1) != null) {
						System.out.println(movieController.particluarTheatreMovieShowTimes(theatreInput1));
					} else {
						System.err.println("Results not found!!!");
					}
					continue;
				case 0:
					System.out.println("\nThank you.... Visit again");
					return;
				default:
					System.err.println("Please select the proper choice\n\n");
					continue;
				}

			} catch (InputMismatchException e) {
				System.err.println("Please enter proper values... Restart the application!!!");
				break;
			}
		}

	}

}
