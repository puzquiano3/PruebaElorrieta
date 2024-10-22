package vista.paneles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
		switch (tipo) {
		case Productos.BEBIDA:{
			productos=Productos.bebidas;
			precios= Productos.preciosBebidas;
			break;}
		case Productos.BOLLERIA:{
			productos= Productos.bollerias;
			precios= Productos.preciosBollerias;
			break;}
		case Productos.GOMINOLA:{
			productos= Productos.gominolas;
			precios = Productos.preciosGominolas;
			break;}
		case Productos.SNACK:{
			productos= Productos.snacks;
			precios= Productos.preciosSnacks;
			break;}
			
		}
		
	}

}
