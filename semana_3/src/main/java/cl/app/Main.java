package cl.app;

import cl.model.PedidoComida;
import cl.model.PedidoEncomienda;
import cl.model.PedidoExpress;
import cl.service.ControladorDeEnvios;

/**
 * Clase principal y punto de acceso a SpeedFast.
 * Simula despachos mediante sobreescritura y sobrecarga.
 */
public class Main {
	public static void main(String[] args) {

		ControladorDeEnvios controlador = new ControladorDeEnvios();

		/**
		 * Asignación por Sobrecarga.
		 */
		PedidoComida pedidoComida = new PedidoComida("001", "Calle Wallaby, 42, Sydney", 2.0);
		pedidoComida.asignarRepartidor("Philip J. Fry");
		pedidoComida.mostrarResumen();
		pedidoComida.despachar();
		controlador.registrarPedido(pedidoComida);

		/**
		 * Asignación por Sobreescritura.
		 */
		PedidoEncomienda pedidoEncomienda = new PedidoEncomienda("002", "Avenida siempre viva, 742, Springfield", 12);
		pedidoEncomienda.asignarRepartidor();
		pedidoEncomienda.mostrarResumen();
		pedidoEncomienda.despachar();
		controlador.registrarPedido(pedidoEncomienda);

		System.out.println();

		/**
		 * Test de envío cancelado.
		 */
		PedidoExpress pedidoExpress = new PedidoExpress("003", "Calle Vicuña Mackenna, 2252, Santiago", 22);
		pedidoExpress.asignarRepartidor("Jose Luis Lucas Juan");
		System.out.println("Cancelando pedido express: " + pedidoExpress.getIdPedido());
		pedidoExpress.cancelar();
		controlador.registrarPedido(pedidoExpress);

		System.out.println();

		/**
		 * impresión de historial completo.
		 */
		controlador.verHistorial();
	}

}

