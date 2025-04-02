package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Friends {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error " + ex.getMessage());
		}
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/prasanth", "root",
				"Prasanth@200"); Statement stm = conn.createStatement(); 
				Scanner scan = new Scanner(System.in);) {
			/*for (int i = 0; i <= 1; i++) {
				System.out.print("Enter the idFriends :");
				int id = scan.nextInt();
				System.out.print("Enter the Names :");
				String name = scan.next();
				System.out.print("Enter the Place :");
				String place = scan.next();
				System.out.print("Enter the Room :");
				String room = scan.next();
				String seql = "insert into friends values(" + id + ",'" + name + "','" + place + "','" + room + "')";
				System.out.println(seql);
				stm.executeUpdate(seql);
			}*/
			String sql="DELETE from friends Where idFriends=2";
			System.out.println(sql);
		} catch (SQLException ex) {
			System.out.println("Error" + ex.getMessage());
		}
	}
}
