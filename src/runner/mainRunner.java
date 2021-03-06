package runner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class mainRunner  {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
		Scanner sc = new Scanner(System.in);
		Transaction_runnable t = new Transaction_runnable();

		//Transaction_runnable t;
		Customer_runnable C = new Customer_runnable();
		
		System.out.println("****WE ARE PLEASED TO HAVE YOU. THANKS FOR YOUR BUSINESS!****");
		System.out.println();
	//	boolean selection = true;
		while (true) {
			// print available options
			System.out.println("Please make a selection from the following options");
			
			System.out.println();
			System.out.println("(1) Display transactions made by customers living in a given Zipcode, for a given month and Year");
			System.out.println();
			System.out.println("(2) Display the number of transactions and total $ Value generated from a given Transaction Type");
			System.out.println();
			System.out.println("(3) Display the number of transactions and total $ Value generated by branches in a given state");
			System.out.println();
			System.out.println("(4) Display the existing account details of a customer");
			System.out.println();
			System.out.println("(5) Modify the existing account details of a customer");
			System.out.println();
			System.out.println("(6) Display the monthly bill of a customer for a given month and year");
			System.out.println();
			System.out.println("(7) Display the transactions made by a distinct customer between two distinct dates");
			System.out.println();
			System.out.println("(8) Exit\n");
			Integer selection = 0;
	//		selection = sc.nextInt();

				// keep running until valid option is selected
			while(!(selection instanceof Integer) || selection > 8 || selection < 1) {
				try {
					
					selection = sc.nextInt();
					
					switch (selection) {
					case 1: t = new Transaction_runnable();
							t.getTransactionByZipcode();
							break;
					case 2: t = new Transaction_runnable();
							t.getTotalByType();
							break;	
					case 3: t = new Transaction_runnable();
							t.getTotalValuesByTransactionByBranches();
							break;
					case 4: C = new Customer_runnable();
							C.getCustomerDetails();
							break;
					case 5: C = new Customer_runnable();
							C.getCustomerModify();
							break;
					case 6: C = new Customer_runnable();
					    	C.getCustomerMonthlyBill();
							break;
					case 7: C = new Customer_runnable();
			    			C.getCustTransByTwoDates();
			    			break;	
					case 8: 
						System.out.println("****Thanks for your patronage****");
						System.out.println("See you next time");
					break;
							
					default:
						System.out.println("Please, enter a valid option");
						break;
					}
					
				}	
				catch (SQLException e) {
					e.printStackTrace();
				}
			}	
		}	
	}
	
}
		
