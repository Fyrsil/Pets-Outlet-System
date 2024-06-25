package System;

public class Order {
    private String itemName;
    private String orderId;
    private String cusName;
    private int orderQty;
    private double orderWeight;
    private double itemPrice;

    public Order(String itemName,String orderId, String cusName,
    		int orderQty, double orderWeight,double itemPrice) {
        this.itemName = itemName;
        this.orderId = orderId;
        this.cusName = cusName;
        this.orderQty = orderQty;
        this.orderWeight = orderWeight;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
    	return itemName;
    }
    
    public String getOrderId() {
    	return orderId;
    }
    
    public String getCusName(){
        return cusName;
    }

    public int getOrderQty(){
        return orderQty;
    }

    public double getOrderWeight(){
        return orderWeight;
    }

    public double getItemPrice(){
        return itemPrice;
    }
    
    public double getTotalPrice() {
    	return orderQty * itemPrice;
    }
    public double getTotalWeight() {
    	return orderQty * orderWeight;
    }
    public String toFileString() {
	    return itemName + ", " + orderId + ", " + cusName + ", " + 
    orderQty + ", " + orderWeight + ", " + itemPrice;
	}
}
