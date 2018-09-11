package model;

public class Transaction {
	private int Day, Month, Count, Year,Cust_SSN, Branch_Zip;
	private double TransactionValue;
	private long Transaction_Id;
	private String Branch_Code, Credit_Card_NO, Branch_Name, Branch_City, Branch_State, Transaction_Type;

	
	public int getBranch_Zip() {
		return Branch_Zip;
	}
	public void setBranch_Zip(int branch_Zip) {
		Branch_Zip = branch_Zip;
	}
	public String getBranch_Name() {
		return Branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}
	public String getBranch_City() {
		return Branch_City;
	}
	public void setBranch_City(String branch_City) {
		Branch_City = branch_City;
	}
	public String getBranch_State() {
		return Branch_State;
	}
	public void setBranch_State(String branch_State) {
		Branch_State = branch_State;
	}	
		public double getTransactionValue() {
			return TransactionValue;
		}
		public int getDay( ) {
			return Day;
		}
		public int getMonth() {
			return Month;
		}
		public int getCust_SSN() {
			return Cust_SSN;
		}
		public int getCount() {
			return Count;
		}
		public String getCredit_Card_NO() {
			return Credit_Card_NO;
		}
		public long getTransaction_Id() {
			return Transaction_Id;
		}
		public String getBranch_Code() {
			return Branch_Code;
		}
		public String getTransaction_Type() {
			return Transaction_Type;
		}
		public int getYear() {
			return Year;
		}
		public void setCount(int Count) {
			this.Count = Count;	
		}
		public void setYear(int Year) {
			this.Year = Year;
		}
		public void setTransaction_Type(String Transaction_Type) {
			this.Transaction_Type = Transaction_Type;
		}
		public void setBranch_Code(String Branch_Code) {
			this.Branch_Code = Branch_Code;
		}
		public void setTransaction_Id(long Transaction_Id) {
			this.Transaction_Id = Transaction_Id;	
		}
		public void setCredit_Card_NO(String Credit_Card_NO) {
			this.Credit_Card_NO = Credit_Card_NO;
		}
		public void setCust_SSN(int Cust_SSN) {
			this.Cust_SSN = Cust_SSN;
		}
		public void setDay(int Day) {
			this.Day = Day;
		}
		public void setMonth(int Month) {
			this.Month = Month;
		}
		public void setTransactionValue(double TransactionValue) {
			this.TransactionValue = TransactionValue;
		}
//		public void setCount(int int1) {
//			
//		}
		
}
	
	

