package vista.paneles;

import javax.swing.JPanel;

import vista.VentanaPrincipal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelInterno extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelPrincipal;
	private VentanaPrincipal ventana;

	/**
	 * Create the panel.
	 */
	
	public PanelInterno() {
		this.setUpPanel();

		

	}
	public PanelInterno(VentanaPrincipal ventana) {
	
		this.setUpPanel();
		JButton btnInicio = new JButton("Inicio");
		
		this.ventana=ventana;
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarPanelInicio();
				
				
			}
		});
		  JPanel panelSuperior = new JPanel();
	        panelSuperior.add(btnInicio);
	        add(panelSuperior, BorderLayout.NORTH);
		
	}
	public PanelInterno(VentanaPrincipal ventana,String[] nombres) {
		
		this.setUpPanel();
		JButton btnInicio = new JButton("Inicio");
		
		this.ventana=ventana;
		for(int n=0; n<nombres.length;n++) {
			this.panelPrincipal.add(new JButton(nombres[n]));
		}
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarPanelInicio();
				
				
			}
		});
		  JPanel panelSuperior = new JPanel();
	        panelSuperior.add(btnInicio);
	        add(panelSuperior, BorderLayout.NORTH);
		
	}

	public JPanel getPanelPrincipal() {
		return this.panelPrincipal;
	}
	
	private void setUpPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panelSuperior = new JPanel();
		add(panelSuperior, BorderLayout.NORTH);
		
		JButton btnInicio = new JButton("Inicio");
	
		panelSuperior.add(btnInicio);
		
		 panelPrincipal = new JPanel();
		 panelPrincipal.setLayout(new FlowLayout());
		add(panelPrincipal, BorderLayout.CENTER);
		
	}
	

}
