package com.bin;

//This class represent the object table that will be assigned to
//Users for every order performed
public class Table {
	private final int tableID;
	private boolean isAvailable;
	
	public Table(int tableID) {
		this.tableID = tableID;
		this.isAvailable = true;
	}
	
	public int getTableID() {
		return tableID;
	}


	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	@Override
	public String toString() {
		return "Table: " + tableID;
	}
	
}
