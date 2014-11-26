package com.px1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
	private static Connection connection;
	private static final String JDBC_DRIVER = Messages.getString("jdbc.driver"); //$NON-NLS-1$
	private static final String JDBC_URL = Messages.getString("jdbc.url"); //$NON-NLS-1$
	private static final String JDBC_USER = Messages.getString("jdbc.user"); //$NON-NLS-1$
	private static final String JDBC_PASSWORD = Messages.getString("jdbc.password"); //$NON-NLS-1$
	private DatabaseConnector(){}
	static {
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		if(connection == null) {
			try {
				connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}
}
