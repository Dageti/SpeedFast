package cl.model;

/**
 * Clase que representa un pedido.
 */
public class Pedido {
	private final int id;
	private final String direccion;
	private EstadoPedido estado;

	/**
	 * Constructor que inicializa siempre con estado PENDIENTE
	 *
	 * @param id        identificador del pedido.
	 * @param direccion dirección a entregar el pedido.
	 */
	public Pedido(int id, String direccion) {
		this.id = id;
		this.direccion = direccion;
		this.estado = EstadoPedido.PENDIENTE;
	}

	/**
	 * Constructor que recibe un estado
	 *
	 * @param id        identificador del pedido.
	 * @param direccion dirección a entregar el pedido.
	 * @param estado    estado actual del ciclo de vida del pedido.
	 */
	public Pedido(int id, String direccion, EstadoPedido estado) {
		this.id = id;
		this.direccion = direccion;
		this.estado = estado;
	}

	/**
	 * Método de sobrecarga a EstadoPedido
	 *
	 * @param nuevoEstado nuevo estado a asignar a ciclo de vida del pedido.
	 */
	public void setEstado(String nuevoEstado) {
		try {
			this.estado = EstadoPedido.valueOf(nuevoEstado.toUpperCase().trim());
		} catch (IllegalArgumentException e) {
			System.err.println("Estado invalido." + nuevoEstado);
		}
	}

	/**
	 * Getters y Setters
	 */
	public int getId() {
		return id;
	}

	public String getDireccion() {
		return direccion;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Pedido [id= " + id + ", direccion= " + direccion + ", estado= " + estado + "]";
	}
}
