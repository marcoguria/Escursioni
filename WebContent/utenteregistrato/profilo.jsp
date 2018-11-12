<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/profilo.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Profile</title>
</head>
<body>

           

<nav class="navbar navbar-inverse">
  <div class="container">
  <form method="GET" action="home.jsp">
 	 <div class="btn-group" role="group"><button class="" type="submit">Home</button></div>
	</form>
	
	<form method="GET" action="LogoutServlet">
		 <div class="btn-group" role="group"><button class="" type="submit">Logout</button></div>
	</form>
	
	</div>
	
</nav>
	

	<%
		if ((int) request.getSession().getAttribute("ruolo") == 1) {
	%>

	<form method="POST" action="../cliente/VisualizzaMiePrenotazioniServlet">
		<input type="submit" value="Visualizza mie prenotazioni" />
	</form>
	
	<form method="POST" action="../cliente/VisualizzaCarteDaEliminareServlet">
		<input type="submit" value="Le mie carte" />
	</form>


	<%
		}
	%>


	<form method="POST" action="GetMyProfileServlet">
		<input type="submit" value="Modifica Profilo" />
	</form>

	
	


</body>
</html>