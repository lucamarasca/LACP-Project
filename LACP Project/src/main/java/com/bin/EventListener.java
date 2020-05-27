package com.bin;

import java.util.concurrent.CompletableFuture;

import javax.swing.JOptionPane;

import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.runtime.rule.FactHandle;

import com.main.Gui;

public class EventListener implements RuleRuntimeEventListener{
	
	
	
	public EventListener() {
		
	}
	
	@Override
	public void objectDeleted(ObjectDeletedEvent arg0) {
		/*
		 * Whenever an order has been completed, it will be removed
		 * from the working memory
		 */
		if(arg0.getOldObject().getClass() == Order.class) {
			Order temp = (Order)arg0.getOldObject();
			System.out.println("The order "+temp.getID()+" has been deleted"
					+ " since it has been completed");	
		}
	}
	//I just have to manage orders 
	@Override
	public void objectInserted(ObjectInsertedEvent arg0) {
		//When a new order is inserted i launch a new thread
		//In this way i can perform more than one order at the same time
		if(arg0.getObject().getClass() == Order.class)
		{
			Order temp = (Order)arg0.getObject();
			FactHandle handler = arg0.getKieRuntime().getFactHandle(temp);
			CompletableFuture.runAsync(() -> arg0.getKieRuntime().update(handler, temp));	
        	
		}
			
			
	}

	//Never used
	@Override
	public void objectUpdated(ObjectUpdatedEvent arg0) {
		return;	
	}
	
	
	
}
