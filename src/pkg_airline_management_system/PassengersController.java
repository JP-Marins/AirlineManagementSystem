package pkg_airline_management_system;

import java.sql.SQLException;
import java.util.Scanner;

public class PassengersController {
	
	public static void AddNewPassenger(Database database, Scanner sc) throws SQLException {
		System.out.println("Enter your first name: ");
		String firstName = sc.nextLine();
		
		System.out.println("Enter your last name: ");
		String surName = sc.nextLine();
		
		System.out.println("Enter your telephone number: ");
		String telephone = sc.nextLine();
		
		System.out.println("Enter your email address: ");
		String email = sc.nextLine();
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(firstName);
		passenger.setSurName(surName);
		passenger.setTelephone(telephone);
		passenger.setEmail(email);
		
		database.addPassenger(passenger);
		System.out.println("Passenger added successfully!");
	}
	
}
