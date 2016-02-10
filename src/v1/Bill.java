package v1;

import java.util.ArrayList;
import java.util.Collections;

public class Bill {
	private double amount;
	private ArrayList < Pair > whoPaid;
	private ArrayList <Person> whoOwes;
	private ArrayList <Pair>   bonuses; 
	
	public Bill()
	{
		amount = 0;
		whoOwes = new ArrayList <Person>();
		whoPaid = new ArrayList< Pair>();
	}
	
	public  void addDebtor(Person newDebtor)
	{
		whoOwes.add(newDebtor);
	}
	
	public void addPayer(Person newPayer, double howMuch)
	{
		Pair newPair = new Pair(newPayer, howMuch);
		whoPaid.add(newPair);
		amount += newPair.getSecond();
	
	}
	
	public void addBonuser()
	{
		
		for (Pair tmp: whoPaid)
		{
			Pair newPair = new Pair(tmp.getFirst() , 0.0);
			bonuses.add(newPair);
		}
		for (Person tmp: whoOwes)
		{
			Pair newPair = new Pair(tmp , 0.0);
			bonuses.add(newPair);
		}
		
	}
	
	public void setBonus(Person whose, double howMuch)
	{
		for(Pair tmp: bonuses)
		{
			if (tmp.getFirst() == whose)
			{
				tmp.setSecond(howMuch);
				break;
			}
		}
	}
	
	public void calculateNow(Boolean bonus)
	{
		double  perCapita=0,
				wasPaid=0,
				peopleInEvent=whoOwes.size()+whoPaid.size();
		
		// 1. Add money given by payers, check if there is something left, sort payers by amount of money paid
		for(Pair tmp: whoPaid)
		{
			wasPaid += tmp.getSecond();
		}
	
			wasPaid -= amount;  // from now on wasPaid is change given
		
	    if( wasPaid < 0)
		{
			System.out.println("Fakap");
		}
	    
	    
		// 2. if bonus == true  first subtract all bonuses from amount, 
	    //	  then divide  money paid by amount of people in the event -> perCapita
	    if(bonus)
	    	for(Pair tmp: bonuses)
	      		amount -= tmp.getSecond(); 
	    perCapita = amount / peopleInEvent;
	    
		// 3. Subtract perCapita from money given by payers
		//	  3a. if payer had any bonuses subtract them as well 
	    // 	  3b. sort the payers list
	    for(Pair tmp: whoPaid)
	    {
	    	tmp.decrease(perCapita);
	    	if(bonus)
	    	{
	    		for(Pair find: bonuses)
	    		{
	    			if (find.getFirst() == tmp.getFirst() )
	    			{
	    				tmp.decrease(find.getSecond());
	    			}
	    		}
	    	}
	    }
	    Collections.sort(whoPaid, new DecreasingComparator ());
	    // 4.  if there is any change give as much as possible of it to the most generous payer
	    for(int i=0;wasPaid != 0; ++i)
	    {
	    	double tmp = whoPaid.get(i).getSecond();
	    	if(tmp < wasPaid ) 
	    	{
	    		whoPaid.get(i).increase(tmp); // take as much as you should
	    		wasPaid -= tmp;				  // and give the rest to the others
	    		
	    	}
	    	else
	    	{
	    		whoPaid.get(i).increase(wasPaid); //take all the money
	    		wasPaid = 0;
	    	}
	    }
	    
	   
		// 5. If amount of money given by any of the payers is below 0 multiply by -1
		// 	  and add this payer as debtor
	    Collections.sort(whoPaid, new IncreasingComparator ());
	    for(Pair tmp: whoPaid)
	    {
	    	if (tmp.getSecond()<0)
	    	{
	    		//@TODO gdzie wpisywac dlugi?
	    	}
	    	else break;
	    }
		
		// 6. For each debtor take take next payer in the list and give him as much money as possible

		//
		
		
	}
	public void addDebtToTable()
	{
		
	}
}