package system;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import database.SerializeDB;

public class Staff extends Person implements Serializable{
	
//	private String staffID;
	//private String password;
	
	public Staff() {
	}
	
	public Staff (String name, String id, String pw, String mail, int contact){
		super(name, id, pw, mail, contact);
	}

	/*public String getStaffID() {
		return staffID;
	}

	public String getPassword() {
		return password;
	}*/
	
	public boolean equals(Object o) {
		if (o instanceof Staff) {
			Staff p = (Staff)o;
			return (getName().equals(p.getName()));
		}
		return false;
	}
	
	//delegates to login class
	public boolean login() {
		Login log= new Login("staff");
		return log.authenticate();
	}
	
	public void addMovie() {
		MovieSystem ms = new MovieSystem();
		if(!(ms.addMovieToDB()))
			System.out.println("Error adding it into database");
		else
			System.out.println("Successfully adding it to database");
	}
	
	public void editMovieDB() {
		MovieSystem ms = new MovieSystem();
		ms.editMovieDB();
	}
}
