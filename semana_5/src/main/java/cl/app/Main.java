package cl.app;

import cl.model.Pedido;
import cl.service.ZonaDeCarga;
import cl.threads.Repartidor;

/**
 * Clase principal y punto de acceso a SpeedFast.
 * Simula despachos mediante hilos.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("[Iniciando zona de carga]");
		ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

		zonaDeCarga.agregarPedido(new Pedido(1, "Tangamandapio 213"));
		zonaDeCarga.agregarPedido(new Pedido(2, "Titirilquen 23"));
		zonaDeCarga.agregarPedido(new Pedido(3, "Alto Jahuel 333"));
		zonaDeCarga.agregarPedido(new Pedido(4, "La Pintanta 765"));
		zonaDeCarga.agregarPedido(new Pedido(5, "Muy muy Lejano 54"));

		Repartidor repartidor1 = new Repartidor("Jose Luis Lucas Juan", zonaDeCarga);
		Repartidor repartidor2 = new Repartidor("Miguel Bosé", zonaDeCarga);
		Repartidor repartidor3 = new Repartidor("Policarpo", zonaDeCarga);

		Thread t1 = new Thread(repartidor1, "Repartidor 1");
		Thread t2 = new Thread(repartidor2, "Repartidor 2");
		Thread t3 = new Thread(repartidor3, "Repartidor 3");

		t1.start();
		t2.start();
		t3.start();

		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			System.err.println("Simulación interrumpida " + e.getMessage());
			Thread.currentThread().interrupt();
		}

		System.out.println("Zona de carga vacía, pedidos entregados exitosamente");

	}
}