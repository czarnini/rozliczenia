package v1;

import java.util.ArrayList;

public class Person {

	private static int counter = 0;
	private String name;
	private int personID;
	private ArrayList <Pair> whoOwsWhom;
	
	public Person (String name)
	{
		this.name = name;
		personID = counter;
		whoOwsWhom = new ArrayList<Pair>();
		++counter;
		
	}
	public String getName()
	{
		return name;
	}
	public void setName(String newName)
	{
		name = newName;
	}
	
	public boolean anyRelation(Person friend)
	{
		for(Pair tempWho: whoOwsWhom)
		{
			if(tempWho.getFirst().getName().equals(friend.getName()))
				return true;
		}
	
		return false;
	}
	
	public double howBigDebtIs(Person friend)
	{
		for(Pair tempWho: whoOwsWhom)
		{
			if(tempWho.getFirst().getName().equals(friend.getName()))
				return tempWho.getSecond();
		}
		return 0;
	}
	
	public void newDebt(Person friend, double newDebt)
	{
		for(Pair tempWho: whoOwsWhom)
		{
			if(tempWho.getFirst().getName().equals(friend.getName()))
			{
				if(newDebt == 0)
					whoOwsWhom.remove(tempWho);
				else
					tempWho.setSecond(newDebt);
			}
		}
	}
	

	
	public int getID()
	{
		return personID;
	}
	
	
}
