package v1;

public class Person {

	public static int counter;
	private String name;
	private int personID;
	
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
	public void setID(int ID)
	{
		personID = ID;
	}
}
