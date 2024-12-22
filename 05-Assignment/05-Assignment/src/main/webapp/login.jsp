<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <link rel="stylesheet" href="login.css">
</head>
<body>
<div class="msg">
</div>
    <div class="login-container">
    	<p style="color:red; font-family: sans-serif; font-size: 18px; text-align: center;">${param.msg}</p>
        <h2>Login</h2>
        <form action="handle-login.jsp" method="POST">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" placeholder="Enter your email" required>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password" placeholder="Enter your password" required>

            <input type="submit" type="Login" class="btn"/>
            <p>don't have account? <a href='register.jsp'>Register here</a></p>
            
        </form>
    </div>
</body>
</html>
