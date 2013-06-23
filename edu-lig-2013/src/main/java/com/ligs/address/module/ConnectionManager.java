package com.ligs.address.module;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(ClassNotFoundException e) {
			throw new RuntimeException(e);
		}

		String url = "jdbc:oracle:thin:@10.13.0.33:1521:orcl";
		String username = "gramer";
		String password = "gramer2188";

		return DriverManager.getConnection(url, username, password);
	}

}
