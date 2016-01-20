package com.paango.dao;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Requirements")
public class Requirements {
	 
		 
		public String requirement="";
		public String rMail="";
		public String rDate="";
		public String rId;
		
		
		
		
		public String getRId() {
			return rId;
			} 
		public void setRId(String id) {
			this.rId= id;
			}
		 
	public String getRequirement() {
	return requirement;
	} 
	public void setRequirement(String requirement) {
	this.requirement = requirement;
	}
	
	public String getRMail() {
	return rMail;
	} 
	public void setRMail(String mail) {
	this.rMail = mail;
	} 
	public String getRDate() {
	return rDate;
	} 
	public void setRDate(String date) {
	this.rDate = date;
	} 


	public void insert(String url) throws MalformedURLException, IOException,
	ProtocolException {
		 
		 final String user = "root";
		 final String psword = "123";
				 
	Connection c=null; 
	PreparedStatement statement=null;

	 try {
		 System.out.println(""+rId);
		
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");       
		 }
		 catch(Exception e)
		 {
		
			
		 }
	     c=DriverManager.getConnection(url,user,psword);
	    
	   
		  String q="INSERT INTO requirements VALUES( ?,?,?,?)";
		  statement = c.prepareStatement(q);
		 
	      statement.setString(1, rId);
		   statement.setString(2, requirement);
		   
		   statement.setString(3, rMail);
		  
		   java.util.Date date = new SimpleDateFormat("dd-mm-yyyy").parse(rDate);
		   java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		   
		  statement.setDate(4, sqlDate);
		   statement.executeUpdate();
		  
		
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

	

public int check(String url) throws MalformedURLException, IOException,
ProtocolException {
 
	final String user = "root";
	 final String psword = "123";
			 
Connection c=null; 
Statement p = null;

	 
	 
try {
		Class.forName("com.mysql.jdbc.Driver");
	 
	 
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/paango?autoReconnect=true",user,psword);
		 
		  
		p=c.createStatement();
	 
  	String s1="select count(*) from requirements where rid="+rId;
	 
	 
	
			ResultSet rs=p.executeQuery(s1);
			 
			if (rs.next()) {
				if(rs.getInt(1)==0)
				{
	 
				return 1;
				
			} 
			else{
				 
				return 0;
			}
			}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


return 0;



}


}
