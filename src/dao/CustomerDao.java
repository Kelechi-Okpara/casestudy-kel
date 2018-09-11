package dao;

import java.io.IOException;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import model.Customer;
import resources.myQueries;


public class CustomerDao  extends dbconnection_abstract {
	public Customer getCustomerDetails(int ssn) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		try {
			System.out.println("\n\nEstablishing connection to the database..\n");
			myconnection();
			System.out.println("Successfully established connection.\n\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
		ps = connection.prepareStatement(myQueries.CustomerDetails);
		ps.setInt(1, ssn);
		rs = ps.executeQuery(); 
		Customer c1 = new Customer();
		
		if(rs.next()){
			
			c1.setFirst_Name(rs.getString(1));
			c1.setLast_Name(rs.getString(2));
			c1.setSsn(rs.getInt(3));
			c1.setCredit_card_NO(rs.getString(4));
			c1.setApt_No(rs.getInt(5));
			c1.setStreet_Name(rs.getString(6));
			c1.setCust_City(rs.getString(7));
			c1.setCust_state(rs.getString(8));
			c1.setCust_Country(rs.getString(9));
			c1.setZip(rs.getInt(10));
			c1.setPhone(rs.getInt(11));
			c1.setEmail(rs.getString(12));
			c1.setLast_updated(rs.getDate(13));
			
			return c1;
		}
		return null;
	}
	
	public Customer modifyCustomer(int ssn, HashMap<Integer, String>newKeyValuePair) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {

		try {
		myconnection();
		ps = connection.prepareStatement(myQueries.modifyCustomer);
		}
		catch (Exception e) {
		}
		Customer c2 = new Customer();
		try {
			ps.setString(1, newKeyValuePair.get(1));
			ps.setString(2, newKeyValuePair.get(2));
			ps.setString(3, newKeyValuePair.get(3));
			ps.setInt(4, Integer.parseInt(newKeyValuePair.get(6))); // 4th and 5th can't be updated
			ps.setString(5, newKeyValuePair.get(7));
			ps.setString(6, newKeyValuePair.get(8));
			ps.setString(7, newKeyValuePair.get(9));
			ps.setString(8, newKeyValuePair.get(10));
			ps.setString(9, newKeyValuePair.get(11));
			ps.setString(10, newKeyValuePair.get(12));
			ps.setString(11, newKeyValuePair.get(13));
			ps.setInt(12, ssn);
		}
		catch (Exception ec) {
			{
			System.out.println("Error" + ec.getStackTrace());
			System.out.println(ec.getMessage());
		    }
		return c2;
		
	}
		
		ps = connection.prepareStatement(myQueries.CustomerDetails);
		ps.setInt(1, ssn);
		rs = ps.executeQuery();
		try {	
		//Customer c1 = new Customer();
		if(rs.next()){
			c2.setFirst_Name(rs.getString(1));
			c2.setLast_Name(rs.getString(2));
			c2.setCredit_card_NO(rs.getString(3));
			c2.setApt_No(rs.getInt(4));
			c2.setStreet_Name(rs.getString(5));
			c2.setCust_City(rs.getString(6));
			c2.setCust_state(rs.getString(7));
			c2.setCust_Country(rs.getString(8));
			c2.setZip(rs.getInt(9));
			c2.setPhone(rs.getInt(10));
			c2.setEmail(rs.getString(11));
			c2.setLast_updated(rs.getDate(12));
		}
	}
	catch (Exception ec) {
		System.out.println(ec.getMessage());
	}	
		return c2;
	}
		 
	
					// Question 3
	public ArrayList<Customer> getCustomerMonthlyBill(String Credit_Card_NO, int Month, int Year) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {{
		ArrayList<Customer> CustomerMonthlyBill = new ArrayList<Customer>();

			myconnection();

			ps = connection.prepareStatement(myQueries.CustomerMonthlyBill);
			ps.setString(1, Credit_Card_NO);
			ps.setInt(2, Month);
			ps.setInt(3, Year);
			rs = ps.executeQuery();
		
			
			while(rs.next()) {
			Customer c1 = new Customer();
			c1.setFirst_Name(rs.getString(1));
			c1.setLast_Name(rs.getString(2));
			c1.setStreet_Name(rs.getString(3));
			//c1.setCredit_card_NO(rs.getString(3));
			c1.setApt_No(rs.getInt(4));
			
			c1.setCust_City(rs.getString(5));
			c1.setZip(rs.getInt(6));
			c1.setCust_state(rs.getString(7));
			c1.setEmail(rs.getString(8));	
			c1.setPhone(rs.getInt(9));
			c1.setBranch_Code(rs.getString(10));	
			c1.setTransaction_Type(rs.getString(11));
			c1.setTransaction_value(rs.getDouble(12));
			CustomerMonthlyBill.add(c1);
		   }
			return CustomerMonthlyBill ;

		}
	}
	
	// functional requirements 4
	 public ArrayList<Customer> getCustTransByTwoDates(int SSN, String FromDate, String ToDate)throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException{
		 ArrayList<Customer> customerList = new ArrayList<Customer>();	
		 
		 myconnection();
		 ps = connection.prepareStatement(myQueries.CustTransByTwoDates);
         ps.setInt(1, SSN);
         ps.setString(2, FromDate);
         ps.setString(3, ToDate);
      		 
         rs = ps.executeQuery();
         
         int counter = 0;
         while(rs.next()) {
//        	 rs.next();
        	 
        	 Customer c1 = new Customer();
        	 c1.setFirst_Name(rs.getString(1));
        	 c1.setLast_Name(rs.getString(2));
//        	 c1.setTransaction_ID(rs.getDouble(3));
//        	 c1.setDay(rs.getInt(4));
//        	 c1.setMonth(rs.getInt(5));
//        	 c1.setYear(rs.getInt(6));
//        	 c1.setCredit_card_NO(rs.getString(7));
//        	 c1.setSsn(rs.getInt(8));
//        	 c1.setBranch_Code(rs.getString(9));
        	 c1.setTransaction_Type(rs.getString(3));
        	// System.out.println(rs.getString(4));
        	 c1.setTransaction_value(rs.getDouble(4));
        	// System.out.println(rs.getDouble(6));
        	 customerList.add(c1);
//        	 System.out.println("Record : " + c1.toString() + " added");
//        	 System.out.println("Record number: " + counter + " added");

         }
         rs.close();
         
         for ( Customer customer: customerList) {
        	 System.out.println(customer.getFirst_Name());
        	 System.out.println(customer.getLast_Name());
        	 System.out.println(customer.getTransaction_Type());
        	 System.out.println(customer.getTransaction_value());
         }
         return customerList;
       }
	
	}
	
