package cl.model;

/**
 * Subclase de Pedido que representa un pedido de maxima prioridad que debe ser despachado en la próxima ruta
 * hereda de {@link Pedido}
 */

public class PedidoExpress extends Pedido {
	public PedidoExpress(String idPedido, String direccionEntrega, String tipoPedido) {
		super(idPedido, direccionEntrega, tipoPedido);
	}

	@Override
	public void asignarRepartidor() {
		System.out.println("asignando al siguiente repartidor que salga a ruta");
	}

	@Override
	public void asignarRepartidor(String nombreRepartidor) {
		System.out.println("Verificando proximo reparto.................. Ok");
		System.out.println("Asignando el pedido a " + nombreRepartidor + " a cargo de la próxima ruta");
	}
}
