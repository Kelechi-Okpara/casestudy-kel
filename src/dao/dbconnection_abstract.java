package dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import java.sql.SQLException;
import java.util.ArrayList;


public abstract class dbconnection_abstract {
	public  Connection connection = null;
	    public  Statement st ;
	    public  ResultSet rs ;
	    public int newResultSet; 
	    public PreparedStatement ps;
	    protected void myconnection() throws  InstantiationException, IllegalAccessException, ClassNotFoundException, IOException, SQLException
	    {
	        // Step one
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	                //step 2
	                FileReader f = new FileReader("db.properties");
	                // will hold properties of f 
	                Properties properties = new Properties();
	                //p loads properties
	                properties.load(f);
	                // step 3
	                 connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
	                
	    }
	}

