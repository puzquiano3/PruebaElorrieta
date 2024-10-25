package vista.paneles;

import javax.swing.JPanel;

import vista.VentanaPrincipal;
import javax.swing.JLabel;

public class Panel2 extends PanelInterno{
	JPanel panelPrincipal;
	
	
	public Panel2(VentanaPrincipal ventana) {
		super(ventana);
		
		panelPrincipal=this.getPanelPrincipal();
		
		JLabel lblNewLabel = new JLabel("Este es el panel 2");
		getPanelPrincipal().add(lblNewLabel);
	}
	

}
