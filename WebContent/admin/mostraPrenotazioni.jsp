<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="it.ats.modello.Prenotazione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		if (request.getSession().getAttribute("ruolo") != null) {
	%>
	<form method="POST" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>

	<%
		}
	%>


	<h1>Elenco Prenotati</h1>

	<%
		Collection<Prenotazione> prenotazioni = (Collection<Prenotazione>) request.getAttribute("prenotazioni");
	%>

	<table>
		<thead>
			<tr>
				<th>DATA</th>
				<th>NOME</th>
				<th>COGNOME</th>
				<th>EMAIL</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Prenotazione prenotazione : prenotazioni) {
			%>

			<tr>
				<td><%=prenotazione.getData_prenotazione()%></td>
				<td><%=prenotazione.getUtenteRegistrato().getNome()%></td>
				<td><%=prenotazione.getUtenteRegistrato().getCognome()%></td>
				<td><%=prenotazione.getUtenteRegistrato().getEmail()%></td>
				
				<%
					}
				%>
		</tbody>
	</table>

</body>
</html>