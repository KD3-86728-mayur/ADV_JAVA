<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>
		<jsp:useBean id="lb" class="com.java.beans.LoginBeans" scope="session" />
		<jsp:setProperty name="lb" property="email" />
		<jsp:setProperty name="lb" property="password" />

		${lb.login()}
		<!-- calling register method  -->

		<c:choose>
			<c:when test="${lb.user != null }" >
			<c:choose>
				<c:when test="${lb.user.role == 'user'}">
					<jsp:forward page="candidate.jsp">
						<jsp:param name="msg" value="Login Success1..." />
					</jsp:forward>
				</c:when>
				<c:otherwise>
					<jsp:forward page="result.jsp">
						<jsp:param name="msg" value="Login Success..." />
					</jsp:forward>
				</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<jsp:forward page="register.jsp">
					<jsp:param name="msg" value="Login Failed..." />
				</jsp:forward>
			</c:otherwise>
		</c:choose>


	</p>

</body>
</html>