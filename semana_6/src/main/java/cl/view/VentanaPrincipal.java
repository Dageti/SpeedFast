package cl.view;

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

	public VentanaPrincipal(ControladorDeEnvios controlador) {
		this.controlador = controlador;

		setTitle("SpeedFast - Gestor de envíos");
		setSize(450, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout(15, 15));

		JPanel panelSuperior = new JPanel(new GridLayout(2, 1, 5, 5));
		panelSuperior.setBorder(new EmptyBorder(20, 20, 10, 20));

		JLabel labelTitulo = new JLabel("Sistema de repartos SpeedFast", SwingConstants.CENTER);
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		JLabel labelSubtitulo = new JLabel("Pedidos", SwingConstants.CENTER);
		labelSubtitulo.setFont(new Font("Arial", Font.PLAIN, 14));

		panelSuperior.add(labelTitulo);
		panelSuperior.add(labelSubtitulo);
		add(panelSuperior, BorderLayout.NORTH);


		JPanel panelCentro = new JPanel(new GridLayout(4, 1, 5, 10));
		panelCentro.setBorder(new EmptyBorder(25, 25, 25, 25));
		btnRegistrarPedido = new JButton("Registrar pedido");
		btnListarPedidos = new JButton("Listar pedidos");
		btnAsignarEnviarPedido = new JButton("Asignar pedido e iniciar entrega");
		btnSalir = new JButton("Salir");

		panelCentro.add(btnRegistrarPedido);
		panelCentro.add(btnListarPedidos);
		panelCentro.add(btnAsignarEnviarPedido);
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
