package cl.view;


import cl.services.ControladorDeEnvios;
import cl.model.Pedido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class VentanaListaPedidos extends JFrame {

	private final ControladorDeEnvios controlador;
	private final VentanaPrincipal ventanaPrincipal;

	private JTable tablaPedidos;
	private DefaultTableModel modeloTabla;

	private JButton btnRefrescar;
	private JButton btnEliminar;
	private JButton btnVolver;

	public VentanaListaPedidos(ControladorDeEnvios controlador, VentanaPrincipal ventanaPrincipal) {
		this.controlador = controlador;
		this.ventanaPrincipal = ventanaPrincipal;

		setTitle("SpeedFast - Lista de pedidos");
		setSize(750, 450);
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
		JLabel labelTitulo = new JLabel("Lista de pedidos");
		labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
		panelSuperior.add(labelTitulo);
		add(panelSuperior, BorderLayout.NORTH);

		inicializarTabla();

		JScrollPane scrollTabla = new JScrollPane(tablaPedidos);
		scrollTabla.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(scrollTabla, BorderLayout.CENTER);

		JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnRefrescar = new JButton("Refrescar");
		btnEliminar = new JButton("Eliminar pedido");
		btnVolver = new JButton("Volver");

		panelBotones.add(btnRefrescar);
		panelBotones.add(btnEliminar);
		panelBotones.add(btnVolver);
		add(panelBotones, BorderLayout.SOUTH);

		cargarDatosTabla();
		configurarEventos();
	}

	private void inicializarTabla() {
		String[] columnas = {
				"ID pedido",
				"Tipo",
				"Dirección",
				"Distancia",
				"Repartidor",
				"Estado",
				"Tiempo estimado",
		};

		modeloTabla = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaPedidos = new JTable(modeloTabla);
		tablaPedidos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
	}

	public void cargarDatosTabla() {
		modeloTabla.setRowCount(0);
		try {
			for (Pedido p : controlador.getListaPedidos()) {

				Object[] fila = {
						p.getIdPedido(),
						p.getTipo(),
						p.getDireccionEntrega(),
						p.getDistanciaKm() + " Km",
						p.getRepartidorAsignado(),
						p.getEstadoPedido(),
						p.calcularTiempoEntrega() + " min"
				};
				modeloTabla.addRow(fila);
			}
		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(this, "Error al cargar datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void eliminarPedidoSeleccionado() {
		int fila = tablaPedidos.getSelectedRow();
		if (fila == -1) {
			JOptionPane.showMessageDialog(this, "Seleccione un pedido", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		String idPedido = modeloTabla.getValueAt(fila, 0).toString();
		String estado = modeloTabla.getValueAt(fila, 5).toString();

		if (!"PENDIENTE".equalsIgnoreCase(estado)) {
			JOptionPane.showMessageDialog(this, "Solo se puede eliminar un despacho pendiente", "Warning", JOptionPane.WARNING_MESSAGE);
			return;
		}
		int confirmacion = JOptionPane.showConfirmDialog(this, "Desea eliminar el pedido ID: " + idPedido + "?");
		if (confirmacion == JOptionPane.YES_OPTION) {
			try {
				if (controlador.eliminarPedido(idPedido)) {
					JOptionPane.showMessageDialog(this, "Pedido eliminado", "Info", JOptionPane.INFORMATION_MESSAGE);
					cargarDatosTabla();
				} else {
					JOptionPane.showMessageDialog(this, "Error al eliminar el pedido", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException ex) {
				JOptionPane.showMessageDialog(this, "Error al eliminar el pedido." + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void configurarEventos() {
		btnRefrescar.addActionListener(e -> {
			cargarDatosTabla();
			JOptionPane.showMessageDialog(this, "Tabla refrescada!", "Info", JOptionPane.INFORMATION_MESSAGE);
		});
		btnEliminar.addActionListener(e -> {
			eliminarPedidoSeleccionado();
		});
		btnVolver.addActionListener(e -> {
			volverAlMenu();
		});
	}

	private void volverAlMenu() {
		ventanaPrincipal.setVisible(true);
		this.dispose();
	}

}
