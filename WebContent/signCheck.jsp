<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import ="java.sql.*" %>
<head><style type="text/css">
 body
 {

 background-color:skyblue 
 }
</style>
</head>
<body>
<%
    String uname = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
     
    String mobile = request.getParameter("mob");
 
    
    
    
    
    
    
    
    
    
    	 final String user = "root";
		 final String psword = "123";
    
    
    Connection c=null; 
	PreparedStatement statement=null;
	 try {
		 
		 Class.forName("com.mysql.jdbc.Driver");
		   
	     c=DriverManager.getConnection("jdbc:mysql://localhost:3306/paango?autoReconnect=true",user,psword);
	     
		  String q="INSERT INTO login values(?,?,?)";
		  statement = c.prepareStatement(q);
		    
		   statement.setString(1, uname);
		   statement.setString(2, pwd);
		   statement.setString(3, mobile);
		    
		  
		   int row = statement.executeUpdate();
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
		   if (row > 0) 
			 {
        response.sendRedirect("index.jsp");
     } else {
        response.sendRedirect("login.jsp");
    }
	 }  
		   catch(Exception e)
			 {
			   
			  %>
			  <h2>User Name is already exist please change the user name</h2><a href="signUp.jsp">signUp Here</a></td>
			  <%
				 
				
			 }
			 finally
			 {
				 try {
					statement.close();
				
					c.close();
				} catch (SQLException e) {
			 
					e.printStackTrace();
				}
			 }
			 
%>

</body>
