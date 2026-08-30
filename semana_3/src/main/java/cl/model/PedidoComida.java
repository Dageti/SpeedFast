package cl.model;

import cl.interfaces.Cancelable;
import cl.interfaces.Despachable;
import cl.interfaces.Rastreable;

/**
 * Subclase de Pedido, representa los pedidos de comida.
 * implementa interfaces Despachable, Cancelable y Rastreable.
 */
public class PedidoComida extends Pedido implements Despachable, Cancelable, Rastreable {
	public PedidoComida(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}

	@Override
	public void asignarRepartidor() {
		this.repartidorAsignado = "Cosme Fulanito";
		this.estadoPedido = "Repartidor asignado";
	}

	@Override
	public int calcularTiempoEntrega() {
		return (int) (15 + (2 * distanciaKm));
	}

	@Override
	public void despachar() {
		System.out.println("Despachando");
		System.out.println("...........");
		this.estadoPedido = "Despachado";
		System.out.println("Pedido despachado exitosamente.");
	}

	@Override
	public void cancelar() {
		System.out.println("Cancelando");
		System.out.println("...........");
		this.estadoPedido = "Cancelado";
		System.out.println("Pedido cancelado exitosamente.");
	}

	@Override
	public void verHistorial() {
		System.out.println("Pedido: " + idPedido + "| Estado: " + estadoPedido + "Repartidor asignado" + repartidorAsignado);
	}

	@Override
	public void mostrarResumen() {
		System.out.println("Pedidos de comida");
		super.mostrarResumen();
	}
}
