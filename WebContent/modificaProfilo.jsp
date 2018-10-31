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

	<form method="POST" action="UpdateUtenteRegistratoServlet">
		Nome: <input type="text" name="nome"
			value="<%=utenteRegistrato.getNome()%>" placeholder="nome"> <br>
		Cognome: <input type="text" name="cognome"
			value="<%=utenteRegistrato.getCognome()%>" placeholder="cognome">
		<br>
		 CodFiscale: <input type="text" name="codf"
			value="<%=utenteRegistrato.getCodf()%>" placeholder="codice fiscale">
		<br>
		 Email: <input type="text" name="email"
			value="<%=utenteRegistrato.getEmail()%>" placeholder="email">
		<br> 
		DataNascita: <input type="date" name="dataNascita"
			value="<%=utenteRegistrato.getData_nascita()%>" placeholder="dataNascita">  <br>
		Username: <input type="text" name="username"
			value="<%=utenteRegistrato.getUsername()%>" placeholder="username">
		<br>
		 Password: <input type="password" name="password" value="">
		<br>
		 ConfermaPassword: <input type="password"
			name="confermaPassword" value=""> <br>

		<%
			if (true) {

			}
		%>

		<input type=submit value="Salva">
		<input type=reset value="Reset"> 

	</form>

	


</body>
</html>