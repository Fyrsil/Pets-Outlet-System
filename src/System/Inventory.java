package System;
public class Inventory {
	private String itemName;
	private String itemId;
	private double itemPrice;
	private double itemWeight;
	private int itemQty;
	
	public Inventory(String itemName, String itemId, double itemPrice,
			double itemWeight, int itemQty) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.itemPrice = itemPrice;
		this.itemWeight = itemWeight;
		this.itemQty = itemQty;
	}
	
	public String getItemName() {
	    return itemName;
	}

	public String getItemId() {
	    return itemId;
	}

	public double getItemPrice() {
	    return itemPrice;
	}

	public double getItemWeight() {
	    return itemWeight;
	}

	public int getItemQty() {
	    return itemQty;
	}
	
	public void setItemQty(int qty) {
		itemQty = qty;
	}
	
	public String toFileString() {
	    return itemName + ", " + itemId + ", " + itemPrice + ", " + itemWeight + ", " + itemQty;
	}
}
