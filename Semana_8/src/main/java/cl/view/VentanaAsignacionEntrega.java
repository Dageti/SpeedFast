package cl.view;

import cl.model.Pedido;
import cl.services.ControladorDeEnvios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class VentanaAsignacionEntrega extends JFrame {

	private final ControladorDeEnvios controlador;
	private final VentanaPrincipal ventanaPrincipal;

	private JTextArea txtConsola;
	private JButton btnAsignar;
	private JButton btnIniciarEntrega;
	private JButton btnVolver;

	public VentanaAsignacionEntrega(ControladorDeEnvios controlador, VentanaPrincipal ventanaPrincipal) {
		this.controlador = controlador;
		this.ventanaPrincipal = ventanaPrincipal;

		setTitle("SpeedFast - Asignar pedidos e iniciar entregas");
		setSize(700, 450);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout(15, 15));

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				volverAlMenu();
			}
		});

		JPanel panelSuperior = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelSuperior.setBorder(new EmptyBorder(5, 5, 5, 5));
		JLabel labelTitulo = new JLabel("Asignación y entrega de pedidos");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		panelSuperior.add(labelTitulo);
		add(panelSuperior, BorderLayout.NORTH);

		txtConsola = new JTextArea();
		txtConsola.setEditable(false);
		txtConsola.setFont(new Font("Arial", Font.PLAIN, 14));
		txtConsola.setText("=== Sistema de entregas SpeedFast ===\n\n");

		JScrollPane scrollConsola = new JScrollPane(txtConsola);
		scrollConsola.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(scrollConsola, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnAsignar = new JButton("Asignar repartidores");
		btnIniciarEntrega = new JButton("Iniciar entregas");
		btnVolver = new JButton("Volver");

		panelBotones.add(btnAsignar);
		panelBotones.add(btnIniciarEntrega);
		panelBotones.add(btnVolver);
		add(panelBotones, BorderLayout.SOUTH);

		configurarEventos();
	}

	private void configurarEventos() {
		btnAsignar.addActionListener(e -> {
			try {

				int asignados = controlador.asignarRepartidores();
				txtConsola.append("Asignando repartidores a pedidos pendientes...\n");
				for (Pedido p : controlador.getListaPedidos()) {
					if ("EN_REPARTO".equalsIgnoreCase(p.getEstadoPedido())) {
						txtConsola.append("Pedido " + p.getIdPedido() + " (" + p.getTipo() + ") asignado a: " + p.getRepartidorAsignado() + "\n");
					}
				}
				txtConsola.append("Total asignados: " + asignados + "\n\n");
				JOptionPane.showMessageDialog(this, "Repartidores asignados: " + asignados, "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al asignar repartidores: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnIniciarEntrega.addActionListener(e -> {
			try {

				txtConsola.append("Iniciando entregas...\n");
				int entregados = controlador.simularEntregas();
				for (Pedido p : controlador.getListaPedidos()) {
					if ("Entregado".equalsIgnoreCase(p.getEstadoPedido())) {
						txtConsola.append("Pedido " + p.getIdPedido() + " entregado en: " + p.getDireccionEntrega() + " por " + p.getRepartidorAsignado() + "\n");
					}
				}
				txtConsola.append("Total entregados: " + entregados + "\n\n");
				JOptionPane.showMessageDialog(this, "Entregas completadas: " + entregados, "Info", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al iniciar entregas: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});

		btnVolver.addActionListener(e -> volverAlMenu());
	}

	private void volverAlMenu() {
		ventanaPrincipal.setVisible(true);
		this.dispose();
	}
}