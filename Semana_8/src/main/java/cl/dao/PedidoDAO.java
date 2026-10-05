package cl.dao;

import cl.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

	public boolean guardar(Pedido pedido) throws SQLException {
		String sql = "INSERT INTO pedido (direccion, tipo, estado, distancia_km) VALUES (?, ?, ?, ?)";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pedido.getDireccionEntrega());
			pst.setString(2, pedido.getTipo());
			pst.setString(3, pedido.getEstadoPedido());
			pst.setDouble(4, pedido.getDistanciaKm());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = pst.getGeneratedKeys()) {
					if (rs.next()) {
						pedido.setIdPedido(String.valueOf(rs.getInt(1)));
					}
				}
				return true;
			}
		}
		return false;
	}

	public List<Pedido> listarTodos() throws SQLException {
		List<Pedido> lista = new ArrayList<>();
		String sql = "SELECT p.id, p.direccion, p.tipo, p.estado, p.distancia_km, r.nombre AS repartidor " +
				"FROM pedido p " +
				"LEFT JOIN entrega e ON p.id = e.id_pedido " +
				"LEFT JOIN repartidor r ON e.id_repartidor = r.id " +
				"ORDER BY p.id ASC";

		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql);
		     ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String direccion = rs.getString("direccion");
				String tipo = rs.getString("tipo");
				String estado = rs.getString("estado");
				double distancia = rs.getDouble("distancia_km");
				String repartidor = rs.getString("repartidor");


				Pedido p;
				if ("Comida".equalsIgnoreCase(tipo)) {
					p = new PedidoComida(id, direccion, distancia);
				} else if ("Encomienda".equalsIgnoreCase(tipo)) {
					p = new PedidoEncomienda(id, direccion, distancia);
				} else {
					p = new PedidoExpress(id, direccion, distancia);
				}
				p.setEstadoPedido(estado);
				if (repartidor != null && !repartidor.isEmpty()) {
					p.setRepartidorAsignado(repartidor);
				}
				lista.add(p);
			}
		}
		return lista;
	}

	public boolean actualizarEstado(String idPedido, String nuevoEstado) throws SQLException {
		String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, nuevoEstado);
			pst.setInt(2, Integer.parseInt(idPedido));
			return pst.executeUpdate() > 0;
		}
	}

	public boolean eliminarPedido(String idPedido) throws SQLException {
		String sql = "DELETE FROM pedido WHERE id = ? AND estado = 'PENDIENTE'";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql)) {
			pst.setInt(1, Integer.parseInt(idPedido));
			return pst.executeUpdate() > 0;
		}
	}
}