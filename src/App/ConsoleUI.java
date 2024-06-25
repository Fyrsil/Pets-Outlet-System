package App;
import java.util.*;

import System.*;

public class ConsoleUI {
	private Scanner scanner;
	private Controller controller;
	
	public ConsoleUI(Controller controller){
		scanner = new Scanner(System.in);
		this.controller = controller;
	}
	
	public void start() {
		controller.read();
		
		
		// loop check
		boolean validOptionEntered = false;
		String step = "0";
		
		while (!validOptionEntered) {
            try {
                System.out.println("\n\t----------------------------------------");
                System.out.println("\t|     Welcome to Pets Outlet System    |");
                System.out.println("\t|       Please select an option:       |");
                System.out.println("\t----------------------------------------");
                System.out.println("\t1. Login into Pets Outlet System account");
                System.out.println("\t2. Register an account");
                System.out.println("\t3. Quit this application");
                System.out.println("\t----------------------------------------");
                System.out.print("\tPlease enter your option > ");
                int option = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                System.out.print("\033[H\033[2J"); //clear screen
                boolean chkloop = true;
                switch (option) {
                    case 1:
                        do{
	                        // Perform login functionality
                        	ArrayList<User> allUser = controller.getAllUser();
	                        System.out.println("\n\t----------------------------------------");
	                        System.out.println("\t|     Login to Pets Outlet System      |");
	                        System.out.println("\t----------------------------------------");
	                        System.out.println("\n\tEnter (Q) to quit.");
	                        System.out.print("\tEnter your email address\t: ");
	                        
	                        // Account validation
	                        String emailaddresslogin = scanner.nextLine();
	                        if(emailaddresslogin.toUpperCase().equals("Q")) {
	                        	chkloop = false;
	                        	break;
	                        }
	                        System.out.print("\tEnter your password\t\t: ");
	                        String passwordlogin = scanner.nextLine();
	                        int chk = -1;
	                        
	                        if(passwordlogin.toUpperCase().equals("Q")) {
	                        	chkloop = false;
	                        	break;
	                        }
	                        for (int i = 0; i < allUser.size(); i++) {
	                            User user = allUser.get(i);
	                            if (user.getEmail().equals(emailaddresslogin) &&
	                            		user.getPassword().equals(passwordlogin)) {
	                                chk = i;
	                                break;
	                            }
	                        }
	                        if(chk > -1){
	                        	// Account type validation
	                        	User currentUser = allUser.get(chk);
	                        	controller.setCurrentUser(currentUser);
	                        	if(currentUser instanceof Client) {
	                        		step = "1";
	                        	}
	                        	else if(currentUser instanceof Manager)
	                        		step = "2";
	                        	else
	                        		step = "3";
	                        	validOptionEntered = true;
	                        	chkloop = false;
	                        	System.out.print("\033[H\033[2J");
	                        }
	                        else {
	                        	System.out.print("\033[H\033[2J"); //clear screen
	                        	System.out.println("\n\tInvalid email or password entered.");
	                        }
	                    }while(chkloop);
                        break;
                    case 2:
                    	// New Client Registration
                        register();
                        break;
                    case 3:
                        // Quit the application
                    	validOptionEntered = true;
                    	exit();
                        break;
                    default:
                        System.out.print("\033[H\033[2J"); //clear screen
                        System.out.println("\n\tInvalid option. Please enter a valid option.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.print("\033[H\033[2J"); //clear screen
                System.out.println("\n\tInvalid input. Please enter a valid integer option.");
                scanner.nextLine(); // Clear the invalid input from scanner
            }
            
            while(step.equals("1")) {
            	// Client view
            	boolean validCheck = false;
            	do {
            	System.out.println("\n\t-------------------------------------");
                System.out.println("\t|  Welcome to Pets Outlet System.   |");
                System.out.println("\t|  Please select an option:         |");
                System.out.println("\t-------------------------------------");
                System.out.println("\n\t1. Make order.");
                System.out.println("\tQ. Quit.");
                System.out.print("\n\tEnter your option > ");
                String opt = scanner.next();
                if(opt.toUpperCase().equals("Q")) {
                	exit();
                	break;
                }
                else if(opt.equals("1")) {
                	// Make order
                	clientViewInv(controller.getCurrentUser());
                }
                else {
                	System.out.print("\033[H\033[2J"); //clear screen
                	System.out.println("\n\tInvalid option entered."); 
                }
                	
                } while(validCheck);
            }
            
            while(step.equals("2")) {
            	// Manager view
            	boolean validCheck = false;
            	do {
	            	System.out.println("\n\t-------------------------------------");
	                System.out.println("\t|  Welcome to Pets Outlet System.   |");
	                System.out.println("\t|  Please select an option:         |");
	                System.out.println("\t-------------------------------------");
	                System.out.println("\n\t1. Manage Inventory.");
	                System.out.println("\t2. Manage Order.");
	                System.out.println("\t3. Manage Billing Statement.");
	                System.out.println("\t4. Manage Sales Report.");
	                System.out.println("\tQ. Quit.");
	                System.out.print("\n\tEnter your option > ");
	                String opt = scanner.next();
	                if(opt.toUpperCase().equals("Q")) {
	                	exit();
	                	break;
	                }
	                else if(opt.equals("1")) {
	                	System.out.print("\033[H\033[2J"); //clear screen
	                	manageInventory();
	                }
	                else if(opt.equals("2")) {
	                	System.out.print("\033[H\033[2J"); //clear screen
	                	manageOrder();
	                }
	                else if(opt.equals("3")) {
	                	System.out.print("\033[H\033[2J"); //clear screen
	                	manageBilling();
	                }
	                else if(opt.equals("4")) {
	                	System.out.print("\033[H\033[2J"); //clear screen
	                	manageReport();
	                }
	                else {
	                	System.out.print("\033[H\033[2J"); //clear screen
	                	System.out.println("\n\tInvalid option entered."); 
	                }
                	
                } while(validCheck);
            	
            	
            }
            
            while(step.equals("3")) {
            	// Supplier view
            	boolean validCheck = false;
            	do {
            	System.out.println("\n\t-------------------------------------");
                System.out.println("\t|  Welcome to Pets Outlet System.   |");
                System.out.println("\t|  Please select an option:         |");
                System.out.println("\t-------------------------------------");
                System.out.println("\n\t1. Restock Inventory.");
                System.out.println("\t2. Add new Item.");
                System.out.println("\tQ. Quit.");
                System.out.print("\n\tEnter your option > ");
                String opt = scanner.next();
                if(opt.toUpperCase().equals("Q")) {
                	exit();
                	break;
                }
                else if(opt.equals("1")) {
                	restockInventory();
                }
                else if(opt.equals("2")) {
                	addNewItem();
                }
                else {
                	System.out.print("\033[H\033[2J"); //clear screen
                	System.out.println("\n\tInvalid option entered."); 
                }
                	
                } while(validCheck);
            }
        }
        scanner.close(); // Close the scanner when done
	}
	
	// Register as a new client
	public void register() {
		ArrayList<User> allUser = controller.getAllUser();
		// Perform registration functionality
        System.out.print("\033[H\033[2J"); //clear screen
        System.out.println("\n\t---------------------------------");
        System.out.println("\t|      Account Registration     |");
        System.out.println("\t---------------------------------");
        System.out.println("\n\tEnter (Q) to quit.");
        System.out.print("\tEnter username : ");
        String username = scanner.nextLine();
        if(!username.toUpperCase().equals("Q")) {
	        boolean chkSame;
	        while(true) {
	        	// Check spacing of user name
	        	if (username.contains(" ")){
	        		System.out.println("\n\tUsername can not contain any space.");
	        		System.out.print("\tEnter username : ");
	        		username = scanner.nextLine();
	        	}
	        	else {
	        		// Check exist of user name
	        		do {
	        			chkSame = false;
	            		for(User user : allUser) {
	                    	if(user.getUsername().equals(username)) {
	                    		System.out.println("\n\tUsername already exists.");
	                    		System.out.print("\tEnter your username : ");
	                    		username = scanner.nextLine();
	                    		chkSame = true;
	                    		break;
	                    	}
	                    }
	        		}while(chkSame);
	        		break;
	        	}
	        }
	        
	        System.out.print("\n\tEnter email address : ");
	        String email = scanner.nextLine();
	        boolean emailChk;
	        // Check exist of email
	        do{
	        	emailChk= false;
	        	for (User user : allUser) {
	                if (user.getEmail().equals(email)) {
	                	System.out.println("\n\tEmail already resgitered.");
	            		System.out.print("\tEnter email address : ");
	            		email = scanner.nextLine();
	                    emailChk = true;
	                    break;
	                }
	            }
	        }while(emailChk);
	        
	        boolean passwdLoop;
	        System.out.print("\n\tEnter password : ");
	    	String passwd = scanner.nextLine();
	    	System.out.print("\tRenter password : ");
	    	String passwdChk = scanner.nextLine();
	    	// Check typo of password
	        do {
	        	passwdLoop = false;
	        	if(!passwd.equals(passwdChk)) {
	        		passwdLoop = true;
	        		System.out.println("\n\tPassword entered isn't same enter password again.");
	        		System.out.print("\tEnter password : ");
	            	passwd = scanner.nextLine();
	            	System.out.print("\tRenter password : ");
	            	passwdChk = scanner.nextLine();
	        	}
	        }while(passwdLoop);
	        
	        // Add Client to List
	        controller.addNewUser(username,email,passwd);
	        System.out.println("\n\tNew user added successfully.");
        }
	}
	
	public void clientViewInv(User currentUser) {
		boolean purLoop = true;
    	do {
    		// Retrieve data
    		ArrayList<Inventory> allInv = controller.getAllInv();
    		Client cUser = (Client) currentUser;
    		
    		// All inventory print out
    		printAllInv(allInv);
    		System.out.println("\tEnter the No. of the item to select the item.");
    		System.out.println("\tEnter (P) to make payment.");
    		System.out.println("\tEnter (Q) to exit.");
    		System.out.print("\n\tEnter your option > ");
    		String itemOpt = scanner.next();
    		System.out.print("\033[H\033[2J"); //clear screen
    		// Option validation
    		// Exiting
    		if(itemOpt.toUpperCase().equals("Q")) 
    			purLoop = false;
    		
    		// Make payment
    		else if(itemOpt.toUpperCase().equals("P")) {
    			boolean paymentLoop = false;
    			do {
    				ArrayList<Order> allOrder = controller.getAllOrder();
    				ArrayList<Order> currentOrder = new ArrayList<>();
    				for(Order order: allOrder) {
    					if(order.getCusName().equals(cUser.getUsername())) {
    						currentOrder.add(order);
    					}
    				}
	    			System.out.println("\n\t"+"-".repeat(72));
	    			System.out.println("\t|                               Order List                             |");
	    			System.out.println("\t"+"-".repeat(72));
	    			// Check Number for Order List
	    			if(currentOrder.size() < 0) {
	    				System.out.println("\n\tOrder List is empty");
	    				System.out.print("\tEnter anything to exit...");
	    				scanner.nextLine();
	    				scanner.nextLine();
	    				System.out.print("\033[H\033[2J"); //clear screen
	    			}
	    			else {
	    				double total = 0;
	    				ArrayList<String> currentOrderID = new ArrayList<>();
	    				// Print order detail
	    				System.out.println(String.format("\t%-7s%-20s%-14s%-7s%-12s%12s\n","[No.]",
	    						"[Name]", "[Weight(kg)]", "[Qty]","[Price(RM)]","[Total(RM)]"));
	    				for (Order order : currentOrder) {
	    					System.out.println(String.format("\t%-8d%-20s%-14.2f%-9d%-7.2f%,13.2f",
	    							currentOrder.indexOf(order) + 1, order.getItemName(),
	    	                        order.getOrderWeight(), order.getOrderQty(),
	    	                        order.getItemPrice(), order.getTotalPrice()));
	    					currentOrderID.add(order.getOrderId());
	    					total += order.getTotalPrice();
	    				}
	    				System.out.println("\t"+"-".repeat(72));
	    				System.out.println(String.format("\t%-60s%11.2f", "Total", total));
	    				System.out.println("\t"+"-".repeat(72));
	    				System.out.println("\n\tEnter payment type (C)redit card or (D)ebit card");
	    				System.out.println("\tEnter (Q)uit to quit payment.");
	    				System.out.print("\n\tEnter your option > ");
	    				String payOpt = scanner.next();
	    				
	    				if(payOpt.toUpperCase().equals("Q")) {
	    					System.out.print("\033[H\033[2J"); //clear screen
	    					paymentLoop = false;
	    				}
	    				
	    				// Payment type validation
	    				else if(payOpt.toUpperCase().equals("C") || payOpt.toUpperCase().equals("D")) {
	    					// Update info for billing
	    					controller.addNewBilling(currentUser.getUsername(), payOpt, total, currentOrderID);
	    					
	    					System.out.println("\n\tPayment was sucessful.");
	    					System.out.print("\tEnter anything to proceed...");
	    					scanner.nextLine();
	    					scanner.nextLine();
	    					paymentLoop = false;
	    				}
	    				else {
	    					System.out.print("\033[H\033[2J"); //clear screen
	    					System.out.println("\n\tInvalid option entered");
	    				}
	    			}
    			}while(paymentLoop);
    		}
    		else {
    			// Item being order
    			boolean qtyLoop = true;
	    		try {
	                int index = Integer.parseInt(itemOpt) - 1;
	                Inventory item = allInv.get(index);
	                do {
		                printItemDetail(item);
		                System.out.println("\n\tEnter the quantity to purchase.");
		                System.out.println("\tEnter the (Q) to quit.");
		                System.out.print("\n\tEnter the your option > ");
		                String opt = scanner.next();
		                // Number item purchase validation
		                if(!opt.toUpperCase().equals("Q")) {
		                	try {
		                		int qty = Integer.parseInt(opt);
		                		if ((qty < item.getItemQty() && qty > 0 )) {
		                			// Update OrderList ,Client OrderList and Inventory
		                			item.setItemQty(item.getItemQty() - qty);
		                			controller.updateInventory(index, item);
		                			controller.addNewOrder(item.getItemName(),cUser.getUsername(),
		                					qty, item.getItemWeight(), item.getItemPrice());
		                			
		                			System.out.println("\n\tItem added successfully to Order");
		                			System.out.print("\tEnter anything to proceed...");
		                			scanner.nextLine();
		                			scanner.nextLine();
		                			
		                			System.out.print("\033[H\033[2J"); //clear screen
		                			qtyLoop = false;
		                		}
		                		else {
		                			System.out.print("\033[H\033[2J"); //clear screen
			    	            	System.out.println("\n\tInvalid amount entered."); 
		                		}
		                	} catch (Exception e) {
		                		System.out.print("\033[H\033[2J"); //clear screen
		    	            	System.out.println("\n\tInvalid option entered."); 
		                	}
		                }
		                else
		                	qtyLoop = false;
	                }while(qtyLoop);
	                
	            } catch (Exception e) {
	            	System.out.print("\033[H\033[2J"); //clear screen
	            	System.out.println("\n\tInvalid option entered."); 
	            }
    		}
    	}while(purLoop);
	}
	
	// Restock Inventory
	public void restockInventory() {
		boolean reLoop = true;
    	do {
    		// Retrieve data
    		ArrayList<Inventory> allInv = controller.getAllInv();
    		
			printAllInv(allInv);
			
			System.out.println("\tEnter the No. of the item to select the item.");
			System.out.println("\tEnter (Q) to exit.");
			System.out.print("\n\tEnter your option > ");
			String itemOpt = scanner.next();
			System.out.print("\033[H\033[2J"); //clear screen
			
			// Option validation
			// Exiting
			if(itemOpt.toUpperCase().equals("Q")) 
				reLoop = false;
			// Option validation
			else {
    			boolean chkLoop = true;
	    		try {
	                int index = Integer.parseInt(itemOpt) - 1;
	                Inventory item = allInv.get(index);
	                do {
		                printItemDetail(item);
		                
		                System.out.println("\n\tEnter the quantity to restock.");
		                System.out.println("\tEnter the (Q) to quit.");
		                System.out.print("\n\tEnter the your option > ");
		                String opt = scanner.next();
		                
		                if(!opt.toUpperCase().equals("Q")) {
		                	try {
		                		int qty = Integer.parseInt(opt);
		                		// Update Inventory qty
		                		item.setItemQty(item.getItemQty() + qty);
		                		controller.updateInventory(index, item);
		                		System.out.println("\n\tQty of item update successfully.");
		                		System.out.print("\tEnter anything to continue...");
		                		scanner.nextLine();
		                		scanner.nextLine();
		                		
		                		chkLoop = false;
		                		System.out.print("\033[H\033[2J"); //clear screen
		                		} catch (Exception e) {
		        	            	System.out.print("\033[H\033[2J"); //clear screen
		        	            	System.out.println("\n\tInvalid option entered."); 
		                		}
		                }
		                else
		                	chkLoop = false;
	                }while(chkLoop);
	    		} catch (Exception e) {
	            	System.out.print("\033[H\033[2J"); //clear screen
	            	System.out.println("\n\tInvalid option entered."); 
	            }
			}
    	}while(reLoop);
	}
	
	// Add new Item to Inventory
	public void addNewItem() {
		boolean addNewItemLoop = true;
		do {
			// Supplier add new Item
			ArrayList<Inventory> allInv = controller.getAllInv();
			System.out.println("\n\t---------------------------------------------------");
			System.out.println("\t|                   Add New Item                  |");
			System.out.println("\t---------------------------------------------------");
			System.out.print("\n\tEnter item name(or 'q' to quit)\t\t: ");
			scanner.nextLine();
			String newItemName = scanner.nextLine();
			
			// Validation
			if(newItemName.toUpperCase().equals("Q")) {
				addNewItemLoop = false;
				System.out.print("\033[H\033[2J"); //clear screen
			}
			else {
				boolean repeatChk = true;
				int step = 0;
				for(Inventory item : allInv) {
					if(item.getItemName().equals(newItemName)) {
						System.out.print("\033[H\033[2J"); //clear screen
						System.out.println("\n\tItem already exists");
						repeatChk = false;
						break;
					}
				}	
				if(repeatChk)
					step++;
				
				// Item detail validation
				// Get Item price
				while(step == 1) {
					System.out.print("\tEnter item price(RM)(or 'b' to back)\t: ");
					String newItemPrice = scanner.next();
					if(newItemPrice.toUpperCase().equals("B")) {
						step --;
						break;
					}
					try {
						double newPrice = Double.parseDouble(newItemPrice);
						step ++;
						// Get Item weight
						while(step == 2) {
							System.out.print("\tEnter item weight(KG)(or 'b' to back)\t: ");
							String newItemWeight = scanner.next();
							if(newItemWeight.toUpperCase().equals("B")) {
								step --;
								break;
							}
							try {
								double newWeight = Double.parseDouble(newItemWeight);
								step ++;
								// Get Item qty
								while(step == 3) {
									System.out.print("\tEnter item quantity(or 'b' to back)\t: ");
									String newItemQty = scanner.next();
									if(newItemQty.toUpperCase().equals("B")) {
										step --;
										break;
									}
									try {
										int newQty = Integer.parseInt(newItemQty);
										// Add New item to Inventory List
										controller.addNewInv(newItemName, newPrice, newWeight, newQty);
										step ++;
										addNewItemLoop = false;
										System.out.println("\n\tNew Item added to inventory.");
										System.out.print("\tEnter anything to continue...");
										scanner.nextLine();
										scanner.nextLine();
										System.out.print("\033[H\033[2J"); //clear screen
									}catch (NumberFormatException e) {
							            System.out.println("\n\tInvalid quantity entered."); 
							        }
								}
							}catch (NumberFormatException e) {
					            System.out.println("\n\tInvalid weight entered."); 
					        }
						}
					}catch (NumberFormatException e) {
			            System.out.println("\n\tInvalid price entered."); 
					}
				}
			}
		}while(addNewItemLoop);
	}
	
	// Manage Inventory
	public void manageInventory() {
		boolean manageInvLoop = true;
		do {
			// Manager manage inventory
			System.out.println("\n\t---------------------------------");
			System.out.println("\t|      Inventory Management     |");
			System.out.println("\t---------------------------------");
			System.out.println("\n\t1. Add New Item to Inventory.");
			System.out.println("\t2. Delete Item from Inventory.");
			System.out.println("\t3. Modify Item from Inventory.");
			System.out.println("\n\t---------------------------------");
			System.out.println("\n\tEnter (Q) to exit.");
			System.out.print("\tEnter your option > ");
			String opt = scanner.next();
			if(opt.toUpperCase().equals("Q")) {
				manageInvLoop = false;
				System.out.print("\033[H\033[2J"); //clear screen
			}
			else if(opt.equals("1"))
				addNewItem();
			else if(opt.equals("2")) {
				// Delete Item
				boolean delInvLoop = true;
				do {
					// Item validation
					ArrayList<Inventory> allInv = controller.getAllInv();
					printAllInv(allInv);
					
					System.out.println("\tEnter the No. of the item to select the item.");
		    		System.out.println("\tEnter (Q) to exit.");
		    		System.out.print("\n\tEnter your option > ");
		    		String delOpt = scanner.nextLine();
		    		if(delOpt.toUpperCase().equals("Q")) {
		    			delInvLoop = false;
		    			System.out.print("\033[H\033[2J"); //clear screen
		    		}
		    		else {
		    			try {
							int index = Integer.parseInt(delOpt) - 1;
							// Check validation for number selected
							Inventory item = allInv.get(index);
							
							printItemDetail(allInv.get(index));
							System.out.print("\n\tEnter (Y) to confirm to delete : ");
							String confirm = scanner.next();
							if(confirm.toUpperCase().equals("Y")) {
								// Update Inventory
								controller.removeInventory(index);
								System.out.println("\n\tItem has been removed.");
								System.out.print("\tEnter anything to proceed...");
								scanner.nextLine();
								scanner.nextLine();
							}
							else {
								System.out.println("\n\tItem removable has be canceled.");
								System.out.print("\tEnter anything to proceed...");
								scanner.nextLine();
								scanner.nextLine();
							}
		    			}catch (Exception e) {
		    				System.out.print("\033[H\033[2J"); //clear screen
				            System.out.println("\n\tInvalid option entered."); 
		    			}
		    		}
		    		
				}while(delInvLoop);
			}
			else if(opt.equals("3")) {
				boolean modInvLoop = true;
				do {
					ArrayList<Inventory> allInv = controller.getAllInv();
					printAllInv(allInv);
					
					System.out.println("\tEnter the No. of the item to select the item.");
		    		System.out.println("\tEnter (Q) to exit.");
		    		System.out.print("\n\tEnter your option > ");
		    		String modOpt = scanner.nextLine();
		    		if(modOpt.toUpperCase().equals("Q")) {
		    			modInvLoop = false;
		    			System.out.print("\033[H\033[2J"); //clear screen
		    		}
		    		else {
		    			// Item validation
		    			try {
							int index = Integer.parseInt(modOpt) - 1;
							Inventory item = allInv.get(index);
							boolean modLoop = true;
							int step = 0;
							do {
								while(step == 0) {
									System.out.println("\n\tItem name\t\t\t\t: " + item.getItemName());
									System.out.print("\tEnter New Item Name(or 'q' to quit)\t: ");
									String newName = scanner.nextLine();
									if(newName.toUpperCase().equals("Q")) {
										step --;
										modLoop = false;
									}
									else {
										step ++;
										while(step == 1) {
											System.out.println("\n\tItem ID\t\t\t\t\t: " + item.getItemId());
											System.out.print("\tEnter New Item ID(or 'b' to back)\t: ");
											String newId = scanner.next();
											if(newId.toUpperCase().equals("B")) {
												step --;
											}
											else {
												step ++;
												while(step == 2) {
													System.out.println("\n\tItem Price\t\t\t\t: " + String.format("%.2f",item.getItemPrice()));
													System.out.print("\tEnter New Item Price(or 'b' to back)\t: ");
													String newPrice = scanner.next();
													if(newPrice.toUpperCase().equals("B")) {
														step --;
													}
													else {
														try {
															double testPrice = Double.parseDouble(newPrice);
															step++;
															while(step == 3) {
																System.out.println("\n\tItem Weight\t\t\t\t: " + item.getItemWeight());
																System.out.print("\tEnter New Item Weight(or 'b' to back)\t: ");
																String newWeight = scanner.next();
																if(newWeight.toUpperCase().equals("B")) {
																	step --;
																}
																else {
																	try {
																		double testWeight = Double.parseDouble(newWeight);
																		step ++;
																		while(step == 4) {
																			System.out.println("\n\tItem Quantity\t\t\t\t: " + item.getItemQty());
																			System.out.print("\tEnter New Item Quantity(or 'b' to back)\t: ");
																			String newQty = scanner.next();
																			if(newQty.toUpperCase().equals("B")) {
																				step --;
																			}
																			else {
																				try {
																					int testQty = Integer.parseInt(newQty);
																					step ++;
																					Inventory newItem = new Inventory(newName, newId, testPrice, testWeight, testQty);
																					// Update inventory
																					controller.updateInventory(index, newItem);
																					System.out.println("\n\tItem has been modified.");
																					System.out.print("\tEnter anything to proceed...");
																					scanner.nextLine();
																					scanner.nextLine();
																					modLoop = false;
																					step ++;
																				}catch (NumberFormatException e) {
																		            System.out.println("\n\tInvalid quantity entered."); 
																    			}
																			}
																		}
																	}catch (NumberFormatException e) {
															            System.out.println("\n\tInvalid weight entered."); 
													    			}
																}
															}
														}catch (NumberFormatException e) {
												            System.out.println("\n\tInvalid price entered.");
										    			}
													}
												}
											}
										}
									}
								}
							}while(modLoop);
		    			}catch (Exception e) {
		    				System.out.print("\033[H\033[2J"); //clear screen
				            System.out.println("\n\tInvalid option entered."); 
		    			}
		    		}
				}while(modInvLoop);
			}
			else {
				System.out.print("\033[H\033[2J"); //clear screen
				System.out.print("\n\tInvalid option entered"); 
			}
		}while(manageInvLoop);
	}
	
	// Manage Order
	public void manageOrder() {
		boolean manageOrderLoop = true;
		do {
			ArrayList<Order> allOrder = controller.getAllOrder();
			// Manage manage order
			System.out.println("\n\t---------------------------------");
			System.out.println("\t|         Order Management       |");
			System.out.println("\t---------------------------------");
			System.out.println("\n\t1. Add New Order.");
			System.out.println("\t2. Delete Order.");
			System.out.println("\t3. Modify Order.");
			System.out.println("\n\t---------------------------------");
			System.out.println("\n\tEnter (Q) to exit.");
			System.out.print("\tEnter your option > ");
			String opt = scanner.next();
			System.out.print("\033[H\033[2J"); //clear screen
			if(opt.toUpperCase().equals("Q")) {
				manageOrderLoop = false;
			}
			else if(opt.equals("1")) {
				// Add New Order
				boolean userSelectLoop = true;
				do{
					ArrayList<User> allUser = controller.getAllUser();
					ArrayList<User> clientL = new ArrayList<>();
					int num = 0;
					
					// Select User
					System.out.println("\n\t-----------------------------");
					System.out.println("\t|         User List         |");
					System.out.println("\t-----------------------------");
					System.out.println(String.format("\n\t%-8s%-10s\n", "[No.]","[UserName]"));
					
					for (User user : allUser) {
						if (user instanceof Client) {
							System.out.println(String.format("\t %-8s%-20s", num + 1, user.getUsername()));
							clientL.add(user);
							num++;
						}
					}
					System.out.println("\t-----------------------------");
					System.out.println("\n\tEnter No. to select user.");
					System.out.println("\tEnter (Q) to quit.");
					System.out.print("\tEnter your option > ");
					String selUser = scanner.next();
					
					if(selUser.toUpperCase().equals("Q")) {
						userSelectLoop = false;
					}
					else {
						// User selection validation
						try {
							int index = Integer.parseInt(selUser) - 1;
							clientViewInv(clientL.get(index));
						} catch (Exception e) {
	                		System.out.print("\033[H\033[2J"); //clear screen
	    	            	System.out.println("\n\tInvalid option entered."); 
	                	}
						
					}
				}while(userSelectLoop);
			}
			else if(opt.equals("2")) {
				// Delete Order
				boolean delOrderLoop = true;
				do {
					// Check OrderList is empty or not
					if(allOrder.size() == 0) {
						System.out.println("\n\t" + "-".repeat(36));
						System.out.println("\t|            Order List            |");
						System.out.println("\t" + "-".repeat(36));
						System.out.println("\n\tOrderList is empty.");
						System.out.println("\n\t" + "-".repeat(36));
						System.out.print("\n\tEnter anything to proceed...");
						scanner.nextLine();
						scanner.nextLine();
						delOrderLoop = false;
					}
					else{
						System.out.println("\n\t" + "-".repeat(36));
						System.out.println("\t|            Order List            |");
						System.out.println("\t" + "-".repeat(36));
						System.out.println(String.format("\n\t%-8s%-12s%-11s%-4s\n", "[No.]","[UserName]","[OrderID]","[Qty]"));
						for(Order order : allOrder) {
							System.out.println(String.format("\t %-8s%-12s%-11s%,3d", allOrder.indexOf(order) + 1,
									order.getCusName(), order.getOrderId(),order.getOrderQty()));
						}
						System.out.println("\n\t" + "-".repeat(36));
						System.out.println("\n\tEnter No. to select Order.");
						System.out.println("\tEnter (Q) to quit.");
						System.out.print("\tEnter option > ");
						String selOrder = scanner.next();
						if(selOrder.toUpperCase().equals("Q")) {
							System.out.print("\033[H\033[2J"); //clear screen
							delOrderLoop = false;
						}
						else {
							try {
								int index = Integer.parseInt(selOrder) - 1;
								// Order validation
								Order selectedOrder = allOrder.get(index);
								
								System.out.println("\n\tEnter (Y) to delete order.");
								System.out.println("\tEnter (N) to cancel order removal.");
								System.out.print("\n\tEnter your option > ");
								String confirm = scanner.next();
								if(confirm.toUpperCase().equals("Y")) {
									// Update Order
									controller.removeOrder(index);
									System.out.println("\n\tThe Order has been removed successfully.");
									System.out.print("\tEnter anything to proceed...");
									scanner.nextLine();
									scanner.nextLine();
								}
								else {
									System.out.println("\n\tOrder removable has been cancelled.");
									System.out.print("\tEnter anything to proceed...");
									scanner.nextLine();
									scanner.nextLine();
								}
							} catch(Exception e) {
								System.out.print("\033[H\033[2J"); //clear screen
								System.out.print("\n\tInvalid option entered"); 
							}
						}
					}
				}while(delOrderLoop);
			}
			else if(opt.equals("3")) {
				boolean modOrderLoop = true;
				do {
					// Check OrderList is empty or not
					if(allOrder.size() == 0) {
						System.out.println("\n\t" + "-".repeat(36));
						System.out.println("\t|            Order List            |");
						System.out.println("\t" + "-".repeat(36));
						System.out.println("\n\tOrderList is empty.");
						System.out.println("\n\t" + "-".repeat(36));
						System.out.print("\n\tEnter anything to proceed...");
						scanner.nextLine();
						scanner.nextLine();
						modOrderLoop = false;
					}
					else {
						// Order selection
						System.out.println("\n\t" + "-".repeat(36));
						System.out.println("\t|            Order List            |");
						System.out.println("\t" + "-".repeat(36));
						System.out.println(String.format("\n\t%-8s%-12s%-11s%-4s\n", "[No.]","[UserName]","[OrderID]","[Qty]"));
						for(Order order : allOrder) {
							System.out.println(String.format("\t %-8s%-12s%-11s%,3d", allOrder.indexOf(order) + 1,
									order.getCusName(), order.getOrderId(),order.getOrderQty()));
						}
						System.out.println("\n\t" + "-".repeat(36));
						System.out.println("\n\tEnter No. to select Order.");
						System.out.println("\tEnter (Q) to quit.");
						System.out.print("\tEnter option > ");
						String selOrder = scanner.next();
						if(selOrder.toUpperCase().equals("Q")) {
							System.out.print("\033[H\033[2J"); //clear screen
							modOrderLoop = false;
						}
						else {
							// Selected Order validation
							try {
								int step = 0;
								int index = Integer.parseInt(selOrder) - 1;
								Order order = allOrder.get(index);
								while(step == 0) {
					
									System.out.println("\n\tItem Name\t\t\t\t: " + order.getItemName());
									System.out.print("\tEnter New Item Name(or 'q' to quit)\t: ");
									String newName = scanner.nextLine();
									if (newName.toUpperCase().equals("Q")) {
										step --;
									}
									else {
										step++;
										while (step == 1) {
											System.out.println("\n\tOrder ID\t\t\t\t: " + order.getOrderId());
											System.out.print("\tEnter New Item Name(or 'b' to back)\t: ");
											String newId = scanner.next();
											if (newId.toUpperCase().equals("B")) {
												step --;
											}
											else {
												step++;
												while(step == 2) {
													System.out.println("\n\tCustomer Name\t\t\t\t: " + order.getCusName());
													System.out.print("\tEnter New Customer Name(or 'b' to back)\t: ");
													String newCusName = scanner.nextLine();
													if (newCusName.toUpperCase().equals("B")) {
														step --;
													}
													else {
														step++;
														while(step == 3) {
															System.out.println("\n\tQuantity Ordered\t\t\t: " + order.getOrderQty());
															System.out.print("\tEnter New Quantity(or 'b' to back)\t: ");
															String newQty = scanner.next();
															if (newQty.toUpperCase().equals("B")) {
																step --;
															}
															else {
																try {
																	int newQtyChk = Integer.parseInt(newQty);
																	step ++;
																	while(step == 4) {
																		System.out.println("\n\tOrder Weight\t\t\t\t: " + order.getOrderWeight());
																		System.out.print("\tEnter New Weight(or 'b' to back)\t: ");
																		String newWeight = scanner.next();
																		if (newWeight.toUpperCase().equals("B")) {
																			step --;
																		}
																		else {
																			try {
																				double newWeightChk = Double.parseDouble(newWeight);
																				step ++;
																				while(step == 5) {
																					System.out.println("\n\tTotal Price\t\t\t\t: " + String.format("%.2f",order.getTotalPrice()));
																					System.out.print("\tEnter New Price(or 'b' to back)\t\t: ");
																					String newPrice = scanner.next();
																					if (newPrice.toUpperCase().equals("B")) {
																						step --;
																					}
																					else {
																						try {
																							double newPriceChk = Double.parseDouble(newPrice);
																							// Update Order List
																							controller.updateOrder(index, new Order(newName, newId, 
																									newCusName, newQtyChk, newWeightChk, newPriceChk));
																							step++;
																							System.out.println("\n\tOrder has been updated.");
																							System.out.print("\tEnter anything to proceed...");
																							scanner.nextLine();
																							scanner.nextLine();
																						}catch(Exception e) {
																							System.out.println("\n\tInvalid price entered.");
																						}
																					}
																				}
																			}catch(Exception e) {
																				System.out.println("\n\tInvalid weight entered.");
																			}
																		}
																	}
																}catch(Exception e) {
																	System.out.println("\n\tInvalid quantity entered.");
																}
															}
														}
													}
												}
											}
										}
									}
								}
								
							} catch (Exception e) {
		                		System.out.print("\033[H\033[2J"); //clear screen
		    	            	System.out.println("\n\tInvalid option entered."); 
		                	}
						}
					}
				}while(modOrderLoop);
			}
		}while(manageOrderLoop);
	}
	
	// Manage Bill Statement
	public void manageBilling() {
		boolean manageBillLoop = true;
		do {
			ArrayList<Billing> allBill = controller.getAllBilling();
			// Manager manage billing
			System.out.println("\n\t---------------------------------");
			System.out.println("\t|       Billing Management      |");
			System.out.println("\t---------------------------------");
			System.out.println("\n\t1. Delete Bill.");
			System.out.println("\t2. Modify Bill.");
			System.out.println("\n\t---------------------------------");
			System.out.println("\n\tEnter (Q) to exit.");
			System.out.print("\tEnter your option > ");
			String opt = scanner.next();
			if (opt.toUpperCase().equals("Q")) {
				manageBillLoop = false;
				System.out.print("\033[H\033[2J"); //clear screen
			}
			else if(opt.equals("1")) {
				boolean delBillLoop = true;
				do {
					// Delete Bill
					if(allBill.size() == 0) {
						// Check Bill List empty or not
						System.out.println("\n\t" + "-".repeat(50));
						System.out.println("\t|                   Bill List                    |");
						System.out.println("\t" + "-".repeat(50));
						System.out.println("\n\tBilling list is empty.");
						System.out.println("\n\t" + "-".repeat(50));
						System.out.print("\n\tEnter anything to proceed...");
						scanner.nextLine();
						scanner.nextLine();
						delBillLoop = false;
					}
					else {
						System.out.println("\n\t" + "-".repeat(50));
						System.out.println("\t|                   Bill List                    |");
						System.out.println("\t" + "-".repeat(50));
						System.out.println(String.format("\t%-8s%-12s%-11s%-4s\n", "[No.]","[UserName]","[BillID]","[OrderID]"));
						for(Billing bill : allBill) {
							System.out.println(String.format("\t %-8s%-12s%-11s%-30s", allBill.indexOf(bill) + 1,
									bill.getCusName(), bill.getBillingId(),bill.getOrderIdList()));
						}
						System.out.println("\t" + "-".repeat(50));
						System.out.println("\n\tEnter the No. of the bill to select the bill.");
				    	System.out.println("\tEnter (Q) to exit.");
				   		System.out.print("\n\tEnter your option > ");
				   		String delOpt = scanner.next();
				   		if(delOpt.toUpperCase().equals("Q")) {
				   			delBillLoop = false;
				   			System.out.print("\033[H\033[2J"); //clear screen
				   		}
				   		else {
				   			try {
				   				int index = Integer.parseInt(delOpt) - 1;
				   				
								// Check validation for bill
								Billing bill = allBill.get(index);
								
								System.out.println("\n\t-------------------------------------------");
						        System.out.println("\t|               Bill detail               |");
						        System.out.println("\t-------------------------------------------");
						        System.out.println("\n\tBill ID \t: " + bill.getBillingId());
						        System.out.println("\tCustomer name\t: " + bill.getCusName());
						        System.out.println("\tPayment type\t: " + bill.getPayment());
						        System.out.println("\tBill total\t: " + String.format("%.2f",bill.getTotal()));
						        System.out.println("\tOrder ID\t: " + bill.getOrderIdList());
						        System.out.println("\n\t-------------------------------------------");
								System.out.print("\n\tEnter (Y) to confirm to delete : ");
								String confirm = scanner.next();
								if(confirm.toUpperCase().equals("Y")) {
									// Delete bill from BillList
									controller.removeBilling(index);
									System.out.println("\n\tBill has been removed.");
									System.out.print("\tEnter anything to proceed...");
									scanner.nextLine();
									scanner.nextLine();
								}
								else {
									System.out.println("\n\tBill removable has be canceled.");
									System.out.print("\tEnter anything to proceed...");
									scanner.nextLine();
									scanner.nextLine();
								}
				   			}catch (Exception e) {
					            System.out.println("\n\tInvalid option entered.");
			    			}
				   		}
					}
				}while(delBillLoop);
			}
			else if(opt.equals("2")) {
				// Modification for Bill
				boolean modifyBillLoop = true;
				do {
					// Bill empty check
					if(allBill.size() == 0) {
						System.out.println("\n\t" + "-".repeat(50));
						System.out.println("\t|                   Bill List                   |");
						System.out.println("\t" + "-".repeat(50));
						System.out.println("\n\tBilling list is empty.");
						System.out.println("\n\t" + "-".repeat(50));
						System.out.print("\n\tEnter anything to proceed...");
						scanner.nextLine();
						scanner.nextLine();
						modifyBillLoop = false;
					}
					else {
						// Print all Bill
						System.out.println("\n\t" + "-".repeat(50));
						System.out.println("\t|                   Bill List                   |");
						System.out.println("\t" + "-".repeat(50));
						System.out.println(String.format("\t%-8s%-12s%-11s%-4s\n", "[No.]","[UserName]","[BillID]","[OrderID]"));
						for(Billing bill : allBill) {
							System.out.println(String.format("\t %-8s%-12s%-11s%-30s", allBill.indexOf(bill) + 1,
									bill.getCusName(), bill.getBillingId(),bill.getOrderIdList()));
						}
						
						System.out.println("\t" + "-".repeat(50));
						System.out.println("\n\tEnter the No. of the bill to select the bill.");
				    	System.out.println("\tEnter (Q) to exit.");
				   		System.out.print("\n\tEnter your option > ");
				   		System.out.print("\033[H\033[2J"); //clear screen
				   		String modOpt = scanner.next();
				   		if(modOpt.toUpperCase().equals("Q")) {
				   			modifyBillLoop = false;
				   		}
				   		else {
				   			try {
				   				// Bill section validation
				   				int index = Integer.parseInt(modOpt) - 1;
				   				Billing bill = allBill.get(index);
				   				int step = 0;
				   				while(step == 0) {
				   					System.out.println("\n\tBill ID\t\t\t\t\t: " + bill.getBillingId());
				   					System.out.print("\tEnter New Bill ID(or 'q' to quit)\t: ");
									String newId = scanner.next();
									if (newId.toUpperCase().equals("Q")) {
										step --;
									}
									else {
										step ++;
										while(step == 1) {
									        System.out.println("\n\tCustomer name\t\t\t\t: " + bill.getCusName());
									        System.out.print("\tEnter New Customer name(or 'b' to back)\t: ");
									        String newCusName = scanner.next();
									        if (newCusName.toUpperCase().equals("B")) {
												step --;
											}
									        else {
									        	step ++;
									        	while(step == 2) {
											        System.out.println("\n\tPayment type\t\t\t\t: " + bill.getPayment().toUpperCase());
											        System.out.print("\tEnter New Payment type(or 'b' to back)\t: ");
											        String newPayment = scanner.next().toUpperCase();
											        if (newPayment.equals("B")) {
														step --;
													}
											        else if(newPayment.equals("C") || newPayment.equals("D")) {
											        	step ++;
											        	while (step == 3) {
												        	System.out.println("\n\tBill total\t\t\t\t: " + String.format("%.2f",bill.getTotal()));
												        	System.out.print("\tEnter New Bill total(or 'b' to back)\t: ");
													        String newTotal = scanner.next();
													        if (newTotal.toUpperCase().equals("B")) {
																step --;
															}
													        else {
													        	try {
													        		double newTotalChk = Double.parseDouble(newTotal);
													        		step ++;
													        		while(step == 4) {
														        		String orderIdListString = bill.getOrderIdList().toString();
														        		System.out.println("\n\tOrder ID\t\t\t\t: " + orderIdListString.substring(1, orderIdListString.length() - 1));
														        		System.out.print("\tEnter New Order ID(or 'b' to back)\t: ");
																        String newOrderIdChk = scanner.nextLine();
																        if (newOrderIdChk.toUpperCase().equals("B")) {
																			step --;
																		}
																        else {
																        	String[] orderId = newOrderIdChk.split(", ");
																        	ArrayList<String> newOrderId = new ArrayList<>();
																        	boolean chk = false;
																        	for (String orderIdChk : orderId) {
																        		if(orderIdChk.matches("O\\d{3}")) {
																        			newOrderId.add(orderIdChk);
																        		}
																        		else {
																        			chk = true;
																        			break;
																        		}
																        	}
																        	if(chk) {
																        		System.out.println("\n\tInvalid orderID format entered.");
																        		System.out.println("\tValid format e.g. O001, O002, O003.");
																        	}
																        	else {
																        		step ++;
																        		// Update Bill
																        		Billing newBilling = new Billing(newId, newCusName, newPayment, newTotalChk, newOrderId);
																        		controller.updateBilling(index, newBilling);
																        		System.out.println("\n\tBill has been updated successfully.");
																        		System.out.print("\tEnter anything to proceed...");
																        		scanner.nextLine();
																        		scanner.nextLine();
																        	}
																        }
													        		}
													        	} catch(Exception e) {
													        		System.out.println("\n\tInvalid Total entered");
													        	}
													        	
													        }
											        	}
											        }
											        else
											        	System.out.println("\n\tInvalid Payment Type entered\n\tEnter 'C'redit or 'D'ebit");
									        	}
									        }
										}
									}
				   				}
				   			} catch(Exception e) {
				   				System.out.println("\n\tInvalid option entered.");
				   			}
				   		}
					}
				}while(modifyBillLoop);
			}
			else {
				System.out.print("\033[H\033[2J"); //clear screen
				System.out.print("\n\tInvalid option entered."); 
			}
		}while(manageBillLoop);
	}
	
	public void manageReport() {
		boolean manageReportLoop = true;
		do {
			// Manager view or generate report
			ArrayList<Billing> allBill = controller.getAllBilling();
			ArrayList<Report> allReport = controller.getAllReport();
			System.out.println("\n\t---------------------------------");
			System.out.println("\t|       Report Management       |");
			System.out.println("\t---------------------------------");
			System.out.println("\n\t1. Generate New Report.");
			System.out.println("\t2. View Report.");
			System.out.println("\n\t---------------------------------");
			System.out.println("\n\tEnter (Q) to exit.");
			System.out.print("\tEnter your option > ");
			String opt = scanner.next();
			if (opt.toUpperCase().equals("Q")) {
				manageReportLoop = false;
				System.out.print("\033[H\033[2J"); //clear screen
			}
			
			else if(opt.equals("1")) {
				// Generate new report
				System.out.println("\n\t" + "-".repeat(40));
				System.out.println("\t|          New Report Detail           |");
				System.out.println("\t" + "-".repeat(40));
				if(allBill.size() == 0) {
					// Check billing
					System.out.println("\n\tNo Billing in Billing List.");
					System.out.println("\tReport unable to be generated.");
					System.out.println("\n\t" + "-".repeat(40));
					System.out.print("\n\tEnter anything to go back...");
					scanner.nextLine();
					scanner.nextLine();
				}
				else {
					boolean createReportLoop = true;
					do {
						// Generate new Report
						ArrayList<String> newBillingIdList = new ArrayList<>();
						double total = 0;
						for(Billing bill : allBill) {
							newBillingIdList.add(bill.getBillingId());
							total += bill.getTotal();
						}
						System.out.println("\n\tNew Report generated");
						System.out.println("\n\tBilling ID:\n\t" + newBillingIdList.toString());
						System.out.println("\tTotal amount : RM " + String.format("%.2f",total));
						System.out.println("\n\t" + "-".repeat(40));
						System.out.println("\n\tEnter 'S' to save or 'C' to cancel saving.");
						System.out.print("\n\tEnter (Q) to exit. ");
						System.out.print("\n\tEnter your option > ");
						String saveOpt = scanner.next();
						if(saveOpt.toUpperCase().equals("Q")) {
							createReportLoop = false;
						}
						// Report generation confirmation
						else if(saveOpt.toUpperCase().equals("S")) {
							// Update Report List
							controller.addNewReport(newBillingIdList, total);
							System.out.print("\n\tNew Report saved successfully.");
							System.out.print("\tEnter anything to proceed...");
							createReportLoop = false;
							scanner.nextLine();
							scanner.nextLine();
						}
						else if(saveOpt.toUpperCase().equals("C")) {
							System.out.println("");
							System.out.print("\n\tNew Report saving cancel.");
							System.out.print("\tEnter anything to proceed...");
							createReportLoop = false;
							scanner.nextLine();
							scanner.nextLine();
						}
						else {
							System.out.print("\033[H\033[2J"); //clear screen
			   				System.out.print("\n\tInvalid option entered."); 
						}
					}while(createReportLoop);
				}
			}
			
			else if(opt.equals("2")) {
				boolean viewReportLoop = true;
				do {
					if(allReport.size() == 0) {
						System.out.println("\n\t" + "-".repeat(50));
						System.out.println("\t|                  Report List                   |");
						System.out.println("\t" + "-".repeat(50));
						System.out.println("\n\tReport list is empty.");
						System.out.println("\n\t" + "-".repeat(50));
						System.out.print("\n\tEnter anything to proceed...");
						scanner.nextLine();
						scanner.nextLine();
						viewReportLoop = false;
					}
					else {
						System.out.println("\n\t" + "-".repeat(50));
						System.out.println("\t|                  Report List                   |");
						System.out.println("\t" + "-".repeat(50));
						System.out.println(String.format("\t%-8s%-23s%11s\n", "[No]","[BillID]","[Total(RM)]"));
						for(Report rpt : allReport) {
							System.out.println(String.format("\t %-8s%-12s%-11s%-30s", allReport.indexOf(rpt) + 1,
									rpt.getBillingIdList().toString(), rpt.getBillTotal()));
						}
						System.out.println("\t" + "-".repeat(50));
						System.out.println("\n\tEnter the No. of the bill to select the bill.");
				    	System.out.println("\tEnter (Q) to exit.");
				   		System.out.print("\n\tEnter your option > ");
				   		String selOpt = scanner.next();
				   		if(selOpt.toUpperCase().equals("Q")) {
				   			viewReportLoop = false;
				   			System.out.print("\033[H\033[2J"); //clear screen
				   		}
				   		else {
				   			try {
				   				int index = Integer.parseInt(selOpt);
				   				Report report = allReport.get(index);
				   				System.out.println("\n\t" + "-".repeat(40));
								System.out.println("\t|            Report Detail             |");
								System.out.println("\t" + "-".repeat(40));
								System.out.println("\n\tReport ID: " + report.getReportId());
								System.out.println("\tBilling ID List:\n\t" + report.getBillingIdList().toString());
								System.out.println("\tTotal amount: " + String.format("%.2f",report.getBillTotal()));
								System.out.println("\n\t" + "-".repeat(40));
								System.out.print("\n\tEnter anything to go back...");
								scanner.nextLine();
								scanner.nextLine();
				   			} catch(Exception e) {
				   				System.out.print("\033[H\033[2J"); //clear screen
				   				System.out.print("\n\tInvalid option entered."); 
				   			}
				   		}
					}
				}while(viewReportLoop);
			}
			
			else {
				System.out.print("\033[H\033[2J"); //clear screen
				System.out.print("\n\tInvalid option entered."); 
			}
		}while(manageReportLoop);
	}
	
	// Print all Inventory
	public void printAllInv(ArrayList<Inventory> allInv) {
		System.out.println("\n\t-------------------------------------------------------------");
		System.out.println("\t|                     Inventory List                        |");
		System.out.println("\t-------------------------------------------------------------");
		System.out.println(String.format("\t%-7s%-20s%-14s%-7s%12s\n","[No.]", "[Name]",
				"[Weight(kg)]","[Qty]","[Price(RM)]"));
        for (Inventory item : allInv) {
        	System.out.println(String.format("\t%-8d%-20s%-14.2f%-6d%,11.2f",
                    allInv.indexOf(item) + 1, item.getItemName(), item.getItemWeight(),
                    item.getItemQty(), item.getItemPrice()));
		}
		System.out.println("\t-------------------------------------------------------------\n");
	}
	
	// Print selected Item info
	public void printItemDetail(Inventory item) {
        System.out.println("\n\t---------------------------------");
        System.out.println("\t|          Item detail          |");
        System.out.println("\t---------------------------------");
        System.out.println("\n\tItem name\t: " + item.getItemName());
        System.out.println("\tItem weight\t: " + item.getItemWeight());
        System.out.println("\tItem price\t: " + item.getItemPrice());
        System.out.println("\tItem Quantity\t: " + item.getItemQty());
        System.out.println("\n\t---------------------------------");
	}
	
	// Exit function
	public void exit() {
        System.out.println("\n\tExiting application.");
        System.out.println("\tGoodbye and thanks for using Pets Outlet System!");
 		controller.update();
		System.exit(0);
    }
}
