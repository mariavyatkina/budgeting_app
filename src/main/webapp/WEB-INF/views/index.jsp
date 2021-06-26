<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Budgeting</title>
<%@include file="file_setup.jsp"%>

<style>
nav {
	margin-right: 10px;
	text-align: right;
}

nav a {
	color: ghostwhite;
	font-size: 20px;
	text-decoration: none;
}

nav a:hover {
	color: white;
}

header {
	background-color: #3c8c30;
	font-size: 2em;
	text-align: center;
	margin-bottom: 20px;
	padding-top: 40px;
}

header h1 {
	color: ghostwhite;
}

* {
	font-family: 'Montserrat', sans-serif;
	/*text-align: center;*/
}

h1, h4 {
	font-weight: 600;
	color: #3c8c30;
	text-align: center;
	margin: 10px;
}

.navigation {
	display: flex;
	margin: 20px 5px;
}

.navcontainer {
	color: #303030;
	border: #3c8c30 2px solid;
	border-radius: 10px;
	background-color: lightgreen;
	padding: 35px 10px;
	margin: 20px;
	text-align: center;
	font-size: 24px;
	flex: 1;
}

a {
	color: #303030;
}

.navcontainer a:hover {
	color: ghostwhite;
	text-decoration: none;
}

.suggest {
	text-align: center;
}

#button {
	background-color: #3c8c30;
	color: ghostwhite;
	font-weight: bold;
	border-radius: 10px;
	text-align: center;
	margin-bottom: 35px;
	margin-top: 20px;
	padding: 15px 40px;
}

#button:hover {
	background-color: #045a08;
}

.content {
	display: flex;
	vertical-align: middle;
	line-height: normal;
	text-align: center;
	color: #303030;
	margin: 50px;
}

.content p {
	flex: 1;
	margin: 10px;
	padding: 20px;
	line-height: normal;
	vertical-align: middle;
}

.content img {
	flex: 1;
	width: 30%;
	height: 20%;
	border: 5px solid #045a08;
}


.contact {
	flex: 1;
	padding: 15px;
}

.contact a:hover {
	color: #89d37d;
}

.forFun {
	color: #045a08;
	padding: 15px;
	margin: 10px;
}

button {
	background-color: #89d37d;
	border: 2px solid #045a08;
	padding: 5px;
	margin: 10px;
}

footer {
	background-color: #045a08;
	color: ghostwhite;
	text-align: center;
	padding: 25px 10px 10px 10px;
	font-style: italic;
}
</style>
</head>

<body>
	<header>
		<div class="header">
			<h1>Budgeting</h1>
			<nav>
				<a href="login/">Login</a> <a href="register/">Register</a>
			</nav>
		</div>
	</header>
	<div class="maindiv">
		<div class="welcome">
			<h1>
				Welcome to Budgeting!<br> Everything is Fine.
			</h1>
		</div>
		<div class="navigation">
			<div class="navcontainer">
				<a href="#mission"> Mission </a>
			</div>


			<div class="navcontainer">
				<a href="#services"> Services </a>
			</div>


			<div class="navcontainer">
				<a href="#about"> About </a>
			</div>


			<div class="navcontainer">
				<a href="#contact"> Contact Us </a>
			</div>

		</div>
		<div class="suggest">
			<h4>Already Have an Account with Us?</h4>
			<a href="login/"><input type="submit" value="SIGN IN" id="button"></a>
			<a href="register/"><input type="submit" value="REGISTER"
				id="button"></a>
		</div>
		<div class="section" id="mission">
			<h1>Our Mission</h1>
			<div class="content">
				<p>Budgeting creates a spending plan for your money and can help
					ensure there is always enough money to pay for food, bills, and
					other expenses. Having a budget is a good tool to avoid credit card
					debt and promotes saving.<br><br>
				
					With <strong style="color: #045a08;">Budgeting</strong> you will  
					gain control over your money, plan and save for retirement, focus on financial goals 
					and prevent unnecessary debt.
					<br><br>
					Budgeting can sound like a chore, but you may be surprised 
					how powerful controlling your money will feel and how much stress is removed from your life.
					</p>

				<img src="images/mission.jpg">
			</div>
		</div>
		<div class="section" id="services">
			<h1>Services</h1>
			<div class="content">
				<img src="images/account.jpg">
				<p><strong style="color: #045a08;">Budgeting</strong> is a powerful tool for effective management of your 
				personal finances.<br><br> Keeping track of your monthly transactions has never been more accessible. <br><br>
				<strong style="color: #045a08;">Budgeting</strong> provides the snapshot of your spending and investments, 
				which allows you to manage your finances with confidence and ease.</p>
			</div>
		</div>
		<div class="section " id="about">
			<h1>About</h1>
			<div class="content ">
				<p><strong style="color: #045a08;">Budgeting</strong> is the first full-stack application<br> built by Java developer <em style="color: darkgreen">Maria Vyatkina</em></p>
				<img src="images/creator3.jpg">
			</div>
		</div>
		<div class="section " id="contact">
			<h1>Contact Us</h1>
			<div class="content ">

				<div class="contact">
					<strong><a href="mailto:mar.vtkn@gmail.com ">mar.vtkn@gmail.com</a>
					</strong>
				</div>
				<div class="contact">
					<strong><a
						href="https://www.linkedin.com/in/maria-vyatkina/ ">LinkedIn</a> </strong>
				</div>
				<div class="contact">
					<strong><a href="https://github.com/mariavyatkina ">GitHub</a>
					</strong>
				</div>
			</div>
			<!--                 <div class="forFun">
                    <h1>For Fun</h1>
                    <button onclick="changeColor()">Change color of paragraphs</button>
                </div> -->
		</div>
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>