<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">

	<h1>Register User</h1>
	
	<form method="post" action="register.jsp" >
	
		First Name : <input type="text" name="fname"/><br/><br/>
		Last Name : <input type="text" name="lname"/><br/><br/>
		Email : <input type="text" name="email"/><br/><br/>
		Password : <input type="password" name="password"/><br/><br/>
		DOB : <input type="date" name="dob"/><br/><br/>
		<input type="submit" value="Register"/>
	</form>
</div>
</body>
</html>