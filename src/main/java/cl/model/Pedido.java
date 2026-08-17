package cl.model;

/**
 * Clase padre, representa un pedido genérico
 *
 */
public class Pedido {
	private String idPedido;
	private String direccionEntrega;
	private String tipoPedido;

	public Pedido(String idPedido, String direccionEntrega, String tipoPedido) {
		this.idPedido = idPedido;
		this.direccionEntrega = direccionEntrega;
		this.tipoPedido = tipoPedido;
	}

	/**
	 * Asigna un repartidor a un pedido mediante ID del pedido
	 */
	public void asignarRepartidor() {
		System.out.println("asignando repartidor al pedido" + this.idPedido);
	}

	/**
	 * Sobrecarga el metodo asignarRepartidor asignando un repartidor en específico mediante el nombre
	 * @param nombreRepartidor nombre del Repartidor a cargo del pedido.
	 */
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
