package pkg_airline_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Database {
	
	private String url = "jdbc:mysql://localhost/Airline Management System";
	private String user = "user";
	private String password = "123321";
	private Statement statement;
	
	public Database() throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, 
											ResultSet.CONCUR_READ_ONLY);
	}
	
	public void  AddPassenger(Passenger p) throws SQLException {
		String insert = "INSERT INTO `Passengers`(`id`, `firstName`, `surName`,"
				+ "`telephone`, `email`) VALUES ('"+p.getId()+"','"+p.getFirstName()+"','"+p.getSurName()+"',"
				+ "'"+p.getTelephone()+"','"+p.getEmail()+"')";
		statement.execute(insert);
	}
	
	public ArrayList<Passenger> getAllPassengers() throws SQLException {
		String get = "SELECT * FROM `Passengers`;";
		ResultSet rs = statement.executeQuery(get);
		ArrayList<Passenger> passengers = new ArrayList<>();
		
		while (rs.next()) {
			Passenger p = new Passenger();
			p.setId(Integer.parseInt(rs.getString("id")));
			p.setFirstName(rs.getString("firstName"));
			p.setSurName(rs.getString("surName"));
			p.setTelephone(rs.getString("telephone"));
			p.setEmail(rs.getString("email"));
			passengers.add(p);
		}
		
		return passengers;
	}
	
}
