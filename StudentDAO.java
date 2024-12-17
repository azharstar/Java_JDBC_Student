package com.databasemanagement.studentportal.dao;

import java.sql.*;

import com.databasemanagement.studentportal.entities.Student;

public class StudentDAO {       //DAO ="Data Access Object"
	public int insertStudent(Connection conObj,Student student) {
		int row = 0;
		try {
			if(conObj != null) {
				// Creating PreparedStatement
				PreparedStatement stmt = conObj.prepareStatement("insert(into student values(?,?,?,?,?,?)");
				//------------------------------------------------------------------------------------
				// Setting data into prepared statement
				stmt.setString(1, student.getStdId());
				stmt.setString(2, student.getStdName());
				stmt.setString(3, student.getStandard());
				stmt.setInt(4, student.getRoll());
				stmt.setInt(5, student.getAge());
				stmt.setString(6, student.getAddress());
				//----------------------------------------------------------------
				// To execute query 
				row = stmt.executeUpdate();
				return row;
			}
			else {
				return row;
			}
		}
		catch (SQLException e) {
			System.out.println(e);
			return row;
		}
	}
}
