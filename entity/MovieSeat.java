package entity;
import java.io.*;

public class MovieSeat implements Serializable{
	
	private int seatID;
	private String customerName;
	private boolean assigned;
	
	public MovieSeat(int seat_id) {
		seatID = seat_id;
		assigned = false;
	}
	
	public int getSeatID() {
		return seatID;
	}
	
	public String getCustomerID() {
		return customerName;
	}
	
	public boolean isOccupied() {
		return assigned;
	}
	
	public void assign(String name) {
		if (!isOccupied()) {
			customerName = name;
			assigned = true;
		}
	}
	
	public void unAssign() {
		assigned = false;
	}
}
