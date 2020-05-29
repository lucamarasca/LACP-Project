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
import com.bin.Table;
import com.google.inject.spi.Element;
import org.kie.api.runtime.rule.FactHandle;
import java.util.ArrayList;
public class AdministratorGUI extends JFrame{
	
	private KieSession kc;
	private ArrayList<Table> tables;
	private ArrayList<FactHandle> facts;
	
	public AdministratorGUI(KieSession kSession,ArrayList<Table> tables, ArrayList<FactHandle> facts) {
		this.tables = tables;
		this.facts = facts;
		this.kc = kSession;
		this.init();
	}
	
	private void init() {
		JFrame frame = new JFrame();
		frame.setTitle("Tables Administration");
		frame.setSize(500,200);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel view = new JPanel(new GridLayout(0, 3));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		//Add Table
		JLabel table_label = new JLabel("Add Table");
		JComboBox add_Table_Combo = new JComboBox();
		JComboBox delete_Table_Combo = new JComboBox();
		for (int i = 1; i <= 100; i++) {
			if(tables.size()>=i)
				if(tables.get(i-1).getTableID() != i)
					add_Table_Combo.addItem(i);
			if(tables.size()<i)
				add_Table_Combo.addItem(i);
		}
		
		JButton btnAdd = new JButton("Add");
		    btnAdd.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent arg0) { 
	            	facts.add(kc.insert(new Table((int) add_Table_Combo.getSelectedItem())));
	            	tables.add(new Table((int) add_Table_Combo.getSelectedItem()));
	            	delete_Table_Combo.addItem(add_Table_Combo.getSelectedItem());
	            	add_Table_Combo.removeItem(add_Table_Combo.getSelectedItem());
	            	view.remove(add_Table_Combo);
	            	view.add(add_Table_Combo, 4);
	            	view.remove(delete_Table_Combo);
	            	view.add(delete_Table_Combo,10);
	            	view.revalidate();
	            	view.repaint();
	            	
	            }
		    });
		view.add(table_label);
		view.add(add_Table_Combo);
		view.add(btnAdd);
		
		//Remove table
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		view.add(Box.createVerticalStrut(25));
		JLabel table_label1 = new JLabel("Delete Table");
		
		for(int i = 0; i < tables.size(); i++)
		{
			//System.out.println(tables.get(i).getTableID());
			delete_Table_Combo.addItem(tables.get(i).getTableID());
		}
		JButton btnRemove = new JButton("Remove");
	    btnRemove.addActionListener(new ActionListener() {
            

			public void actionPerformed(ActionEvent arg0) { 
            	System.out.println("Removed");
            	for(int i = 0; i < tables.size(); i++)
            	{
            		if(tables.get(i).getTableID() == (int)delete_Table_Combo.getSelectedItem())
        			{
        				tables.remove(i);
        				kc.delete(facts.get(i));
        				facts.remove(i);
        			}
            	}
            	add_Table_Combo.addItem(delete_Table_Combo.getSelectedItem());
            	delete_Table_Combo.removeItem(delete_Table_Combo.getSelectedItem());
            	view.remove(add_Table_Combo);
            	view.add(add_Table_Combo, 4);
            	view.remove(delete_Table_Combo);
            	view.add(delete_Table_Combo,10);
            	view.revalidate();
            	view.repaint();
            }
	    });
		view.add(table_label1);
		view.add(delete_Table_Combo);
		view.add(btnRemove);
	    frame.setContentPane(view);
	    
	    //We need to call this after all components are loaded into the window, otherwise
	    //it will load an empty window and, in order to show correctly all the components, the user has to resize the window
	    frame.setVisible(true);
	}
}
