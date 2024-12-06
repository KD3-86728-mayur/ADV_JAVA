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
	<h1>Vote</h1>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean" />
	<jsp:setProperty name="vb" property="candId" param="cand" />
	<jsp:setProperty name="vb" property="userId" value="${log.user.id}" />


	<c:choose>
		<c:when test="${log.user.status == 0}">
			${vb.vote()}
			<c:choose>
				<c:when test="${vb.success}">
					<p>Thank you, You have successfully voted.</p>
				</c:when>
				<c:otherwise>
					<p>Sorry, Your voting is failed.</p>
				</c:otherwise>
			</c:choose>
		</c:when>
		<c:otherwise>
			<p>You have already voted!</p>
		</c:otherwise>
	</c:choose>
	<a href="logout.jsp">Logout</a>
</body>
</html>