package pkg_airline_management_system;

//Encapsulation class

public class Passenger {

	private int id;
	private String firstName;
	private String surName;
	private String telephone;
	private String email;
	
	public Passenger () {}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId () {
		return id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setSurName(String surName) {
		this.surName = surName;
	}
	
	public String getSurName() {
		return surName;
	}
	
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String getTelephone() {
		return telephone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}
	
}
