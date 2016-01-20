<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head >
<title>AddRequirement</title>
<style type="text/css" >
span
{
color:red;
}
 
 body
 {

 background-color:skyblue 
 }

</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <form    method="post" action="Courses" enctype="multipart/form-data">


<h1>Requirement Id<span>*</span>:</h1>
<input  type="text" name="rid" required>

  <br>
  
<h1>Requirement<span>*</span>:</h1>
<input  type="text" name="rreq"  required>

  <br>

<h1>Email<span>*</span>:</h1>
<input  type="text" name="rmail"  required>
 
 <br>
 
 
<h1>Created date<span>*</span>:</h1>
 <input  type="date" name="rdate"  required>
  
  
 
 <br>
 <input type="hidden" name="type" value="requirements">
 <input type="submit" value="Add Course">
   </form>
 




 
		
 </body>
 </html>
 