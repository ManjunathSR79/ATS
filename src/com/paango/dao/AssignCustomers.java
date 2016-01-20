package com.paango.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.annotation.WebServlet;

@WebServlet("/AssignCustomers")
public class AssignCustomers {
public String pId;
	
	
public String cId;




public String getPId() {
	return pId;
	} 
public void setPId(String id) {
	this.pId = id;
	}
	
	public String getCId() {
		return cId;
		} 
	public void setCId(String id) {
		this.cId = id;
		}
	

public void insert(String url) throws MalformedURLException, IOException,
ProtocolException {
	 
	 final String user = "root";
	 final String psword = "123";
			 
Connection c=null; 
PreparedStatement statement=null;
 
 try {
	 
	  
	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");       
	 }
	 catch(Exception e)
	 {
 
		
	 }
     c=DriverManager.getConnection(url,user,psword);
    
    
	  String q="INSERT INTO assigncustomer VALUES( ?,?)";
	  statement = c.prepareStatement(q);
	 
      statement.setString(1, pId);
	   statement.setString(2, cId);
	    
	 
	   
	   int row = statement.executeUpdate();
	  
 
	  
 }
 catch(Exception e)
 {
	 System.out.println(" unable to connect "+e);
	
 }
 finally
 {
	 try {
		statement.close();
	
		c.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
 
		e.printStackTrace();
	}
 }
  
}

}
