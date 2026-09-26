package cl.dao;

import cl.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO {

	public boolean guardar(Pedido pedido) {
		String sql = "INSERT INTO pedido (direccion, tipo, estado) VALUES (?, ?, ?)";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			pst.setString(1, pedido.getDireccionEntrega());
			pst.setString(2, pedido.getTipo());
			pst.setString(3, pedido.getEstadoPedido());

			int filas = pst.executeUpdate();
			if (filas > 0) {
				try (ResultSet rs = pst.getGeneratedKeys()) {
					if (rs.next()) {
						pedido.setIdPedido(String.valueOf(rs.getInt(1)));
					}
				}
				return true;
			}
		} catch (SQLException e) {
			System.err.println("Error al guardar pedido: " + e.getMessage());
		}
		return false;
	}

	public List<Pedido> listarTodos() {
		List<Pedido> lista = new ArrayList<>();
		String sql = "SELECT id, direccion, tipo, estado FROM pedido ORDER BY id ASC";

		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql);
		     ResultSet rs = pst.executeQuery()) {

			while (rs.next()) {
				String id = String.valueOf(rs.getInt("id"));
				String direccion = rs.getString("direccion");
				String tipo = rs.getString("tipo");
				String estado = rs.getString("estado");

				Pedido p;
				if ("Comida".equalsIgnoreCase(tipo)) {
					p = new PedidoComida(id, direccion, 5.0);
				} else if ("Encomienda".equalsIgnoreCase(tipo)) {
					p = new PedidoEncomienda(id, direccion, 8.0);
				} else {
					p = new PedidoExpress(id, direccion, 3.0);
				}
				p.setEstadoPedido(estado);
				lista.add(p);
			}
		} catch (SQLException e) {
			System.err.println("Error al listar los pedidos: " + e.getMessage());
		}
		return lista;
	}

	public boolean actualizarEstado(String idPedido, String nuevoEstado) {
		String sql = "UPDATE pedido SET estado = ? WHERE id = ?";
		try (Connection connection = ConnectionDB.conectar();
		     PreparedStatement pst = connection.prepareStatement(sql)) {

			pst.setString(1, nuevoEstado);
			pst.setInt(2, Integer.parseInt(idPedido));
			return pst.executeUpdate() > 0;
		} catch (SQLException e) {
			System.err.println("Error al actualizar estado: " + e.getMessage());
		}
		return false;
	}
}