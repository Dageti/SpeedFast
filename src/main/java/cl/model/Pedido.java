package cl.model;

public class Pedido {
	private String idPedido;
	private String direccionEntrega;
	private String tipoPedido;

	public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
		this.idPedido = idPedido;
		this.direccionEntrega = direccionEntrega;
		this.tipoPedido = tipoPedido;
	}

	public void asignarRepartidor() {
		System.out.println("asignando repartidor al pedido" + this.idPedido);
	}

	public void asignarRepartidor(String nombreRepartidor) {
		System.out.println("asignando pedido al repartidor: " + nombreRepartidor);
	}

	@Override
	public String toString() {
		return "Pedido{" +
				"idPedido='" + idPedido + '\'' +
				", direccionEntrega='" + direccionEntrega + '\'' +
				", tipoPedido='" + tipoPedido + '\'' +
				'}';
	}
}
