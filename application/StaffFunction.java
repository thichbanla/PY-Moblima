package application;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

import database.SerializeDB;
import entity.*;

public class StaffFunction {
	
	int option;
	
	Scanner sc = new Scanner(System.in);
	
	public static void showMenu(){
		
		System.out.println("=====================================");
		System.out.println("|1. Add Movies                      |");
		System.out.println("|2. Update Details of Movies        |");
		System.out.println("|3. Generate Sale Report            |");
		System.out.println("|5. Staff Logout                    |");
		System.out.println("=====================================");
		
	}
}
