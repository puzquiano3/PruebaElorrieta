package vista.paneles;

import javax.swing.JPanel;

import modelo.Productos;
import vista.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
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
		
		panel.setPreferredSize(new Dimension(100, 100));
		add(panel,BorderLayout.CENTER);
		panel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JButton btnBebidas = new JButton("BEBIDAS");
		panel.add(btnBebidas);
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BEBIDA);
			}
		});
		btnBebidas.setIcon(new ImageIcon(ruta+"bebidas.png"));
		
		JButton btnBolleria = new JButton("BOLLERIA");
		panel.add(btnBolleria);
		btnBolleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BOLLERIA);
			}
		});
		btnBolleria.setIcon(new ImageIcon(ruta+"bolleria.png"));
		btnBolleria.setSelectedIcon(null);
		
		JButton btnGominiolas = new JButton("GOMINOLAS");
		panel.add(btnGominiolas);
		btnGominiolas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.GOMINOLA);
			}
		});
		btnGominiolas.setIcon(new ImageIcon(ruta+"gominolas.png"));
		
		JButton btnSnacks = new JButton("SNACKS");
		panel.add(btnSnacks);
		btnSnacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.SNACK);
				
			}
		});
		btnSnacks.setIcon(new ImageIcon(ruta+"snakcs.png"));

	}
}
