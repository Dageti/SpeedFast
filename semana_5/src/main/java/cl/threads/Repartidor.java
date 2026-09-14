package cl.threads;

import cl.model.EstadoPedido;
import cl.model.Pedido;
import cl.service.ZonaDeCarga;


/**
 * Representa al repartidor como agente concurrente.
 * <p>
 * Permite el comportamiento como hilos independientes sincronizados para simular las entregas de SpeedFast
 */
public class Repartidor implements Runnable {
	private final String nombre;
	private final ZonaDeCarga zonaDeCarga;

	/**
	 *  Constructor que instancia un repartidor con su zona de carga.
	 * @param nombre Nombre del repartidor.
	 * @param zonaDeCarga Instancia a compartir con otros repartidores.
	 */
	public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
		this.nombre = nombre;
		this.zonaDeCarga = zonaDeCarga;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * Ejecucuion en hilos.
	 *
	 * Permite el retiro compartido desde zona de carga pero con exclusividad para cada pedido, garantizando unicidad en el sistema.
	 */
	@Override
	public void run() {
		while (true) {
			Pedido pedido = zonaDeCarga.retirarPedido();
			if (pedido == null) {
				break;
			}
			try {
				System.out.println("[Repartidor - " + this.nombre + "] retirando pedido #" + pedido.getId() + "...");
				pedido.setEstado(EstadoPedido.EN_REPARTO);
				System.out.println("[Repartidor - " + this.nombre + "] Estado: " + pedido.getEstado());
				System.out.println("[Repartidor - " + this.nombre + "] entregando pedido # " + pedido.getId() + "...");
				Thread.sleep(2000);
				pedido.setEstado(EstadoPedido.ENTREGADO);
				System.out.println("[Repartidor - " + this.nombre + "] Estado: " + pedido.getEstado());
			} catch (InterruptedException e) {
				System.err.println("[Repartidor - " + this.nombre + "] interrumpida entrega: " + e.getMessage());
				Thread.currentThread().interrupt();
			}
		}
	}
}
