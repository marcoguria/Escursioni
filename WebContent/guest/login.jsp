<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/loginCss.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Login</title>
</head>


<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h2>Login</h2>
					<p>Please enter your username and password</p>
				</div>

				<form id="Login" method="POST" action="LoginServlet">

					<div class="form-group">


						<input type="text" name="username" class="form-control"
							id="inputEmail" placeholder="Username">

					</div>

					<div class="form-group">

						<input type="password" name="password" class="form-control"
							id="inputPassword" placeholder="Password">

					</div>


					<button type="submit" class="btn btn-primary">Login</button>
			</div>
			</form>
		</div>

	</div>
	</div>
	</div>
</html>