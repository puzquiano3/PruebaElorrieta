package vista.paneles;

import javax.swing.JPanel;

import vista.VentanaPrincipal;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;

public class PanelInicial extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelInicial(VentanaPrincipal ventana) {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.mostrarPanelTipos();
			}
		});
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		JPanel panelImagen= new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout());
		
		JLabel lblNewLabel = new JLabel("BIENVENIDOS A ELORRIETA");
		panel.add(lblNewLabel,BorderLayout.CENTER);
		
		JLabel lblMaquina = new JLabel();
	
		String rutaImagen="/multimedia/maquina.png";
		URL imagenURL = getClass().getResource(rutaImagen);
		ImageIcon imagenOriginal = new ImageIcon(imagenURL);
		Dimension dimension=getSize();
		
		// Escalar la imagen al tamaño del botón
	
		panelImagen.add(lblMaquina);
		add(panelImagen,BorderLayout.CENTER);

		Image imagenEscalada = imagenOriginal.getImage().getScaledInstance(500,500, Image.SCALE_SMOOTH);
		ImageIcon iconoEscalado = new ImageIcon(imagenEscalada);
		lblMaquina.setIcon(iconoEscalado);
		
		
	
	}

}
