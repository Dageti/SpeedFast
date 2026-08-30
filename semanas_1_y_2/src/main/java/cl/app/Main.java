package cl.app;

import cl.model.PedidoComida;
import cl.model.PedidoEncomienda;
import cl.model.PedidoExpress;

/**
 * Clase principal de SpeedFast.
 */
public class Main {
	public static void main(String[] args) {

		PedidoComida pedidoComida = new PedidoComida("001", "Calle Wallaby 42, Sydney", 2.0);
		PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("002", "Condominio Bernarda 23, Osorno", 5.0);
		PedidoExpress pedidoExpress = new PedidoExpress("003", "Las acacias 32, Santiago", 8.0);

		pedidoComida.mostrarResumen();
		System.out.println("Tiempo de espera estimado para su pedido de comida: " + pedidoComida.calcularTiempoEntrega() + " minutos.\n");
		pedidoEncomienda.mostrarResumen();
		System.out.println("Tiempo de espera estimado para su encomienda: " + pedidoEncomienda.calcularTiempoEntrega() + " minutos.\n");
		pedidoExpress.mostrarResumen();
		System.out.println("Tiempo de espera estimado para su pedido express: " + pedidoExpress.calcularTiempoEntrega() + " minutos.\n");
	}
}
