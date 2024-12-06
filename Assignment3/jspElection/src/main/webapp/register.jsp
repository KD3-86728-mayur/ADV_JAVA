<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="regis" class="com.sunbeam.beans.registrationBean"/>
	<jsp:setProperty property="firstName" name="regis" param="fname"/>
	<jsp:setProperty property="lastName" name="regis" param="lname"/>
	<jsp:setProperty property="email" name="regis" param="email"/>
	<jsp:setProperty property="password" name="regis" param="password"/>
	<jsp:setProperty property="birth" name="regis" param="dob"/>
	
	${regis.saveInDb()}
	
	<c:choose>
		<c:when test="${regis.count == 1}">
			<h1>Registration successful</h1>
			<p><a href="index.jsp">Login</a></p>
		</c:when>
		<c:otherwise>
			<h1>Registration failed</h1>
			<p><a href="newUser.jsp">Register Again</a></p>
		</c:otherwise>
	</c:choose>
</body>
</html>