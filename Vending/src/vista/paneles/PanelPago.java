package vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;

import controlador.GestorProductos;
import vista.VentanaPrincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class PanelPago extends JPanel {
	private VentanaPrincipal v;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public PanelPago(VentanaPrincipal v) {
		this.v=v;
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel(String.format("Total a pagar: %.2f",GestorProductos.totalConIva()));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 32));
		JTextArea textArea = new JTextArea();
		JButton btnAtras= new JButton("ATRAS");
		JButton btnPagar = new JButton("PAGAR");
		add(btnAtras);
		add(lblNewLabel);
		add(textArea);
		add(btnPagar);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelResumen();
			}
		});

	}

}
