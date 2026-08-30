package cl.model;

import cl.interfaces.Cancelable;
import cl.interfaces.Despachable;
import cl.interfaces.Rastreable;

public abstract class PedidoExpress extends Pedido implements Despachable, Cancelable, Rastreable {
	public PedidoExpress(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}
}
