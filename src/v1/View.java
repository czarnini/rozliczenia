package v1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class View {
	Controler controler;
	JFrame frame;
	JPanel menuPanel;
	JPanel billPanel;
	JPanel debtTablePanel;
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
		menuPanel = new JPanel();
		billPanel = new JPanel();
		debtTablePanel = new JPanel();
		frame.add(billPanel);
	//	frame.add(debtTablePanel);
	//	frame.add(menuPanel);
		frame.setVisible(true);
	}
	void linkControler (Controler controler)
	{
		this.controler = controler;
	}
	void createMenu()
	{
		
		Dimension buttonSize = new Dimension(200,60);
		JButton buttonNewBill = new JButton("Dodaj rachunek");
		JButton buttonDebtTable = new JButton ("Tabela d³ugów");
		JButton buttonExit = new JButton ("WyjdŸ");
		
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
		buttonNewBill.setMaximumSize(buttonSize);
		buttonNewBill.setPreferredSize(buttonSize);
		buttonNewBill.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonNewBill.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showNewBill();
				    
			}
		});
		menuPanel.add(Box.createVerticalStrut(40));
		menuPanel.add(buttonNewBill);
		menuPanel.add(Box.createGlue());
		
		buttonDebtTable.setMaximumSize(buttonSize);
		buttonDebtTable.setPreferredSize(buttonSize);
		buttonDebtTable.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonDebtTable.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showDebtTable();
				
			}
		});
		menuPanel.add(buttonDebtTable);
		
		buttonExit.setMaximumSize(buttonSize);
		buttonExit.setPreferredSize(buttonSize);
		buttonExit.setAlignmentX(Component.CENTER_ALIGNMENT);
		buttonExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();		
			}
		});
		menuPanel.add(Box.createGlue());
		menuPanel.add(buttonExit);
		menuPanel.add(Box.createVerticalStrut(40));
	}
	void createDebtTable()
	{
		//TODO: czy to teraz w ogóle jest? Nie ustaliliœmy jak to ma wygl¹daæ...
	}
	void createNewBill()
	{ //wymiary: 600x600
		JButton allButton = new JButton ("Do rozliczenia");
		JButton moreButton = new JButton ("Wiêcej opcji >>");
		JButton backButton = new JButton("Wróæ");
		JButton addPayerButton = new JButton ("Dodaj p³atnika");
		JButton addDeptorButton = new JButton ("Dodaj d³u¿nika");
		JLabel kwotaLabel = new JLabel ("Zap³acona kwota: ");
		JLabel payersLabel = new JLabel ("P³atnicy:");
		JLabel debtorsLabel = new JLabel ("D³u¿nicy:");
		JTextField kwotaTField = new JTextField();
		JTable payersTable = new JTable(12,2);
		JTable deptorsTable = new JTable (12,1);
		SpringLayout layout = new SpringLayout();
		billPanel.setLayout(layout);
//layout.putConstraint(SpringLayout.NORTH, label1, 10, SpringLayout.NORTH, panel);
//layout.putConstraint(SpringLayout.WEST, label1, 5, SpringLayout.WEST, panel);
		kwotaLabel.setFont(new Font(null, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		layout.putConstraint(SpringLayout.NORTH, kwotaLabel,20, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, kwotaLabel, 150, SpringLayout.WEST, billPanel);
		billPanel.add(kwotaLabel);
		
		kwotaTField.setPreferredSize(new Dimension (120,20));
		layout.putConstraint(SpringLayout.NORTH, kwotaTField, 20, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, kwotaTField, 300, SpringLayout.WEST, billPanel);
		billPanel.add(kwotaTField);
		
		addDeptorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Okno dialogowe
				
			}
		});
		layout.putConstraint(SpringLayout.NORTH, addDeptorButton, 60, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, addDeptorButton, 400, SpringLayout.WEST, billPanel);
		billPanel.add(addDeptorButton);
		
		addPayerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		layout.putConstraint(SpringLayout.NORTH, addPayerButton, 60, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, addPayerButton, 100, SpringLayout.WEST, billPanel);
		billPanel.add(addPayerButton);
		
		payersLabel.setFont(new Font(null, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		layout.putConstraint(SpringLayout.NORTH, payersLabel,100, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, payersLabel, 135, SpringLayout.WEST, billPanel);
		billPanel.add(payersLabel);
		
		debtorsLabel.setFont(new Font(null, Font.LAYOUT_LEFT_TO_RIGHT, 14));
		layout.putConstraint(SpringLayout.NORTH, debtorsLabel,100, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, debtorsLabel, 435, SpringLayout.WEST, billPanel);
		billPanel.add(debtorsLabel);
		
		payersTable.setPreferredSize(new Dimension (200,200));
		layout.putConstraint(SpringLayout.NORTH, payersTable,120, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, payersTable, 50, SpringLayout.WEST, billPanel);
		billPanel.add(payersTable);
		
		deptorsTable.setPreferredSize(new Dimension (200,200));
		layout.putConstraint(SpringLayout.NORTH, deptorsTable,120, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, deptorsTable, 350, SpringLayout.WEST, billPanel);
		billPanel.add(deptorsTable);
		
		backButton.setPreferredSize(new Dimension(140, 28));
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//showMenu();
			}
		});
		layout.putConstraint(SpringLayout.NORTH, backButton,350, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, backButton, 45, SpringLayout.WEST, billPanel);
		billPanel.add(backButton);
		
		allButton.setPreferredSize(new Dimension(140, 28));
		allButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		layout.putConstraint(SpringLayout.NORTH, allButton,350, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, allButton, 230, SpringLayout.WEST, billPanel);
		billPanel.add(allButton);
		
		moreButton.setPreferredSize(new Dimension(140, 28));
		moreButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			}
		});
		layout.putConstraint(SpringLayout.NORTH, moreButton,350, SpringLayout.NORTH, billPanel);
		layout.putConstraint(SpringLayout.WEST, moreButton, 415, SpringLayout.WEST, billPanel);
		billPanel.add(moreButton);
	}
	void showMenu()
	{
		frame.setBounds((screenWidth/2)-150, (screenHeight/2)-200, 300, 400);
		billPanel.setVisible(false);
		debtTablePanel.setVisible(false);
		menuPanel.setVisible(true);
	}
	void showDebtTable()
	{
		frame.setBounds((screenWidth/2)-300, (screenHeight/2)-300, 600, 600);
		billPanel.setVisible(false);
		menuPanel.setVisible(false);
		debtTablePanel.setVisible(true);
	}
	void showNewBill()
	{
		frame.setBounds((screenWidth/2)-300, (screenHeight/2)-300, 600, 600);
		menuPanel.setVisible(false);
		debtTablePanel.setVisible(false);
		billPanel.setVisible(true);
	}

}
//TEST