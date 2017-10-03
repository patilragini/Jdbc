/**
 * purpose: retrieve image from data base
 * @author ragini
 */
package com.bridgelabz.program;

import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.Blob;
import com.mysql.jdbc.PreparedStatement;

public class imageRetrival {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		System.out.println("jdbc image retrival!!!");
		 try {
		 Connection con = null;
		 Class.forName("com.mysql.jdbc.Driver");
		 System.out.println("Driver loaded & Rrgisterd");
		
		 String URL = "jdbc:mysql://localhost:3306/mydatabase";
		 String USER = "root";
		 String PASS = "root";
		 con = DriverManager.getConnection(URL, USER, PASS);
		 PreparedStatement ps = (PreparedStatement)
		 con.prepareStatement("select * from emp");
		 ResultSet rs = ps.executeQuery();
		 if (rs.next()) {// now on 1st row
		
		 Blob b = (Blob) rs.getBlob(4);// 2 means 2nd column data
		 byte barr[] = b.getBytes(1, (int) b.length());// 1 means first
		 // image
		
		 FileOutputStream fout = new
		 FileOutputStream("/home/bridgeit/Pictures/Wallpapers/img.png");
		 fout.write(barr);
		
		 fout.close();
		 } // end of if
		 System.out.println("ok");
		 ResultSetMetaData rsmd = rs.getMetaData();
		 for( int i = 0; i < rsmd.getColumnCount(); i++)
		    {
		      System.out.print( rsmd.getColumnLabel(i+1) + "\t");
		    }
		 System.out.println("\n______________________________________");
		 while(rs.next())
		 {
		 System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" +
		 rs.getDouble(3)+"\t"+rs.getString(4));
		 }
		
		 con.close();
		 } catch (Exception e) {
		 e.printStackTrace();
		 }
	}
}
