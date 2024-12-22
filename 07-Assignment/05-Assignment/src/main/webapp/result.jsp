<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>

<head>
<title>Result page</title>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	rel="stylesheet">


<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f2f5;
	display: flex;
	flex-direction: column;
	align-items: center;
	margin: 0;
	padding: 20px;
}

h2 {
	color: #333;
	margin-bottom: 20px;
}

table {
	width: 80%;
	border-collapse: collapse;
	margin-bottom: 20px;
	background-color: #fff;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
}

th, td {
	border: 1px solid #ddd;
	padding: 12px;
	text-align: center;
}

th {
	background-color: #007bff;
	color: white;
}

tr:nth-child(even) {
	background-color: #f9f9f9;
}

tr:hover {
	background-color: #f1f1f1;
}

p a {
	color: #007bff;
	text-decoration: none;
	font-weight: bold;
}

p a:hover {
	text-decoration: underline;
}
</style>
</head>

<body>
<p style="color:red; font-family: sans-serif; font-size: 18px; text-align: center;">${param.msg}</p>
        
<jsp:useBean id="rb" class="com.java.beans.ResultBean"/>
	${rb.fetchCandidates()}
	<h2>Voting Result</h2>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Party</th>
				<th>Votes</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${rb.candList}">
				<tr>
					<td>${c.id}</td>
					<td>${c.name}</td>
					<td>${c.party}</td>
					<td>${c.votes}</td>
					<td>
						<a href='delete-cand.jsp?id=${c.id }'><i class="fa-solid fa-trash fa-2x" style='color:red; margin-right: 15px;'></i> </a>
						<a href='edit-cand.jsp?id=${c.id }'><i class="fa-solid fa-pen-to-square fa-2x" style='color:green;'></i></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href='add-cand.jsp'>Add Candidate</a> <a href='logout.jsp'
			style="margin-left: 20px">Sign Out</a>
	</p>
	<p>
</body>

</html>