package system;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import database.SerializeDB;

public class MovieSystem {
	
	private List list;
	private String name, type, rating, length, status;
	Scanner sc = new Scanner(System.in);
	//private long movieRevenue

	public boolean addMovieToDB() {
		
		int rchoice;
		boolean flag = false;
		List list;
		
		try {
			System.out.print("Enter the new Movie Name: ");
			name = sc.nextLine();
			
			System.out.print("Enter the Movie Type: ");
			type = sc.nextLine();
			
			System.out.print("Enter the Movie Length: ");
			length = sc.nextLine();
			
			System.out.println("Choose the Movie Rating: ");
			
			System.out.println("1. G");
			System.out.println("2. PG");
			System.out.println("3. PG13 ");
			System.out.println("4. NC16");
			System.out.println("5. M18");
			System.out.println("6. R21");
			System.out.println("7. TBA");
			System.out.print("Choice: ");
			
			do {
				rchoice = sc.nextInt(); sc.nextLine();
				switch(rchoice) {
				case 1: rating = "G"; break;
				case 2: rating = "PG"; break;
				case 3: rating = "PG13"; break;
				case 4: rating = "NC16"; break;
				case 5: rating = "M18"; break;
				case 6: rating = "R21"; break;
				case 7: rating = "TBA"; break;
				default: System.out.println("No such choice");			
				}
			} while (rchoice < 1 || rchoice >7);			
			
			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			
			for(int i=0; i<list.size(); i++){
				Movie movie = (Movie)list.get(i);

				if(movie.getMovieName().equals(name)) {
					flag = true;
					break;
				}
				else 
					flag = false;
			}
			
			if (!flag) {
				Movie mov = new Movie(name, type, rating, length, "Coming Soon");
				list.add(mov);
				SerializeDB.writeSerializedObject("Movie.ser", list);
				return true;
			}
			else
				System.out.println("Movie already in database. Update the details instead");
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
			return false;
		}
		return false;
	}
	
	public boolean editMovieDB() {
		
		int choice, rchoice;
		List list;
		
		try {			
			System.out.print("Enter the movie name: ");
			name = sc.nextLine();

			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			
			for(int i=0; i<list.size(); i++){
				Movie movie = (Movie)list.get(i);

				if(movie.getMovieName().equals(name)) {
					do {
						System.out.println("Which detail do you want to update?");
						System.out.println(movie.getMovieName());
						System.out.println("1. Update the Movie Name");
						System.out.println("2. Update the Movie Type");
						System.out.println("3. Update the Movie Runtime");
						System.out.println("4. Update the Movie Rating");
						System.out.println("5. Update the Movie Status");
						System.out.println("6. Exit");
						
						System.out.print("Choice: ");		
						choice = sc.nextInt();
						sc.nextLine();
						
						switch (choice) {
						case 1: System.out.print("Enter the Movie Name: ");
								name = sc.nextLine();
								movie.setMovieName(name);
								break;
								
						case 2: System.out.println(movie.getMovieType());
								System.out.print("Enter the Movie Type: ");
								type = sc.nextLine();
								movie.setMovieType(type);
								break;
								
						case 3: System.out.println(movie.getMovieLength());
								System.out.print("Enter the Movie Runtime: ");
								length = sc.nextLine();
								movie.setMovieLength(length);
								break;
								
						case 4: System.out.println(movie.getRating());
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
									rchoice = sc.nextInt(); sc.nextLine();
									System.out.println();
									
									switch(rchoice) {
									case 1: rating = "G"; break;
									case 2: rating = "PG"; break;
									case 3: rating = "PG13"; break;
									case 4: rating = "NC16"; break;
									case 5: rating = "M18"; break;
									case 6: rating = "R21"; break;
									case 7: rating = "TBA"; break;
									default: System.out.println("No such choice");			
									}
								} while (rchoice < 1 || rchoice >7);

								movie.setMovieRating(rating);
								break;
								
						case 5: System.out.println(movie.getMovieStatus());
								System.out.println("Choose the new Status: ");
								System.out.println("1. Coming Soon");
								System.out.println("2. Preview");
								System.out.println("3. Now Showing");
								System.out.println("4. End Of Showing");
								
								do {
									System.out.print("Choice: ");
									rchoice = sc.nextInt(); sc.nextLine();
									System.out.println();
									
									switch(rchoice) {
									case 1: status = "Coming Soon"; break;
									case 2: status = "Preview"; break;
									case 3: status = "Now Showing"; break;
									case 4: status = "End Of Showing"; break;
									default: System.out.println("No such choice");			
									}
								} while (rchoice < 1 || rchoice > 4);
								
								movie.setMovieStatus(status);
								break;
								
						case 6: Movie mov = new Movie(movie.getMovieName(), movie.getMovieType(),
													  movie.getRating(), movie.getMovieLength(), 
													  movie.getMovieStatus());
								list.remove(mov);
								list.add(mov);
								SerializeDB.writeSerializedObject("Movie.ser", list);
								return true;

						default: System.out.println("No such choice");
						}
						
					} while (choice != 6);
				}
				else 
					System.out.println("Movie not found in Database.");
			}	
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
			return false;
		}
		return false;
	}
	
}
