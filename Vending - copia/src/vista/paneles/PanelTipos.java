package vista.paneles;

import javax.swing.JPanel;

import modelo.Productos;
import vista.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Image;

import net.miginfocom.swing.MigLayout;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelTipos extends JPanel {

	private static final long serialVersionUID = 1L;
	private String ruta="multimedia\\tipos\\";

	/**
	 * Create the panel.
	 */
	public PanelTipos(VentanaPrincipal v) {
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		JButton btnAtras= new JButton("ATRAS");
		panel.setPreferredSize(new Dimension(100, 100));
		add(btnAtras,BorderLayout.NORTH);	
		add(panel,BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 10, 10));
		JButton btnBebidas = crearBoton("BEBIDAS",ruta+"bebidas.png");
		panel.add(btnBebidas);
		JButton btnBolleria = crearBoton("BOLLERIA",ruta+"bolleria.png");
		JButton btnGominiolas = crearBoton("GOMINOLAS",ruta+"gominolas.png");
		JButton btnSnacks = crearBoton("SNACKS",ruta+"snakcs.png");
		panel.add(btnBolleria);
		panel.add(btnGominiolas);
		panel.add(btnSnacks);
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelInicio();
			}
		});
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BEBIDA);
			}
		});

		
		
		
		btnBolleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BOLLERIA);
			}
		});
	
		
		

		btnGominiolas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.GOMINOLA);
			}
		});
		
		

		btnSnacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.SNACK);
				
			}
		});

	}
	private JButton crearBoton(String nombre, String rutaImagen) {
		JButton boton = new JButton(nombre);
		ImageIcon imagenOriginal = new ImageIcon(rutaImagen);
		// Escalar la imagen al tamaño del botón
		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		// Establecer la imagen escalada como icono del botón
		boton.setIcon(iconoEscalado);

		return boton;

	}
}
