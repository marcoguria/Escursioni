<%@page import="it.ats.modello.UtenteRegistrato"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.*"%>
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
		Map<String, String> map = (Map) request.getAttribute("mappaErrori");
	%>
	
	

	<form method="GET" action="home.jsp">
		<input type="submit" value="Home" />
	</form>
	<br>

	<form method="POST" action="UpdateUtenteRegistratoServlet">
		Nome: <input type="text" name="nome" value="<%=utenteRegistrato.getNome()%>" placeholder="nome">
		<%
		if (map != null && map.containsKey("nome")) {
		%>
		<p><%=map.get("nome")%></p>
		<%
			}
		%> <br>
		Cognome: <input type="text" name="cognome" value="<%=utenteRegistrato.getCognome()%>" placeholder="cognome">
		<%
		if (map != null && map.containsKey("cognome")) {
		%>
		<p><%=map.get("cognome")%></p>
		<%
			}
		%>
		<br> 
		CodFiscale: <input type="text" name="codf"
			value="<%=utenteRegistrato.getCodf()%>" placeholder="codice fiscale">
			<%
			if (map != null && map.containsKey("codf")) {
		%>
		<p><%=map.get("codf")%></p>
		<%
			}
		%>
		<br>
		 Email: <input type="email" name="email" value="<%=utenteRegistrato.getEmail()%>" placeholder="email">
		<%
		if (map != null && map.containsKey("email")) {
		%>
		<p><%=map.get("email")%></p>
		<%
			}
		%>
		<br> 
		DataNascita: <input type="date" name="dataNascita"
			value="<%=utenteRegistrato.getData_nascita()%>"
			placeholder="dataNascita"> <br> 
			
		Username: <input
		type="text" name="username"
		value="<%=utenteRegistrato.getUsername()%>" placeholder="username"
		min="1920-01-01" max="2000-01-01" readonly>
		<%
		if (map != null && map.containsKey("username")) {
		%>
		<p><%=map.get("username")%></p>
		<%
			}
		%>
		<br> 
		Password: <input type="password" name="password" value="">
		
		<%
			if (map != null && map.containsKey("password")) {
		%>
		<p><%=map.get("password")%></p>
		<%
			}
		%>
		<br> 
		ConfermaPassword: <input type="password"
			name="conferma" value=""> 
		
		<%
		if (map != null && map.containsKey("conferma")) {
		%>
		<p><%=map.get("conferma")%></p>
		<%
			}
		%><br>

		<%
			if (true) {

			}
		%>
		<input type="hidden" name="contesto" value="modificaProfilo">
		<input type=submit value="Salva"> <input type=reset
			value="Reset">

	</form>




</body>
</html>