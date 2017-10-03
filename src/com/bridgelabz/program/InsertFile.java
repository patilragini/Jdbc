package com.bridgelabz.program;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertFile {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3306/mydatabase";
		String USER = "root";
		String PASS = "root";
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		FileInputStream fin = new FileInputStream("/home/bridgeit/Pictures/addemp.png");
		File file = new File("/home/bridgeit/Pictures/Temp.txt");
		FileReader f1 = new FileReader(file);
		String sql = "insert into emp values(?,?,?,?,?)";
		java.sql.PreparedStatement ps = con.prepareStatement(sql);
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
		ps.setCharacterStream(5, f1, (int) file.length());
		int i = ps.executeUpdate();
		System.out.println(i + " records affected");
		scanner.close();

	}
}
