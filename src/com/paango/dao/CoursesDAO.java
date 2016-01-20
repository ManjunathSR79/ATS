package com.paango.dao;
  
 
 
import java.sql.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import javax.servlet.annotation.WebServlet;
@WebServlet("/CoursesDAO")
public class CoursesDAO
{
	 
	public 	String projectDescription="";
	public String projectName="";
	public String projectMail="";
	public String projectDate="";
	public String projectId;
	
	
	
	
	public String getProjectId() {
		return projectId;
		} 
	public void setProjectId(String id) {
		this.projectId = id;
		}
	 
public String getProjectDescription() {
return projectDescription;
} 
public void setProjectDescription(String courseDescription) {
this.projectDescription = courseDescription;
}
public String getProjectName() {
return projectName;
}
public void setProjectName(String projectName) {
this.projectName = projectName;
} 
public String getProjectMail() {
return projectMail;
} 
public void setProjectMail(String mail) {
this.projectMail = mail;
} 
public String getProjectDate() {
return projectDate;
} 
public void setProjectDate(String date) {
this.projectDate = date;
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
    
    
	  String q="INSERT INTO projects VALUES( ?,?,?,?,?)";
	  statement = c.prepareStatement(q);
	 
      statement.setString(1, projectId);
	   statement.setString(2, projectName);
	   statement.setString(3, projectDescription);
	   statement.setString(4, projectMail);
	 
	   java.util.Date date = new SimpleDateFormat("dd-mm-yyyy").parse(projectDate);
	   java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	   
	  statement.setDate(5, sqlDate);
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
	 
  	String s1="select count(*) from projects where pid="+projectId;
	 
	 
	
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
	
