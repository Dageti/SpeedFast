package cl.app;

import cl.services.ControladorDeEnvios;
import cl.view.VentanaPrincipal;

import javax.swing.*;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ControladorDeEnvios controlador = new ControladorDeEnvios();
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(controlador);
			ventanaPrincipal.setVisible(true);
		});
	}
}

