package v1;

import java.awt.EventQueue;

public class Rozliczenia {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Model model = new Model();
				View view = new View();
				Controler controler = new Controler(model, view);
				controler.appStart();
				//model.test1();
			}
		});
	}
}	
/* TESTy BOGUCA	
	public static void main(String[] args) {
		Model model = new Model();
		model.test1();
	}

}
*/