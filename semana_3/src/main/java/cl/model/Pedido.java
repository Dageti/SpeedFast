package cl.model;

/**
 * Clase abstracta, base para cualquier pedido.
 * Define comportamientos mediante sobrecarga de métodos.
 */
public abstract class Pedido {
	protected String idPedido;
	protected String direccionEntrega;
	protected double distanciaKm;
	protected String repartidorAsignado;
	protected String estadoPedido;

	public Pedido(String idPedido, String direccionEntrega, double distanciaKm) {
		this.idPedido = idPedido;
		this.direccionEntrega = direccionEntrega;
		this.distanciaKm = distanciaKm;
		this.repartidorAsignado = "";
		this.estadoPedido = "pendiente";
	}

	public void asignarRepartidor(String nombre) {
		this.repartidorAsignado = nombre;
		this.estadoPedido = "repartidor asignado";
	}

	/**
	 * Método abstracto para asignar repartidor según tipo de pedido
	 */
	public abstract void asignarRepartidor();

	/**
	 * Método abstracto para calcular tiempo de entrega según tipo de pedido
	 */
	public abstract int calcularTiempoEntrega();

	/**
	 * Método resumen reutilizable por subclases
	 */
	public void mostrarResumen() {
		System.out.println("Pedido: " + this.idPedido);
		System.out.println("Dirección: " + this.direccionEntrega);
		System.out.println("Distancia: " + this.distanciaKm);
		System.out.println("Repartidor Asignado: " + this.repartidorAsignado);
		System.out.println("Tiempo estimado de espera: " + this.calcularTiempoEntrega() + " minutos.");
	}

	/**
	 * Getters y Setters
	 */
	public String getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(String idPedido) {
		this.idPedido = idPedido;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public double getDistanciaKm() {
		return distanciaKm;
	}

	public void setDistanciaKm(double distanciaKm) {
		this.distanciaKm = distanciaKm;
	}

	public String getRepartidorAsignado() {
		return repartidorAsignado;
	}

	public void setRepartidorAsignado(String repartidorAsignado) {
		this.repartidorAsignado = repartidorAsignado;
	}

	public String getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(String estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	@Override
	public String toString() {
		return "Resumen Pedido" +
				"ID Pedido: " + idPedido + "\n" +
				"Dirección de entrega: " + direccionEntrega + "\n" +
				"Distancia: " + distanciaKm + "Km\n" +
				"Repartidor Asignado: " + repartidorAsignado + "\n" +
				"Estado: " + estadoPedido;
	}
}
