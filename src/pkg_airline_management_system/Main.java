package pkg_airline_management_system;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws SQLException {
		
		Database database = new Database();
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		do {
			System.out.println("Welcome to Airline Management System");
			System.out.println("1. Add new passenger");
			System.out.println("2. Quit");
			
			i = sc.nextInt();
			switch (i) {
			case 1:
				PassengersController.AddNewPassenger(database, sc);
				break;
			}
		} while (i!=2);
		
	}

}
