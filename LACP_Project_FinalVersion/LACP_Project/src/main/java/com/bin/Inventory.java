package com.bin;

import java.util.ArrayList;

//This classe manage the total amount of dished in a restaurant
public class Inventory {
	private ArrayList<Drink> drinks;
	private ArrayList<Starter> starters;
	private ArrayList<FirstCourse> firsts;
	private ArrayList<SecondCourse> seconds;
	private ArrayList<Dessert> desserts;
	
	public Inventory()
	{
		//Creating List
		drinks = new ArrayList<Drink>();
		starters = new ArrayList<Starter>();
		firsts = new ArrayList<FirstCourse>();
		seconds = new ArrayList<SecondCourse>();
		desserts = new ArrayList<Dessert>();
		//Filling the drinks
		drinks.add(new Drink(0,"Soda",150,2));
		drinks.add(new Drink(0,"Water",200,1));
		drinks.add(new Drink(0,"Coca Cola",150,2));
		drinks.add(new Drink(0,"Beer",150,2));
		//Filling the starters
		starters.add(new Starter(0,"House's starter",50,7));
		starters.add(new Starter(0,"Jalapenos",80,6));
		starters.add(new Starter(0,"Toast",50,6));
		//Filling first
		firsts.add(new FirstCourse(0,"Spaghetti",50,8));
		firsts.add(new FirstCourse(0,"Rice",50,10));
		firsts.add(new FirstCourse(0,"Ravioli",50,15));
		//Filling seconds
		seconds.add(new SecondCourse(0,"Fish 'n Chips",50,5));
		seconds.add(new SecondCourse(0,"Fillet Steak",50,13));
		seconds.add(new SecondCourse(0,"Stew",50,18));
		//Filling Desserts
		desserts.add(new Dessert(0,"Ice Cream",50,5));
		desserts.add(new Dessert(0,"Panna Cotta",50,5));
		desserts.add(new Dessert(0,"Catalan Cream",50,6));
		
	}
	
	public String hasDishes(Order order)
	{
		int result = 0;
		String missedDishes = " ";
		ArrayList<Drink> copydrink = new ArrayList<Drink>();
		copydrink = cloneListDrink(drinks);
		ArrayList<Starter> copystarter = new ArrayList<Starter>();
		copystarter = cloneListStarter(starters);
		ArrayList<FirstCourse> copyfirst = new ArrayList<FirstCourse>();
		copyfirst = cloneListFirst(firsts);
		ArrayList<SecondCourse> copysecond = new ArrayList<SecondCourse>();
		copysecond = cloneListSecond(seconds);
		ArrayList<Dessert> copydessert = new ArrayList<Dessert>();
		copydessert = cloneListDessert(desserts);
		
		for(int i = 0; i < drinks.size();i++)
			for(int j = 0; j < order.getDrink().size();j++)	
				if(drinks.get(i).getContent().equals(order.getDrink().get(j).getContent()))
					if(drinks.get(i).getQuantity() - order.getDrink().get(j).getQuantity() >= 0)
					{
						
						copydrink.get(i).setQuantity(drinks.get(i).getQuantity() - order.getDrink().get(j).getQuantity());
						result++;
					}
					else
						missedDishes += drinks.get(i).getContent() + " ";
		for(int i = 0; i < starters.size();i++)
			for(int j = 0; j < order.getStarter().size();j++)	
				if(starters.get(i).getContent().equals(order.getStarter().get(j).getContent()))
					if(starters.get(i).getQuantity() - order.getStarter().get(j).getQuantity() >= 0)
					{
						
						copystarter.get(i).setQuantity(starters.get(i).getQuantity() - order.getStarter().get(j).getQuantity());
						result++;
					}
					else
						missedDishes += starters.get(i).getContent() + " ";
		for(int i = 0; i < firsts.size();i++)
			for(int j = 0; j < order.getFirstCourse().size();j++)	
				if(firsts.get(i).getContent().equals(order.getFirstCourse().get(j).getContent()))
					if(firsts.get(i).getQuantity() - order.getFirstCourse().get(j).getQuantity() >= 0)
					{
						
						copyfirst.get(i).setQuantity(firsts.get(i).getQuantity() - order.getFirstCourse().get(j).getQuantity());
						result++;
					}
					else
						missedDishes += firsts.get(i).getContent() + " ";
		for(int i = 0; i < seconds.size();i++)
			for(int j = 0; j < order.getSecondCourse().size();j++)	
				if(seconds.get(i).getContent().equals(order.getSecondCourse().get(j).getContent()))
					if( seconds.get(i).getQuantity() - order.getSecondCourse().get(j).getQuantity() >= 0)
					{
				
						copysecond.get(i).setQuantity(seconds.get(i).getQuantity() - order.getSecondCourse().get(j).getQuantity());
						result++;
					}
					else
						missedDishes += seconds.get(i).getContent() + " ";
		for(int i = 0; i < desserts.size();i++)
			for(int j = 0; j < order.getDessert().size();j++)	
				if(desserts.get(i).getContent().equals(order.getDessert().get(j).getContent()))
					if( desserts.get(i).getQuantity() - order.getDessert().get(j).getQuantity() >= 0)
					{						
						copydessert.get(i).setQuantity(desserts.get(i).getQuantity() - order.getDessert().get(j).getQuantity());
						result++;
					}
					else
						missedDishes += desserts.get(i).getContent() + " ";
		if(result == order.getNumberOfDishes())
		{
			//Once i checcked the consistency i can update my datas
			drinks = copydrink;
			firsts = copyfirst;
			seconds = copysecond;
			starters = copystarter;
			desserts = copydessert;
			
			return "";
		}
			
		return missedDishes;
	}
	
	//Clone methods
	public ArrayList<Drink> cloneListDrink(ArrayList<Drink> list) {
	    ArrayList<Drink> clone = new ArrayList<Drink>(list.size());
	    for (Drink item : list) clone.add(new Drink(item.getOrderID(),item.getContent()
	    		,item.getQuantity(),item.getPrice()));
	    return clone;
	}
	public ArrayList<Starter> cloneListStarter(ArrayList<Starter> list) {
	    ArrayList<Starter> clone = new ArrayList<Starter>(list.size());
	    for (Starter item : list) clone.add(new Starter(item.getOrderID(),item.getContent()
	    		,item.getQuantity(),item.getPrice()));
	    return clone;
	}
	public ArrayList<FirstCourse> cloneListFirst(ArrayList<FirstCourse> list) {
	    ArrayList<FirstCourse> clone = new ArrayList<FirstCourse>(list.size());
	    for (FirstCourse item : list) clone.add(new FirstCourse(item.getOrderID(),item.getContent()
	    		,item.getQuantity(),item.getPrice()));
	    return clone;
	}
	public ArrayList<SecondCourse> cloneListSecond(ArrayList<SecondCourse> list) {
	    ArrayList<SecondCourse> clone = new ArrayList<SecondCourse>(list.size());
	    for (SecondCourse item : list) clone.add(new SecondCourse(item.getOrderID(),item.getContent()
	    		,item.getQuantity(),item.getPrice()));
	    return clone;
	}
	public ArrayList<Dessert> cloneListDessert(ArrayList<Dessert> list) {
	    ArrayList<Dessert> clone = new ArrayList<Dessert>(list.size());
	    for (Dessert item : list) clone.add(new Dessert(item.getOrderID(),item.getContent()
	    		,item.getQuantity(),item.getPrice()));
	    return clone;
	}
	
	public String toString()
	{
		String result = "DRINKS:\n" ;
		for(Drink drink : drinks )
			result += drink.printContent();
		result += "\nSTARTERS:\n";
		for(Starter starter : starters )
			result += starter.printContent();
		result += "\nFIRST COURSES:\n";
		for(FirstCourse first : firsts )
			result += first.printContent();
		result += "\nSECOND COURSES:\n";
		for(SecondCourse second : seconds )
			result += second.printContent();
		result += "\nDESSERTS:\n";
		for(Dessert dessert : desserts )
			result += dessert.printContent();
		return result;
	}
	
}
