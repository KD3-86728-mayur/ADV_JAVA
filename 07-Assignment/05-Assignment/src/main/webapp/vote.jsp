<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vote</title>
<style type="text/css">
/* General body styling */
body {
	font-family: Arial, sans-serif;
	margin: 0;
	padding: 0;
	background-color: #f5f5f5;
	color: #333;
	display: flex;
	justify-content: center;
	align-items: center;
	min-height: 100vh;
}

/* Container for the voting section */
.container {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 8px;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
	max-width: 500px;
	text-align: center;
	width: 90%;
}

/* Header styling */
.container h2 {
	font-size: 24px;
	color: #4caf50;
	margin-bottom: 20px;
}

/* Paragraph styling */
.container p {
	font-size: 16px;
	line-height: 1.6;
	margin: 10px 0;
}

/* Link styling */
.container a {
	display: inline-block;
	text-decoration: none;
	color: #fff;
	background-color: #007bff;
	padding: 10px 15px;
	border-radius: 4px;
	font-size: 14px;
	transition: background-color 0.3s ease;
	margin-top: 20px;
}

.container a:hover {
	background-color: #0056b3;
}

/* Add subtle animation */
@
keyframes fadeIn {from { opacity:0;
	transform: translateY(10px);
}

to {
	opacity: 1;
	transform: translateY(0);
}

}
.container {
	animation: fadeIn 0.5s ease-in-out;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Voting Status</h2>
		<jsp:useBean id="vb" class="com.java.beans.VoteBean" />
		<jsp:setProperty name="vb" property="candId" param="candidate" />
		<jsp:setProperty name="vb" property="userId" value="${lb.user.id}" />

		<c:choose>
			<c:when test="${lb.user.status == 0}">
                ${vb.doVote()}
                <c:choose>
					<c:when test="${vb.success}">
						<p>You have successfully voted.</p>
                        ${lb.user.setStatus(1)}
                    </c:when>
					<c:otherwise>
						<p>Your voting attempt failed.</p>
					</c:otherwise>
				</c:choose>
			</c:when>
			<c:otherwise>
				<p>You have already voted.</p>
			</c:otherwise>
		</c:choose>
		<p>
			<a href="logout.jsp">Sign Out</a>
		</p>
	</div>
</body>

</html>