package testing;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import database.SerializeDB;
import system.*;

public class AddDatabase {

	public static void main(String[] args) {

		List list;
		try {
			/////////////////////////////// STAFF //////////////////////////////////////////
			// Create new data
			ArrayList staffList = new ArrayList();
			Staff staff = new Staff("admin", "admin", "password", "admin@moblima.com", 12345678);
			// add to list
			staffList.add(staff);
			
			ArrayList movieGoerList = new ArrayList();
			MovieGoer movieGoer;
			movieGoer = new MovieGoer("User Name1", "username1", "password1", "username1@gmail.com", 98765432);	
			movieGoerList.add(movieGoer);
			movieGoer = new MovieGoer("User Name2", "username2", "password2", "username2@gmail.com", 23414124);	
			movieGoerList.add(movieGoer);
			movieGoer = new MovieGoer("User Name3", "username3", "password3", "username3@gmail.com", 54563422);
			movieGoerList.add(movieGoer);
			SerializeDB.writeSerializedObject("Staff.ser", staffList);
			SerializeDB.writeSerializedObject("MovieGoer.ser", movieGoerList);

			// read from serialized file the list of professors
			list = (ArrayList) SerializeDB.readSerializedObject("Staff.ser");
			for (int i = 0; i < list.size(); i++) {
				Staff st = (Staff) list.get(i);
				System.out.println("name is " + st.getName());
				System.out.println("contact is " + st.getContact());
				System.out.println("email is " + st.getEmail());
			}
			
			list = (ArrayList) SerializeDB.readSerializedObject("MovieGoer.ser");
			for (int i = 0; i < list.size(); i++) {
				MovieGoer mg = (MovieGoer) list.get(i);
				System.out.println("name is " + mg.getName());
				System.out.println("contact is " + mg.getContact());
				System.out.println("email is " + mg.getEmail());
			}

			//
			/////////////////////////////// Movie //////////////////////////////////////////
			// Create new data
			// String name, String type, String rate, String length, String status
			// ArrayList mlist = new ArrayList();
			// Movie addMovie = new Movie("The Second Sight", "BlockBuster", "TBA", "TBA",
			// "Coming Soon");
			// // add to list
			// mlist.add(addMovie);
			// SerializeDB.writeSerializedObject("Movie.ser", mlist);

			// read from serialized file the list of movie
			list = (ArrayList) SerializeDB.readSerializedObject("Movie.ser");
			for (int i = 0; i < list.size(); i++) {
				Movie mov = (Movie) list.get(i);
				System.out.println("Movie title	: " + mov.getMovieName());
				System.out.println("Showing status	: " + mov.getMovieStatus());
				System.out.println("Movie type	: " + mov.getMovieType());
				// System.out.println("SYNOPSIS : " + mov.getMovieAbstract());
				// System.out.println("Director : " + mov.getDirector());
				// System.out.println("Cast : " + mov.getCasts());
				System.out.println("Overall rating	: " + mov.getRating());
				System.out.println("-------------------");
			}

			// // write to serialized file - update/insert/delete
			// example - add one staff
			// Movie adds = new Movie("Marvels Thor The Dark World", "BlockBuster", "TBA",
			// "TBA", "Coming Soon");
			// // add to list
			// list.add(adds);
			// // list.remove(adds); // remove if p equals object in the list
			//
			// SerializeDB.writeSerializedObject("Movie.ser", list);

		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}
	}
}
