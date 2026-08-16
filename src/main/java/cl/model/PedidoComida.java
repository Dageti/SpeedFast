package cl.model;

public class PedidoComida extends Pedido {
	public PedidoComida(String idPedido, String direccionEntrega, String tipoPedido) {
		super(idPedido, direccionEntrega, tipoPedido);

	}

	@Override
	public void asignarRepartidor() {
		System.out.println("asignando repartidor con mochila térmica para el pedido");
	}
	@Override
	public void asignarRepartidor(String nombreRepartidor) {
		System.out.println("Buscando repartidor con mochila térmica............... OK");
		System.out.println("Asignando el pedido a " +  nombreRepartidor + " pues posee mochila térmica");
	}
}
