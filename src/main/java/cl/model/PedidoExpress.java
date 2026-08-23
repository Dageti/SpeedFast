package cl.model;

/**
 * Subclase de Pedido que representa un pedido de maxima prioridad que debe ser despachado en la próxima ruta
 * hereda de {@link Pedido}
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

//	@Override
//	public void asignarRepartidor() {
//		System.out.println("asignando al siguiente repartidor que salga a ruta");
//	}
//
//	@Override
//	public void asignarRepartidor(String nombreRepartidor) {
//		System.out.println("Verificando proximo reparto.................. Ok");
//		System.out.println("Asignando el pedido a " + nombreRepartidor + " a cargo de la próxima ruta");
//	}
