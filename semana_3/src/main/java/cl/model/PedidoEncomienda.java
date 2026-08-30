package cl.model;

import cl.interfaces.Cancelable;
import cl.interfaces.Despachable;
import cl.interfaces.Rastreable;

public abstract class PedidoEncomienda extends Pedido implements Despachable, Cancelable, Rastreable {
	public PedidoEncomienda(String idPedido, String direccionEntrega, double distanciaKm) {
		super(idPedido, direccionEntrega, distanciaKm);
	}
}
