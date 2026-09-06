package cl.service;

import cl.interfaces.Rastreable;
import cl.model.Pedido;

import java.util.ArrayList;
import java.util.List;

/**
 * Servicio encargado del manejo del historial de pedidos.
 * Implementa interfaz rastreable.
 */
public class ControladorDeEnvios implements Rastreable {
	private final List<Pedido> historialEntregas;

	public ControladorDeEnvios() {
		this.historialEntregas = new ArrayList<>();
	}

	/**
	 * Registra un pedido en el historial.
	 *
	 * @param pedido Pedido a registrar.
	 */
	public void registrarPedido(Pedido pedido) {
		this.historialEntregas.add(pedido);
	}

	@Override
	public void verHistorial() {
		for (Pedido pedido : historialEntregas) {
			String tipoPedido = pedido.getClass().getSimpleName();
			System.out.println("Pedido:" + pedido.getIdPedido() + ", Tipo pedido: " + tipoPedido + ", Repartidor: " + pedido.getRepartidorAsignado() + ", estado: " + pedido.getEstadoPedido());
		}
	}
}
