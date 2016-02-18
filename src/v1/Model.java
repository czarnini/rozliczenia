package v1;

import java.util.ArrayList;

	public class Model {
	private ArrayList <Person> friendsList;
	private ArrayList <Bill> previousBills; //?
	
	
	
	public Model()
	{
		friendsList = new ArrayList <Person>(); //@TODO load from file
		previousBills = new ArrayList<Bill>();
	}
	
	public void addFriend(Person friend)
	{
		friendsList.add(friend);
	}
	
	public void deleteFriend(String name)
	{
		for(int i = 0; i != friendsList.size(); ++i)
		{
			if (friendsList.get(i).getName() == name)
			{
				friendsList.remove(i);
			}
		}
	}
	
	public void addBill (double amount, 
						 ArrayList<Pair> whoPays, 
						 ArrayList<Debtor> whoOws,
						 ArrayList<Pair> bonuses)
	{
		Bill newBill = new Bill(amount, whoPays, whoOws, bonuses);
		previousBills.add(newBill);
	}
	
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
	addFriend(platnik1);
	addFriend(platnik2);
	addFriend(platnik3);
	addFriend(platnik4);
	addFriend(dluznik1);
	deleteFriend("Platnik2");
	
	
	
    /*		
	Bill 	rachunek1 = new Bill();
	rachunek1.addPayer(platnik1, 45);
	rachunek1.addPayer(platnik2, 60);
	//rachunek1.addPayer(platnik3, 10);
	//rachunek1.addPayer(platnik4, 50);

	rachunek1.addDebtor(dluznik1);
	rachunek1.addDebtor(dluznik2);
	//rachunek1.addDebtor(dluznik3);
	rachunek1.addBonus(platnik1, 10.0);
	rachunek1.addBonus(dluznik1, 20.0);
	rachunek1.addBonus(dluznik2, 10.0);
	rachunek1.calculateNow(true);

	rachunek1.printAllDebts();*/
	
	}
	
}

