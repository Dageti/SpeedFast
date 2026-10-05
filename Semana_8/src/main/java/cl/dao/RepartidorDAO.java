package cl.dao;

import cl.model.Repartidor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

	public boolean guardarRepartidor(Repartidor repartidor) throws SQLException {
		String sql = "INSERT INTO repartidor (nombre) VALUES (?)";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, repartidor.getNombre());
			int filas = pst.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = pst.getGeneratedKeys()) {
					if (rs.next()) {
						repartidor.setId(rs.getInt(1));
					}
				}
				return true;
			}
		}
		return false;
	}

	public List<Repartidor> listarTodos() throws SQLException {
		List<Repartidor> lista = new ArrayList<>();
		String sql = "SELECT id, nombre FROM repartidor ORDER BY id ASC";

		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql);
		     ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				Repartidor r = new Repartidor(rs.getInt("id"), rs.getString("nombre"));
				lista.add(r);
			}
		}
		return lista;
	}
}