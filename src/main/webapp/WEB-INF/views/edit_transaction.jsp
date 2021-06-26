<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Transaction</title>
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
		<h2>Edit Transaction</h2>
		<div class="form">
			<form:form action="save-transaction" method="post"
				modelAttribute="transaction">
				<div class="hiddenProperties">
					<label class="forminput">Transaction Id:
						${transaction.transactionId}</label>
					<form:hidden path="transactionId" />
					<br> <label class="forminput">Date Added:
						${transaction.dateAdded}</label>
					<form:hidden path="dateAdded" />
					<br> <label class="forminput">Type:
						${transaction.category.categoryType} </label>
					<form:hidden path="category.categoryType" />
					<br>
				</div>
				<label>Category</label>
				<form:select path="category.categoryName" class="forminput">
					<option selected="selected">${transaction.category.categoryName}</option>
					<c:forEach items="${listCategoryNames}" var="categories">
						<option>${categories.categoryName}</option>
					</c:forEach>
				</form:select>
				<br>
				<label>Description</label>
				<form:input type="text" path="description"
					value="${transaction.description}" class="forminput" />
				<form:errors path="description" />
				<br>
				<label>Date</label>
				<form:input type="date" path="dateOfTransaction" class="forminput"
					value="${transaction.dateOfTransaction}" />
				<br>
				<label>Amount</label>
				<form:input type="number" step="0.01" path="amount" class="forminput"
					value="${transaction.amount}" />
				<br>
				<input type="submit" value="EDIT TRANSACTION" id="button">
			</form:form>
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>