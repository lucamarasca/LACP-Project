package com.bin;

import java.util.ArrayList; 

import org.kie.api.runtime.KieSession;

public class Order {
	
	private final int ID;
	private OrderStatus status;
	//private OrderPriority priority;
	private ArrayList<Starter> starter;
	private ArrayList<FirstCourse> firstCourse;
	private ArrayList<SecondCourse> secondCourse;
	private ArrayList<Dessert> dessert;
	private ArrayList<Drink> drink;
	private int tableID;
	private KieSession kSession;
	private boolean consistency;

	
	public Order(int id, ArrayList<Starter> starter, ArrayList<FirstCourse> firstCourse,
			ArrayList<SecondCourse> secondCourse, ArrayList<Dessert> dessert, 
			ArrayList<Drink> drink, KieSession kSession) {
		this.ID = id;
		this.starter = starter;
		this.firstCourse = firstCourse;
		this.secondCourse = secondCourse;
		this.dessert = dessert;
		this.drink = drink;
		this.tableID = -1;
		this.kSession = kSession;
		this.consistency = false;
		this.status = OrderStatus.ORDERED;
		
	}
	public boolean isConsistency() {
		return consistency;
	}
	public void setConsistency(boolean consistency) {
		this.consistency = consistency;
	}
	public boolean Prova() {
		return true;
	}
	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public ArrayList<Starter> getStarter() {
		return starter;
	}

	public void setStarter(ArrayList<Starter> starter) {
		this.starter = starter;
	}

	public ArrayList<FirstCourse> getFirstCourse() {
		return firstCourse;
	}

	public void setFirstCourse(ArrayList<FirstCourse> firstCourse) {
		this.firstCourse = firstCourse;
	}

	public ArrayList<SecondCourse> getSecondCourse() {
		return secondCourse;
	}

	public void setSecondCourse(ArrayList<SecondCourse> secondCourse) {
		this.secondCourse = secondCourse;
	}

	public ArrayList<Dessert> getDessert() {
		return dessert;
	}

	public void setDessert(ArrayList<Dessert> dessert) {
		this.dessert = dessert;
	}

	public ArrayList<Drink> getDrink() {
		return drink;
	}

	public void setDrink(ArrayList<Drink> drink) {
		this.drink = drink;
	}

	public int getID() {
		return ID;
	}
	

	public int getTableID() {
		return tableID;
	}

	public void setTableID(int tableID) {
		this.tableID = tableID;
	}
	
	public int getNumberOfDishes()
	{
		int result = -5;
		result += this.getDrink().size() + this.getStarter().size() 
				+ this.getFirstCourse().size() + this.getSecondCourse().size()
				+this.getDessert().size();
		return result;
	}
	

	@Override
	public String toString() {
		String result = "\t\t\tORDER N." + ID + "\nstatus: " + status+ "\nstarters: " ;
		for(int i = 0; i < starter.size();i++)
			result += starter.get(i).printContent() + " ";
		result += "\nfirstCourses: " ;
		for(int i = 0; i < firstCourse.size();i++)
			result += firstCourse.get(i).printContent() + " ";
		result += "\nsecondCourses: " ;
		for(int i = 0; i < secondCourse.size();i++)
			result += secondCourse.get(i).printContent() + " ";
		result += "\ndesserts: ";
		for(int i = 0; i < dessert.size();i++)
			result += dessert.get(i).printContent() + " ";
		result += "\ndrinks: " ;
		for(int i = 0; i < drink.size();i++)
			result += drink.get(i).printContent() + " ";
		result += "\ntable: "+ tableID;
		return result;
					
				
	}
	
}
