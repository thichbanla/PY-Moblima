package system;
import java.util.ArrayList;
import java.io.*;

public class Cineplex implements Serializable{
	
	private String cineplexName;
	private ArrayList cinema = new ArrayList();
	
	public Cineplex() {}
	
	public Cineplex(String cineplexName, ArrayList cinema){
		this.cineplexName = cineplexName;
		this.cinema = cinema;		
	}
	
	public String getCineplexName(){
		return cineplexName;
	}
	
	public ArrayList getCinema(){
		return cinema;
	}
}
