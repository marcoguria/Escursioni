<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>gestisci escursione</title>
</head>
<body >

	<form method="POST" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>

	<form method="POST" action="../utenteregistrato/profilo.jsp">
		<input type="submit" value="Profilo" />
	</form>

	

	<form method="POST" action="inserisciEscursione.jsp">
		<input type="submit" value="Inserisci nuova escursione" />
	</form>
	
		<form method="POST" action="AbiltaDisabilitaEscursioneServlet">
		<input type="submit" value="Abilita/Disabilita Escursione" />
	</form>
</body>
</html>