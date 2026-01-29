package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private static final String DB_URL = "jdbc:mysql://localhost/db";
    private static final String DB_USER = "root";
    private String password = "admin123";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, password);
    }

    public void findUser(String username) throws SQLException {
        String query = "SELECT id, name, email FROM users WHERE name = ?";

        try (Connection conn = getConnection();
                PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, username);
            pst.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn = getConnection();
                PreparedStatement pst = conn.prepareStatement(query)) {

            pst.setString(1, username);
            pst.executeUpdate(); 
        }
    }
}