package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUser {
    public boolean updateUser(String user,String newEmail, String newPhone, String newPassword) {
        boolean isUpdated = false;
        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TIU", "root", "Ansh@2389");

            // Prepare the SQL statement
            String sql = "UPDATE USERS SET EMAIL=?, PHONE=?, PASSWORD=? WHERE  USER_NAME=?";
            pstmt = connection.prepareStatement(sql);
            
            pstmt.setString(1, newEmail);
            pstmt.setString(2, newPhone);
            pstmt.setString(3, newPassword);
            pstmt.setString(4, user);

            // Execute the update
            int recordUpdate = pstmt.executeUpdate();
            if (recordUpdate > 0) 
                isUpdated = true;

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

        return isUpdated;
    }
}