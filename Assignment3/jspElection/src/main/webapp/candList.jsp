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
<h1>Welcome ${log.user.firstName} </h1>
<h2>Candidate List:</h2>

<jsp:useBean id="cd" class="com.sunbeam.beans.ResultBean"/>
${cd.getCandList()}


<form action="vote.jsp" method="post">

	<c:forEach var="c" items="${cd.candidates}">
	
		<input type="radio" name="cand" value="${c.id}"/> ${c.name} - ${c.party}
	</c:forEach>

<input type="submit" value="Vote"/>
</form>
</body>
</html>