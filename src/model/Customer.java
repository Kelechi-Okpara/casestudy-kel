package model;

import java.sql.*;

public class Customer {
		
	public String First_Name, Middle_Name, Last_Name, Street_Name, Cust_City, Cust_state, Branch_Code, Cust_Country,Transaction_Type, Cust_Email, Credit_card_NO;
	public int ssn, Apt_No, zipCode, phone, Day, Month, Year; 
	public Double Transaction_value, Transaction_ID;
	public Date last_updated;
	public Timestamp timestamp;
	

	public int getDay() {
		return Day;
	}
	public void setDay(int day) {
		Day = day;
	}
	public int getMonth() {
		return Month;
	}
	public void setMonth(int month) {
		Month = month;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getFirst_Name() {
		return First_Name;
	}
	public String getBranch_Code() {
		return Branch_Code;
	}
	public void setBranch_Code(String branch_Code) {
		Branch_Code = branch_Code;
	}
	public String getTransaction_Type() {
		return Transaction_Type;
	}
	public void setTransaction_Type(String transaction_Type) {
		Transaction_Type = transaction_Type;
	}
	public double getTransaction_value() {
		return Transaction_value;
	}
	public void setTransaction_value(double transaction_value) {
		Transaction_value = transaction_value;
	}
	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getMiddle_Name() {
		return Middle_Name;
	}
	public void setMiddle_Name(String middle_Name) {
		Middle_Name = middle_Name;
	}
	public String getLast_Name() {
		return Last_Name;
	}
	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}
	public String getStreet_Name() {
		return Street_Name;
	}
	public void setStreet_Name(String street_Name) {
		Street_Name = street_Name;
	}
	public String getCust_City() {
		return Cust_City;
	}
	public void setCust_City(String cust_City) {
		Cust_City = cust_City;
	}
	public String getCust_state() {
		return Cust_state;
	}
	public void setCust_state(String cust_state) {
		Cust_state = cust_state;
	}
	public String getCust_Country() {
		return Cust_Country;
	}
	public void setCust_Country(String cust_Country) {
		Cust_Country = cust_Country;
	}
	public String getCust_Email() {
		return Cust_Email;
	}
	public void setEmail(String Cust_Email) {
		this.Cust_Email = Cust_Email;
	}
	public String getCredit_card_NO() {
		return Credit_card_NO;
	}
	public void setCredit_card_NO(String credit_card_NO) {
		Credit_card_NO = credit_card_NO;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getApt_No() {
		return Apt_No;
	}
	public void setApt_No(int apt_No) {
		Apt_No = apt_No;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZip(int zipCode) {
		this.zipCode = zipCode;
	}
	public Double getTransaction_ID() {
		return Transaction_ID;
	}
	public void setTransaction_ID(Double transaction_ID) {
		Transaction_ID = transaction_ID;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public Date getLast_updated() {
		return last_updated;
	}
	public void setLast_updated(Date last_updated) {
		this.last_updated = last_updated;
	}

	
}
