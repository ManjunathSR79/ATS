<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.ResultSetMetaData" %>
<%@ page import="java.sql.Statement" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style type="text/css">
        body {
        padding-top: 40px;
        padding-bottom: 40px;
        background-color: #f5f5f5;
      }
       .form-signin {
        max-width: 300px;
        padding: 19px 29px 29px;
        margin: 0 auto 20px;
        background-color: #fff;
        border: 1px solid #e5e5e5;
        -webkit-border-radius: 5px;
           -moz-border-radius: 5px;
                border-radius: 5px;
        -webkit-box-shadow: 0 1px 2px rgba(0,0,0,.05);
           -moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
                box-shadow: 0 1px 2px rgba(0,0,0,.05);
      }
      .form-signin .form-signin-heading,
       {
        margin-bottom: 10px;
      }
      .form-signin input[type="text"],
      .form-signin input[type="password"] {
        font-size: 16px;
        height: auto;
        margin-bottom: 15px;
        padding: 7px 9px;
      }
 
</style>

    </head>
    <body>
    <form  class="form-signin" method="post" action="loginCheck.jsp"  >
    <center>
    <h2 class="form-signin-heading">Please sign in</h2>
               
                 
        User Name  <input type="text" class="input-block-level" name="uname" placeholder="Email address">
        
        
        Password   <input type="password" class="input-block-level" name="pass" placeholder="Password">
       
       <input type="submit" value="Login" /></td>
          <button class="btn btn-large btn-primary" type="submit">Sign in</button> 
          
           <p class="form-signin-heading"><a href="signUp.jsp">SignUp Here</a></p>
         
        
    </center>
   </form>
    <center>
   <form method="post" action="Courses" enctype="multipart/form-data">
            <input type="radio" name="rating" value="1" class="star">being not needed
            <input type="radio" name="rating" value="2" class="star">not needed
            <input type="radio" name="rating" value="3" class="star">needed
            <input type="radio" name="rating" value="4" class="star">must have
            <input type="radio" name="rating" value="5" class="star">being must have
             <input type="hidden" name="type" value="ratings">
            <input type="submit" value ="Rate it" style=background-color:skyblue >
        </form>
        
        <center>
        <%
 
 try
  {
	 Class.forName("com.mysql.jdbc.Driver");
	 String url="jdbc:mysql://localhost:3306/paango";
	  String user = "root";
	  String psword = "123";
	  Connection c=null;
	  Statement s=null;
	  ResultSet rs=null;
	   c=DriverManager.getConnection(url,user,psword);
	s =c.createStatement();
	 String s1="select count(*) from ratings where rate=5  ";
	 rs=s.executeQuery(s1);
	 if(rs.next())
	 {
	 %>
	<h3> 5 Stars          
		 <%=rs.getInt(1)%>
	 </h3>
	  
	 
	 
	 <%
	 }else{%>
		 <%=0 %>
		 <%}
	 
	 s1="select count(*) from ratings  where rate=4";
	 rs=s.executeQuery(s1);
	 if(rs.next())
	 {
	 %>
	<h3> 4 Stars          
	 <%=rs.getInt(1)%>
	  </h3>
	 
	 
	 <%
	 }else{%>
		 <%=0 %>
		 <%}
	 
	 
	 
	 
	 
	 
	  s1="select count(*) from ratings  where rate=3";
	 rs=s.executeQuery(s1);
	 if(rs.next())
	 {
	 %>
	<h3> 3 Stars           
	<%=rs.getInt(1)%>
	 </h3>
 
	 
	 
	 <%
	 }else{%>
		 <%=0 %>
		 <%}
	 
	 
	 
	 
	 s1="select count(*) from ratings  where rate=2";
	 rs=s.executeQuery(s1);
	 if(rs.next())
	 {
	 %>
	<h3> 2 Stars           
	 <%=rs.getInt(1)%>
	</h3>
	 
	 
	 <%
	 }else{%>
		 <%=0 %>
		 <%}
	 
	 
	 
	 
	 
	  s1="select count(*) from ratings  where rate=1";
	 rs=s.executeQuery(s1);
	 if(rs.next())
	 {
	 %>
	<h3> 1 Stars          
	 <%=rs.getInt(1)%>
	</h3>
	 
	 
	 <%
	 }else{%>
		 <%=0 %>
		 <%}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	  
	
	 rs.close();
	 s.close();
	 c.close();
	 %>
	 
 
 
<%
  }
 catch(Exception e)
 {
	 System.out.println("execute query  "+e);
 }
 finally
 {
	
	 
 }
 %>
   
   </center>
    </body>
</html>