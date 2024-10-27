package vista.paneles;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controlador.GestorProductos;
import modelo.Productos;
import vista.VentanaPrincipal;

public class PanelProductos extends JPanel {
	JLabel[] lblProductos;
	JButton[] btnProductos;
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	String[] productos;
	double[] precios;
	String[] imagenes;
	int[] identificadores;
	private VentanaPrincipal v;

	public PanelProductos(VentanaPrincipal v, int tipo) {
		inicializar(v, tipo);

	}

	private void inicializar(VentanaPrincipal v, int tipo) {
		inicializarProductos(tipo);

		JButton atras = new JButton("INICIO");

		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanel1();

			}
		});
		this.add(atras);
		lblProductos = new JLabel[productos.length];
		btnProductos = new JButton[productos.length];

		for (int n = 0; n < productos.length; n++) {
			btnProductos[n] = crearBoton(productos[n], "multimedia\\productos\\" + imagenes[n],identificadores[n]);
			btnProductos[n].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int id=Integer.parseInt( e.getActionCommand());
				 GestorProductos.comprar(id);
				 int pos=GestorProductos.getPosicion(id);
				String mensaje="LLevas "+Productos.cantidadComprada[pos]+ " "+Productos.nombres[pos]+" comprados";
				JOptionPane.showMessageDialog(null, mensaje);
				
					
				}
			});

			lblProductos[n] = new JLabel(productos[n]);
			lblProductos[n].setName("" + n);
			this.add(btnProductos[n]);
			this.add(lblProductos[n]);
		}
		this.repaint();
		this.revalidate();
		this.setVisible(true);

	}

	private void inicializarProductos(int tipo) {
		int cant=GestorProductos.numProductosTipo(tipo);
		if (cant> 0) {
			identificadores=GestorProductos.getIdentificadoresTipo(tipo);
			productos = GestorProductos.getProductosTipo(tipo);
			precios = GestorProductos.getPreciosTipo(tipo);
			imagenes = GestorProductos.getImagenesTipo(tipo);
			

	}
	}

	private JButton crearBoton(String nombre, String rutaImagen,int id) {
		JButton boton = new JButton(nombre);
		ImageIcon imagenOriginal = new ImageIcon(rutaImagen);

		// Escalar la imagen al tamaño del botón
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);

		// Establecer la imagen escalada como icono del botón
		boton.setIcon(iconoEscalado);
		boton.setActionCommand(Integer.toString(id));

		return boton;

	}

}
