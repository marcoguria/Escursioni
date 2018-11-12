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


	<form method="POST" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>
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
				<th>STATO UTENTE</th>

				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (UtenteRegistrato utenteRegistrato : utenti) {
			%>

			<tr>
				<td><%=utenteRegistrato.getID()%></td>
				<td><%=utenteRegistrato.getNome()%></td>
				<td><%=utenteRegistrato.getCognome()%></td>
				<td><%=utenteRegistrato.getCodf()%></td>
				<td><%=utenteRegistrato.getEmail()%></td>
				<td><%=utenteRegistrato.getData_nascita()%></td>
				<td><%if(utenteRegistrato.getFlag_ruolo()==0){	
					out.println("AMMINISTRATORE");  %>
					<% }if(utenteRegistrato.getFlag_ruolo()==1){
						out.println("CLIENTE");
						}%></td>				
				<td><% if(utenteRegistrato.getAttivo()==0){	
					out.println("DISATTIVO");  %>
					<% }if(utenteRegistrato.getAttivo()==1){
						out.println("ATTIVO");
						} %>
				</td>
				<!-- srthrtshwrhthwt -->
				<td>
				
				<%if (utenteRegistrato.getFlag_ruolo()==1){ %>
				<% if(utenteRegistrato.getAttivo()==0){%>
					<form method="POST" action="SbloccaUtenteServlet">
						<input type="hidden" name="idCliente"
							value="<%=utenteRegistrato.getID()%>" /> <input type="submit"
							value="SBLOCCA" />
						</form>
					<% }if(utenteRegistrato.getAttivo()==1){%>
						<form method="POST" action="BloccaUtenteServlet">
						<input type="hidden" name="idCliente"
							value="<%=utenteRegistrato.getID()%>" /> <input type="submit"
							value="BLOCCA" />
						</form>
						<%} %>
						
						<%} %>
					
				</td>


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