package runner;

import java.util.*;

import dao.CustomerDao;
import dao.dbconnection_abstract;
import model.Customer;

import java.io.IOException;
import java.sql.SQLException;


public class Customer_runnable extends dbconnection_abstract {

	public void getCustomerDetails() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		myconnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the ssn of the customer: \n");
		int ssn = sc.nextInt();
		CustomerDao cDao = new CustomerDao();
		Customer myCustomer = cDao.getCustomerDetails( ssn);
		//System.out.println("Name: 1 \n");
		System.out.printf("%-8s|%-4s|%-11s|%-16s|%-10s|%-19s|%-10s|%-10s|%-14s|%-8s|%-9s|%-18s|%-8s\n", "First_Name", "Last_Name", "Ssn", "Credit_Card_No",  "Apartment NO", "Street Name", "Cust_City", "Cust_State", "Cust_Country", "Zipcode", "Phone", "Email", "Last_Updated " );
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("  %-8s|%-9s|%-11s|%-14s|%-12s|%-19s|%-10s|%-10s|%-14s|%-8s|%-9s|%-16s|%-8s\n", myCustomer.getFirst_Name(), myCustomer.getLast_Name(), myCustomer.getSsn(), myCustomer.getCredit_card_NO(), myCustomer.getApt_No(), 
				myCustomer.getStreet_Name(), myCustomer.getCust_City(), myCustomer.getCust_state(), myCustomer.getCust_Country(), myCustomer.getZipCode(), myCustomer.getPhone(), myCustomer.getCust_Email(), myCustomer.getLast_updated() );
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
//		System.out.println("Name: " + myCustomer.getFirst_Name() + myCustomer.getLast_Name() + "|"   + " Apartment NO: " + myCustomer.getApt_No() + "|"
//		+ " Street Name: " + myCustomer.getStreet_Name() + "|" + " City: " + myCustomer.getCust_City() + "|" + " State : " + myCustomer.getCust_state() + "|" + " Country: " + myCustomer.getCust_Country()
//		+ " Zipcode: " + myCustomer.getZip() + "|" + " Phone: " + myCustomer.getPhone() + "|" + " Email: " + myCustomer.getEmail() + "|" + " Last_Updated: " + myCustomer.getLast_updated());
//		System.out.println();
		
	}



	//functional requirements 2
public HashMap<Integer, String> getCustomerModify() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		
		//myconnection();
		Scanner sc = new Scanner(System.in);
		CustomerDao cDao = new CustomerDao();
		String changedValue="";
		
		System.out.println("Please, enter a customer's ssn to update the info \n");
		int ssn = sc.nextInt();
		
		HashMap<Integer, String> newKeyValuePair;
		newKeyValuePair = new HashMap<Integer, String>();
		
		try {
			
			Customer myCustomer = cDao.getCustomerDetails(ssn);
			newKeyValuePair.put(1, myCustomer.getFirst_Name());
			System.out.println("Middle Name while putting in the Map: "+myCustomer.getMiddle_Name());
			System.out.println();
			
			newKeyValuePair.put(2, myCustomer.getMiddle_Name());
			newKeyValuePair.put(3, myCustomer.getLast_Name());
			newKeyValuePair.put(4, String.valueOf(myCustomer.getSsn()));
			newKeyValuePair.put(5, myCustomer.getCredit_card_NO());
			newKeyValuePair.put(6, String.valueOf(myCustomer.getApt_No()));
			newKeyValuePair.put(7, myCustomer.getStreet_Name());
			newKeyValuePair.put(8, myCustomer.getCust_City());
			newKeyValuePair.put(9, myCustomer.getCust_state());
			newKeyValuePair.put(10, myCustomer.getCust_Country());
			newKeyValuePair.put(11, String.valueOf(myCustomer.getZipCode()));
			newKeyValuePair.put(12, String.valueOf(myCustomer.getPhone()));
			newKeyValuePair.put(13, myCustomer.getCust_Email());		
			
		}	catch (Exception e) {
			System.err.println(e);
			System.exit(1);
		}
		
		System.out.println("Current Values of the fields are as follows: "+"\n"+ 
		" 1 - First Name"+  "|" + "Current value is:"+  "|" + newKeyValuePair.get(1)+"\n"
		+" 2 - Middle Name"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(2)+"\n"
		+" 3 - Last Name"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(3)+"\n"
		+" 5 - Credit card"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(5)+"\n"
		+" 6 - Apt No"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(6)+"\n"
		+" 7 - Street Name"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(7)+"\n"
		+" 8 - Cust_City"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(8)+"\n"
		+" 9 - Cust_state"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(9)+"\n"
		+" 10 - Cust_Country"+ "|" + "Current value is: "+ "|" + newKeyValuePair.get(10)+"\n"
		+" 11 - ZipCode"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(11)+"\n"
		+" 12 - Phone"+ "|" + "Current value is: "+  "|" + newKeyValuePair.get(12)+"\n"
		+" 13 - Cust_Email"+ "|" + "tCurrent value is: "+  "|" + newKeyValuePair.get(13)+"\n"
		+"  0 - Exit");
		
		try {
			int Key = 222; //Initialized to Non-Zero Integers
			while(Key!=0) {
				System.out.println();
				System.out.println("Please, choose any field you want to modify");
				Key = sc.nextInt();
				if ( Key >= 1 && Key <= 13 && Key != 4) {
					System.out.println("Please, enter the new value for the field");
					changedValue = sc.next();
					newKeyValuePair.replace(Key, changedValue); // refresh the Map with the new values
				}
				else {
					System.out.println("Invalid option, please make a selection between 1 and 13 - Except 4");
				}					
			}					
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			Customer myCustomer = cDao.modifyCustomer(ssn, newKeyValuePair);

		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return newKeyValuePair;
	}		
		
//		CustomerDao cDao = new CustomerDao();
//		Customer myCustomer = cDao.getUpdateCustomerDetails(ssn, First_Name, Last_Name, Apt_No, Street_Name, Cust_City, Cust_State, Zip, Phone, Email );
//		System.out.println("First_Name is: " + myCustomer.getFirst_Name() + "|" + "Last_Name: " + myCustomer.getLast_Name() + "|" + "Apt_No: " + myCustomer.getApt_No()
//		      + "|" + "Street_Name: " + myCustomer.getStreet_Name() + "|" + "Cust_City: " + myCustomer.getCust_City() + "|" + " Cust_State: " + myCustomer.getCust_state()
//		      + "|" + "Zip: " + myCustomer.getZipCode() + "|" + " Phone: " + myCustomer.getPhone() + "|" + " Email: " + myCustomer.getCust_Email());
//		

 // functional requirements 3

public void getCustomerMonthlyBill() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
	CustomerDao cDao = new CustomerDao();
	Scanner sc = new Scanner(System.in);
	ArrayList<Customer> myCustomer = new ArrayList<Customer>();
	
	System.out.println("Please, enter the customer credit card NO: ");
	
	String Credit_Card_NO;
	Credit_Card_NO = sc.nextLine();
	
	System.out.println("Please, enter the Month: ");
	//Scanner sc1 = new Scanner(System.in);
	int Month = sc.nextInt();
	
	System.out.println("Please, enter the Year: ");   
	int Year = sc.nextInt();
	
	//CustomerDao cDao = new CustomerDao();
	myCustomer = cDao.getCustomerMonthlyBill(Credit_Card_NO, Month, Year);
	
	System.out.println(" Name: " + "\t\t" + " Apartment NO" + "\t\t" +" Street_Name " +"\t" +" Cust_City " +"\t" + " Cust_State "+ "\t"+ " Zipcode"+ "\t" 
			+" Phone "+"\t\t" +" Cust_Email "+ "\t" + " Branch_Code " + "\t" +" Transaction_Type " +"\t" +"Transaction_value ");
	System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		
	for (Customer customer : myCustomer) {
	System.out.println( customer.getFirst_Name() +"," + customer.getLast_Name() + "\t\t" + customer.getApt_No()  + "\t\t" + customer.getStreet_Name() 
	+ "\t" + customer.getCust_City() + "\t\t" + customer.getCust_state() + "\t" + customer.getZipCode() + "\t\t" + customer.getPhone() + "\t\t" + customer.getCust_Email() 
	+"\t" + customer.getBranch_Code() + "\t\t" + customer.getTransaction_Type() + "\t\t" + customer.getTransaction_value());
	System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		}
	 }


//     functional Requirements 4

public void getCustTransByTwoDates()throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException {
      CustomerDao cDao = new CustomerDao();
	  ArrayList<Customer> mycustomer = new ArrayList<Customer>();	
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Please enter the Ssn of the customer: ");
      int SSN = keyboard.nextInt();
      System.out.println("Please enter the Start Date in the format YYY-MM-DD:");

      String startDay = keyboard.next();
      
      System.out.println("Start Date is : " + startDay);
      System.out.println("Please enter the End Date in the format YYY-MM-DD:");
      String endDay = keyboard.next();
      System.out.println("End Date is : " + endDay);
      
      try {
    	  mycustomer = cDao.getCustTransByTwoDates(SSN, startDay, endDay);
		  System.out.printf("%-8s|%-7s|%-6s|%-6s|\n", "First_Name", "Last_Name", "Transaction_Type", "Transaction_Value");
		  System.out.println("--------------------------------------------------------");
    	  for (Customer customer: mycustomer) {
    		//  System.out.println("Transactions made by a customer Between Two Dates. ");
    		  System.out.printf("%-10s|%-10s|%-15s|%-17s|\n", customer.getFirst_Name(), customer.getLast_Name(), customer.getTransaction_Type(), customer.getTransaction_value());
    		  System.out.println("---------------------------------------------------------\n");
    	  }
      }
      catch (Exception e) {
		// TODO: handle exception
    	  System.out.println(" General processing Error!!! " + e.getMessage());
    	  e.printStackTrace();
    	  keyboard.close();
   	 }
      finally {	
	 }
      
 		}
 
	}
