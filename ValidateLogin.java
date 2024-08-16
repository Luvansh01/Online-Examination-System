package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ValidateLogin {

    public boolean checkLogin(String user, String pass) {
        boolean isValid = false;
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/TIU", "root", "Ansh@2389");

            // Prepare the SQL statement
            String sql = "SELECT USER_NAME FROM USERS WHERE USER_NAME=? AND PASSWORD=?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);

            // Execute the query
            rs = pstmt.executeQuery();
            
            // Check if any record is returned
            if (rs.next()) {
                isValid = true;
            }

        } catch (ClassNotFoundException e) {
            System.err.println("Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("SQL exception: " + e.getMessage());
        } finally {
            // Close resources
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close resources: " + e.getMessage());
            }
        }

        return isValid;
    }
}
