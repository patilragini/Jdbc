package com.bridgelabz.program;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

public class JdbcDbInsert {

	public static void main(String args[]) throws ClassNotFoundException, NumberFormatException, IOException {
		Connection con = null;
		Statement stmnt = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded & Rrgisterd");

			String URL = "jdbc:mysql://localhost:3306/mydatabase";
			String USER = "root";
			String PASS = "root";
			con = DriverManager.getConnection(URL, USER, PASS);
			stmnt = con.createStatement();
			System.out.println("cannection estabilished!!!");
			// System.out.println("prepared statements place holder");

			PreparedStatement prestate = (PreparedStatement) con.prepareStatement("insert into emp values(?,?,?,?)");
			FileInputStream fin = new FileInputStream("/home/bridgeit/Pictures/img.png");
			prestate.setInt(1, 11);
			prestate.setString(2, "abc");
			prestate.setInt(3, 19);
			prestate.setBinaryStream(4, fin, fin.available());

			int i = prestate.executeUpdate();
			System.out.println(i + " records affected");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (stmnt != null)
					stmnt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
	}

}