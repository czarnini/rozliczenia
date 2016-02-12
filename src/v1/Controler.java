package v1;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Collections;

public class Controler {

	View view;
	Model model;
	
	public Controler(Model model, View view)
	{
		this.model = model;
		this.view = view;
		view.linkControler(this);
		//model.linkControler(this);
	}

	 void appStart()
	 {
		 view.createMenu();
	 }
	
	
	/*
	 public static void main(String[] args) {
		 Person o1, o2;
		 ArrayList<Pair> lol = new ArrayList<Pair>();
		 o1 = new Person("ola");
		 o2 = new Person("ala");
		 
		 Pair p1 = new Pair(o1, 1.0);
		 lol.add(p1);
		 
		 p1 = new Pair(o2, 20.0);
		 lol.add(p1); 
		 
		 p1 = new Pair(o2, 2.0);
		 lol.add(p1);
		 
		 Collections.sort(lol, new DecreasingComparator ());
		for(Pair tmp: lol)
		{
			System.out.println(tmp.getSecond());
		}
		 
			
		}*/
}
