package com.bin;


public class Dessert{
	
	private String content;
	private int orderID;
	private int quantity;
	private float price;
	
	public Dessert(int orderID, String content, int quantity, float price) {
		this.orderID = orderID;
		this.content = content;
		this.quantity = quantity;
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getOrderID() {
		return this.orderID;
	}
	
	public String printContent() {
		if(content.equals("-"))
			return content;
		return content + " (x" + quantity + ")";
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Dessert [content=" + content + ", orderID=" + orderID + "]";
	}
}
