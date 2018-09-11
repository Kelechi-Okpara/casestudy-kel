package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.fabric.xmlrpc.base.Value;

import model.Transaction;
import resources.myQueries;


public class TransactionDao extends dbconnection_abstract {
	// case study Question 1
public ArrayList<Transaction> getTransactionByZipcode(int Zipcode, int Month, int year) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		ArrayList<Transaction>Transaction = new ArrayList<Transaction>();
		
		try {
		myconnection();
		System.out.println("Connected");
		}
	    catch (Exception e) {
		    e.getStackTrace();
		}
		
		ps = connection.prepareStatement(myQueries.TransactionByZipcode);
		ps.setInt(1, Zipcode);
		ps.setInt(2, Month);
		ps.setInt(3, year);
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			Transaction t1 = new Transaction();
			
	    	t1.setTransaction_Id(rs.getLong(1));
	    	t1.setDay(rs.getInt(2));
	    	t1.setMonth(rs.getInt(3));
	    	t1.setYear(rs.getInt(4));
	    	t1.setCredit_Card_NO(rs.getString(5));
	    	t1.setCust_SSN(rs.getInt(6));
	    	t1.setBranch_Code(rs.getString(7));
	    	t1.setTransaction_Type(rs.getString(8));
	    	t1.setTransactionValue(rs.getDouble(9));
	    	Transaction.add(t1);	
			
	 } 
	 return Transaction;
	
}

	// case study Question 2
	public Transaction getTotalByType(String type) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		myconnection();
		
		ps = connection.prepareStatement(myQueries.TotalByType);
		ps.setString(1, type);
		rs = ps.executeQuery(); 
		Transaction t1 = new Transaction();
		
		if(rs.next()){
		 
			t1.setTransactionValue(rs.getDouble(3));
			t1.setCount(rs.getInt(2));
	 	}
	 return t1;
 	}
	
	// case study Question 3
	public Transaction getTotalValuesByTransactionByBranches(String state) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException, IOException {
		ArrayList<Transaction>Transaction = new ArrayList<Transaction>();
		myconnection();
		
		ps = connection.prepareStatement(myQueries.TotalValuesByTransactionByBranches);
		ps.setString(1, state);
		rs = ps.executeQuery(); 
		Transaction t1 = new Transaction();
		
		if(rs.next()){
			t1.setTransaction_Type(rs.getString(1));
			t1.setTransactionValue(rs.getDouble(3));
			t1.setCount(rs.getInt(2));
			t1.setBranch_Name(rs.getString(4));
			t1.setBranch_Code(rs.getString(5));
			t1.setBranch_Zip(rs.getInt(6));
			t1.setBranch_City(rs.getString(7));
			t1.setBranch_State(rs.getString(8));
	    	//Transaction.add(t1);	
	 	}
	 return t1;
 	}
}
