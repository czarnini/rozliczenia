package v1;

public class Pair 
{
	private Person first;
	private double second;
	
	public Pair(Person first, Double second)
	{
		this.first = first;
		this.second = second;	
	}
	public void setFirst(Person newFirst)
	{
		first = newFirst;
	}
	public Person getFirst()
	{
		return first;
	}
	public void setSecond(Double newSecond)
	{
		second = newSecond;
	}
	
	public Double getSecond()
	{
		return second;
	}
	
	public void increase(Double x)
	{
		second += x;
	}
	
	public void decrease(Double x)
	{
		second -= x;
	}
	
}	
