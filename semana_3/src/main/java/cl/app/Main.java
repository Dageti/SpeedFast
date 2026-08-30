package cl.app;

import cl.model.PedidoComida;

public class Main {
	public static void main(String[] args) {

		PedidoComida pedidoComida = new PedidoComida("001", "Calle Wallaby 42, Sydney", 2.0);
		pedidoComida.asignarRepartidor("Philip J. Fry");
		pedidoComida.despachar();
	}
}
