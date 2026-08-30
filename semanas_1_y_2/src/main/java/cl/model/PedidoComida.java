package cl.model;

/**
 * Subclase de Pedido, representa un pedido de comida.
 * Hereda de {@link Pedido}
 */
public class PedidoComida extends Pedido {
	public PedidoComida(String idPedido, String direccionEntrega, double distanciaKM) {
		super(idPedido, direccionEntrega, distanciaKM);

	}

	@Override
	public int calcularTiempoEntrega() {
		return (int) (15 + (2 * (distanciaKm)));
	}
}



