/**
 * purpose: Insert image from data base
 * @author ragini
 */
package com.bridgelabz.program;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class ImageInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
		con.setAutoCommit(false);
		Scanner scanner = new Scanner(System.in);
		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement("insert into emp values(?,?,?,?)");
			FileInputStream fin = new FileInputStream("/home/bridgeit/Pictures/addemp.png");
			System.out.println("enter id:");
			int id = scanner.nextInt();
			ps.setInt(1, id);
			System.out.println("enter name:");
			String name = scanner.next();
			ps.setString(2, name);
			System.out.println("enter age: ");
			int age = scanner.nextInt();
			ps.setInt(3, age);
			ps.setBinaryStream(4, fin, fin.available());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");
			con.commit();
			con.close();
			fin.close();
			scanner.close();
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
		}
	}
}
