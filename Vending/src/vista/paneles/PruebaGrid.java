package vista.paneles;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PruebaGrid extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PruebaGrid() {
		setLayout(new GridLayout(6, 2));
		
		JButton btnNewButton = new JButton("New button");
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("New button");
		add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("New button");
		add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("New button");
		add(btnNewButton_4);
		
		JButton btnNewButton_2 = new JButton("New button");
		add(btnNewButton_2);
		
		JButton btnNewButton_7 = new JButton("New button");
		add(btnNewButton_7);
		
		JButton btnNewButton_6 = new JButton("New button");
		add(btnNewButton_6);

	}

}
