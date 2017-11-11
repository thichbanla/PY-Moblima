package entity;
import java.io.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import application.BookingSystem;
import application.Login;
import database.SerializeDB;

public class MovieGoer extends Person implements Serializable {

	public MovieGoer() {}
	public MovieGoer(String name, String id, String pw, String email, int contact){
		super(name, id, pw, email, contact);
	}

	public boolean login(){
		Login log= new Login("movie-goer");
		return log.authenticate();
	}
	
	public boolean buyMovieTicket(){
		BookingSystem bk = new BookingSystem();
		return false;
	}
}
