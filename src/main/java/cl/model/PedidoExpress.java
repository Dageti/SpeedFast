package cl.model;

/**
 * Subclase de Pedido que representa un pedido de maxima prioridad
 * Hereda de {@link Pedido}
 */

public class PedidoExpress extends Pedido {
	public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}

	@Override
	public int calcularTiempoEntrega() {
		return (distanciaKm > 5) ? 15 : 10;
	}
}


