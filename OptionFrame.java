package v1;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class OptionFrame extends JFrame {
	
	private JButton newDebt;
	private JButton showDebts;
	
	public OptionFrame() {
		
		super("Hajs v. 1.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		
		newDebt   = new JButton("Nowy dlug");
		showDebts = new JButton("Przegladaj dlugi");
		getContentPane().add(newDebt);
		getContentPane().add(showDebts);
		pack();
		setVisible(true);
		
		
	}
}
