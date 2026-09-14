package cl.service;

import cl.model.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Encargado de almacenar la lista de pedidos pendientes, protegida mediante synchronized.
 */

public class ZonaDeCarga {
	private final List<Pedido> pedidosPendientes;

	public ZonaDeCarga() {
		this.pedidosPendientes = new ArrayList<>();
	}

	/**
	 * Agrega un pedido a la lista.
	 *
	 * @param pedido Pedido a agregar.
	 */
	public synchronized void agregarPedido(Pedido pedido) {
		if (pedido != null) {
			pedidosPendientes.add(pedido);
			System.out.println("pedido #" + pedido.getId() + " agregado. Dirección: " + pedido.getDireccion());
		}
	}

	/**
	 * Retira primer pedido de la lista.
	 */
	public synchronized Pedido retirarPedido() {
		if (pedidosPendientes.isEmpty()) {
			return null;
		}
		return pedidosPendientes.remove(0);
	}


	/**
	 * Verifica si quedan pedidos en la lista.
	 *
	 * @return true si esta vacía.
	 */
	public synchronized boolean hayPedidos() {
		return !pedidosPendientes.isEmpty();
	}

	/**
	 * Verifica la cantidad de pedidos restantes.
	 *
	 * @return cantidad de pedidos en la cola.
	 */
	public synchronized int cantidadPedidosRestantes() {
		return pedidosPendientes.size();
	}
}
