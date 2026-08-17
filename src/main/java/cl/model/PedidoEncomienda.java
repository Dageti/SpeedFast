package cl.model;

/**
 * Subclase de Pedido que representa una encomienda que requiere un pesaje previo para asegurar que sea un paquete válido
 * hereda de {@link Pedido}
 */
public class PedidoEncomienda extends Pedido {
	public PedidoEncomienda(String idPedido, String direccionEntrega, String tipoPedido) {
		super(idPedido, direccionEntrega, tipoPedido);
	}

	@Override
	public void asignarRepartidor() {
		System.out.println("realizando control de peso del paquete y asignando a repartidor");
	}

	@Override
	public void asignarRepartidor(String nombreRepartidor) {
		System.out.println("Asignando el pedido a " + nombreRepartidor + " quien esta en el area de pesaje");
		System.out.println("Verificando peso del paquete......... OK");
	}
}
