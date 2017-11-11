package application;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;
import entity.Movie;

public class MovieMgr {

	private List<Movie> list;
	private String name, cast, director, plot, rating, status, cinema;
	private float price;
	//private float userRate;
	Scanner sc = new Scanner(System.in);
	// private long movieRevenue

	@SuppressWarnings("unchecked")
	public boolean addMovieToDB() {

		int rchoice;
		boolean flag = false;
		// List list;

		try {
			System.out.print("Enter the new Movie Name: ");
			name = sc.nextLine();
			System.out.print("Cast: ");
			director = sc.nextLine();
			System.out.print("Director: ");
			director = sc.nextLine();

			// check if movie has already been added to DB
			list = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
			for (int i = 0; i < list.size(); i++) {
				Movie movie = (Movie) list.get(i);
				if ((movie.getMovieName()).equals(name) && (movie.getCast()).equals(cast)
						&& (movie.getDirector()).equals(director)) {
					flag = true;
					break;
				} else
					flag = false;
			}
			// else continue to get movie details
			System.out.print("Synopsis: ");
			director = sc.nextLine();
			System.out.println("Choose the Movie Rating: ");
			System.out.println("1. G");
			System.out.println("2. PG");
			System.out.println("3. PG13 ");
			System.out.println("4. NC16");
			System.out.println("5. M18");
			System.out.println("6. R21");
			System.out.println("7. TBA");

			do {
				System.out.print("Choice: ");
				rchoice = sc.nextInt();
				sc.nextLine();
				System.out.println();

				switch (rchoice) {
				case 1:
					rating = "G";
					break;
				case 2:
					rating = "PG";
					break;
				case 3:
					rating = "PG13";
					break;
				case 4:
					rating = "NC16";
					break;
				case 5:
					rating = "M18";
					break;
				case 6:
					rating = "R21";
					break;
				case 7:
					rating = "TBA";
					break;
				default:
					System.out.println("No such choice");
				}
			} while (rchoice < 1 || rchoice > 7);
			director = sc.nextLine();
			System.out.print("Enter the Cinema: ");
			cinema = sc.nextLine();
			// add the new movie into DB
			if (!flag) {
				Movie mov = new Movie(name, cast, director, plot, rating, "Coming Soon");
				list.add(mov);
				SerializeDB.writeSerializedObject("Movie.ser", list);
				return true;
			} else
				System.out.println("Movie already in database. Update the details instead");
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
			return false;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean editMovieDB() {

		int choice, rchoice;
		List<Movie> list;

		try {
			System.out.print("Enter the movie name: ");
			name = sc.nextLine();
			System.out.print("Director: ");
			director = sc.nextLine();

			list = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");

			for (int i = 0; i < list.size(); i++) {
				Movie movie = (Movie) list.get(i);

				if ((movie.getMovieName()).equals(name) && (movie.getDirector()).equals(director)) {
					do {
						System.out.println("Details currently saved in the system");
						System.out.print("\nMovie Name: ");
						movie.getMovieName();
						System.out.print("\nCasts: ");
						movie.getCast();
						System.out.print("\nDirector: ");
						movie.getDirector();
						System.out.print("\nSynopsis: ");
						movie.getPlot();
						System.out.print("\nMovie Rating: ");
						movie.getMovieRating();
						System.out.print("\nShow Status: ");
						movie.getStatus();
						
						System.out.println("Which detail do you want to update?");
						System.out.println("1. Update the Movie Name");
						System.out.println("2. Update the Movie Casts");
						System.out.println("3. Update the Movie Director");
						System.out.println("4. Update the Movie Synopsis");
						System.out.println("5. Update the Movie Rating");
						System.out.println("6. Update the Movie Status");
						System.out.println("7. Exit");

						System.out.print("Choice: ");
						choice = sc.nextInt();
						sc.nextLine();

						switch (choice) {
						case 1:
							System.out.print("Enter the Movie Name: ");
							name = sc.nextLine();
							movie.setName(name);
							break;
						case 2:
							System.out.print("Enter the casts: ");
							cast = sc.nextLine();
							movie.setCast(cast);
							break;
						case 3:
							System.out.print("Enter the director: ");
							director = sc.nextLine();
							movie.setDirector(director);
							break;
						case 4:
							System.out.print("Enter the synopsis: ");
							plot = sc.nextLine();
							movie.setPlot(plot);
						case 5:
							System.out.println("Choose the Movie Rating: ");
							System.out.println("1. G");
							System.out.println("2. PG");
							System.out.println("3. PG13 ");
							System.out.println("4. NC16");
							System.out.println("5. M18");
							System.out.println("6. R21");
							System.out.println("7. TBA");

							do {
								System.out.print("Choice: ");
								rchoice = sc.nextInt();
								sc.nextLine();
								System.out.println();

								switch (rchoice) {
								case 1:
									rating = "G";
									break;
								case 2:
									rating = "PG";
									break;
								case 3:
									rating = "PG13";
									break;
								case 4:
									rating = "NC16";
									break;
								case 5:
									rating = "M18";
									break;
								case 6:
									rating = "R21";
									break;
								case 7:
									rating = "TBA";
									break;
								default:
									System.out.println("No such choice");
								}
							} while (rchoice < 1 || rchoice > 7);

							movie.setRating(rating);
							break;
						case 6:
							System.out.println("Choose the new Status: ");
							System.out.println("1. Coming Soon");
							System.out.println("2. Preview");
							System.out.println("3. Now Showing");
							System.out.println("4. End Of Showing");
							do {
								System.out.print("Choice: ");
								rchoice = sc.nextInt();
								sc.nextLine();
								System.out.println();

								switch (rchoice) {
								case 1:
									status = "Coming Soon";
									break;
								case 2:
									status = "Preview";
									break;
								case 3:
									status = "Now Showing";
									break;
								case 4:
									status = "End Of Showing";
									break;
								default:
									System.out.println("No such choice");
								}
							} while (rchoice < 1 || rchoice > 4);

							movie.setMovieStatus(status);
							break;
						default:
							System.out.println("No such choice");
						}

					} while (choice != 6);
				} else
					System.out.println("Movie not found in Database.");
			}
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
			return false;
		}
		return false;
	}

}
