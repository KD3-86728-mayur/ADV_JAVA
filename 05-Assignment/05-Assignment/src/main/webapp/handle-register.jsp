<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Handle registration page.</title>
</head>
<body>
	<div style="text-align: center;">

		<p>
			<jsp:useBean id="rb" class="com.java.beans.RegisterBeans" />
			<jsp:setProperty name="rb" property="*" />

			${rb.register()}
			<!-- calling register method  -->

			<c:choose>
				<c:when test="${rb.userStatus == true }">
					<jsp:forward page="login.jsp">
						<jsp:param name="msg" value="Registration completed..." />
					</jsp:forward>
				</c:when>
				<c:otherwise>
					<jsp:forward page="register.jsp">
						<jsp:param name="msg" value="Something went wrong...Please register again.." />
					</jsp:forward>
				</c:otherwise>
			</c:choose>
		</p>
	</div>

</body>
</html>