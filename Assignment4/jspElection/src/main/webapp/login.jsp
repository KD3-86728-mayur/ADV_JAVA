<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="log" class="com.sunbeam.beans.loginBean" scope="session" />

	<jsp:setProperty property="email" name="log" param="email" />
	<jsp:setProperty property="password" name="log" param="password" />

	${log.validateUaer()}

	<c:choose>
		<c:when test="${log.user != null}">
			<c:choose>
				<c:when test="${log.user.role == 'admin'}">
					<c:redirect url="result.jsp" />

				</c:when>
				<c:otherwise>
					
					<c:redirect url="candList.jsp" />
				</c:otherwise>
			</c:choose>

		</c:when>
		<c:otherwise>
			<h1>Login failed</h1>
			<p>
				<a href="index.jsp">Login Again</a>
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>