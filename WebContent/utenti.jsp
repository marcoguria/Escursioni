<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.ats.modello.UtenteRegistrato"%>
    <%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostra Utenti</title>
</head>
<body>
<h1>Elenco Utenti</h1>

	<%
		Collection<UtenteRegistrato> utenti = (Collection<UtenteRegistrato>) request.getAttribute("utenti");
	%>

	<%
		if (utenti == null || utenti.isEmpty()) {
	%>

	<p>Non esistono utenti in archivio</p>

	<%
		} else {
	%>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>NOME</th>
				<th>COGNOME</th>
				<th>CODF</th>
				<th>EMAIL</th>
				<th>DATA NASCITA</th>
				<th>RUOLO</th>
				<th>USERNAME</th>

				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (UtenteRegistrato utenteRegistrato : utenti) {
			%>

			<tr>
				<td><%=utenteRegistrato.getID() %></td>
				<td><%=utenteRegistrato.getNome()%></td>
				<td><%=utenteRegistrato.getCognome()%></td>
				<td><%=utenteRegistrato.getCodf()%></td>
				<td><%=utenteRegistrato.getEmail()%></td>
				<td><%=utenteRegistrato.getData_nascita()%></td>
				<td><%=utenteRegistrato.getFlag_ruolo()%></td>
				<td><%=utenteRegistrato.getUsername()%></td>

				
			</tr>

			<%
				}
			%>
		</tbody>
	</table>

	<%
		}
	%>
	
	


</body>
</html>