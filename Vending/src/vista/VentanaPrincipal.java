package vista;

import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;


import vista.paneles.PanelInicial;
import vista.paneles.PanelInterno;
import vista.paneles.PanelProductos;
import vista.paneles.PanelTipos;



public class VentanaPrincipal extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel panelActual; // Panel que se muestra actualmente

    public VentanaPrincipal() {
        setTitle("Aplicación con Paneles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(679, 586);
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
    public void mostrarPanelTipos() {
        cambiarPanel(new PanelTipos(this));
    }
    public void mostrarPanelProductos(int n) {
    	cambiarPanel(new PanelProductos(this,n));
    }


    // Punto de entrada de la aplicación
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal();
        });
    }
}



