<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<%@include file="file_setup.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<link rel="stylesheet" type="text/css" href="../css/style2.css">
</head>
<body>
	<header>
	<div class="header">
		<h1>Budgeting</h1>
		<nav> <a href="main-page">Main Page</a> <a href="register">Register</a>
		</nav>
	</div>
	</header>
	<div class="maindiv">
		<div class="login">
			<div class="logo">
				<img src="../images/login.jpg">
			</div>
			<div class="registerheader">
				<h3 style="font-size: 20px;">USER LOGIN</h3>
			</div>
			<form:form action="save" method="post" modelAttribute="command">
				<label>Email: </label>
				<br>
				<form:input type="email" path="email" placeholder="Email" />
				<br>
				<form:errors path="email" class="errors" /> <br>

				<label>Password: </label>
				<br>
				<form:input type="password" path="password" placeholder="Password" />
				<br>
				<form:errors path="password" class="errors" /> <br>
				<!-- <label><a href="#">Forgot Password?</a></label>
				<br> -->
				<input id="button" type="submit" value="SIGN IN"
					style="margin: 15px;">
				<br>
				<label id="register">Don't Have an Account? <br> <a
					href="register">Register</a></label>
			</form:form>
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>