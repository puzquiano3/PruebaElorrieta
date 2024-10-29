package vista.paneles;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextArea;

import controlador.GestorProductos;
import modelo.Productos;
import vista.VentanaPrincipal;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class PanelCambio extends JPanel {
	private VentanaPrincipal v;
	private double[] billetes= {200,100,50,20,10,5};
	private double[] monedas= {2,1,0.5,0.2,0.1,0.05,0.02,0.01};
	private int[] cantBilletes= new int[6];
	private int[] cantMonedas= new int[8];
	private JLabel lblCompraTotal,lblPagado,lblCambio;
	private double cantTotal,cantPagada,cambio;
	private String placeHolder="Introduzca una cantidad";
	private JTextArea textArea;
	private String mensajeCambio;

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	
	public PanelCambio(VentanaPrincipal v,double cantTotal,double cantPagada) {
		
		this.v=v;
		setLayout(new GridLayout(1,2));
		JPanel panelIzq=new JPanel();
		panelIzq.setLayout(new GridLayout(4,0));
		JPanel panelDch= new JPanel();
		panelDch.setLayout(new GridLayout(0,1));
		Font fuente=new Font("Tahoma", Font.PLAIN, 25);
		this.cantTotal=cantTotal;
		
		this.cantPagada=cantPagada;
		this.cambio=(cantTotal-cantPagada)*-1;
		cambio=Math.round(cambio*100.0)/100.0;
		
		lblCompraTotal = new JLabel(String.format("Total compra: %.2f",cantTotal));
		lblCompraTotal.setFont(fuente);
		lblPagado= new JLabel(String.format("Total pagado: %.2f",cantPagada));
		lblPagado.setFont(fuente);
		
		lblCambio= new JLabel(String.format("Cambio pendiente: %.2f",cambio));
		lblCambio.setFont(fuente);
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
       textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

		panelIzq.add(lblCompraTotal);
		panelIzq.add(lblPagado);
		panelIzq.add(lblCambio);
		
			cobrar();
			rellenarArea();
			panelDch.add(textArea);
			add(panelIzq);
			add(panelDch);
			new Thread(new Runnable() {
			    @Override
			    public void run() {
			        try {
			            Thread.sleep(5000); 
			            resetearStrings();// Pausa de 10 segundos
			            v.mostrarPanelInicio(); // Llama al método después de la pausa
			        } catch (InterruptedException e) {
			            e.printStackTrace(); // Manejo de la excepción si el hilo es interrumpido
			        }
			    }
			}).start();
			


	}
	private void rellenarArea() {
		mensajeCambio="El detalle de su cambio es el siguiente \n";
		for(int n=0;n<billetes.length;n++) {
			if(cantBilletes[n]>0) {
				//textArea.setText(crearLabel(n,"Billetes"));
				mensajeCambio+=""+cantBilletes[n]+String.format(" Billetes de %.2f Euros\n",billetes[n]);
			}
			
		}
		for(int n=0;n<monedas.length;n++) {
			if(cantMonedas[n]>0) {
				//textArea.add(crearLabel(n,"Monedas"));
				mensajeCambio+=""+cantMonedas[n]+String.format(" Monedas de %.2f Euros\n",monedas[n]);
			}
			
		}
		textArea.setText(mensajeCambio);
	
		
	}
	private void cobrar() {
		double restante=cambio;
		
		for(int n=0;n<billetes.length;n++) {
			while(restante-billetes[n]>=0) {
				restante-=billetes[n];
				restante=Math.round(restante*100.0)/100.0;
				cantBilletes[n]++;
			}
		}
		for(int n=0;n<monedas.length;n++) {
			while(restante-monedas[n]>=0) {
				restante-=monedas[n];
				restante=Math.round(restante*100.0)/100.0;
				cantMonedas[n]++;
			}
		}
	}
	private JLabel crearLabel(int n,String tipo) {
		if(tipo.equals("Billetes")) {
		String texto=cantBilletes[n]+" "+tipo+"de "+String.format(" %.2f Euros",billetes[n]);
		return new JLabel(texto);
		}
		if(tipo.equals("Monedas")) {
			String texto=cantMonedas[n]+" "+tipo+"de "+String.format(" %.2f Euros",monedas[n]);
			return new JLabel(texto);
			}
		return null;
			
		
	}
	private void resetearStrings() {
		Arrays.fill(cantBilletes, 0);
		Arrays.fill(cantMonedas, 0);
		Arrays.fill(Productos.cantidadComprada, 0);

	}


	

}

