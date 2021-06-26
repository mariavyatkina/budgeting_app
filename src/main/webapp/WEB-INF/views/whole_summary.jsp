<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Transactions</title>
<%@include file="file_setup.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<link rel="stylesheet" type="text/css" href="../css/style3.css">
</head>
<body>
	<header>
		<div class="header">
			<h1>Budgeting</h1>
			<%@include file="navigation.jsp"%>
		</div>
	</header>
	<div class="maindiv">
		<h3>All Transactions</h3>
		<div class="summaries" style="display: block;">
			<table class="tablesummary" style="margin: 20px auto; width: 70%;">
				<thead>
					<tr>
						<td colspan="4">Expenses</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Date</td>
						<td>Description</td>
						<td>Amount</td>
						<td>Category</td>
					</tr>
					<c:forEach items="${expenses}" var="expenses">
						<tr>
							<td>${expenses[0]}</td>
							<td>${expenses[1]}</td>
							<td>$ ${expenses[2]}</td>
							<td>${expenses[3]}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table class="tablesummary" style="margin: 20px auto; width: 70%;">
				<thead>
					<tr>
						<td colspan="4">Income</td>
					</tr>
				</thead>
				<tbody>
				<tr>
						<td>Date</td>
						<td>Description</td>
						<td>Amount</td>
						<td>Category</td>
					</tr>
					<c:forEach items="${income}" var="income">
						<tr>
							<td>${income[0]}</td>
							<td>${income[1]}</td>
							<td>$ ${income[2]}</td>
							<td>${income[3]}</td>
						</tr>
					</c:forEach>
			</table>
			<table class="tablesummary" style="margin: 20px auto; width: 70%;">
				<thead>
					<tr>
						<td colspan="4">Investments</td>
					</tr>
				</thead>
				<tbody>
				<tr>
						<td>Date</td>
						<td>Description</td>
						<td>Amount</td>
						<td>Category</td>
					</tr>
				<c:forEach items="${investments}" var="investments">
					<tr>
						<td>${investments[0]}</td>
						<td>${investments[1]}</td>
						<td>$ ${investments[2]}</td>
						<td>${investments[3]}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>