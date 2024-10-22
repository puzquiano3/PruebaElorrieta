package vista.paneles;

import javax.swing.JPanel;

import modelo.Productos;
import vista.VentanaPrincipal;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTipos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelTipos(VentanaPrincipal v) {
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BEBIDA);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\pauz_\\git\\repository\\Vending\\multimedia\\productos\\bebidas.png"));
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.SNACK);
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\pauz_\\git\\repository\\Vending\\multimedia\\productos\\snakcs.png"));
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.BOLLERIA);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\pauz_\\git\\repository\\Vending\\multimedia\\productos\\bolleria.png"));
		btnNewButton_2.setSelectedIcon(null);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				v.mostrarPanelProductos(Productos.GOMINOLA);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\pauz_\\git\\repository\\Vending\\multimedia\\productos\\gominolas.png"));
		add(btnNewButton_3);

	}

}
