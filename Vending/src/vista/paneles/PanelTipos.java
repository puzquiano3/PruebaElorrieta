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
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(144, 97, 371, 245);
		add(panel);
		panel.setLayout(null);
		
		JButton btnBebidas = new JButton("BEBIDAS");
		btnBebidas.setBounds(20, 10, 161, 56);
		panel.add(btnBebidas);
		btnBebidas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BEBIDA);
			}
		});
		btnBebidas.setIcon(new ImageIcon(ruta+"bebidas.png"));
		
		JButton btnSnacks = new JButton("SNACKS");
		btnSnacks.setBounds(20, 61, 161, 56);
		panel.add(btnSnacks);
		btnSnacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.SNACK);
				
			}
		});
		btnSnacks.setIcon(new ImageIcon(ruta+"snakcs.png"));
		
		JButton btnBolleria = new JButton("BOLLERIA");
		btnBolleria.setBounds(20, 114, 161, 56);
		panel.add(btnBolleria);
		btnBolleria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BOLLERIA);
			}
		});
		btnBolleria.setIcon(new ImageIcon(ruta+"bolleria.png"));
		btnBolleria.setSelectedIcon(null);
		
		JButton btnGominiolas = new JButton("GOMINOLAS");
		btnGominiolas.setBounds(20, 169, 161, 56);
		panel.add(btnGominiolas);
		btnGominiolas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.GOMINOLA);
			}
		});
		btnGominiolas.setIcon(new ImageIcon(ruta+"gominolas.png"));

	}
}
