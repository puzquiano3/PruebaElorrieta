package vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;

import controlador.GestorProductos;
import vista.VentanaPrincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelCambio extends JPanel {
	private VentanaPrincipal v;
	private double[] billetes= {200,100,50,20,10,5};
	private double[] monedas= {2,1,0.5,0.2,0.1,0.05,0.02,0.01};
	private JLabel lblCompraTotal,lblPagado,lblCambio;
	private double cantTotal,cantPagada,cambio;
	private String placeHolder="Introduzca una cantidad";
	private JTextArea textArea;
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public PanelCambio(VentanaPrincipal v,double cantTotal,double cantPagada) {
		
		this.v=v;
		setLayout(new GridLayout(0, 1, 0, 0));
		Font fuente=new Font("Tahoma", Font.PLAIN, 25);
		this.cantTotal=cantTotal;
		
		this.cantPagada=cantPagada;
		this.cambio=(cantTotal-cantPagada)*-1;
		
		lblCompraTotal = new JLabel(String.format("Total compra: %.2f",cantTotal));
		lblCompraTotal.setFont(fuente);
		lblPagado= new JLabel(String.format("Total pagado: %.2f",cantPagada));
		lblPagado.setFont(fuente);
		
		lblCambio= new JLabel(String.format("Cambio pendiente: %.2f",cambio));
		lblCambio.setFont(fuente);
		textArea = new JTextArea();
		textArea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textArea.setText("");
			}
		});
		textArea.setText(placeHolder);
		JButton btnAtras= new JButton("ATRAS");
		JButton btnPagar = new JButton("PAGAR");
		add(btnAtras);
		add(lblCompraTotal);
		add(lblPagado);
		add(lblCambio);
		add(textArea);
		add(btnPagar);
		btnPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelResumen();
			}
		});

	}
	

}
