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
<h1>Delete cnad</h1>
<jsp:useBean id="dcb" class="com.sunbeam.beans.DeleteCandBean"/>
	<jsp:setProperty name="dcb" property="id" param="id" />
	${dcb.deleteCand()}
	
	
	<c:choose>
		<c:when test="${dcb.count == 1}">
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Delete Successfully." />
			</jsp:forward>
		</c:when>
		<c:otherwise>
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Delete Failed." />
			</jsp:forward>		
		</c:otherwise>
	</c:choose>
</body>
</html>