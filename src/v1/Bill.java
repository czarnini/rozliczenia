package v1;

import java.util.ArrayList;
import java.util.Collections;

public class Bill {
	private double amount;
	private ArrayList <Pair>   whoPaid;
	private ArrayList <Debtor> whoOwes;
	private ArrayList <Pair>   bonuses; 
	
	public Bill()
	{
		amount = 0;
		whoOwes = new ArrayList <Debtor>();
		whoPaid = new ArrayList <Pair>();
	}
	
	public  void addDebtor(Person who)
	{
		Debtor newDebtor = new Debtor(who);
		whoOwes.add(newDebtor);
	}
	
	public void addPayer(Person newPayer, double howMuch)
	{
		Pair newPair = new Pair(newPayer, howMuch);
		whoPaid.add(newPair);
		amount += newPair.getSecond();
	
	}
	public int numberOfFriends()
	{
		return (whoPaid.size() + whoOwes.size());
	}
	
	public void addBonuser()
	{
		
		for (Pair tmp: whoPaid)
		{
			Pair newPair = new Pair(tmp.getFirst() , 0.0);
			bonuses.add(newPair);
		}
		for (Debtor tmp: whoOwes)
		{
			Pair newPair = new Pair(tmp.getWho() , 0.0);
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
	
	public void printAllDebts()
	{
		for (Debtor tmp: whoOwes)
		{
			System.out.println(tmp.getWho().getName()+"  Owes:");
			tmp.showDebts();
			System.out.println("------------------------------");
		}
	}
	public void calculateNow(Boolean bonus)
	{
		double  perCapita=0,
				wasPaid=0,
				peopleInEvent=whoOwes.size()+whoPaid.size(); //what if someone takes bonus only??
		
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
	    
	    for(Debtor tmp: whoOwes)
	    {
	    	tmp.setDebt(perCapita);
	    }
	    
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
	    for(int i = whoPaid.size()-1; i>=0; --i)
	    {
	    	Pair tmp = whoPaid.get(i);
	    	if (tmp.getSecond()<0)
	    	{
	    		Debtor newOwer = new Debtor(tmp.getFirst());
	    		tmp.multiply(-1.0);
	    		whoOwes.add(0, newOwer);
	    		newOwer.setDebt(tmp.getSecond());
	    	} 
	    	else break;
	    }
		
		// 6. For each debtor take take next payer in the list and give him as much money as possible
		//@TODO BONUSES!
	    Collections.sort(whoPaid, new DecreasingComparator ());
	    for(Debtor tmpDebt: whoOwes)
	    {
	    	if(tmpDebt.getDebt() != 0.0)
	    	{
		    	double hasToPay = tmpDebt.getDebt();
		    	
		    	for(Pair tmpPay: whoPaid)
		    	{
		    		if(tmpPay.getSecond() != 0.0)
		    		{
			    		double delta = tmpPay.getSecond() - hasToPay;	
			    		if (delta <= 0) // hasToPay is greater (or equal)than tmpPay should get
			    		{
			    			tmpDebt.addCreditor(tmpPay);		// tmpDebt gives tmpPay as much as tmpPay needs
			    			hasToPay -= tmpPay.getSecond();		// tmpDebt now has smaller debt
			    			tmpDebt.setDebt(hasToPay);
			    			tmpPay.setSecond(0.0);				//	tmpPay will not get any more money from now on 
			    			if (delta == 0)						//  if tmpDebt paid his whole debt he does not need to pay anymore
			    				break;
			    		}
			    		else  // tmpPay should get more money that tmpDebt can give him
			    		{
			    			tmpDebt.addCreditor(tmpPay.getFirst(), hasToPay); // tmpDebt gives all his money
			    			tmpDebt.setDebt(0.0); 							  // and doesn't need to pay anymore
			    			tmpPay.decrease(hasToPay);						  // but tmpPay needs to get some more money
			    			break;											  // Proceed to next Debtor
			    		}
		    		}
		    	
		    	}
	    	}
	    }
		
		
	}

	
	
}