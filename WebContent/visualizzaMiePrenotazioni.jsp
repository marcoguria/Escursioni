<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="it.ats.modello.Prenotazione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Elenco prenotazioni</h1>

	<%
		Collection<Prenotazione> prenotazioni = (Collection<Prenotazione>) request.getAttribute("prenotazioni");
	%>

	<%
		if (prenotazioni == null || prenotazioni.isEmpty()) {
	%>

	<p>Non esistono prenotazioni in archivio</p>

	<%
		} else {
	%>

	<table>
		<thead>
			<tr>
				<th>DATA PRENOTAZIONE</th>
				<th>LUOGO</th>
				<th>TIPO</th>
				<th>DATA ESCURSIONE</th>
				<th>DURATA</th>
				<th>DIFFICOLTA'</th>
				<th>PREZZO</th>
				<th>GUIDA</th>
				
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%
				for (Prenotazione prenotazione : prenotazioni) {
					//Bisogna stampare tutte le info provenienti dalla join fatta nella servlet
			%>
			
			<tr>
				<td><%=prenotazione.getData_prenotazione()%></td>
				<td><%=prenotazione.getEscursione().getLuogo()%></td>
				<td><%=escursione.getTipo()%></td>
				<td><%=escursione.getData()%></td>
				<td><%=escursione.getDurata()%></td>
				<td><%=escursione.getDifficolta()%></td>
				<td><%=escursione.getPrezzo()%></td>
				<td><%=escursione.getGuida()%></td>
				<td><%=escursione.getMaxPartecipanti()%></td>
				<td><%=escursione.getNumPrenotati()%></td>
				<td>
						<form method="POST" action="FindByIdEscursioneServlet">
							<input type="hidden" name="idEscursione" value="<%= escursione.getId() %>"/>
							<input type="submit" value="Prenota"/>
						</form>
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