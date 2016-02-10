package v1;

import java.util.ArrayList;

public class Bill {
	private double amount;
	private ArrayList < Pair<Person, Double> > whoPaid = new ArrayList< Pair<Person, Double> >();
	private ArrayList <Person> whoOwes = new ArrayList <Person>();
	
	public Bill()
	{
		amount = 0;
	}
	
	public  void addDebtor(Person newDebtor)
	{
		whoOwes.add(newDebtor);
	}
	
	public void addPayer(Person newPayer, double howMuch)
	{
		Pair <Person, Double> newPair = new Pair<Person, Double>(newPayer, howMuch);
		whoPaid.add(newPair);
		amount += newPair.getSecond();
	}
	public void calculateNow()
	{
		
	}
	public void addDebtToTable()
	{
		
	}
}
