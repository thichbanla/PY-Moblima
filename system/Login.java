package system;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import system.*;
import database.SerializeDB;

public class Login {

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

	public boolean authenticate() {

		try {
			System.out.print("Enter Login ID: ");
			id = sc.nextLine();
			System.out.print("Enter Password: ");
			pw = sc.nextLine();

			ArrayList list = new ArrayList();

			if (userType == "staff") {
				list = (ArrayList) SerializeDB.readSerializedObject("Staff.ser");
			} else if (userType == "movie-goer") {
				list = (ArrayList) SerializeDB.readSerializedObject("MovieGoer.ser");
			}

			for (int i = 0; i < list.size(); i++) {
				Person p = (Person) list.get(i);

				if (p.getID().equals(id)) {
					if (p.getPW().equals(pw)) {
						return true;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Exception >> " + e.getMessage());
		}

		return false;
	}

}