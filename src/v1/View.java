package v1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class View {
	Controler controler;
	JFrame frame;
	private int screenWidth;
	private int screenHeight;
	
	public View()
	{
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("RozLicz Sie v0.1");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = (int)screenSize.getWidth();
		screenHeight = (int)screenSize.getHeight();
	}
	void linkControler (Controler controler)
	{
		this.controler = controler;
	}
	void createMenu()
	{
		frame.setBounds((screenWidth/2)-150, (screenHeight/2)-200, 300, 400);
		
		Dimension buttonSize = new Dimension(200,60);
		JPanel menuPanel = new JPanel();
		JButton buttonNewBill = new JButton("Dodaj rachunek");
		JButton buttonDebtTable = new JButton ("Tabela d�ug�w");
		JButton buttonExit = new JButton ("Wyjd�");
		
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
		buttonExit.setMaximumSize(buttonSize);
		buttonExit.setPreferredSize(buttonSize);
		buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();		
			}
		});
		menuPanel.add(Box.createVerticalStrut(40));
		menuPanel.add(buttonExit);
		
		buttonDebtTable.setMaximumSize(buttonSize);
		buttonDebtTable.setPreferredSize(buttonSize);
		buttonDebtTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonDebtTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDebtTable();
				
			}
		});
		menuPanel.add(Box.createGlue());
		menuPanel.add(buttonDebtTable);
		
		buttonNewBill.setMaximumSize(buttonSize);
		buttonNewBill.setPreferredSize(buttonSize);
		buttonNewBill.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonNewBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showNewBill();
				    
			}
		});
		menuPanel.add(Box.createGlue());
		menuPanel.add(buttonNewBill);
		menuPanel.add(Box.createVerticalStrut(40));
		
		frame.add(menuPanel);
		frame.setVisible(true);
	}
	void createDebtTable()
	{
		
	}
	void createNewBill()
	{
		
	}
	void showMenu()
	{
		
	}
	void showDebtTable()
	{
		
	}
	void showNewBill()
	{
		
	}

}
//TEST