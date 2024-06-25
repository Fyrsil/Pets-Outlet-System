package System;
import java.util.*;
public class Billing {
	private String billingId; 
	private String cusName;
	private String payment;
	private double total;
	private ArrayList<String> orderIdList;
	
	public Billing(String billingId, String cusName, String payment,
			double total, ArrayList<String> orderL) {
		this.cusName = cusName;
		this.billingId = billingId;
		this.payment = payment;
		this.total = total;
		this.orderIdList = orderL;
	}
	
	public ArrayList<String> getOrderIdList(){
		return orderIdList;
	}
	
	public String getCusName() {
		return cusName;
	}
	
	public String getBillingId() {
		return billingId;
	}
	
	public String getPayment() {
		return payment;
	}
	
	public double getTotal() {
		return total;
	}
	
	public String toFileString() {
	    return billingId + ", " + cusName + ", " + payment + ", " + 
	total + ", " + orderIdList;
	}
}
