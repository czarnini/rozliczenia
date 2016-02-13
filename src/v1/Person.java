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
	
	public int getID()
	{
		return personID;
	}
	
	public void addDebtor(Pair newDebtor)
	{
		whoOwsWhom.add(newDebtor);
	}
	
	public void addDebtor (Person whom, double howMuch)
	{
		Pair newDebtor = new Pair(whom, howMuch);
		whoOwsWhom.add(newDebtor);
	}
}
