<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<style type="text/css">
body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
	margin-top: 25px;
	padding: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background-color: #fff;
	padding: 20px 40px;
	border-radius: 10px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	max-width: 400px;
	width: 100%;
}

h2 {
	text-align: center;
	color: #333;
	margin-bottom: 20px;
}

label {
	display: block;
	margin-bottom: 8px;
	font-weight: bold;
	color: #555;
}

input[type="text"], input[type="email"], input[type="password"], input[type="date"],
	select {
	width: 100%;
	padding: 10px;
	margin-bottom: 15px;
	border: 1px solid #ccc;
	border-radius: 5px;
	font-size: 16px;
}

input[type="submit"] {
	width: 100%;
	padding: 10px;
	background-color: #1E90FF;
	border: none;
	border-radius: 5px;
	font-size: 18px;
	color: #fff;
	cursor: pointer;
	transition: background-color 0.3s;
}

input[type="submit"]:hover {
	background-color: #FF4500;
}
</style>
</head>
<body>

	<div class="container">
		<h2>Add User</h2>
		<form action="add-candidates.jsp" method="post">
			<label for="name">Candidate Name</label> <input type="text" id="name"
				name="name" required> <label for="partyname">Party
				Name</label> <input type="text" id="partyname" name="party" required>
			<input type="submit" value="Add-User" />
		</form>
	</div>

</body>
</html>