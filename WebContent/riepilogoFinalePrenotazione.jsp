<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="it.ats.modello.Escursione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Escursioni in sardegna</title>
</head>
<body>
	<%
		Escursione escursione = (Escursione) request.getAttribute("escursione");
		CartaPagamento cartaPagamento = (CartaPagamento) request.getAttribute("carta");

		if (escursione == null || cartaPagamento == null) {
	%>

	<p>Non esiste questa escursione in archivio</p>

	<%
		} else {
	%>


	<h2>RIEPILOGO ESCURSIONE</h2>
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
				<td></td>
			</tr>
		</tbody>
	</table>


	<h2>RIEPILOGO CARTA</h2>

	<%=cartaPagamento.getTipo()%>
	<%=cartaPagamento.getNumero_carta()%>

	<%
		}
	%>

</body>
</html>