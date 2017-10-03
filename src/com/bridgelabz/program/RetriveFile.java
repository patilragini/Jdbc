package com.bridgelabz.program;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.jdbc.Clob;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class RetriveFile {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Scanner scanner = new Scanner(System.in);
		Class.forName("com.mysql.jdbc.Driver");
		String URL = "jdbc:mysql://localhost:3306/mydatabase";
		String USER = "root";
		String PASS = "root";
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from emp where id=300");
		ResultSet res = (ResultSet) pst.executeQuery();
		res.next(); // move the pointer first row

		Clob c1 = (Clob) res.getClob(5); //5 is column number
		
		Reader r1 = c1.getCharacterStream();

		FileWriter fw = new FileWriter("/home/bridgeit/Pictures/Wallpapers/File.txt");

		int k;
		while ((k = r1.read()) != -1) {
			fw.write((char) k);
		}
		System.out.println("retive done!!!");
		fw.close();
		res.close();
		con.close();
		scanner.close();
		

	}
}
