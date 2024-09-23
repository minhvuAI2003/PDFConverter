<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<!-- Coding By CodingNepal - codingnepalweb.com -->
<html lang="en" dir="ltr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Registration or Sign Up form in HTML CSS | CodingLab</title>
<link rel="stylesheet" href="style.css">
</head>
<body style="flex-direction: column;">

	<div class="wrapper">
		<h2>Registration</h2>

		<form name="myForm" action="<%=request.getContextPath()%>/register"
			onsubmit="return validateForm()">

			<div class="input-box">
				<input type="text" placeholder="Enter your username" name="username"
					required>
			</div>
			<div class="input-box">
				<input type="text" placeholder="Enter your email" name="email"
					required>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Create password" name="password"
					required>
			</div>
			<div class="input-box">
				<input type="password" placeholder="Confirm password"
					name="re-password" required>
			</div>

			<div class="input-box button">
				<input type="Submit" value="Register Now">
			</div>
			<div class="text">
				<h3>
					Already have an account? <a href="login.jsp">Login now</a>
				</h3>
			</div>
		</form>
	</div>
</body>
<script>
	function validateForm() {
		let x = document.forms["myForm"]["password"].value;
		let y = document.forms["myForm"]["re-password"].value;
		let z = document.forms["myForm"]["email"].value;
		let w = document.forms["myForm"]["username"].value;
		if (x !== y) {
			alert("Password must be the same!!!");
			document.forms["myForm"]["password"].value = "";
			document.forms["myForm"]["re-password"].value = "";
			document.forms["myForm"]["email"].value = "";
			document.forms["myForm"]["username"].value = "";
			return false;
		}
	}
</script>

</html>