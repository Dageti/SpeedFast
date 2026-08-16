package cl.app;

import cl.model.PedidoComida;
import cl.model.PedidoEncomienda;
import cl.model.PedidoExpress;

public class Main {
	public static void main(String[] args) {

		PedidoComida pedidoComida = new PedidoComida("001", "Calle Wallaby 42, Sydney", "Comida");
		PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("001", "Condominio Bernarda 23, Osorno", "Encomienda");
		PedidoExpress pedidoExpress = new PedidoExpress("003", "Las acacias 32, Santiago", "Express");

		System.out.println("-------Pedido Comida-------");
		pedidoComida.asignarRepartidor();
		pedidoComida.asignarRepartidor("Cosme Fulanito");

		System.out.println("-------Pedido Encomienda-------");
		pedidoEncomienda.asignarRepartidor();
		pedidoEncomienda.asignarRepartidor("Philip J. Fry");

		System.out.println("-------Pedido Express-------");
		pedidoExpress.asignarRepartidor();
		pedidoExpress.asignarRepartidor("Homero Simpson");
	}
}
