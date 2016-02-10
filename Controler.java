package v1;

import java.awt.EventQueue;

public class Controler {

	private View view;
	private Model model;
	
	public Controler()
	{
		view = new View();
		model = new Model();
	}

	 public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Controler gameControler = new Controler();
				}
			});
		}
}
