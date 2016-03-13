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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

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
	}
	void linkControler (Controler controler)
	{
		this.controler = controler;
	}
	void createMenu()
	{
		
		Dimension buttonSize = new Dimension(200,60);
		menuPanel = new JPanel();
		JButton buttonNewBill = new JButton("Dodaj rachunek");
		JButton buttonDebtTable = new JButton ("Tabela dï¿½ugï¿½w");
		JButton buttonExit = new JButton ("Wyjdï¿½");
		
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
		//TODO: czy to teraz w ogóle jest? Nie ustaliliœmy jak to ma wygl¹daæ...
	}
	void createNewBill()
	{
		billPanel = new JPanel();
		JButton allButton = new JButton ("Do rozliczenia");
		JButton moreButton = new JButton ("Wiêcej opcji ->");
		JButton addPayerButton = new JButton ("Dodaj p³atnika");
		JButton addDeptorButton = new JButton ("Dodaj d³u¿nika");
		JLabel kwotaLabel = new JLabel ("Zap³acona kwota: ");
		JLabel payersLabel = new JLabel ("P³atnicy:");
		JLabel debtorsLabel = new JLabel ("D³u¿nicy:");
		JTextField kwotaTField = new JTextField();
		JTable payersTable = new JTable(6,2);
		JTable deptorsTable = new JTable (6,1);
		
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