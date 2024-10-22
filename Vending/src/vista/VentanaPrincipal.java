package vista;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import vista.paneles.Panel1;
import vista.paneles.Panel2;
import vista.paneles.PanelInicial;
import vista.paneles.PanelInterno;



public class VentanaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panelActual; // Panel que se muestra actualmente

    public VentanaPrincipal() {
        setTitle("Aplicación con Paneles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        
        // Configuración inicial del contenido
        panelActual = new PanelInicial(this); // Mostrar PanelPrincipal al inicio
        getContentPane().add(panelActual);

        setVisible(true);
    }

    // Método para cambiar el panel actual
    public void cambiarPanel(JPanel nuevoPanel) {
        // Eliminar el panel actual del JFrame
        getContentPane().remove(panelActual);
        
        // Cambiar al nuevo panel
        panelActual = nuevoPanel;
        getContentPane().add(panelActual);
        
        // Actualizar la interfaz gráfica
        revalidate();
        repaint();
    }

    // Método para volver al PanelPrincipal
    public void mostrarPanelInicio() {
        cambiarPanel(new PanelInicial(this));
    }

    // Método para mostrar un Panel1, Panel2, etc.
    public void mostrarPanel1() {
        cambiarPanel(new Panel1(this));
    }
    public void mostrarPanel2() {
        cambiarPanel(new Panel2(this));
    }

    // Punto de entrada de la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
    }
}


//public class VentanaPrincipal extends JFrame {
//	
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	private PanelInicial panelInicial;
//	private PanelInterno panel1;
//	private PanelInterno panel2;
//
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaPrincipal frame = new VentanaPrincipal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public VentanaPrincipal() {
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setLayout(new CardLayout());
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		panelInicial= new PanelInicial(this);
//		panel1= new PanelInterno(this);
//		panel2= new PanelInterno(this);
//		contentPane.add(panel1);
//		contentPane.add(panel2);
//		contentPane.add(panelInicial);
//		mostrarPanelInicio();
//		setContentPane(contentPane);
//	}
//	
//	@SuppressWarnings("deprecation")
//	public void mostrarPanelInicio() {
//panelInicial.show();
//		
//		
//	}
//	public void mostrarPanel1() {
//	panel1.show();
//		
//		
//	}
//	public void mostrarPanel2() {
//	panel2.show();
//	}
//}
