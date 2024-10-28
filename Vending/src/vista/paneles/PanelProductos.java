package vista.paneles;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controlador.GestorProductos;
import modelo.Productos;
import vista.VentanaPrincipal;
import java.awt.Font;

public class PanelProductos extends JPanel {
	JLabel[] lblProductos;
	JButton[] btnProductos;
	JPanel botonera,principal;
	 JTextArea textArea;
	
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	String[] productos;
	double[] precios;
	String[] imagenes;
	int[] identificadores;
	int tipo;
	private VentanaPrincipal v;

	public PanelProductos(VentanaPrincipal v, int tipo) {
		this.tipo=tipo;
		inicializar(v, tipo);

	}

	private void inicializar(VentanaPrincipal v, int tipo) {
		inicializarProductos(tipo);
		setLayout(new BorderLayout());

		JButton atras = new JButton("ATRAS");
		JButton finalizarCompra= new JButton("FINALIZAR COMPRA");
		principal=new JPanel();
		principal.setLayout(new GridLayout(1,2));
       if(GestorProductos.numProductosTipo(tipo)>0) {
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
				rellenarProductosComprados();
				
					
				}
			});

			//lblProductos[n] = new JLabel(productos[n]+" "+precios[n]+ " Euros");
			lblProductos[n] = new JLabel(String.format(productos[n]+" %.2f Euros",precios[n]));
			lblProductos[n].setName("" + n);
			botonera.add(btnProductos[n]);
			botonera.add(lblProductos[n]);
		}
       }
			textArea = new JTextArea();  // Ajusta las filas y columnas según sea necesario
			textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        
		
		principal.add(botonera);
		principal.add(new JScrollPane(textArea));
		this.add(atras,BorderLayout.NORTH);
		this.add(principal,BorderLayout.CENTER);
		this.add(finalizarCompra,BorderLayout.SOUTH);
		this.repaint();
		this.revalidate();
		this.setVisible(true);
		rellenarProductosComprados();
		
		atras.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelTipos();

			}
		});
		finalizarCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelResumen();
				
			}
		});

	}

	private void inicializarProductos(int tipo) {
		int cant=GestorProductos.numProductosTipo(tipo);
		botonera=new JPanel();
		GridLayout gridLayout = new GridLayout(cant, 2);
		gridLayout.setVgap(10);
		gridLayout.setHgap(10);
		botonera.setLayout(gridLayout);
		
		
		
		if (cant> 0) {
			identificadores=GestorProductos.getIdentificadoresTipo(tipo);
			productos = GestorProductos.getProductosTipo(tipo);
			precios = GestorProductos.getPreciosTipo(tipo);
			imagenes = GestorProductos.getImagenesTipo(tipo);
			

	}
	}

	private JButton crearBoton(String nombre, String rutaImagen,int id) {
		JButton boton = new JButton();
		ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
		// Escalar la imagen al tamaño del botón
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		// Establecer la imagen escalada como icono del botón
		boton.setIcon(iconoEscalado);
		boton.setActionCommand(Integer.toString(id));

		return boton;

	}
	
	private void rellenarProductosComprados() {
		textArea.removeAll();
		String texto="";
		for(int n=0;n<Productos.nombres.length;n++) {
			if(Productos.cantidadComprada[n]>0 && Productos.tipos[n]==tipo) {
				texto+=Productos.cantidadComprada[n]+" Ud. de "+Productos.nombres[n]+
						"\n Precio unitario= "+Productos.precios[n]+"\n---------------\n";
				
			}
			textArea.setText(texto);
			
		}
		textArea.repaint();
		textArea.revalidate();
		
	}

}
