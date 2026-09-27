package cl.view;


import cl.model.Repartidor;
import cl.services.ControladorDeEnvios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class VentanaPrincipal extends JFrame {

	private final ControladorDeEnvios controlador;

	private JButton btnRegistrarPedido;
	private JButton btnListarPedidos;
	private JButton btnAsignarEnviarPedido;
	private JButton btnSalir;
	private JButton btnRegistrarRepartidor;

	public VentanaPrincipal(ControladorDeEnvios controlador) {
		this.controlador = controlador;

		setTitle("SpeedFast - Gestor de envíos");
		setSize(760, 220);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout(10, 10));

		JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
		panelSuperior.setBorder(new EmptyBorder(15, 15, 15, 15));

		JLabel labelTitulo = new JLabel("Sistema de repartos SpeedFast", SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 18));
		JLabel labelSubtitulo = new JLabel("Gestión de Pedidos", SwingConstants.CENTER);
		labelSubtitulo.setFont(new Font("Arial", Font.PLAIN, 13));

		panelSuperior.add(labelTitulo);
		panelSuperior.add(labelSubtitulo);
		add(panelSuperior, BorderLayout.NORTH);

		JPanel panelCentro = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 15));
		panelCentro.setBorder(new EmptyBorder(15, 15, 15, 15));
		btnRegistrarPedido = new JButton("Registrar pedido");
		btnListarPedidos = new JButton("Listar pedidos");
		btnAsignarEnviarPedido = new JButton("Asignar e iniciar entrega");
		btnRegistrarRepartidor = new JButton("Registrar repartidor");

		btnSalir = new JButton("Salir");

		panelCentro.add(btnRegistrarPedido);
		panelCentro.add(btnListarPedidos);
		panelCentro.add(btnAsignarEnviarPedido);
		panelCentro.add(btnRegistrarRepartidor);
		panelCentro.add(btnSalir);
		add(panelCentro, BorderLayout.CENTER);

		configurarEventos();
	}

	private void configurarEventos() {
		btnRegistrarPedido.addActionListener(e -> {
			VentanaRegistroPedido ventanaRegistroPedido = new VentanaRegistroPedido(controlador, this);
			ventanaRegistroPedido.setVisible(true);
			this.setVisible(false);
		});

		btnListarPedidos.addActionListener(e -> {
			VentanaListaPedidos ventanaLista = new VentanaListaPedidos(controlador, this);
			ventanaLista.setVisible(true);
			this.setVisible(false);
		});
		btnAsignarEnviarPedido.addActionListener(e -> {
			VentanaAsignacionEntrega ventanaAsignacion = new VentanaAsignacionEntrega(controlador, this);
			ventanaAsignacion.setVisible(true);
			this.setVisible(false);
		});
		btnRegistrarRepartidor.addActionListener(e -> {
			String nombre = JOptionPane.showInputDialog(this, "Ingrese el nombre del Repartidor:", "Registar Rpartidor", JOptionPane.QUESTION_MESSAGE);
			if (nombre != null && !nombre.trim().isEmpty()) {
				Repartidor nuevoRepartidor = new Repartidor(nombre.trim());
				boolean guardado = controlador.registrarRepartidor(nuevoRepartidor);
				if (guardado) {
					JOptionPane.showMessageDialog(null, "Repartidor registado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "Error al registrar el repartidor", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnSalir.addActionListener(e -> {
			int confirm = JOptionPane.showConfirmDialog(
					this, "Desea salir?",
					"Confirmación",
					JOptionPane.YES_NO_OPTION
			);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		});
	}
}
