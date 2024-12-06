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

<jsp:useBean id="cd" class="com.sunbeam.beans.ResultBean"/>
${cd.getCandList()}


<h1>Candidate List</h1>
<table>
<thead>
<tr>
<td>Id</td>
<td>Name</td>
<td>Party</td>
<td>Votes</td>
<td>Action</td>
</tr>
</thead>
<tbody>
<c:forEach var="c" items="${cd.candidates}">

	<tr>
		<td>${c.id}</td>
		<td>${c.name}</td>
		<td>${c.party}</td>
		<td>${c.votes}</td>
		<td>
			<a href="editCand.jsp?id=${c.id}">Edit</a>
			<a href="deleteCand.jsp?id=${c.id}">Delete</a>
		</td>
	</tr>

</c:forEach>
</tbody>
</table>

<p>${param.msg}</p>
</body>
</html>