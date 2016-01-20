package com.paango.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.swing.JOptionPane;

@WebServlet("/Ratings")
public class Ratings {
	
	public 	String rate;
	
	public String getRate() {
		return rate;
		} 
	public void setRate(String rate) {
		this.rate=rate ;
		}
	
	
	public void insert(String url) throws MalformedURLException, IOException,
	ProtocolException {
		// JOptionPane.showMessageDialog(null, "I am happy.");
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
	    
	    
		  String q="INSERT INTO ratings VALUES( ?)";
		  statement = c.prepareStatement(q);
		 
	      statement.setString(1,rate );
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

	}