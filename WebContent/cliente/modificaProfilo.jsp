<%@page import="it.ats.modello.UtenteRegistrato"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		UtenteRegistrato utenteRegistrato = (UtenteRegistrato) request.getAttribute("utente");
	%>

	<form method="GET" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>
	<br>

	<form method="POST" action="../cliente/UpdateUtenteRegistratoServlet">
		Nome: <input type="text" name="nome"
			value="<%=utenteRegistrato.getNome()%>" placeholder="nome"> <br>
		Cognome: <input type="text" name="cognome"
			value="<%=utenteRegistrato.getCognome()%>" placeholder="cognome">
		<br> 
		CodFiscale: <input type="text" name="codf"
			value="<%=utenteRegistrato.getCodf()%>" placeholder="codice fiscale">
		<br>
		 Email: <input type="email" name="email"
			value="<%=utenteRegistrato.getEmail()%>" placeholder="email">
		<br> 
		DataNascita: <input type="date" name="dataNascita"
			value="<%=utenteRegistrato.getData_nascita()%>"
			placeholder="dataNascita"> <br> Username: <input
			type="text" name="username"
			value="<%=utenteRegistrato.getUsername()%>" placeholder="username"
			min="1920-01-01" max="2000-01-01" required>
		<br> 
		Password: <input type="password" name="password" value="">
		<br> 
		ConfermaPassword: <input type="password"
			name="confermaPassword" value=""> <br>

		<%
			if (true) {

			}
		%>

		<input type=submit value="Salva"> <input type=reset
			value="Reset">

	</form>




</body>
</html>