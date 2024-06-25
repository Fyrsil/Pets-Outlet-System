package System;

import java.util.*;

public class Controller {
	private IDataStore dataLists;
	private User currentUser;
	
	public Controller(IDataStore dataLists) {
		this.dataLists = dataLists;
	}
	
	public ArrayList<Inventory> getAllInv() {
		return dataLists.getInvList();
	}
	
	public ArrayList<User> getAllUser(){
		return dataLists.getUserList();
	}
	
	public ArrayList<Order> getAllOrder(){
		return dataLists.getOrderList();
	}
	
	public ArrayList<Billing> getAllBilling(){
		return dataLists.getBillingList();
	}
	
	public ArrayList<Report> getAllReport(){
		return dataLists.getReportList();
	}
	
	public void addNewInv(String itemName, double itemPrice,
			double itemWeight, int itemQty) {
		dataLists.createNewInv(itemName, itemPrice,itemWeight, itemQty);
	}
	
	public void addNewUser(String username, String email, String passwd) {
		dataLists.createNewClient(username, email, passwd);
	}
	
	public void addNewOrder(String itemName, String cusName,
    		int orderQty, double orderWeight,double itemPrice) {
		dataLists.createNewOrder(itemName, cusName, orderQty, orderWeight, itemPrice);
	}
	
	public void addNewBilling(String cusName, String payment,double total,
    		ArrayList<String> orderL) {
		dataLists.createNewBilling(cusName, payment, total, orderL);
	}
	
	public void addNewReport(ArrayList<String> billingIdList, double total) {
		dataLists.createNewReport(billingIdList, total);
	}
	
	public void updateInventory(int index, Inventory inventory) {
    	dataLists.updateInventory(index,inventory);
    }
    public void updateUser(int index, User user) {
    	dataLists.updateUser(index, user);
    }

    public void updateOrder(int index, Order order) {
    	dataLists.updateOrder(index, order);
    }

    public void updateBilling(int index, Billing billing) {
    	dataLists.updateBilling(index, billing);
    }

    public void updateReport(int index, Report report) {
    	dataLists.updateReport(index, report);
    }
    public void removeInventory(int index) {
    	dataLists.removeInventory(index);
    }
	public void removeUser(int index) {
		dataLists.removeUser(index);
	}
	public void removeOrder(int index) {
		dataLists.removeOrder(index);
	}
	public void removeBilling(int index) {
		dataLists.removeBilling(index);
	}
	public void removeReport(int index) {
		dataLists.removeReport(index);
	}

	public void setCurrentUser(User user) {
		currentUser = user;
	}
	public User getCurrentUser() {
		return currentUser;
	}
	
	public void read() {
		dataLists.read();
	}
	
	public void update() {
		dataLists.update();
	}
}
