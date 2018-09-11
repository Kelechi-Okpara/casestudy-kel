package runner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dao.TransactionDao;
import dao.dbconnection_abstract;
import model.Transaction;

public class Transaction_runnable extends dbconnection_abstract{
	
	// functional requirement 1
	public void getTransactionByZipcode() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException{
	//	ArrayList<Transaction>Transaction = new ArrayList<Transaction>();

		myconnection();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a 5-digit zipcode:");
		int Zipcode = sc.nextInt();
		System.out.println("Please enter a 2-digit Month:");
		int Month = sc.nextInt();
		System.out.println("Please enter a 4-digit Year:");
		int Year = sc.nextInt();
		System.out.println();
	//	sc.close();
		TransactionDao TDao = new TransactionDao();
	
		System.out.printf("%-8s|%-5s|%-7s|%-8s| %-14s|%-12s|%-6s\n","Transaction_Id","Transaction_Type","Transaction_Value","Day","Credit_Card_NO","Cust_SSN","Branch_Code");
		System.out.println("---------------------------------------------------------------------------------------------------");
		ArrayList <Transaction> Tansbytype = TDao.getTransactionByZipcode(Zipcode, Month, Year);
		for (Transaction t1 : Tansbytype) {

			System.out.printf( "%-14s|%-17s|%-17s|%-8s|%-12s| %-6s| %-6s\n", t1.getTransaction_Id(), t1.getTransaction_Type(), t1.getTransactionValue(), 
					t1.getDay(), t1.getCredit_Card_NO(), t1.getCust_SSN(), t1.getBranch_Code());
			System.out.println("-----------------------------------------------------------------------------------------------");
		    System.out.println();
		}
		
	}	
		// functional requirements 2
	
	public void getTotalByType() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException{
		Scanner sc = new Scanner(System.in);
		System.out.println(" Please enter Transaction Type from the options below");
		System.out.println();
		System.out.println(" Education" +"\n" +" Entertainment");
		System.out.println(" Grocery");
		System.out.println(" Gas");
		System.out.println(" Bills");
		System.out.println(" Test");
		System.out.println(" Healthcare");
		System.out.println();
		String type = sc.nextLine();

		TransactionDao TDao = new TransactionDao();
		Transaction mytransactions = TDao.getTotalByType(type);
		System.out.println();
		System.out.printf(" %-7s|%-4s\n", "Total Number of " + type + " Transactions "," Total (USD) Value of Transactions");
		System.out.println("---------------------------------------------------------------------");
		System.out.printf(" %-34s| %-4s\n", mytransactions.getCount(), mytransactions.getTransactionValue()); 
		System.out.println("---------------------------------------------------------------------\n");
	}
	
         // functional requirement 3
	public void getTotalValuesByTransactionByBranches() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException{
		TransactionDao TDao = new TransactionDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the state: ");
		String state = sc.nextLine();
		Transaction mytransactions = TDao.getTotalValuesByTransactionByBranches(state);
		System.out.printf(" %-6s|%-4s|%-8s|%-5s|%-6s|%-4s|%-12s|%-4s\n","Transaction_Type", "Number of "+state+" Transactions","Total Value of Transactions","Branch_Name","Branch_Code","Branch_Zip","Branch_City","Branch_State");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf(" %-15s|  %-23s|  %-25s|%-4s|  %-8s| %-9s|%-13s| %-4s\n", mytransactions.getTransaction_Type(), mytransactions.getCount(), mytransactions.getTransactionValue(), mytransactions.getBranch_Name(), mytransactions.getBranch_Code(), 
				mytransactions.getBranch_Zip(), mytransactions.getBranch_City(), mytransactions.getBranch_State()); 
		System.out.println("-----------------------------------------------------------------------------------------------------------------------------------\n");
		
		}	
		
	}
