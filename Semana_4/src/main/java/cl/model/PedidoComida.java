package cl.model;

/**
 * Subclase de Pedido, representa los pedidos de comida.
 */
public class PedidoComida extends Pedido {
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
	public void mostrarResumen() {
		System.out.println("==== Pedido Comida ====");
		super.mostrarResumen();
	}
}
