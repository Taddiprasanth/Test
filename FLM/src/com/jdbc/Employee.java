package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanth", "root", "Prasanth@200" );
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select * from employee");
		while(rs.next()) {
			int id=rs.getInt("idEmployee");
			String first_name=rs.getString("First name");
			String last_name=rs.getString("Last Name");
			int sal=rs.getInt("Salary");
			String adress=rs.getString("Address");
			System.out.println(id+"\t"+first_name+"\t"+last_name+"\t"+sal+"\t"+adress);
		}
	}

}
