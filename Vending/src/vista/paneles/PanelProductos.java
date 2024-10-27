package vista.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GestorProductos;
import modelo.Productos;
import vista.VentanaPrincipal;

public class PanelProductos extends JPanel {
	JLabel[] lblProductos;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	String[] productos;
	double[] precios;
	private VentanaPrincipal v;
	
	public PanelProductos(VentanaPrincipal v,int tipo) {
		inicializar(v,tipo);
	
		

	}
	
	private void inicializar(VentanaPrincipal v, int tipo) {
		inicializarProductos(tipo);
		
		JButton atras= new JButton("INICIO");
		
		atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanel1();
				
			}
		});
		this.add(atras);
		lblProductos= new JLabel[productos.length];
		
		for(int n=0;n<productos.length;n++) {
			lblProductos[n]= new JLabel(productos[n]);
			lblProductos[n].setName(""+n);	
			this.add(lblProductos[n]);
		}
		this.repaint();
		this.revalidate();
		this.setVisible(true);
		
		

	}
	private void inicializarProductos(int tipo) {
		if(GestorProductos.numProductosTipo(tipo)>0)
			productos=GestorProductos.getProductosTipo(tipo);
			precios= GestorProductos.getPreciosTipo(tipo);
		
	}

}
