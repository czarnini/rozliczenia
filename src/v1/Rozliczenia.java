package v1;

import java.awt.EventQueue;

public class Rozliczenia {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Model model = new Model();
				View view = new View();
				Controler gameControler = new Controler(model, view);
				gameControler.appStart();
			}
		});
	}

}
