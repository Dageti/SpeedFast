package cl.app;

import cl.model.*;
import cl.service.ControladorDeEnvios;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Clase principal y punto de acceso a SpeedFast.
 * Simula despachos mediante hilos.
 */
public class Main {
	public static void main(String[] args) {
		System.out.println("========= Simulación de entregas =========");

		ControladorDeEnvios controlador = new ControladorDeEnvios();

		Pedido pedido1 = new PedidoExpress("Ex001", "Providencia 3214", 5);
		Pedido pedido2 = new PedidoComida("Co001", "San Joaquin 1212", 7);
		Pedido pedido3 = new PedidoEncomienda("En001", "Estación Central 212", 15);
		Pedido pedido4 = new PedidoComida("Co002", "Maipú 2331", 43);
		Pedido pedido5 = new PedidoComida("Co003", "La cisterna 234", 8);
		Pedido pedido6 = new PedidoEncomienda("En002", "Estación Central 567", 3);

		Repartidor repartidor1 = new Repartidor("Jose Luis Lucas Juan");
		Repartidor repartidor2 = new Repartidor("Miguel Bosé");
		Repartidor repartidor3 = new Repartidor("Policarpo");

		repartidor1.agregarPedido(pedido1);
		repartidor1.agregarPedido(pedido2);

		repartidor2.agregarPedido(pedido3);
		repartidor2.agregarPedido(pedido4);

		repartidor3.agregarPedido(pedido5);
		repartidor3.agregarPedido(pedido6);

		List<Pedido> pedidos = List.of(pedido1, pedido2, pedido3, pedido4, pedido5, pedido6);
		for (Pedido pedido : pedidos) {
			controlador.registrarPedido(pedido);
		}

		ExecutorService executor = Executors.newFixedThreadPool(3);

		System.out.println("----- Inicio de recorridos -----");

		executor.execute(repartidor1);
		executor.execute(repartidor2);
		executor.execute(repartidor3);
		executor.shutdown();
		try {
			boolean finalizado = executor.awaitTermination(60, TimeUnit.SECONDS);

			if (finalizado) {
				System.out.println("========= Las entregas han sido completadas =========");
			} else {
				System.out.println("Se acabó la jornada laboral antes de finalizar las entregas");
			}
		} catch (InterruptedException e) {
			System.err.println("Error " + e.getMessage());
		}
		System.out.println("========= Historial =========");
		controlador.verHistorial();
	}

}

