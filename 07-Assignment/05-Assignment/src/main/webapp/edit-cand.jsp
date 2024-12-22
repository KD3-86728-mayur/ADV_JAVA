<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang='en'>


<head>

<meta charset='UTF-8'>

<meta name='viewport' content='width=device-width, initial-scale=1.0'>
<title>Update Candidate Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f9f9f9;
	margin: 0;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.form-container {
	background-color: #ffffff;
	border: 1px solid #ddd;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
	padding: 20px 30px;
	max-width: 400px;
	width: 100%;
}

h2 {
	margin-bottom: 20px;
	color: #333;
	text-align: center;
}

form {
	display: flex;
	flex-direction: column;
}

input[type="text"], input[type="hidden"] {
	width: 100%;
	padding: 10px;
	margin: 5px 0 15px;
	border: 1px solid #ccc;
	border-radius: 4px;
	font-size: 14px;
	box-sizing: border-box;
}

input[type="text"]:focus {
	border-color: #007bff;
	outline: none;
	box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
}

input[readonly] {
	background-color: #f5f5f5;
	cursor: not-allowed;
}

input[type="submit"] {
	background-color: #007bff;
	color: white;
	border: none;
	padding: 10px;
	font-size: 16px;
	border-radius: 4px;
	cursor: pointer;
	transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
	background-color: #0056b3;
}

@media ( max-width : 480px) {
	.form-container {
		padding: 15px;
	}
}
</style>

</head>


<body>


	<div class='form-container'>

		<h2>Update Candidate Details</h2>
		<jsp:useBean id="fcb" class="com.java.beans.FindCandidateBean" />
		<jsp:setProperty name="fcb" property="candId" param="id" />
		${fcb.findCandidate()}
		<form method="post" action="update-cand.jsp">
			<input type="hidden" name="id" value="${fcb.cand.id}" /> Name: <input
				type="text" name="name" value="${fcb.cand.name}" /> <br /> Party:
			<input type="text" name="party" value="${fcb.cand.party}" /> <br />
			Votes: <input type="text" name="votes" readonly="readonly"
				value="${fcb.cand.votes}" /> <br /> <input type="submit"
				value="Update" />
		</form>
	</div>
</body>


</html>