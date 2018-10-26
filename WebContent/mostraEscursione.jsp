<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.Escursione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Escursioni Ajò in Sardegna</title>
</head>
<body>
	<h1>Mostra Escursione</h1>

	<%
		Escursione escursione = (Escursione) request.getAttribute("escursioni");
	%>

	<%
		if (escursione == null) {
	%>

	<p>Non esiste questa escursione in archivio</p>

	<%
		} else {
	%>

	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>LUOGO</th>
				<th>TIPO</th>
				<th>DATA ESCURSIONE</th>
				<th>DURATA</th>
				<th>DIFFICOLTA'</th>
				<th>PREZZO</th>
				<th>GUIDA</th>
				<th>MAX PARTECIPANTI</th>
				<th>NUM PRENOTATI</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			
			<tr>
				<td><%=escursione.getId()%></td>
				<td><%=escursione.getLuogo()%></td>
				<td><%=escursione.getTipo()%></td>
				<td><%=escursione.getData()%></td>
				<td><%=escursione.getDurata()%></td>
				<td><%=escursione.getDifficolta()%></td>
				<td><%=escursione.getPrezzo()%></td>
				<td><%=escursione.getGuida()%></td>
				<td><%=escursione.getMaxPartecipanti()%></td>
				<td><%=escursione.getNumPrenotati()%></td>
				<td>
						<form method="POST" action="FindCarteByIdSessioneServlet">
							<input type="hidden" name="idUtente" value="<%= session.getId() %>"/>
							<input type="submit" value="Prosegui"/>
						</form>
					</td> 
			</tr>

			<%
				}
			%>
		</tbody>
	</table>



</body>
</html>