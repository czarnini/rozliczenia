package v1;

public class Controler {

    private	View view;
	private Model model;
	
	public Controler(Model model, View view)
	{
		this.model = model;
		this.view = view;
		view.linkControler(this);
		//model.linkControler(this);
	}

	 void appStart()
	 {
		 view.createNewBill();
		 view.createDebtTable();
		 view.createMenu();
		 view.showMenu();
	 }
}
