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
import java.awt.Color;
import javax.swing.DropMode;

public class PanelPago extends JPanel {
	private VentanaPrincipal v;
	private JLabel lblCompraTotal,lblPagado,lblDebe;
	private double cantTotal,pagado,pendiente;
	private String placeHolder="Introduzca una cantidad";
	private JTextArea textArea;
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public PanelPago(VentanaPrincipal v) {
		
		this.v=v;
		setLayout(new GridLayout(0, 1, 100, 0));
		Font fuente=new Font("Tahoma", Font.PLAIN, 25);
		cantTotal=GestorProductos.totalConIva();
		pagado=0;
		pendiente=cantTotal;
		
		lblCompraTotal = new JLabel(String.format("Total compra: %.2f",cantTotal));
		lblCompraTotal.setFont(fuente);
		lblPagado= new JLabel("Pagado : 0,00 Euros");
		lblPagado.setFont(fuente);
		
		lblDebe= new JLabel(String.format("Debe: %.2f",pendiente));
		lblDebe.setFont(fuente);
		textArea = new JTextArea();
		textArea.setTabSize(15);
		textArea.setLineWrap(true);
		textArea.setBackground(new Color(255, 128, 255));
		textArea.setFont(textArea.getFont().deriveFont(textArea.getFont().getSize() + 12f));
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
		add(lblDebe);
		add(textArea);
		add(btnPagar);
		btnPagar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if(pagar()) {
				v.mostrarPanelCambio(cantTotal, pagado);
			}}
		});
		btnAtras.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				v.mostrarPanelResumen();
				
			}
		});

	}
	
	private boolean pagar() {
		boolean result=false;
		double pago;
		String pagoTexto;
		
		pagoTexto=textArea.getText();
		if(pagoTexto.equals(placeHolder)) {
			JOptionPane.showMessageDialog(null, "Introduzca una cantidad");
		} else {
			try {pago=Double.parseDouble(pagoTexto);
			
			pagado+=pago;
			pendiente-=pago;
			
				lblPagado.setText(String.format("Pagado: %.2f Euros",pagado));
				
			if(pendiente<=0) {
				lblDebe.setText(String.format("Su cambio es: %.2f",pendiente*-1));
				result=true;
				
				
			}else {
				lblDebe.setText(String.format("Debe: %.2f",pendiente));
				
			}
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "El valor introducido no es correcto"+e.getMessage());
				e.printStackTrace();
				
			}
		}
		
		
		
		return result;
		
		
	}

}
