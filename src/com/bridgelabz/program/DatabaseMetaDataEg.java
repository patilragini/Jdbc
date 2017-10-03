/**
 * purpose: Database Meta Data 
 * @author ragini
 */package com.bridgelabz.program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.DatabaseMetaData;

public class DatabaseMetaDataEg {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
System.out.println("Jdbc Database Meta Data");
Class.forName("com.mysql.jdbc.Driver");
String URL = "jdbc:mysql://localhost:3306/mydatabase";
String USER = "root";
String PASS = "root";
Connection con=DriverManager.getConnection(URL,USER,PASS);
DatabaseMetaData dmd=(DatabaseMetaData) con.getMetaData();
System.out.println("Driver name: "+dmd.getDriverName());
System.out.println("Driver version: "+dmd.getDriverMajorVersion());
System.out.println("Driver major version: "+dmd.getDriverMajorVersion());
System.out.println("Driver  URL: "+dmd.getURL());
System.out.println("Driver Name of db: "+dmd.getUserName());
System.out.println("Driver ProductNmae: "+dmd.getDatabaseProductName());


	}

}
