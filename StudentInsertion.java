package com.databasemanagement.studentportal;

import java.sql.*;
import java.io.*;

public class StudentInsertion {

	public static void main(String[] args) throws IOException {
		try {
			// to register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// to create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip","root","123456");
			// to create a statement 
			Statement stmt = con.createStatement();
			// executing insert query
			int i =stmt.executeUpdate("insert into student values('std091','Azhar')");
			if(i > 0) {
				System.out.println("Successfully inserted into table.");
			}
			else {
				System.out.println("Not Successfully inserted into table.");
			}
		}
		catch(ClassNotFoundException ce) {
			System.out.println(ce);
		}
		catch(SQLException se) {
			System.out.println(se);
		}
	}

}
