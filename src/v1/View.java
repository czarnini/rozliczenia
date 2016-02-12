package v1;

import javax.swing.JFrame;

public class View {
	Controler controler;
	JFrame frame;
	
	
	public View()
	{
		frame = new JFrame();
		
	}
	void linkControler (Controler controler)
	{
		this.controler = controler;
	}
	void createMenu()
	{
		
	}

}
