package application;
import system.*;

import java.util.Scanner;
import java.io.*;

public class Moblima {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int choice;
		
		//create cineplex, cinema here
		
		do {
			
			System.out.println("=====================================");
			System.out.println("|1. User Login                      |");
			System.out.println("|2. Acount Register                 |");
			System.out.println("|3. Staff Login                     |");
			System.out.println("|4. Movie Listings                  |");
			System.out.println("|5. Now showing		                |");
			System.out.println("=====================================");
			
			System.out.print("Enter your choice: ");
			choice = sc.nextInt();
			sc.nextLine();				
			
			switch (choice) {
			case 1: //user logging in
				MovieGoer customer = new MovieGoer();
				
					break;
					
			case 2: //account registration
					break;
					
			case 3: //staff login
				Person person = new Staff();
				if(!(person.login()))
					System.out.println("Incorrect ID or Password");
				else					
					showStaffMenu();
				break;
				
			case 4: //display all movies (including now showing and upcoming movies)
					
					
			case 5: //List of now showing movies				
					
					
			default: //need to improve here
					 System.out.println("Re-enter your choice!");
					 System.out.print("Enter your choice: ");
					 choice = sc.nextInt();
			}
		} while (choice <= 5 && choice > 0); //end of do-while loop
	}
	
	public static void showStaffMenu() {
		
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
			sc.nextLine();
			
			switch (staffchoice){
			case 1: staff.addMovie();
					break;
			case 2: staff.editMovieDB();
					break;
			case 3: //generate sale report
					break;
			case 4: break;
			default: System.out.println("Re-enter your choice!");
			 		 System.out.print("Enter your choice: ");
			 		 staffchoice = sc.nextInt();
			}
		
		} while(staffchoice != 4);
	}

}
