<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
<style type="text/css">
/* General Body Styling */
body {
    font-family: Arial, sans-serif;
    background-color: #f0f2f5;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

/* Centered Container */
.form-container {
    background-color: #ffffff;
    border-radius: 10px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
    padding: 30px;
    width: 350px;
    text-align: center;
}

/* Header Styling */
h2 {
    color: #333333;
    margin-bottom: 20px;
    font-size: 24px;
    border-bottom: 2px solid #007bff;
    display: inline-block;
    padding-bottom: 5px;
}

/* Radio Buttons and Labels */
input[type="radio"] {
    margin-right: 10px;
}

label {
    font-size: 16px;
    color: #555555;
}

/* Submit Button Styling */
input[type="submit"] {
    background-color: #007bff;
    color: #ffffff;
    border: none;
    border-radius: 5px;
    padding: 10px 20px;
    font-size: 16px;
    cursor: pointer;
    margin-top: 20px;
    width: 100%;
    transition: background-color 0.3s ease;
}

input[type="submit"]:hover {
    background-color: #0056b3;
}

/* Extra Spacing Between Radio Options */
.candidate-list {
    margin-top: 20px;
    text-align: left;
}

</style>
</head>

<body>
	<div class="form-container">
    <h2>Candidate List</h2>
    <jsp:useBean id="clb" class="com.java.beans.CandidateBean"/>
	${clb.getAllCandidate()}
    <form method="post" action="vote.jsp">
        <div class="candidate-list">
            <c:forEach var="c" items="${clb.candidates}">
                <label>
                    <input type="radio" name="candidate" value="${c.id}" />
                    ${c.name} - ${c.party}
                </label><br/>
            </c:forEach>
        </div>
        <input type="submit" value="Vote"/>
    </form>
</div>
</body>
</html>