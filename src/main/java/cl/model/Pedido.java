package cl.model;

/**
 * Clase abstracta, representa un pedido genérico
 *
 */
public abstract class Pedido {
	protected String idPedido;
	protected String direccionEntrega;
	protected double distanciaKm;

	public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
		this.idPedido = idPedido;
		this.direccionEntrega = direccionEntrega;
		this.distanciaKm = distanciaKm;
	}

	public void mostrarResumen() {
		System.out.println("ID del pedido: " + idPedido);
		System.out.println("Dirección de entrega: " + direccionEntrega);
		System.out.println("Distancia: " + distanciaKm + "Kms.");
	}

	public abstract int calcularTiempoEntrega();

	@Override
	public String toString() {
		return "Pedido{" +
				"idPedido='" + idPedido + '\'' +
				", direccionEntrega='" + direccionEntrega + '\'' +
				", distanciaKM='" + distanciaKm + '\'' +
				'}';
	}
}
