<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestisci sito</title>
</head>
<body>
	<form method="POST" action="../utenteregistrato/profilo.jsp">
		<input type="submit" value="Profilo" />
	</form>

	<form method="POST" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>
	
	<form method="POST" action="gestisciEscursioni.jsp">
		<input type="submit" value="Gestisci Escursioni" />
	</form>
	
	<form method="POST" action="ReportEscursioniServlet">
		<input type="submit" value="Report Escursioni" />
	</form>

	<form method="POST" action="gestisciClienti.jsp">
		<input type="submit" value="Gestisci Clienti" />
	</form>


</body>
</html>