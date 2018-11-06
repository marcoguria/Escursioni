<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.Escursione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Abilita/Disabilita Escursione</title>
</head>
<body>
	<h1>Elenco Escursioni</h1>

	<%
		Collection<Escursione> escursioni = (Collection<Escursione>) request.getAttribute("escursioni");
	%>

	<%
		if (escursioni == null || escursioni.isEmpty()) {
	%>

	<p>Non esistono escursioni in archivio</p>

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
			<%
				for (Escursione escursione : escursioni) {
			%>

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
					<%
						if (escursione.getDisponibile() == 0){
					%>
					<form method="POST" action="AbilitaEscursioneServlet">
						<input type="hidden" name="idEscursione"
							value="<%=escursione.getId()%>" /> <input type="submit"
							value="Abilita" />
					</form> 
					<%
						}
					%>
					
<%
 	if (escursione.getDisponibile() == 1){
 		
 %>	
					<form method="POST" action="DisabilitaEscursioneServlet">
						<input type="hidden" name="idEscursione" value="<%=escursione.getId()%>" /> 
						<input type="submit" value="Disabilita" />
					</form>
				</td>
			</tr>
			<%
				}
			%>

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