package pkg_airline_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
    
    private final String url = "jdbc:mysql://localhost:3306/airline_db";
    private final String user = "user";
    private final String password = "123321"; 
    private Connection connection;
    
    public Database() throws SQLException {
        this.connection = DriverManager.getConnection(url, user, password);
    }
    
    public void addPassenger(Passenger p) throws SQLException {
        String sql = "INSERT INTO `Passengers` (`firstName`, `surName`, `telephone`, `email`) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, p.getFirstName());
            pstmt.setString(2, p.getSurName());
            pstmt.setString(3, p.getTelephone());
            pstmt.setString(4, p.getEmail());
            
            pstmt.executeUpdate();
        }
    }
    
    public ArrayList<Passenger> getAllPassengers() throws SQLException {
        String sql = "SELECT * FROM `Passengers`";
        ArrayList<Passenger> passengers = new ArrayList<>();

        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            while (rs.next()) {
                Passenger p = new Passenger();

                p.setId(rs.getInt("id"));
                p.setFirstName(rs.getString("firstName"));
                p.setSurName(rs.getString("surName"));
                p.setTelephone(rs.getString("telephone"));
                p.setEmail(rs.getString("email"));
                
                passengers.add(p);
            }
        }
        
        return passengers;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o banco: " + e.getMessage());
        }
    }
}