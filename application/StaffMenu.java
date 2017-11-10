package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import system.*;
import database.SerializeDB;

public class StaffMenu {
	
	int choice;
	
	Scanner sc = new Scanner(System.in);
	
	public boolean authenticate(){

		System.out.print("Enter Login ID: ");
		String id = sc.nextLine();
		System.out.print("Enter Password: ");
		String pw = sc.nextLine();
		
		try{
			ArrayList list = new ArrayList();		
			
			list = (ArrayList) SerializeDB.readSerializedObject("Staff.ser");
			
			for(int i=0;i<list.size();i++){
				Staff s = (Staff)list.get(i);

				if(s.getStaffID().equals(id)){
					if(s.getPassword().equals(pw)){
						return true;
					}
				}
			}
		}
		catch (Exception e ) {
			System.out.println( "Exception >> " + e.getMessage() );
		}
		
		return false;
	}
	
	public void showMenu(){
		
		do {
			System.out.println("=====================================");
			System.out.println("|1. Add Movies                      |");
			System.out.println("|2. Update Details of Movies        |");
			System.out.println("|3. Generate Sale Report            |");
			System.out.println("|5. Staff Logout                    |");
			System.out.println("=====================================");
		} while (choice < 4 && choice >= 1);
	}
}
