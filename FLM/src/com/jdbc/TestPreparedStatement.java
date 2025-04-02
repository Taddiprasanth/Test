package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestPreparedStatement {

	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/prasanth";
		String user="root";
		String password="Prasanth@200";
		String sql="insert into student values(?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Error"+e.getMessage());
		}
		try(Connection con=DriverManager.getConnection(url, user, password);
				PreparedStatement prestm=con.prepareStatement(sql);
				Scanner scan=new Scanner(System.in);){
			for(int i=1;i<=5;i++) {
				System.out.print("Enter id :");
				int id=scan.nextInt();
				System.out.print("Enter name :");
				String name=scan.next();
				System.out.print("Enter markes :");
				int marks=scan.nextInt();
				System.out.println("Enter grade :");
				String grade=scan.next();
				System.out.print("Enter mobile :");
				String mobile=scan.next();
				prestm.setInt(1, id);
				prestm.setString(2, name);
				prestm.setInt(3, marks);
				prestm.setString(4, grade);
				prestm.setString(5,mobile);
				prestm.addBatch();
			}
			int[] a=prestm.executeBatch();
			System.out.println(a.length+" Student data is insert is successful ");
		} catch (SQLException ex) {
			System.out.println("Error"+ex.getMessage());
		}

	}

}
