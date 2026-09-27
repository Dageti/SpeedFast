package cl.services;

import cl.interfaces.Rastreable;
import cl.model.*;
import cl.dao.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Rastreable {
	private final PedidoDAO pedidoDAO;
	private final RepartidorDAO repartidorDAO;
	private final EntregaDAO entregaDAO;

	public ControladorDeEnvios() {
		this.pedidoDAO = new PedidoDAO();
		this.repartidorDAO = new RepartidorDAO();
		this.entregaDAO = new EntregaDAO();
	}

	public boolean registrarPedido(Pedido pedido) {
		return pedidoDAO.guardar(pedido);
	}

	public boolean registrarRepartidor(Repartidor repartidor) {
		return repartidorDAO.guardarRepartidor(repartidor);
	}

	public List<Pedido> getListaPedidos() {
		return pedidoDAO.listarTodos();
	}

	public List<Repartidor> getListaRepartidores() {
		return repartidorDAO.listarTodos();
	}

	public int asignarRepartidores() {
		List<Pedido> pedidos = pedidoDAO.listarTodos();
		List<Repartidor> repartidores = repartidorDAO.listarTodos();
		int asignado = 0;

		if (repartidores.isEmpty()) {
			return 0;
		}
		int index = 0;
		for (Pedido pedido : pedidos) {
			if ("PENDIENTE".equalsIgnoreCase(pedido.getEstadoPedido())) {
				Repartidor repartidor = repartidores.get(index % repartidores.size());

				pedidoDAO.actualizarEstado(pedido.getIdPedido(), "EN_REPARTO");
				pedido.setRepartidorAsignado(repartidor.getNombre());
				pedido.setEstadoPedido("EN_REPARTO");

				try {
					int idPedido = Integer.parseInt(pedido.getIdPedido());
					Entrega entrega = new Entrega(idPedido, repartidor.getId(), LocalDate.now(), LocalTime.now());
					entregaDAO.guardar(entrega);
				} catch (NumberFormatException e) {
					System.err.println("Error en ID del Pedido: " + e.getMessage());
				}
				asignado++;
				index++;
			}
		}
		return asignado;
	}

	public int simularEntregas() {
		int entregados = 0;
		List<Pedido> pedidos = pedidoDAO.listarTodos();
		for (Pedido p : pedidos) {
			if ("EN_REPARTO".equals(p.getEstadoPedido()) || "repartidor asignado".equalsIgnoreCase(p.getEstadoPedido())) {
				pedidoDAO.actualizarEstado(p.getIdPedido(), "ENTREGADO");
				p.setEstadoPedido("ENTREGADO");
				entregados++;
			}
		}
		return entregados;
	}

	@Override
	public void verHistorial() {
		for (Pedido pedido : getListaPedidos()) {
			String tipoPedido = pedido.getTipo();
			System.out.println("Pedido: " + pedido.getIdPedido() + ", Tipo: " + tipoPedido + ", Estado: " + pedido.getEstadoPedido());
		}
	}
}

