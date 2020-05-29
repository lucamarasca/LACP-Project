package com.main;


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
        	

        	//Create the GUI used for orders
        	Gui frame = new Gui(kSession);
        	//Create an event listener for managing drools events
        	kSession.addEventListener(new EventListener());
        	
        	//I have automatically filled my inventory
        	Inventory invent = new Inventory();
        	kSession.insert(invent);
        	//create a list of tables that will be associated to an order
        	Table t1 = new Table(1);
        	Table t2 = new Table(2);
        	Table t3 = new Table(3);
        	Table t4 = new Table(4);
        	Table t5 = new Table(5);
        	//Insert the tables in the memory
        	kSession.insert(t1);
        	kSession.insert(t2);
        	kSession.insert(t3);
        	kSession.insert(t4);
        	kSession.insert(t5);
        	//I will fire all rules
            kSession.fireAllRules();
            
            
           
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    
}

