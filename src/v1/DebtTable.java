package v1;

import java.util.ArrayList;
import java.lang.Math;

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
	
	public void addDebtToTable(ArrayList <Person> whoOwesFirst, ArrayList <Pair> whoPaid, ArrayList <Double> moneyFromOwes)
	{
		
		ArrayList<Pair> whoOwes = new ArrayList<Pair>();
		
		for(int i=0; i<whoOwesFirst.size(); ++i)
		{
			Pair newPair = new Pair(whoOwesFirst.get(i), moneyFromOwes.get(i));
			whoOwes.add(newPair);
		}
		
		//whoOwes  whoPaid   moneyFromOwes
		for(Pair tempPaid: whoPaid)
		{
			for(Person mainList: friendsList)
			{
				if(tempPaid.getFirst().getName().equals(mainList.getName()))
				{
					for(Pair tempOwes: whoOwes)
					{
						if(mainList.anyRelation(tempOwes.getFirst()))
						{
							double howMuch;
							double howMuch2 = tempPaid.getSecond();
							double howMuch3 = tempOwes.getSecond();
							howMuch = mainList.howBigDebtIs(tempOwes.getFirst());
							
							howMuch = Math.min(howMuch, howMuch2);
							howMuch = Math.min(howMuch, howMuch3);
							
						}
					}
									
				}
			}
		}
	}
}
