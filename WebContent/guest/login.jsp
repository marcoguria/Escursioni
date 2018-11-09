<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/loginCss.css">
<title>Insert title here</title>
</head>
<body>
<div id="login">

<div class="row">

  <div class="col-lg-12" align="center" id="panel">
  
	<form method="POST" action="LoginServlet">

		Username: <input type="text" name="username" /> <br><br>
		Password: <input type="password" name="password" /> <br><br>
		
		<input type="submit" value="Login" />

	</form>
	<br>
	<a href="registrazione.jsp">Clicca qui per registrarti</a>
	<br>
	</div>
	
	</div>
		</div>
	




</body>
</html>