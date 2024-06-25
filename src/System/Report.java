package System;
import java.util.*;
public class Report {
	private String reportId;
    private ArrayList<String> billingIdList;
    private double total;
    
    public String getReportId() {
    	return reportId;
    }
    
    public ArrayList<String> getBillingIdList() {
    	return billingIdList;
    }
    
    public double getBillTotal() {
    	return total;
    }
    
    public Report(String reportId, ArrayList<String> billingIdList,
    		double total) {
    	this.reportId = reportId;
    	this.billingIdList = billingIdList;
    	this.total = total;
    }
    public String toFileString() {
	    return reportId + ", " + total + ", " + billingIdList;
    }
}
