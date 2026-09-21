package cl.services;

import cl.interfaces.Rastreable;
import cl.model.*;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Rastreable {
	private final List<Pedido> listaPedidos;

	public ControladorDeEnvios() {
		this.listaPedidos = new ArrayList<>();
		listaPedidos.add(new PedidoComida("001", "Tangamandapio 213", 5.0));
		listaPedidos.add(new PedidoEncomienda("002", "Titirilquen 23", 8.0));
		listaPedidos.add(new PedidoExpress("003", "Alto Jahuel 333", 2.0));
	}

	public void registrarPedido(Pedido pedido) {
		this.listaPedidos.add(pedido);
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public int asignarRepartidores() {
		int asignados = 0;
		for (Pedido p : listaPedidos) {
			if ("pendiente".equalsIgnoreCase(p.getEstadoPedido())) {
				p.asignarRepartidor();
				asignados++;
			}
		}
		return asignados;
	}

	public int simularEntregas() {
		int entregados = 0;
		for (Pedido p : listaPedidos) {
			if ("repartidor asignado".equalsIgnoreCase(p.getEstadoPedido()) ||
					"en reparto".equalsIgnoreCase(p.getEstadoPedido())) {
				p.setEstadoPedido("Entregado");
				entregados++;
			}
		}
		return entregados;
	}

	@Override
	public void verHistorial() {
		for (Pedido pedido : listaPedidos) {
			String tipoPedido = pedido.getTipo();
			System.out.println("Pedido: " + pedido.getIdPedido() + ", Tipo: " + tipoPedido + ", Repartidor: " + pedido.getRepartidorAsignado() + ", Estado: " + pedido.getEstadoPedido());
		}
	}
}