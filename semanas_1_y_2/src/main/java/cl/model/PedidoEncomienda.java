package cl.model;

/**
 * Subclase de Pedido que representa una encomienda.
 * Hereda de {@link Pedido}
 */
public class PedidoEncomienda extends Pedido {
	public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}

	@Override
	public int calcularTiempoEntrega() {
		return (int) (20 + (1.5 * (distanciaKm)));
	}
}
