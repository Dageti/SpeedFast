package cl.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class ConnectionDB {
	private static final String URL = "jdbc:mysql://localhost:3306/speedfast_db";
	private static final String USER = "root";

	private static final String PASSWORD = "dev1";

	public static Connection conectar() throws SQLException {
		return DriverManager.getConnection(URL, USER, PASSWORD);

	}
}