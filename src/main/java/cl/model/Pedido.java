package cl.model;

/**
 * Clase abstracta, representa un pedido genérico
 * Sus clases hijas están obligadas a implementar el cálculo de tiempo de entrega.
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

	/**
	 * Muestra por consola el resumen del pedido.
	 */
	public void mostrarResumen() {
		System.out.println("ID del pedido: " + idPedido);
		System.out.println("Dirección de entrega: " + direccionEntrega);
		System.out.println("Distancia: " + distanciaKm + "Kms.");
	}

	/**
	 * Método abstracto para calcular tiempo de entrega. será sobreescrito según su tipo de pedido
	 * @return Tiempo de entrega en minutos.
	 */
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
