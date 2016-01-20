<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ page import="java.sql.*" %>
<html>
<head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
 body
 {

 background-color:skyblue 
 }
</style>
 </head> 
 <body> 
 
 
 
 <%
 String username=request.getParameter("uname");
 String password=request.getParameter("pass"); 
 int i=0;
 Connection c=null;
 Statement s=null;
 ResultSet rs=null;
 try
  {
	 Class.forName("com.mysql.jdbc.Driver");
	 String url="jdbc:mysql://localhost:3306/paango";
	  String user = "root";
	  String psword = "123";
	
	   c=DriverManager.getConnection(url,user,psword);
	s =c.createStatement();
	 String s1="select * from login WHERE uname='" + username+"' AND password='"+password+"'" ;
	 rs=s.executeQuery(s1);
	 while(rs.next())
	 {
		 
   
 
 String pword=rs.getString("password") ;
 String uname=rs.getString("uname") ;
 
 if((username.equals(uname) && password.equals(pword)))
 { 
	 i=1;
	// session.setAttribute("username",username); 
	 response.sendRedirect("mainPage.jsp"); 
	 return;
 }   
 %>
     S
     <%
 }
	 
	 if(i==0)
	 {
		 
 %>
 
 Invalid User name or password  
     
     <a  href="login.jsp "> Try Again </a>
     <%
      
  }
	 
  }
 catch(Exception e)
 {
	 e.printStackTrace();
 } 
 finally
 {
	 rs.close();
	 s.close();
	 c.close();
	 
 }
 
   %> 
 
 
	 </body>
 
</html>