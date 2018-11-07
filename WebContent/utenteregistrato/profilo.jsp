<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="GET" action="LogoutServlet">
		<input type="submit" value="Logout" />
	</form>
	<form method="GET" action="home.jsp">
		<input type="submit" value="Home" />
	</form>

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