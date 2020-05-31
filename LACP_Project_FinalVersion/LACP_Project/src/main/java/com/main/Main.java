package com.main;


import java.util.ArrayList;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.bin.*;
import com.gui.OrderGUI;
/**
 * This is a sample class to launch a rule.
 */
public class Main {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	//This is used for 
        	kSession.setGlobal("randomTime", 7000);
        	
        	ArrayList<FactHandle> facts = new ArrayList<FactHandle>();
        	ArrayList<Table> tables = new ArrayList<Table>();
        	//Create the GUI used for orders
        	
        	//Create an event listener for managing drools events
        	kSession.addEventListener(new EventListener());
        	
        	//I have automatically filled my inventory
        	Inventory invent = new Inventory();
        	kSession.insert(invent);
        	//create a list of tables that will be associated to an order
        	for(int i = 1; i < 6; i++)
        	{
        		tables.add(new Table(i));
        		facts.add(kSession.insert(tables.get(i-1)));
        	}
        	Gui frame = new Gui(kSession, tables, facts);
        	//I will fire all rules
            kSession.fireAllRules();
            
            
           
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    
}

