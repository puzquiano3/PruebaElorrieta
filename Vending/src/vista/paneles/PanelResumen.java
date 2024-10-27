package vista.paneles;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import modelo.Productos;
import vista.VentanaPrincipal;

public class PanelResumen extends JPanel {
	private VentanaPrincipal v;
	JTextArea textArea;
	
	public PanelResumen(VentanaPrincipal v) {
		inicializar(v);
		
		
	}
	
	private void inicializar(VentanaPrincipal v) {
		JButton atras = new JButton("ATRAS");
		JButton pagarCompra= new JButton("REALIZAR PAGO");
		setLayout(new BorderLayout());
		textArea = new JTextArea();  // Ajusta las filas y columnas según sea necesario
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        add(atras,BorderLayout.NORTH);
        add(new JScrollPane(textArea),BorderLayout.CENTER);
        add(pagarCompra,BorderLayout.SOUTH);
        rellenarProductosComprados();
        atras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelTipos();
			}
		});
        
        pagarCompra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelPago();
				
			}
		});
            	
		
	}
	private void rellenarProductosComprados() {
		textArea.removeAll();
		String texto="";
		for(int n=0;n<Productos.nombres.length;n++) {
			if(Productos.cantidadComprada[n]>0) {
				texto+=Productos.cantidadComprada[n]+" Ud. de "+Productos.nombres[n]+" Precio unitario= "+Productos.precios[n]+"\n";
				
			}
			textArea.setText(texto);
			
		}
		textArea.repaint();
		textArea.revalidate();
		
	}
	

}
