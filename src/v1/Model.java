package v1;

public class Model {
	
	public void test1()
	{
	Person  platnik1 = new Person("Platnik1"),
			platnik2 = new Person("Platnik2"),
    		platnik3 = new Person("Platnik3"),
    		platnik4 = new Person("Platnik4"),
    		dluznik1 = new Person("dluznik1"),
    		dluznik2 = new Person("dluznik2"),
    		dluznik3 = new Person("dluznik3"),
    		dluznik4 = new Person("dluznik4");
	
	
    		
	Bill 	rachunek1 = new Bill();
	rachunek1.addPayer(platnik1, 160);
	rachunek1.addPayer(platnik2, 20);

	rachunek1.addDebtor(dluznik1);
	rachunek1.addDebtor(dluznik2);
	rachunek1.addDebtor(dluznik3);
	
	rachunek1.calculateNow(false);

	rachunek1.printAllDebts();
	
	}
	
}

