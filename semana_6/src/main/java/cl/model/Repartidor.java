package cl.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Clase representa a un repartidor y sus entregas.
 * Implementa Runnable para funcionar como hilo independiente.
 */

public class Repartidor implements Runnable {
	private String nombre;
	private List<Pedido> pedidosAsignados;

	public Repartidor(String nombre) {
		this.nombre = nombre;
		pedidosAsignados = new ArrayList<>();
	}

	public Repartidor(String nombre, List<Pedido> pedidosAsignados) {
		this.nombre = nombre;
		this.pedidosAsignados = pedidosAsignados != null ? new ArrayList<>(pedidosAsignados) : new ArrayList<>();
	}

	/**
	 * Metodo encargado de agregar un pedido a la cola del repartidor.
	 *
	 * @param pedido Pedido agregado.
	 */
	public void agregarPedido(Pedido pedido) {
		if (pedido != null) {
			pedido.setRepartidorAsignado(this.nombre);
			pedido.setEstadoPedido("asignado a repartidor");
			this.pedidosAsignados.add(pedido);
		}
	}

	@Override
	public void run() {
		System.out.println("Repartidor " + nombre + " inicia su ruta con " + pedidosAsignados.size() + " pedidos asignados");
		for (Pedido pedido : pedidosAsignados) {
			String tipoPedido = pedido.getClass().getSimpleName();

			System.out.println("Repartidor: " + nombre + " -  entregando - " + tipoPedido + " - ID del pedido: " + pedido.getIdPedido() + " - Dirección de entrega: " + pedido.getDireccionEntrega());

			int tiempoEntregaRandom = ThreadLocalRandom.current().nextInt(1000, 5000);

			try {
				Thread.sleep(tiempoEntregaRandom);
				pedido.setEstadoPedido("Entregado");
				System.out.println("Repartidor: " + nombre + " entregó pedido " + pedido.getIdPedido() + " con éxito.");
			} catch (InterruptedException e) {
				System.out.println("Repartidor: " + nombre + ". Entrega " + pedido.getIdPedido() + " fue interrumpida");
				Thread.currentThread().interrupt();
				break;
			}
		}
		System.out.println("Repartidor: " + nombre + " finalizo todas sus entregas.");
	}

	/**
	 * Getters y Setters
	 */
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Pedido> getPedidosAsignados() {
		return pedidosAsignados;
	}

	public void setPedidosAsignados(List<Pedido> pedidosAsignados) {
		this.pedidosAsignados = pedidosAsignados;
	}
}
