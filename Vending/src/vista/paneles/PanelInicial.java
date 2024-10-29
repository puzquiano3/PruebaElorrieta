package vista.paneles;

import javax.swing.JPanel;

import vista.VentanaPrincipal;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelInicial extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelInicial(VentanaPrincipal ventana) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.mostrarPanelTipos();
			}
		});
		setLayout(new BorderLayout(1, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout());
		
		JLabel lblNewLabel = new JLabel("BIENVENIDOS A MI APLICACION");
		panel.add(lblNewLabel);
	
	}

}
