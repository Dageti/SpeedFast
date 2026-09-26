package cl.app;

import cl.dao.ConnectionDB;

import java.sql.SQLException;
import java.sql.Connection;


public class Main {
	public static void main(String[] args) {
		System.out.println("test conexión a bd");
		try (Connection conexion = ConnectionDB.conectar()) {
			if (conexion != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.err.println("Error al conectar con db: " + e.getMessage());
		}

	}
}