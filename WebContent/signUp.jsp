<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SignUp</title>
        
        <style type="text/css">
 body
 {

 background-color:skyblue 
 }
</style>

    </head>
    <body>
        <form method="post" action="signCheck.jsp">
            <center>
            <table border="1" width="30%" cellpadding="5">
               
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
               
               
                   
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td>Mobile No.</td>
                        <td><input type="text" name="mob" value="" /></td>
                    </tr>
                    
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                        
                    </tr>
                    <tr>
                        <td colspan="2">if you are having account  <a href="login.jsp">Login Here</a></td>
                    </tr>
               
            </table>
            </center>
        </form>
    </body>
</html>