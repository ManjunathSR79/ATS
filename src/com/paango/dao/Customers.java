package com.paango.dao;
  
 

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.sql.*;
import java.sql.Connection;

import javax.servlet.annotation.WebServlet;



@WebServlet("/Customers")
public class Customers
{
	 
	public 	String cId="";
	public String cName="";
	public String cMail="";
	public String cPhone;
	public String cTitle="";
	public String cCompany="";
	public String cNotes="";
	public String cPicture="";
	public String cLinkedin="";
	public String cFacebook="";
	public String cTwitter="";
	
	
	
	
	
	public String getId() {
		return cId;
		} 
	public void setId(String id) {
		this.cId = id;
		}
	 
 
public String getName() {
return cName;
}
public void setName(String cName) {
this.cName = cName;
} 
public String getMail() {
return cMail;
} 
public void setMail(String mail) {
this.cMail = mail;
} 
public String getPhone() {
return cPhone;
} 
public void setPhone(String phone) {
this.cPhone = phone;
} 
public String getTitle () {
return cTitle ;
} 
public void setTitle (String title ) {
this.cTitle =  title;
} 
public String getCompany () {
return  cCompany;
} 
public void setCompany (String company  ) {
this.cCompany =company  ;
} 
public String getNotes() {
return  cNotes;
} 
public void setNotes (String notes  ) {
this.cNotes =notes  ;
} 
public String getPicture () {
return  cPicture;
} 
public void setPicture (String picture  ) {
this.cPicture =  picture;
} 

public String getLinkedin() {
return  cLinkedin;
} 
public void setLinkedin(String linkedin ) {
this.cLinkedin =  linkedin;
} 
public String getFacebook () {
return  cFacebook;
} 
public void setFacebook (String facebook  ) {
this.cFacebook =  facebook;
} 
public String getTwitter () {
return  cTwitter;
} 
public void setTwitter (String twitter  ) {
this.cTwitter =twitter  ;
} 
public void insert(String url) throws MalformedURLException, IOException,
ProtocolException {
	 
	 final String user = "root";
	 final String psword = "123";
			 
Connection c=null; 
PreparedStatement statement=null;

 try {
	 System.out.println(""+cId);

	 try
	 {
		 Class.forName("com.mysql.jdbc.Driver");       
	 }
	 catch(Exception e)
	 {
		
		
	 }
     c=DriverManager.getConnection(url,user,psword);
    
    // System.out.println("DATE    "+ (java.sql.Date) d);
     //System.out.println("DATE    "+  projectDate );
	  String q="INSERT INTO customers VALUES( ?,?,?,?,?,?,?,?,?,?,?)";
	  statement = c.prepareStatement(q);
	 
      statement.setString(1,cId );
	   statement.setString(2, cName);
	   statement.setString(3, cMail);
	   statement.setString(4, cPhone );
	   statement.setString(5, cTitle);
	   statement.setString(6, cCompany);
	   statement.setString(7, cNotes);
	   statement.setString(8, cPicture);
	   statement.setString(9, cLinkedin);
	   statement.setString(10, cFacebook);
	   statement.setString(11,cTwitter );
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
	 
  	String s1="select count(*) from customers where cid="+cId;
	 
	 
	
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
	
