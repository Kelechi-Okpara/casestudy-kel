package resources;

public class myQueries {
public final static String TransactionByZipcode  = "SELECT distinct  cdw_sapp_creditcard.*, First_name, Last_name "+
		" FROM cdw_sapp_creditcard " +
		" JOIN cdw_sapp_customer UsiNG (credit_card_NO) " +
		" WHERE Cust_Zip = ? and MONTH = ? and YEAR = ? " +
		" ORDER BY Day DESC ";

public final static String TotalByType = "SELECT distinct Transaction_Type, count(Transaction_Type) As '# Transactions', sum(Transaction_Value) FROM cdw_sapp_creditcard WHERE Transaction_Type = ? GROUP BY Transaction_Type;";


public final static String TotalValuesByTransactionByBranches = "SELECT distinct Transaction_Type, count(cr.Transaction_Type) 'Number of Transactions', sum(cr.Transaction_Value) 'Values of Transactions', "
        + " Branch_Name,BRANCH_CODE, Branch_ZIP, Branch_City, Branch_State " + 
		" FROM cdw_sapp_creditcard cr " +
		" JOIN cdw_sapp_branch br USING (Branch_Code) " +
		" WHERE Branch_State = ? " +
		" GROUP BY 1 ";
					

public final static String CustomerDetails = " SELECT FIRST_NAME, LAST_NAME, ssn, CREDIT_CARD_NO, APT_NO, "
		+ "STREET_NAME, CUST_CITY, CUST_STATE, CUST_COUNTRY, CUST_ZIP, CUST_PHONE, CUST_EMAIL, LAST_UPDATED "+
		" FROM cdw_sapp_customer " +
		" WHERE ssn = ? ";

public final static String modifyCustomer = " UPDATE cdw_sapp_customer set First_Name = ?, Middle_Name = ?, Last_Name = ?, Apt_NO = ?, "
        + " Street_Name = ?, Cust_City = ?, Cust_State = ?, Cust_Country = ?, Cut_Zip = ?, Cust_Phone = ?, Cust_Email = ? WHERE ssn = ? ";

//public final static String UpdateCustomerDetailsQ1 = " UPDATE cdw_sapp_customer set  =?=?WHERE ssn = ? ";
//public final static String UpdateCustomerDetailsQ2 = " = ? WHERE ssn = ? " ;

public final static String CustomerMonthlyBill = "SELECT First_Name, Last_Name, Street_Name, Apt_No, Cust_City, "
        +" Cust_zip, Cust_state, Cust_Email, Cust_phone, Branch_Code, Transaction_Type, Transaction_value "
		+" FROM cdw_sapp_creditcard cd "
		+" JOIN cdw_sapp_customer cr "
		+" ON cr.ssn = cd.Cust_SSN "
		+" WHERE cd.Credit_Card_NO = ? && cd.Month = ? && cd.Year = ? " ;

//public final static String CustTransByTwoDates = "SELECT Day, Month, Year, Credit_card_no, Branch_code, Transaction_Type, round(Transaction_value, 2) "
//        +" FROM (SELECT * "
//		+" FROM CDW_SAPP_CREDITCARD "
//        +" WHERE CAST(STR_TO_DATE(CONCAT(Year,'-',Month,'-',Day), '%Y-%m-%d') As Date) Between CAST(STR_TO_DATE(CONCAT( ? ,'-', ? ,'-', ? ), '%Y-%m-%d') "
//		+" As Date) AND CAST(STR_TO_DATE(CONCAT( ? ,'-', ? ,'-', ? ), '%Y-%m-%d') As Date)) t_range "       
//        +" WHERE t_range.cust_ssn = ? "
//        +" ORDER BY Year Desc, Month Desc, Day Desc " ;

public final static String CustTransByTwoDates = " SELECT First_Name, Last_Name, Transaction_Type, Transaction_value" +
		" FROM cdw_sapp_creditcard Q " + 
		" JOIN cdw_sapp_customer C " + 
		" ON Q.Cust_SSN = C.ssn " +
		" WHERE C.ssn = ? " +
		" AND CAST(STR_TO_DATE(CONCAT(Year,'-',Month,'-',Day), '%Y-%m-%d') As Date) " +
		" Between CAST(STR_TO_DATE(?, '%Y-%m-%d') As Date) " +
		" AND CAST(STR_TO_DATE(?, '%Y-%m-%d') As Date) " +
		" ORDER BY Year Desc, Month Desc, Day Desc" ;

	}






