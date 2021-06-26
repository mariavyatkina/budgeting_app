<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account</title>
<%@include file="file_setup.jsp"%>
<link rel="stylesheet" type="text/css" href="../css/mainstyle.css">
<link rel="stylesheet" type="text/css" href="../css/style3.css">
</head>

<body>
	<header>
		<div class="header">
			<h1>Budgeting</h1>
			<nav>
				<a href="logout">Logout</a>
			</nav>
		</div>
	</header>
	<div class="maindiv">
		<div class="greeting">
			<h4>Hi ${command.firstName}!</h4>
		</div>
		<div class="summary">
			<h2 id="summaryOf">Summary of This Month</h2>
		</div>
		<div class="monthlysummary">
			<div class="summarycontainer">
				<h4>Expense Amount</h4>
				<h2 name="expenseAmount" class="amount">$ ${sumExpense}</h2>
				<a href="add-expense"><input type="submit" value="Add"
					id="button"></a>
			</div>
			<div class="summarycontainer">
				<h4>Income Amount</h4>
				<h2 name="incomeAmount" class="amount">$ ${sumIncome}</h2>
				<a href="add-income"><input type="submit" value="Add"
					id="button"></a>
			</div>
			<div class="summarycontainer">
				<h4>Investment Amount</h4>
				<h2 name="investmentAmount" class="amount">$ ${sumInvestment}</h2>
				<a href="add-investment"><input type="submit" value="Add"
					id="button"></a>
			</div>
		</div>
		<h3>Detailed Summary</h3>
		<div class="summaries">
			<table class="tablesummary">
				<thead>
					<tr>
						<td colspan="2">Expenses</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${categorySumExp}" var="expenses">
						<tr>
							<td><a
								href="transactions-overview?categoryType=${expenses[0]}">${expenses[0]}</a></td>
							<td>$ ${expenses[1]}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>Total</td>
						<td>$ ${sumExpense}</td>
					</tr>
				</tfoot>
			</table>
			<table class="tablesummary">
				<thead>
					<tr>
						<td colspan="2">Income</td>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${categorySumInc}" var="income">
						<tr>
							<td><a
								href="transactions-overview?categoryType=${income[0]}">${income[0]}</a></td>
							<td>$ ${income[1]}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>Total</td>
						<td>$ ${sumIncome}</td>
					</tr>
				</tfoot>
			</table>
			<table class="tablesummary">
				<thead>
					<tr>
						<td colspan="2">Investments</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${categorySumInv}" var="investments">
						<tr>
							<td><a
								href="transactions-overview?categoryType=${investments[0]}">${investments[0]}</a></td>
							<td>$ ${investments[1]}</td>
						</tr>
					</c:forEach>
				</tbody>
				<tfoot>
					<tr>
						<td>Total</td>
						<td>$ ${sumInvestment}</td>
					</tr>
				</tfoot>
			</table>
		</div>
		<a href="whole-summary">Show All Trasactions</a>
	</div>
	<%@include file="footer.jsp"%>

</body>
</html>