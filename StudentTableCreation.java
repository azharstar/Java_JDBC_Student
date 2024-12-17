package com.databasemanagement.studentportal;

import java.sql.*;

public class StudentTableCreation {
	public static void main(String[] args) {
		// Register MySql Driver
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//to establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip","root","123456");
			// to create a statement 
			Statement stmt = con.createStatement();
			// to execute query for table creation
			stmt.execute("Create table Student(stdId varchar(10) Primary key,stdname varchar(20) Not Null)");
			System.out.println("Table Created Successfully..");
			// to close the connection
			con.close();
		}
		catch(ClassNotFoundException ce) {
			System.out.println(ce);
		}
		catch(SQLException se) {
			System.out.println(se);
		}
	}

}
