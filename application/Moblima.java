package application;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import database.SerializeDB;
import entity.*;

import java.io.*;
import java.text.SimpleDateFormat;

public class Moblima {

	static Scanner sc = new Scanner(System.in);
	// private static Person person;

	public static void main(String[] args) {

		int choice;
		do {

			System.out.println("=====================================");
			System.out.println("|1. User Login                      |");
			System.out.println("|2. Acount Register                 |");
			System.out.println("|3. Staff Login                     |");
			System.out.println("|4. Movie Listings                  |");
			System.out.println("|5. Now showing	                    |");
			System.out.println("=====================================");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1: // user logging in
				MovieGoer customer = new MovieGoer();

				if (!(customer.login()))
					System.out.println("Incorrect ID or Password");
				else
					showMovieGoerMenu();
				break;

			case 2: // account registration
				break;

			case 3: // staff login
				Staff staff = new Staff();
				if (!(staff.login()))
					System.out.println("Incorrect ID or Password");
				else
					showStaffMenu();
				break;

			case 4: // display all movies (including now showing and upcoming movies)
				break;

			case 5: // List of now showing movies
				break;

			default: // need to improve here
				System.out.println("Re-enter your choice!");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
			}
		} while (choice <= 5 && choice > 0); // end of do-while loop
	}

	private static void showStaffMenu() {

		int staffchoice;
		Staff staff = new Staff();

		do {
			System.out.println("=====================================");
			System.out.println("|1. Add Movies                      |");
			System.out.println("|2. Update Details of Movies        |");
			System.out.println("|3. Generate Sale Report            |");
			System.out.println("|4. Staff Logout                    |");
			System.out.println("=====================================");

			System.out.print("Enter your choice: ");
			staffchoice = sc.nextInt();
			// sc.nextLine();

			switch (staffchoice) {
			case 1:
				staff.addMovie();
				break;
			case 2:
				staff.editMovieDB();
				break;
			case 3: // generate sale report
				break;
			case 4:
				break;
			default:
				System.out.println("Re-enter your choice!");
				System.out.print("Enter your choice: ");
				staffchoice = sc.nextInt();
			}

		} while (staffchoice != 4);
	}

	private static void showMovieGoerMenu() {
		int choice;
		MovieGoer movieGoer = new MovieGoer();

		do {
			System.out.println("=====================================");
			System.out.println("|1. Movie Listings                  |");
			System.out.println("|2. View Show Time                  |");
			System.out.println("|3. Top 5 Movies                    |");
			System.out.println("|4. Search for a Movie              |");
			System.out.println("|5. Rate a Movie                    |");
			System.out.println("|6. Book a Ticket                   |");
			System.out.println("|7. View Booking History            |");
			System.out.println("|8. User Logout                     |");
			System.out.println("=====================================");

			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			ArrayList<Movie> list;
			switch (choice) {
			case 1: // movie listings
				printMovieList(false);
				break;

			case 2:// view showtime
				queryShowTime();
				break;

			case 3: // top 5 movies (by ticket sales or by overall review rate
				break;

			case 4: // search for a movie
				System.out.print("Enter movie name: ");
				sc.nextLine();
				String inputName = sc.nextLine();				
				list = queryMovieList();
				
				boolean found = false;
				for (int i = 0; i < list.size(); i++) {
					Movie mov = (Movie) list.get(i);
					if ((mov.getMovieName()).equals(inputName))	
					{
						System.out.println("\nSearch result:");
						showMovieDetails(mov);
						found = true;
					}
				}				
				if(!found) System.out.println("Movie not found");					
				break;

			case 5: // rate a movie
				break;

			case 6: // book a ticket

				break;

			case 7: // view booking history
				break;

			case 8: // logout
				System.out.println("Logout successfully");
				break;

			default:
				System.out.println("Re-enter your choice!");
				System.out.print("Enter your choice: ");
				choice = sc.nextInt();
			}

		} while (choice != 8);

	}

	private static void showMovieDetails(Movie mov) {
		System.out.print("Movie title	: " + mov.getMovieName());
		System.out.print("\nCast : " + mov.getCast());
		System.out.print("\nDirector : " + mov.getDirector());
		System.out.print("\nSYNOPSIS : " + mov.getPlot());
		System.out.print("\nMovie rating : " + mov.getMovieRating());
		System.out.print("\nOverall user rate : " + mov.getUserRate());
		System.out.print("\nShowing status : " + mov.getStatus());
		// System.out.println("\nViewer Review: " +mov.getReview());
		System.out.println("\n-------------------");
	}

	private static ArrayList<ShowTime> queryShowTime() {
		String location = null, movieName = null;
		GregorianCalendar date = null;
		int userInput;
		ArrayList<ShowTime> st;
		System.out.println("Showing time for?");
		do {
			System.out.println("=====================================");
			System.out.println("|1. A movie        		            |");
			System.out.println("|2. A location	                    |");
			System.out.println("|3. A date                          |");
			System.out.println("|4. Submit the query                |");
			System.out.println("=====================================");
			userInput = sc.nextInt();

			switch (userInput) {
			case 1:
				printMovieList(false);
				movieName = moviePicker().getMovieName();
				break;
			case 2:
				Cineplex cineplex = cineplexPicker();
				location = cineplex.getName();
				break;
			case 3:
				date = datePicker();
				break;
			}
		} while (userInput != 4);

		st = showTimeList(movieName, location, date); // showtime

		int i = 1;
		System.out.println("Index\tDate\t    Time\tMovie\t\tType\t\tCineplex\t\tCinema\tUsual Price");
		for (ShowTime showtime : st) {
			System.out
					.println(i + ". \t" + calendarToSting(showtime.getDateTime()) + "\t" + (showtime.getMovie()).getMovieName()
							+ "\t" + showtime.getMovie().getMovieRating() + "\t" + showtime.getCineplex().getName() + "\t\t"
							+ showtime.getNoOfCinema() + "\t$ " + getPrice(showtime.getMovie().getMovieRating()));
			i++;
		}
		return st;
	}

	public static ArrayList<Cineplex> queryCineplexList() {
		ArrayList<Cineplex> cineplexList = new ArrayList<Cineplex>();
		cineplexList = (ArrayList<Cineplex>) SerializeDB.readSerializedObject("Cineplex.ser");

		return cineplexList;
	}

	private static Cineplex cineplexPicker() {
		int index = 0;
		int choice;
		ArrayList<Cineplex> cineplexes = queryCineplexList();
		if (cineplexes == null || cineplexes.size() == 0) {
			throw new NullPointerException("No cineplex found");
		}

		for (Cineplex cineplex : cineplexes) {
			System.out.println(index + "\t" + cineplex.getName());
			index++;
		}
		System.out.println("Please pick a cineplex");
		choice = sc.nextInt();

		return cineplexes.get(choice);// return a cineplex at the specific index in this list
	}

	private static GregorianCalendar datePicker() {
		int year, month, day;
		System.out.println("Enter year");
		year = sc.nextInt();
		System.out.println("Enter month");
		month = sc.nextInt();
		month = month - 1;
		System.out.println("Enter day");
		day = sc.nextInt();
		sc.nextLine();

		return new GregorianCalendar(year, month, day, 0, 0);
	}
	
	public static String calendarToSting(GregorianCalendar date){
		String s;
		StringBuilder sb = new StringBuilder();
		if((date.get(Calendar.DAY_OF_MONTH))<10){
			sb.append("0");
		}
		sb.append(date.get(Calendar.DAY_OF_MONTH));
		sb.append("/");
		if((date.get(Calendar.MONTH)+1)<10){
			sb.append("0");
		}
		sb.append((date.get(Calendar.MONTH)+1));
		sb.append("/");
		sb.append(date.get(Calendar.YEAR));
		sb.append("  ");
		if((date.get(Calendar.HOUR_OF_DAY))<10){
			sb.append("0");
		}
		
		sb.append(date.get(Calendar.HOUR_OF_DAY));
		sb.append(":");
		if((date.get(Calendar.MINUTE))<10){
			sb.append("0");
		}
		sb.append(date.get(Calendar.MINUTE));
		s = sb.toString();
		return s;
	}

	public static ArrayList<Movie> queryMovieList() {
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieList = (ArrayList<Movie>) SerializeDB.readSerializedObject("Movie.ser");
		if (movieList == null || movieList.size() == 0)
			throw new NullPointerException("No cineplex found");

		return movieList;
	}

	private static void printMovieList(boolean detail) {
		int index = 0;
		ArrayList<Movie> list = new ArrayList<>();
		list = queryMovieList();

		for (int i = 0; i < list.size(); i++) {
			Movie mov = (Movie) list.get(i);
			for (Movie movie : list) {
				System.out.println(index + "\t" + movie.getMovieName() + "\t" + movie.getStatus());
				index++;
				if (detail)
					showMovieDetails(mov);
			}
		}
	}

	private static ArrayList<ShowTime> showTimeList(String movieName, String cineplexName, GregorianCalendar dateTime) {
		ArrayList<ShowTime> showTimeList = new ArrayList<ShowTime>();// store show time having same certain signatures
		// ArrayList<ShowTime> allShowTime = (ArrayList<ShowTime>)
		// SerializeDB.readSerializedObject("ShowTime.ser");//get all show time
		ShowTimeMgr stMgr = new ShowTimeMgr();
		showTimeList = stMgr.queryShowTime(dateTime, cineplexName, movieName);
		if (showTimeList == null || showTimeList.size() == 0)
			System.out.println("No movie found");
		return showTimeList;

	}

	private static Movie moviePicker() {
		ArrayList<Movie> movieList = new ArrayList<>();
		movieList = queryMovieList();
		System.out.println("Please pick a movie");
		int movieChoice = sc.nextInt();
		return movieList.get(movieChoice);
	}

	public static double getPrice(String movieType) {
		double price = 0;// not completed yet
		return price;
	}

}
