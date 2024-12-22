<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="dcb" class="com.java.beans.deleteCandidate" />
<jsp:setProperty name="dcb" property="candId" param="id" />
${dcb.deleteCand() }
<jsp:forward page="result.jsp">
	<jsp:param value="deleted successfully" name="msg"/>
</jsp:forward>
</body>
</html>