/**
 * purpose: (RESULT SET META DATA)prints table from database in table format
 * @author ragini
 */

package com.bridgelabz.program;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class ResultSetMetaDataEg {

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

			String sql = "select * from emp";
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnLabel(i + 1) + "\t");
			}
			System.out.println("\n______________________________________");
			while (rs.next()) {
				System.out.println(
						rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4));
			}
		
			System.out.println("table nmae:"+rsmd.getTableName(1));
			System.out.println("Details of column:");
			System.out.println("total number of column  in table:"+rsmd.getColumnCount());
			System.out.println("1: "+rsmd.getColumnType(1)+"\t"+rsmd.getColumnTypeName(1)+"\t"+rsmd.getCatalogName(1));
			System.out.println("2: "+rsmd.getColumnType(2)+"\t"+rsmd.getColumnTypeName(2)+"\t"+rsmd.getColumnName(2));
			System.out.println("3: "+rsmd.getColumnType(3)+"\t"+rsmd.getColumnTypeName(3)+"\t"+rsmd.getColumnName(3));
			System.out.println("4: "+rsmd.getColumnType(4)+"\t"+rsmd.getColumnTypeName(4)+"\t"+rsmd.getColumnName(4));
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
