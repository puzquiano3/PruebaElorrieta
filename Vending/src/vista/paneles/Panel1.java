package vista.paneles;

import javax.swing.JPanel;

import vista.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Panel1 extends PanelInterno {
	private JPanel panelPrincipal;
	
	public Panel1(VentanaPrincipal ventana) {
		super(ventana);
		panelPrincipal=this.getPanelPrincipal();
		
		JLabel lblNewLabel = new JLabel("Este es el panel1");
		panelPrincipal.add(lblNewLabel);
		repaint();
		revalidate();
		
		
		
		
	}
	public Panel1(VentanaPrincipal ventana,String[] nombres) {
		super(ventana,nombres);
		repaint();
		revalidate();
		
	}


}
