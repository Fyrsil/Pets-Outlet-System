package System;

import java.util.ArrayList;

public interface IDataStore {
	public ArrayList<Inventory> getInvList();
	public ArrayList<User> getUserList();
	public ArrayList<Order> getOrderList();
	public ArrayList<Billing> getBillingList();
	public ArrayList<Report> getReportList();
	public void addOrder(Order order);
	public void addBilling(Billing billing);
	public void addReport(Report report);
	public void updateInventory(int index, Inventory inventory);
	public void updateUser(int index, User user);
	public void updateOrder(int index, Order order);
	public void updateBilling(int index, Billing billing);
	public void updateReport(int index, Report report);
	public void removeInventory(int index);
	public void removeUser(int index);
	public void removeOrder(int index);
	public void removeBilling(int index);
	public void removeReport(int index);
	public void createNewClient(String username, String email, String passwd);
	public void createNewInv(String itemName, double itemPrice,
			double itemWeight, int itemQty);
	public void createNewOrder(String itemName, String cusName,
    		int orderQty, double orderWeight,double itemPrice);
	public void createNewBilling(String cusName, String payment,double total,
    		ArrayList<String> orderL);
	public void createNewReport(ArrayList<String> billingIdList, double total);
	public void read();
	public void update();
}
