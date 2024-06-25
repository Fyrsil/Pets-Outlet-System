package System;
import java.util.*;
import java.io.*;

public class DataList implements IDataStore{
	private ArrayList<Inventory> invList;
	private ArrayList<User> userList;
	private ArrayList<Order> orderList;
	private ArrayList<Billing> billingList;
	private ArrayList<Report> reportList;
	
	public DataList() {
		invList = new ArrayList<>();
		userList = new ArrayList<>();
		orderList = new ArrayList<>();
		billingList = new ArrayList<>();
		reportList = new ArrayList<>();
	}
	
	public ArrayList<Inventory> getInvList() {
        return invList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<Order> getOrderList() {
        return orderList;
    }	
	
    public ArrayList<Billing> getBillingList() {
        return billingList;
    }
    
    public ArrayList<Report> getReportList() {
        return reportList;
    }
    
    public void addInv(Inventory item) {
    	invList.add(item);
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public void addOrder(Order order) {
        orderList.add(order);
    }
    
    public void addBilling(Billing billing) {
    	billingList.add(billing);
    }
    
    public void addReport(Report report) {
        reportList.add(report);
    }
    
    public void updateInventory(int index, Inventory inventory) {
    	invList.set(index,inventory);
    }
    public void updateUser(int index, User user) {
        userList.set(index, user);
    }

    public void updateOrder(int index, Order order) {
        orderList.set(index, order);
    }

    public void updateBilling(int index, Billing billing) {
        billingList.set(index, billing);
    }

    public void updateReport(int index, Report report) {
        reportList.set(index, report);
    }
    public void removeInventory(int index) {
    	invList.remove(index);
    }
	public void removeUser(int index) {
		userList.remove(index);
	}
	public void removeOrder(int index) {
		orderList.remove(index);
	}
	public void removeBilling(int index) {
		billingList.remove(index);
	}
	public void removeReport(int index) {
		reportList.remove(index);
	}
    
    public void createNewClient(String username, String email, String passwd) {
    	addUser(new Client(username,email,passwd));
    }
    
    public void createNewInv(String itemName, double itemPrice,
    		double itemWeight, int itemQty) {
    	// generate itemID
    	String itemId = "";
    	if(invList.size() < 10) {
    		itemId = ("I00"+ (invList.size() + 1));
    	}
    	else if(invList.size() < 100) {
    		itemId = ("I0"+ (invList.size() + 1));
    	}
    	else
    		itemId = ("I"+ (invList.size() + 1));
    	addInv(new Inventory(itemName, itemId,itemPrice, itemWeight, itemQty));
	}
    
    public void createNewOrder(String itemName, String cusName,
    		int orderQty, double orderWeight,double itemPrice) {
    	// generate orderID
    	String orderId = "";
    	if(orderList.size() < 10) {
    		orderId = ("O00"+ (orderList.size() + 1));
    	}
    	else if(orderList.size() < 100) {
    		orderId = ("O0"+ (orderList.size() + 1));
    	}
    	else
    		orderId = ("O"+orderList.size() + 1);
    	addOrder(new Order(itemName, orderId, cusName, orderQty, orderWeight, itemPrice));
    }
    
    public void createNewBilling(String cusName, String payment,double total,
    		ArrayList<String> orderL) {
    	// generate billingID
    	String billingId = "";
    	if(billingList.size() < 10) {
    		billingId = ("B00"+ (billingList.size() + 1));
    	}
    	else if(billingList.size() < 100) {
    		billingId = ("B0"+ (billingList.size() + 1));
    	}
    	else
    		billingId = ("B"+ (billingList.size() + 1));
    	addBilling(new Billing(billingId, cusName, payment, total, orderL));
    }
    
    public void createNewReport(ArrayList<String> billingIdList, double total) {
    	// generate report ID
    	String rptId = "";
    	if(reportList.size() < 10) {
    		rptId = ("R00"+ (reportList.size() + 1));
    	}
    	else if(reportList.size() < 100) {
    		rptId = ("R0"+ (reportList.size() + 1));
    	}
    	else
    		rptId = ("R"+ (reportList.size() + 1));
    	addReport(new Report(rptId, billingIdList, total));
    }
    
    public void read() {
    	// read file
    	try (BufferedReader br = new BufferedReader(new FileReader("Inventory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String itemName = parts[0];
                String itemId = parts[1];
                double itemPrice = Double.parseDouble(parts[2]);
                double itemWeight = Double.parseDouble(parts[3]);
                int itemQty = Integer.parseInt(parts[4]);
                Inventory item = new Inventory(itemName, itemId, itemPrice, itemWeight, itemQty);
                invList.add(item);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (BufferedReader br = new BufferedReader(new FileReader("User.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String userName = parts[0];
                String emailAddress = parts[1];
                String password = parts[2];
                if(userName.equals("Supplier")) {
                	Supplier user = new Supplier(userName, emailAddress, password);
                	userList.add(user);
                }
                else if(userName.equals("Manager")) {
                	Manager user = new Manager(userName, emailAddress, password);
                	userList.add(user);
                }
                else {
                	Client user = new Client(userName, emailAddress, password);
                	userList.add(user);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (BufferedReader br = new BufferedReader(new FileReader("Order.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                
                String itemName= parts[0];
                String orderId = parts[1];
                String cusName = parts[2];
                int orderQty = Integer.parseInt(parts[3]);
                double orderWeight = Double.parseDouble(parts[4]);
                double itemPrice = Double.parseDouble(parts[5]);
                orderList.add(new Order(itemName, orderId, cusName, orderQty, orderWeight, itemPrice));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (BufferedReader br = new BufferedReader(new FileReader("Billing.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");

                String billingId = parts[0];
                String cusName = parts[1];
                String payment = parts[2];
                double total = Double.parseDouble(parts[3]);
                
                ArrayList<String> orderIdList = new ArrayList<>();
                for(int i = 4; i < parts.length; i++) {
                	orderIdList.add(parts[i].replace("[", "").replace("]", ""));
                }

                billingList.add(new Billing(billingId, cusName, payment, total, orderIdList));
                }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (BufferedReader br = new BufferedReader(new FileReader("Report.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");

                String reportId = parts[0];
                double total = Double.parseDouble(parts[1]);
                
                ArrayList<String> billIdList = new ArrayList<>();
                for(int i = 2; i < parts.length; i++) {
                	billIdList.add(parts[i].replace("[", "").replace("]", ""));
                }
                reportList.add(new Report(reportId, billIdList, total));
                }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void update() {
    	// update file
    	try (PrintWriter writer = new PrintWriter(new FileWriter("Inventory.txt"))) {
            for (Inventory item : invList) {
                writer.println(item.toFileString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	
    	try (PrintWriter writer = new PrintWriter(new FileWriter("User.txt"))) {
            for (User user : userList) {
                writer.println(user.toFileString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (PrintWriter writer = new PrintWriter(new FileWriter("Order.txt"))) {
            for (Order order : orderList) {
                writer.println(order.toFileString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (PrintWriter writer = new PrintWriter(new FileWriter("Billing.txt"))) {
            for (Billing bill : billingList) {
                writer.println(bill.toFileString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    	try (PrintWriter writer = new PrintWriter(new FileWriter("Report.txt"))) {
            for (Report report : reportList) {
                writer.println(report.toFileString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
