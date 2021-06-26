<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>
<%@include file="file_setup.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<link rel="stylesheet" type="text/css" href="../css/style4.css">
</head>
<body>
	<header>
		<div class="header">
			<h1>Budgeting</h1>
			<%@include file="navigation.jsp"%>
		</div>
	</header>
	<div class="maindiv">
		<h2>New Expense</h2>
		<div class="form">
			<form:form action="add-transaction" method="post"
				modelAttribute="transaction">
				<label>Category</label>
				<form:select value="category" path="category.categoryName"
					class="forminput">
					<c:forEach items="${listExpenseCategory}" var="expenseCategory">
						<option>${expenseCategory.categoryName}</option>
					</c:forEach>
				</form:select>
				<br>
				<label>Description</label>
				<form:input type="text" path="description"
					placeholder="Enter a description of your expense" class="forminput" />
				<form:errors path="description" />
				<br>
				<label>Date</label>
				<form:input type="date" path="dateOfTransaction" class="forminput" />
				<br>
				<form:errors path="dateOfTransaction" />
				<label>Amount</label>
				<form:input type="number" step="0.01" path="amount" class="forminput" />
				<br>
				<form:errors path="amount" />
				<input type="submit" value="ADD EXPENSE" id="button">
			</form:form>
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>