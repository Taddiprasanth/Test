package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDataBase {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanth","root","Prasanth@200");
		Statement stmt=conn.createStatement();
		ResultSet Rs=stmt.executeQuery("SELECT * FROM friends");
		while(Rs.next()) {
			int id=Rs.getInt("idFriends");
			String name=Rs.getString("Names");
			String Place=Rs.getString("Palces");
			String Room=Rs.getString("Room");
			System.out.println(id+"\t"+name+ "  \t"+Place+"\t"+Room);
		}
	}

}
