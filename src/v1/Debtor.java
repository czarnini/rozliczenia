package v1;

import java.util.ArrayList;

public class Debtor {
	private Person who;
	private double hasToPay;
	private ArrayList <Pair> givesMoneyTo;
	
	public Debtor(Person newOwer)
	{
		who = newOwer;
		givesMoneyTo = new ArrayList<Pair>();
	}
	
	public Person getWho()
	{
		return who;
	}
	
	public void setDebt(double newDebt)
	{
		hasToPay = newDebt;
	}
	
	public double getDebt()
	{
		return hasToPay;
	}
	
	public void addCreditor(Pair newCreditor)
	{
		Pair pair = new Pair(newCreditor.getFirst(), newCreditor.getSecond());
		givesMoneyTo.add(pair);
	}
	
	public void addCreditor (Person whom, double howMuch)
	{
		Pair newCreditor = new Pair(whom, howMuch);
		givesMoneyTo.add(newCreditor);
	}
	
	public void showDebts ()
	{
		for(Pair tmp : givesMoneyTo)
		{
			System.out.println(tmp.getFirst().getName()+"\t"+tmp.getSecond()+"\n");
		}
	}
	

}
