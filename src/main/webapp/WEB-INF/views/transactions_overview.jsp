<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transactions for ${categoryType}</title>
<%@include file="file_setup.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<link rel="stylesheet" type="text/css" href="../css/style5.css">
</head>
<body>
	<header>
		<div class="header">
			<h1>Budgeting</h1>
			<%@include file="navigation.jsp"%>
		</div>
	</header>
	<div class="maindiv">
		<h2>Transactions for ${categoryType}</h2>
		<table>
			<thead>
				<tr>
					<td>Date</td>
					<td>Description</td>
					<td>Amount</td>
					<td></td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${transactions}" var="transaction">
					<tr>
						<td>${transaction[0]}</td>
						<td>${transaction[1]}</td>
						<td>${transaction[2]}</td>
						<td><a href="edit?id=${transaction[3]}">Edit</a>&nbsp;&nbsp;&nbsp;
							<a href="delete?id=${transaction[3]}">Delete</a></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>