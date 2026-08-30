package cl.model;

/**
 * Subclase de Pedido, representa los pedidos de Encomiendas.
 */
public class PedidoEncomienda extends Pedido {
	public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}

	@Override
	public void asignarRepartidor() {
		this.repartidorAsignado = "Tom";
		this.estadoPedido = "Repartidor asignado";
	}

	@Override
	public int calcularTiempoEntrega() {
		return (int) (20 + (1.5 * distanciaKm));
	}


	@Override
	public void mostrarResumen() {
		System.out.println("==== Pedido Encomienda ====");
		super.mostrarResumen();
	}

}
