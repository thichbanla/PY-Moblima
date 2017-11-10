package system;
import java.io.*;

public class Movie implements Serializable {

	private String movieName;
	private String movieType;
	private String movieLength;
	//private ShowTime 
	private String movieRating;
	private long movieRevenue;
	private String movieStatus;
	
	public Movie(){
	}
	
	public Movie(String name, String type, String rate, String length, String status){
		
		movieName = name;
		movieType = type;
		movieRating = rate;
		movieLength = length;
		movieRevenue = 0;
		setMovieStatus(status);
		
	}
	
	//All the gets methods
	public String getMovieName(){
		return movieName;
	}
	public String getMovieType(){
		return movieType;
	}
	public String getMovieLength(){
		return movieLength;
	}
	
	public long getMovieRevenue(){
		return movieRevenue;
	}
	
	public String getRating(){
		return movieRating;
	}
	
	//All the set methods
	public void setMovieName(String name){
		movieName = name;
	}
	
	public void setMovieType(String type){
		movieType = type;
	}
	
	public void setMovieRating(String rate){
		movieRating = rate;
	}
	
	public void setMovieLength(String length){
		movieLength = length;
	}

	public String getMovieStatus() {
		return movieStatus;
	}

	public void setMovieStatus(String movieStatus) {
		this.movieStatus = movieStatus;
	}
	
	public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie p = (Movie)o;
			return (getMovieName().equals(p.getMovieName()));
		}
		return false;
	}
}