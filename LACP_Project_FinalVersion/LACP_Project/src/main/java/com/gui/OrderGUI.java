package com.gui;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

import javax.swing.*;

import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.bin.Dessert;
import com.bin.Drink;
import com.bin.FirstCourse;
import com.bin.Order;
import com.bin.OrderStatus;
import com.bin.SecondCourse;
import com.bin.Starter;
import com.google.inject.spi.Element;

import java.util.ArrayList;
public class OrderGUI extends JFrame{
	
	private KieSession kc;
	
	
	public OrderGUI(KieSession kSession) {
		
		this.kc = kSession;
		this.init();
	}
	
	private void init() {
		JFrame frame = new JFrame();
		frame.setTitle("New Order");
		frame.setSize(600,700);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel view = new JPanel(new GridLayout(0, 3));
		
		JLabel drinkD = new JLabel("\nDrink", SwingConstants.CENTER);
		
		
		JLabel empty_label1 = new JLabel("\t");
		JLabel empty_label2 = new JLabel("\t");
		
		
		Font font = new Font("Courier", Font.BOLD,24);
		drinkD.setFont(font);
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
	    view.add(empty_label1);
	    view.add(drinkD);
	    view.add(empty_label2);
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    
	    JLabel drink1 = new JLabel("Soda", SwingConstants.CENTER);
	    JLabel drink1price = new JLabel("2.00$",SwingConstants.CENTER);
		JComboBox drinkQuantity1 = new JComboBox();
		
		int numbers_to_add_max = 100;
		for (int i = 0; i <= numbers_to_add_max; i++) {
			drinkQuantity1.addItem(i);
		}
		view.add(drink1);
		view.add(drink1price);
		view.add(drinkQuantity1);
		
		JLabel drink2 = new JLabel("Water", SwingConstants.CENTER);
	    JLabel drink2price = new JLabel("1.00$", SwingConstants.CENTER);
		JComboBox drinkQuantity2 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			drinkQuantity2.addItem(i);
		}
		view.add(drink2);
		view.add(drink2price);
		view.add(drinkQuantity2);
		
		JLabel drink3 = new JLabel("Coca Cola", SwingConstants.CENTER);
		JLabel drink3price = new JLabel("2.00$", SwingConstants.CENTER);
		JComboBox drinkQuantity3 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			drinkQuantity3.addItem(i);
		}
		view.add(drink3);
		view.add(drink3price);
		view.add(drinkQuantity3);
		
		JLabel drink4 = new JLabel("Beer", SwingConstants.CENTER);
		JLabel drink4price = new JLabel("2.00$", SwingConstants.CENTER);
		JComboBox drinkQuantity4 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			drinkQuantity4.addItem(i);
		}
		view.add(drink4);
		view.add(drink4price);
		view.add(drinkQuantity4);
		
		//Just adding blank space and a separator
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(new JSeparator());
		view.add(new JSeparator());
		view.add(new JSeparator());
//++++++++++++++++++STARTER+++++++++++++++	
		JLabel empty_label3 = new JLabel("\t");
		JLabel starterc = new JLabel("Starter", SwingConstants.CENTER);
		starterc.setFont(font);
		JLabel empty_label4 = new JLabel("\t");
	    view.add(empty_label3);
	    view.add(starterc);
	    view.add(empty_label4);
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    
	    JLabel starter1 = new JLabel("House's starter", SwingConstants.CENTER);
	    JLabel starter1price = new JLabel("7.00$", SwingConstants.CENTER);
		JComboBox starterQuantity1 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			starterQuantity1.addItem(i);
		}
		view.add(starter1);
		view.add(starter1price);
		view.add(starterQuantity1);
		
		JLabel starter2 = new JLabel("Jalapenos", SwingConstants.CENTER);
		JLabel starter2price = new JLabel("6.00$", SwingConstants.CENTER);
		JComboBox starterQuantity2 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			starterQuantity2.addItem(i);
		}
		view.add(starter2);
		view.add(starter2price);
		view.add(starterQuantity2);
		
		JLabel starter3 = new JLabel("Toast", SwingConstants.CENTER);
		JLabel starter3price = new JLabel("7.00$", SwingConstants.CENTER);
		JComboBox starterQuantity3 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			starterQuantity3.addItem(i);
		}
		view.add(starter3);
		view.add(starter3price);
		view.add(starterQuantity3);
		
		//Just adding blank space and a separator
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(new JSeparator());
		view.add(new JSeparator());
		view.add(new JSeparator());
//++++++++++++++++First course+++++++++++++++++++++
		JLabel empty_label5 = new JLabel("\t");
		JLabel firstCourseD = new JLabel("First Course", SwingConstants.CENTER);
		firstCourseD.setFont(font);
		JLabel empty_label6 = new JLabel("\t");
	    view.add(empty_label5);
	    view.add(firstCourseD);
	    view.add(empty_label6);
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    
	    JLabel first1 = new JLabel("Spaghetti", SwingConstants.CENTER);
	    JLabel first1price = new JLabel("8.00$", SwingConstants.CENTER);
		JComboBox firstQuantity1 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			firstQuantity1.addItem(i);
		}
		view.add(first1);
		view.add(first1price);
		view.add(firstQuantity1);
		
		JLabel first2 = new JLabel("Rice", SwingConstants.CENTER);
		JLabel first2price = new JLabel("10.00$", SwingConstants.CENTER);
		JComboBox firstQuantity2 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			firstQuantity2.addItem(i);
		}
		view.add(first2);
		view.add(first2price);
		view.add(firstQuantity2);
		
		JLabel first3 = new JLabel("Ravioli", SwingConstants.CENTER);
		JLabel first3price = new JLabel("15.00$", SwingConstants.CENTER);
		JComboBox firstQuantity3 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			firstQuantity3.addItem(i);
		}
		view.add(first3);
		view.add(first3price);
		view.add(firstQuantity3);
		//Just adding blank space and a separator
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(new JSeparator());
		view.add(new JSeparator());
		view.add(new JSeparator());
//+++++++++++++++Second course++++++++++
		JLabel empty_label7 = new JLabel("\t");
		JLabel secondD = new JLabel("Second Course", SwingConstants.CENTER);
		secondD.setFont(font);
		JLabel empty_label8 = new JLabel("\t");
	    view.add(empty_label7);
	    view.add(secondD);
	    view.add(empty_label8);
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    
	    JLabel second1 = new JLabel("Fish 'n Chips", SwingConstants.CENTER);
	    JLabel second1price = new JLabel("5.00$", SwingConstants.CENTER);
		JComboBox secondQuantity1 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			secondQuantity1.addItem(i);
		}
		view.add(second1);
		view.add(second1price);
		view.add(secondQuantity1);
		
		JLabel second2 = new JLabel("\n" + "fillet steak", SwingConstants.CENTER);
		JLabel second2price = new JLabel("13.00$", SwingConstants.CENTER);
		JComboBox secondQuantity2 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			secondQuantity2.addItem(i);
		}
		view.add(second2);
		view.add(second2price);
		view.add(secondQuantity2);
		
		JLabel second3 = new JLabel("Stew", SwingConstants.CENTER);
		JLabel second3price = new JLabel("18.00$", SwingConstants.CENTER);
		JComboBox secondQuantity3 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			secondQuantity3.addItem(i);
		}
		view.add(second3);
		view.add(second3price);
		view.add(secondQuantity3);
		
		//Just adding blank space and a separator
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(new JSeparator());
		view.add(new JSeparator());
		view.add(new JSeparator());
		
//+++++++++++++++++Dessert+++++++++++++++
		JLabel empty_label9 = new JLabel("\t");
		JLabel dessertD = new JLabel("Dessert", SwingConstants.CENTER);
		dessertD.setFont(font);
		JLabel empty_label10 = new JLabel("\t");
	    view.add(empty_label9);
	    view.add(dessertD);
	    view.add(empty_label10);
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    view.add(new JLabel("\t"));
	    
	    JLabel dessert1 = new JLabel("Ice Cream", SwingConstants.CENTER);
	    JLabel dessert1price = new JLabel("5.00$", SwingConstants.CENTER);
		JComboBox dessertQuantity1 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			dessertQuantity1.addItem(i);
		}
		view.add(dessert1);
		view.add(dessert1price);
		view.add(dessertQuantity1);
		
		JLabel dessert2 = new JLabel("Panna Cotta", SwingConstants.CENTER);
		JLabel dessert2price = new JLabel("5.00$", SwingConstants.CENTER);
		JComboBox dessertQuantity2 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			dessertQuantity2.addItem(i);
		}
		view.add(dessert2);
		view.add(dessert2price);
		view.add(dessertQuantity2);
		
		JLabel dessert3 = new JLabel("Catalan Cream", SwingConstants.CENTER);
		JLabel dessert3price = new JLabel("6.00$", SwingConstants.CENTER);
		JComboBox dessertQuantity3 = new JComboBox();
		for (int i = 0; i <= numbers_to_add_max; i++) {
			dessertQuantity3.addItem(i);
		}
		view.add(dessert3);
		view.add(dessert3price);
		view.add(dessertQuantity3);
		
		JLabel empty_space10 = new JLabel("\t");
		view.add(empty_space10);
	   
	    JButton btnSubmit = new JButton("Submit");
	    btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {   
            	Random rand = new Random(); 
            	int id = rand.nextInt(500); 
            	ArrayList<Drink> drinks = new ArrayList<Drink>();
            	ArrayList<Starter> starters = new ArrayList<Starter>();
            	ArrayList<FirstCourse> firsts = new ArrayList<FirstCourse>();
            	
            	
            	
            	ArrayList<SecondCourse> seconds = new ArrayList<SecondCourse>();
            	
            	ArrayList<Dessert> desserts = new ArrayList<Dessert>();
            	
            	
            	//Add selected drinks
            	drinks.add(new Drink(id, "-",0,0));
            	if(!drinkQuantity1.getSelectedItem().toString().equals("0"))
            	{
            		drinks.add(new Drink(id, "Soda",(Integer)drinkQuantity1.getSelectedItem(),2));
            	}
            	if(!drinkQuantity2.getSelectedItem().toString().equals("0"))
            	{
            		drinks.add(new Drink(id, "Water",(Integer)drinkQuantity2.getSelectedItem(),1));
            	}
            	if(!drinkQuantity3.getSelectedItem().toString().equals("0"))
            	{
            		drinks.add(new Drink(id, "Coca Cola",(Integer)drinkQuantity3.getSelectedItem(),2));
            	}
            	if(!drinkQuantity4.getSelectedItem().toString().equals("0"))
            	{
            		drinks.add(new Drink(id, "Beer",(Integer)drinkQuantity4.getSelectedItem(),2));
            	}
            	//Add selected starters
            	starters.add(new Starter(id, "-",0,0));
            	if(!starterQuantity1.getSelectedItem().toString().equals("0"))
            	{
            		starters.add(new Starter(id, "House's starter",(Integer)starterQuantity1.getSelectedItem(),7));
            	}
            	if(!starterQuantity2.getSelectedItem().toString().equals("0"))
            	{
            		starters.add(new Starter(id, "Jalapenos",(Integer)starterQuantity2.getSelectedItem(),6));
            	}
            	if(!starterQuantity3.getSelectedItem().toString().equals("0"))
            	{
            		starters.add(new Starter(id, "Toast",(Integer)starterQuantity3.getSelectedItem(),7));
            	}
            	//Add selected firsts
            	firsts.add(new FirstCourse(id, "-",0,0));
            	if(!firstQuantity1.getSelectedItem().toString().equals("0"))
            	{
            		firsts.add(new FirstCourse(id, "Spaghetti",(Integer)firstQuantity1.getSelectedItem(),8));
            	}
            	if(!firstQuantity2.getSelectedItem().toString().equals("0"))
            	{
            		firsts.add(new FirstCourse(id, "Rice",(Integer)firstQuantity2.getSelectedItem(),10));
            	}
            	if(!firstQuantity3.getSelectedItem().toString().equals("0"))
            	{
            		firsts.add(new FirstCourse(id, "Ravioli",(Integer)firstQuantity3.getSelectedItem(),15));
            	}
            	//Add selected seconds
            	seconds.add(new SecondCourse(id, "-",0,0));
            	if(!secondQuantity1.getSelectedItem().toString().equals("0"))
            	{
            		seconds.add(new SecondCourse(id, "Fish 'n Chips",(Integer)secondQuantity1.getSelectedItem(),5));
            	}
            	if(!secondQuantity2.getSelectedItem().toString().equals("0"))
            	{
            		seconds.add(new SecondCourse(id, "Fillet Steak",(Integer)secondQuantity2.getSelectedItem(),13));
            	}
            	if(!secondQuantity3.getSelectedItem().toString().equals("0"))
            	{
            		seconds.add(new SecondCourse(id, "Stew",(Integer)secondQuantity3.getSelectedItem(),18));
            	}
     
            	//Add selected Dessert
            	desserts.add(new Dessert(id, "-",0,0));
            	if(!dessertQuantity1.getSelectedItem().toString().equals("0"))
            	{
            		desserts.add(new Dessert(id, "Ice Cream",(Integer)dessertQuantity1.getSelectedItem(),5));
            	}
            	if(!dessertQuantity2.getSelectedItem().toString().equals("0"))
            	{
            		desserts.add(new Dessert(id, "Panna Cotta",(Integer)dessertQuantity2.getSelectedItem(), 5));
            	}
            	if(!dessertQuantity3.getSelectedItem().toString().equals("0"))
            	{
            		desserts.add(new Dessert(id, "Catalan Cream",(Integer)dessertQuantity3.getSelectedItem(),6));
            	}
            	
            	
            	
            	
            	Order order = new Order(id, starters, 
    					firsts, 
    					seconds, 
    					desserts,
    					drinks,
    					kc
    				);
            	
            	
            	kc.insert(order);
            	CompletableFuture.runAsync(() -> kc.fireAllRules());
            }
        });
	    view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
	    view.add(btnSubmit);
	    frame.setContentPane(view);
	    
	    //We need to call this after all components are loaded into the window, otherwise
	    //it will load an empty window and, in order to show correctly all the components, the user has to resize the window
	    frame.setVisible(true);
	}
}
