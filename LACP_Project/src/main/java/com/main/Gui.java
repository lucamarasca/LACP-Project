package com.main;

import org.kie.api.runtime.KieSession;

import com.gui.*;

//this is used for manage GUIs
public class Gui{
	
	private final OrderGUI newOrderFrame;
	
	public Gui(KieSession kSession){
		this.newOrderFrame = new OrderGUI(kSession);
		
	}

	public OrderGUI getNewOrderFrame() {
		return newOrderFrame;
	}

	

}
