package com.databasemanagement.studentportal.utils;

import java.sql.*;

public class DataBaseConnectionUtils{
	private static Connection connection = null;
	static {
		try {
			/*--- Register driver for mysql ----*/
			Class.forName("com.mysql.cj.jdbc.Driver");
			// ---------------------------------------------------------------------------------
			/*---- creating variables required for establishing a connection with mysql database*/
			String url = "jdbc:mysql://localhost:3306/studentmanagent";
			String username = "root";
			String password = "123456";
			/*--------------------------------------------------------------------------*/
			/*---- Creating connection ----*/
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/*--------------------------------------------------------------------------------*/
	/*---- method to return connection ----*/
	public static Connection getConnection() {
		return connection;
	}

	/*----- Method to close the connection -----*/
	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}

