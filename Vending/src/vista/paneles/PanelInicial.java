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

public class PanelInicial extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelInicial(VentanaPrincipal ventana) {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout());
		
		JLabel lblNewLabel = new JLabel("BIENVENIDOS A MI APLICACION");
		panel.add(lblNewLabel);
		
		JButton btn1 = new JButton("panel1");
	
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarPanel1();
			}
		});
		
		JButton btn2 = new JButton("panel2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarPanel2();
				
			}
		});
		panel.add(btn1);
		panel.add(btn2);
	
	

	}

}
