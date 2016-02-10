package v1;

public class Pair <A, B> 
{
	private A first;
	private B second;
	
	public Pair(A first, B second)
	{
		this.first = first;
		this.second = second;	
	}
	public void setFirst(A newFirst)
	{
		first = newFirst;
	}
	public A getFirst()
	{
		return first;
	}
	public void setSecond(B newSecond)
	{
		second = newSecond;
	}
	public B getSecond()
	{
		return second;
	}	
}	
