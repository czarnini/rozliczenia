package v1;

import java.util.ArrayList;

public class DebtTable {
	
	private ArrayList <Person> friendsList;
	
	public DebtTable()
	{
		friendsList = new ArrayList <Person>(); //@TODO load from file
	}
	
	public void addFriend(Person friend)
	{
		friendsList.add(friend);
	}
	
	public void addDebtToTable(ArrayList <Person> whoOwes, ArrayList <Pair> whoPaid)
	{
		//double money = 0;
		
		//for(Pair tmpPaid: whoPaid)
		//{
			//money += tmpPaid.getSecond();
		//}
		
		//money /= whoOwes.size();
		
	}
}
