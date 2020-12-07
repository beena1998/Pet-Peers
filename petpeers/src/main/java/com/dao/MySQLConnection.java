package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/petsdb?autoReconnect=true&useSSL=false";
			Class.forName(driverName);
			con = DriverManager.getConnection(url, "root", "root");
			System.out.println(con != null ? "connection established" : "connection failed");
			
		} catch (ClassNotFoundException cnfe) {
			System.out.println("There is no respective jars : " + cnfe.getMessage());
		} catch (SQLException se) {// Catching SQL Exception
			System.out.println("SQL Exception :" + se.getMessage());
		} catch (Exception e) {
			System.out.println(e);
		}

	/*	finally {
			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} */
		
	}
}