package com.main;

import java.util.ArrayList;


import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;
import com.bin.Table;
import com.gui.*;

//this is used for manage GUIs
public class Gui{
	
	private final OrderGUI newOrderFrame;
	private final AdministratorGUI newAdminFrame;
	
	public Gui(KieSession kSession, ArrayList<Table> tables, ArrayList<FactHandle> facts){
		this.newOrderFrame = new OrderGUI(kSession);
		this.newAdminFrame = new AdministratorGUI(kSession,tables,facts);
		
	}

	public OrderGUI getNewOrderFrame() {
		return newOrderFrame;
	}

	

}
