package cl.model;

/**
 * Subclase de Pedido, representa los pedidos express.
 */
public class PedidoExpress extends Pedido {
	public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}

	@Override
	public void asignarRepartidor() {
		this.repartidorAsignado = "Jerry";
		this.estadoPedido = "Repartidor asignado";
	}

	@Override
	public int calcularTiempoEntrega() {
		return (distanciaKm > 5) ? 15 : 10;
	}


	@Override
	public void mostrarResumen() {
		System.out.println("==== Pedido Express ====");
		super.mostrarResumen();
	}
}
