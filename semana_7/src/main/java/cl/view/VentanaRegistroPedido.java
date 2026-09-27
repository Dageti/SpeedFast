package cl.view;

import cl.model.*;
import cl.services.ControladorDeEnvios;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaRegistroPedido extends JFrame {

	private final ControladorDeEnvios controlador;
	private final VentanaPrincipal ventanaPrincipal;
	private JTextField txtDireccion;
	private JTextField txtDistancia;
	JComboBox<String> comboTipoPedido;

	private JButton btnGuardar;
	private JButton btnLimpiar;
	private JButton btnVolver;

	public VentanaRegistroPedido(ControladorDeEnvios controlador, VentanaPrincipal ventanaPrincipal) {
		this.controlador = controlador;
		this.ventanaPrincipal = ventanaPrincipal;

		setTitle("SpeedFast - Registrar pedido");
		setSize(480, 400);
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
		panelSuperior.setBorder(new EmptyBorder(15, 15, 15, 15));
		JLabel labeltitulo = new JLabel("Registrar nuevo pedido");
		labeltitulo.setFont(new Font("Arial", Font.BOLD, 14));
		panelSuperior.add(labeltitulo);
		add(panelSuperior, BorderLayout.NORTH);

		JPanel panelFormulario = new JPanel(new GridLayout(3, 2, 10, 15));
		panelFormulario.setBorder(new EmptyBorder(15, 15, 15, 15));

		JLabel labelDireccion = new JLabel("Dirección de entrega:");
		txtDireccion = new JTextField();
		panelFormulario.add(labelDireccion);
		panelFormulario.add(txtDireccion);

		JLabel labelTipo = new JLabel("Tipo de pedido:");
		String[] opcionesTipo = {"Comida", "Encomienda", "Express"};
		comboTipoPedido = new JComboBox<>(opcionesTipo);
		panelFormulario.add(labelTipo);
		panelFormulario.add(comboTipoPedido);

		JLabel labelDistancia = new JLabel("Distancia (en Km):");
		txtDistancia = new JTextField();
		panelFormulario.add(labelDistancia);
		panelFormulario.add(txtDistancia);

		add(panelFormulario, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnGuardar = new JButton("Guardar");
		btnLimpiar = new JButton("Limpiar");
		btnVolver = new JButton("Volver");
		panelBotones.add(btnGuardar);
		panelBotones.add(btnLimpiar);
		panelBotones.add(btnVolver);
		add(panelBotones, BorderLayout.SOUTH);

		configurarEventos();
	}

	private void configurarEventos() {
		btnGuardar.addActionListener(e -> guardarPedido());
		btnLimpiar.addActionListener(r -> limpiarFormulario());
		btnVolver.addActionListener(e -> volverAlMenu());
	}

	private void guardarPedido() {
		String direccion = txtDireccion.getText().trim();
		String strDistancia = txtDistancia.getText().trim();
		String tipo = (String) comboTipoPedido.getSelectedItem();

		if (direccion.isEmpty() || strDistancia.isEmpty() || tipo.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Por favor complete todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
			return;
		}
		double distancia;
		try {
			distancia = Double.parseDouble(strDistancia);
			if (distancia <= 0) {
				JOptionPane.showMessageDialog(this, "La distancia debe ser mayor a 0", "Error", JOptionPane.ERROR_MESSAGE);

				return;
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(this, "La distancia debe ser un número válido", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Pedido nuevoPedido;
		if ("Comida".equalsIgnoreCase(tipo)) {
			nuevoPedido = new PedidoComida("0", direccion, distancia);
		} else if ("Encomienda".equalsIgnoreCase(tipo)) {
			nuevoPedido = new PedidoEncomienda("0", direccion, distancia);
		} else {
			nuevoPedido = new PedidoExpress("0", direccion, distancia);
		}
		controlador.registrarPedido(nuevoPedido);
		JOptionPane.showMessageDialog(this, "Pedido registrado con éxito. ID: " + nuevoPedido.getIdPedido(), "Info", JOptionPane.INFORMATION_MESSAGE);
		limpiarFormulario();
	}

	private void limpiarFormulario() {
		txtDireccion.setText("");
		txtDistancia.setText("");
		comboTipoPedido.setSelectedIndex(0);
		txtDireccion.requestFocus();
	}

	private void volverAlMenu() {
		ventanaPrincipal.setVisible(true);
		this.dispose();
	}
}
