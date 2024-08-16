package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterUser {
    public boolean registerUser(String user, String batch, String name, String email, String phone, String password) {
        boolean isRegistered = false;
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TIU", "root", "Ansh@2389");

            // Prepare the SQL statement
            String sql = "INSERT INTO USERS (USER_NAME, BATCH, NAME, EMAIL, PHONE, PASSWORD) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, batch);
            pstmt.setString(3, name);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setString(6, password);

            // Execute the update
            int recordUpdate = pstmt.executeUpdate();
            if (recordUpdate > 0) {
                isRegistered = true;
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close resources: " + e.getMessage());
            }
        }

        return isRegistered;
    }
}
