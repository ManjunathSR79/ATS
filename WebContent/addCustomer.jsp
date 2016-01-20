<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html> 
<head >
<title>AddCourse</title>
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


<h1> Customer ID<span>*</span>:</h1>
<input  type="text" name="cid"   required>

  <br>
  
<h1> Full Name<span>*</span>:</h1>
<input  type="text" name="cname"  required>

  <br>

<h1>Email<span>*</span>:</h1>
<input  type="text" name="cmail"  required>
  <br>
<h1>Phone<span>*</span>:</h1>
 <input  type="text" name="cphone"  required>
  
  
  <br>
<h1>Title<span>*</span>:</h1>
 <input  type="text" name="ctitle"  required>
  
   <br>
<h1>Company<span>*</span>:</h1>
 <input  type="text" name="ccompany"  required>
  
   <br>
<h1>Notes<span>*</span>:</h1>
 <input  type="text" name="cnotes"  required>
  
   <br>
<h1>Picture URL<span>*</span>:</h1>
 <input  type="text" name="cpicture"  required>
  
   <br>
<h1>Linkedin profile<span>*</span>:</h1>
 <input  type="text" name="clinkedin"  required>
  
   <br>
<h1>Facebook Profile<span>*</span>:</h1>
 <input  type="text" name="cfacebook"  required>
  
   <br>
<h1>Twitter profile<span>*</span>:</h1>
 <input  type="text" name="ctwitter"  required>
  
 <br>
 
 <input type="hidden" name="type" value="customers">
 <input type="submit" value="Add Course">
   </form>
 




 
		
 </body>
 </html>
 