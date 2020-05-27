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
	public boolean hasDishes(Order order)
	{
		int result = 0;
		
		for(int i = 0; i < drinks.size();i++)
			for(int j = 0; j < order.getDrink().size();j++)	
				if(drinks.get(i).getContent().equals(order.getDrink().get(j).getContent())
						&& drinks.get(i).getQuantity() - order.getDrink().get(j).getQuantity() >= 0)
				{
					drinks.get(i).setQuantity(drinks.get(i).getQuantity() - order.getDrink().get(j).getQuantity());
					result++;
				}
		for(int i = 0; i < starters.size();i++)
			for(int j = 0; j < order.getStarter().size();j++)	
				if(starters.get(i).getContent().equals(order.getStarter().get(j).getContent())
						&& starters.get(i).getQuantity() - order.getStarter().get(j).getQuantity() >= 0)
				{
					starters.get(i).setQuantity(starters.get(i).getQuantity() - order.getStarter().get(j).getQuantity());
					result++;
				}
		for(int i = 0; i < firsts.size();i++)
			for(int j = 0; j < order.getFirstCourse().size();j++)	
				if(firsts.get(i).getContent().equals(order.getFirstCourse().get(j).getContent())
						&& firsts.get(i).getQuantity() - order.getFirstCourse().get(j).getQuantity() >= 0)
				{
					firsts.get(i).setQuantity(firsts.get(i).getQuantity() - order.getFirstCourse().get(j).getQuantity());
					result++;
				}
		for(int i = 0; i < seconds.size();i++)
			for(int j = 0; j < order.getSecondCourse().size();j++)	
				if(seconds.get(i).getContent().equals(order.getSecondCourse().get(j).getContent())
						&& seconds.get(i).getQuantity() - order.getSecondCourse().get(j).getQuantity() >= 0)
				{
					seconds.get(i).setQuantity(seconds.get(i).getQuantity() - order.getSecondCourse().get(j).getQuantity());
					result++;
				}
		for(int i = 0; i < desserts.size();i++)
			for(int j = 0; j < order.getDessert().size();j++)	
				if(desserts.get(i).getContent().equals(order.getDessert().get(j).getContent())
						&& desserts.get(i).getQuantity() - order.getDessert().get(j).getQuantity() >= 0)
				{
					desserts.get(i).setQuantity(desserts.get(i).getQuantity() - order.getDessert().get(j).getQuantity());
					result++;
				}
		if(result == order.getNumberOfDishes())
			return true;
		return false;
	}

}
