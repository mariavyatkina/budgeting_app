<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="file_setup.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<link rel="stylesheet" type="text/css" href="../css/style2.css">


</head>

<body>
<body>
	<header>
	<div class="header">
		<h1>Budgeting</h1>
		<nav> <a href="main-page">Main Page</a> <a href="login">Login</a>
		</nav>
	</div>
	</header>
	<div class="maindiv">
		<div class="login">
			<div class="logo">
				<img src="../images/login.jpg">
			</div>
			<div class="registerheader">
				<h3 style="font-size: 20px;">REGISTER</h3>
			</div>
			<form:form name="registerForm" action="save" method="post"
				sessionAttribute="user">
				<form:input type="text" path="firstName" placeholder="First Name" />
				<br>
				<form:errors path="firstName" class="errors"/>
				<form:input type="text" path="lastName" placeholder="Last Name" />
				<br>
				<form:errors path="lastName"  class="errors" />
				<form:input type="email" path="email" placeholder="Email" />
				<br>
				<form:errors path="email"  class="errors"/>
				<form:input type="password" path="password" placeholder="Password" />
				<br>
				<form:errors path="password"  class="errors"/>
				<a href="#"><input id="button" type="submit" value="REGISTER"
					style="margin: 15px;"><br></a>
				<label>Already Have an Account? <br> <a href="login">Sign
						In</a></label>
			</form:form>
		</div>
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>