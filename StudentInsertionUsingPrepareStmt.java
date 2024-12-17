package com.databasemanagement.studentportal;

import java.sql.*;

import java.io.*;

public class StudentInsertionUsingPrepareStmt {

	public static void main(String[] args) throws IOException
	{
		String stdid,stdname,standard;
		int age,roll;
		/*---- Input of data Using BufferedReader class -----*/
		/*--- Creating object of BufferedReader class ------*/
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		/*---- Input of student id -----*/
		System.out.print("Enter student id : ");
		stdid= br.readLine();
		/*---- Input of student name -----*/
		System.out.print("Enter Name : ");
		stdname = br.readLine();
		/*---- Input of standard --------*/
		System.out.print("Enter standard : ");
		standard = br.readLine();
		/*---- Input of age -----*/
		System.out.print("Enter age(in year) : ");
		age = Integer.parseInt(br.readLine());
		/*---- Input of roll number -----*/
		System.out.print("Enter roll number : ");
		roll = Integer.parseInt(br.readLine());
		System.out.println("--------------------------------------");
		try
		{
			//To register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//to create connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/anudip","root","123456");
			//to create statement
			PreparedStatement stmt = con.prepareStatement("insert into student values(?,?,?,?,?)");
			/*--- to set data into parameter ------*/
			stmt.setString(1, stdid);
			stmt.setString(2, stdname);
			stmt.setString(3, standard);
			stmt.setInt(4, roll);
			stmt.setInt(5, age);
			/*---------------------------------------*/
			/*--- to execute the query -----*/
			int row = stmt.executeUpdate();
			if(row > 0)
			{
				System.out.println("Student successfully inserted into table");
			}
			else
			{
				System.out.println("Unable to insert srudent data");
			}
			//close the connection
			con.close();
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println(ce);
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
	}

}
