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
<body>
<div id="login">

<div class="row">

  <div class="col-lg-12" align="center" id="panel">
  
	<form method="POST" action="LoginServlet">

		<div id="fontPanel"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Username <br><input type="text" name="username"/> </div> <br><br>
		<div id="fontPanel"><span class="glyphicon glyphicon-lock" aria-hidden="true"></span> Password <br> <input type="password" name="password" /> </div><br><br>
				
		<input type="submit" value="Login" class="btn btn-default" />

	</form>
	<br>
	<a href="registrazione.jsp">Clicca qui per registrarti</a>
	<br>
	</div>
	
	</div>
		</div>
	




</body>
</html>