package entity;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import application.Login;
import application.MovieMgr;
import database.SerializeDB;

public class Staff extends Person implements Serializable{
	/**
	 * Used during deserialization to verify that the sender and receiver of a serialized object have loaded 
	 * classes for that object that are compatible with respect to serialization 
	 */
	private static final long serialVersionUID = 1L;
	private String staffId;
	private String password;
	
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
		MovieMgr ms = new MovieMgr();
		if(!(ms.addMovieToDB()))
			System.out.println("Error adding it into database");
		else
			System.out.println("Successfully adding it to database");
	}
	
	public void editMovieDB() {
		MovieMgr ms = new MovieMgr();
		ms.editMovieDB();
	}
}
