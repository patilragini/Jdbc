package com.bridgelabz.program;

import java.sql.*;

class Jdbc {
	public static void main(String args[]) throws ClassNotFoundException {
		Connection con = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded & Rergisterd");
			String URL="jdbc:mysql://localhost:3306";
			String USER="root";
			String PASS="root";
			con = DriverManager.getConnection(URL,USER,PASS);
			System.out.println("connection established");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
		}
	}
}