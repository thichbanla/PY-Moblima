package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import database.SerializeDB;
import entity.*;

public class Login {

	private boolean status = false;
	private String id;
	private String pw;
	private String userType;
	int choice;
	Scanner sc = new Scanner(System.in);

	public Login(String userType) {
		this.userType = userType;
	}

	// public MovieGoer(String name, String email, int contact){
	// super(name, contact, email);

	@SuppressWarnings("unchecked")
	public boolean authenticate() {

		try {
			while (!this.status) {
				System.out.print("Enter Login ID: ");
				id = sc.nextLine();
				System.out.print("Enter Password: ");
				pw = sc.nextLine();

				ArrayList<Person> list = new ArrayList<>();

				if (userType == "staff") {
					list = (ArrayList<Person>) SerializeDB.readSerializedObject("Staff.ser");
				} else if (userType == "movie-goer") {
					list = (ArrayList<Person>) SerializeDB.readSerializedObject("MovieGoer.ser");
				}

				for (Person p : list) {
					if (p.getID().equals(id) && p.getPW().equals(pw)) {
						System.out.println("Login Successful");
						System.out.println();
						this.status = true;
						return true;
					}
				}
				System.out.println("Incorrect ID or Password");
				this.status = false;

			}
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}

		return false;
	}

}