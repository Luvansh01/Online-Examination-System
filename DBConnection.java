package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBConnection {
	 private static final String url="jdbc:mysql://localhost:3306/users";
	    private static final String username="root";
	    private static final String password="Ansh@2389";

	    public static void main(String[] args){
	   
	        try{
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Drivers Loaded Successfully!");
	        }catch(Exception e){
	            e.getMessage();
	        }
	        try{
	            System.out.println("Connection Established Successfully.");
	         
	        }catch(Exception e1) {
	        	e1.printStackTrace();	
	        }
	   }
}
