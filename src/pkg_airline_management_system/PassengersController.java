package pkg_airline_management_system;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengersController {
	
	public static void AddNewPassenger(Database database, Scanner sc) throws SQLException {
		System.out.println("Enter your first name: ");
		String firstName = sc.next();
		
		System.out.println("Enter your last name: ");
		String surName = sc.next();
		
		System.out.println("Enter your telephone number: ");
		String telephone = sc.next();
		
		System.out.println("Enter your email address: ");
		String email = sc.next();
		
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(firstName);
		passenger.setSurName(surName);
		passenger.setTelephone(telephone);
		passenger.setEmail(email);
		ArrayList<Passenger> passengers = database.getAllPassengers();
		
		int id;
		if (passengers.size() != 0) {
			id = passengers.get(passengers.size()-1).getId()+1;
		} else {
			id = 0;
		}
		passenger.setId(id);
		database.AddPassenger(passenger);
		System.out.println("Passenger added successfully!");
	}
	
}
