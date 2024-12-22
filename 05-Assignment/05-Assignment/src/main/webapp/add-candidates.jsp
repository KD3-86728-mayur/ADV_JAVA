<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="acb" class="com.java.beans.AddCandidateBean" />
		<jsp:setProperty name="acb" property="*" />
	
	${acb.addCand()}
	
	<c:choose>
			<c:when test="${acb.count == 1 }">
				<jsp:forward page="result.jsp">
					<jsp:param name="msg" value="Candidate Added..." />
				</jsp:forward>
			</c:when>
			<c:otherwise>
				<jsp:forward page="register.jsp">
					<jsp:param name="msg"
						value="Something went wrong.." />
				</jsp:forward>
			</c:otherwise>
	</c:choose>
</body>
</html>