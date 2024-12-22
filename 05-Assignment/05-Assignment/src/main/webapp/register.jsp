<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration Form</title>
<link rel="stylesheet" href="register.css">
</head>
<body>

	<div class="container">
		<p style="color: red; font-family: sans-serif; font-size: 18px; text-align: center;">${param.msg}</p>

		<h2>Registration Form</h2>
		<form action="handle-register.jsp" method="post">
			<label for="firstname">First Name</label> <input type="text"
				id="firstname" name="firstName" required> <label
				for="lastname">Last Name</label> <input type="text" id="lastname"
				name="lastName" required> <label for="email">Email</label> <input
				type="email" id="email" name="email" required> <label
				for="password">Password</label> <input type="password" id="password"
				name="password" required> <label for="dob">Date of
				Birth</label> <input type="date" id="dob" name="birth" required> <label
				for="usertype">Select Type</label> <select id="usertype" name="role"
				required>
				<option value="">-- Select --</option>
				<option value="admin">Admin</option>
				<option value="user">User</option>
			</select> <input type="submit" value="Register">
		</form>
	</div>

</body>
</html>
