package cl.dao;

import cl.model.Entrega;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntregaDAO {

	public boolean guardar(Entrega entrega) throws SQLException {
		String sql = "INSERT INTO entrega (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, ?, ?)";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setInt(1, entrega.getIdPedido());
			pst.setInt(2, entrega.getIdRepartidor());
			pst.setDate(3, Date.valueOf(entrega.getFecha()));
			pst.setTime(4, Time.valueOf(entrega.getHora()));

			int filas = pst.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = pst.getGeneratedKeys()) {
					if (rs.next()) {
						entrega.setId(rs.getInt(1));
					}
				}
				return true;
			}
		}
		return false;
	}
}