<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<title>Login Form Design | CodeLab</title>
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<div class="wrapper" style="margin-bottom: 200px;">
		<div class="title">Login Form</div>
		<form action=" <%=request.getContextPath()%>/login" method="post">
			<div class="field">
				<input type="text" name="email" required> <label>Email
					Address</label>
			</div>
			<div class="field">
				<input type="password" name="password" required> <label>Password</label>
			</div>

			<div class="field">
				<input type="submit" value="Login">
			</div>
			<div class="signup-link">
				Not a member? <a href="registration.jsp">Signup now</a>
			</div>
		</form>
	</div>
</body>
</html>