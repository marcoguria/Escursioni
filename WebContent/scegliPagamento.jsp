<%@page import="it.ats.modello.Escursione"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Collection<CartaPagamento> cartePagamento = (Collection<CartaPagamento>) request.getAttribute("cartePagamento");
	%>
	<%
		Escursione escursione = (Escursione) request.getAttribute("escursione");
	%>

	<%
		if (escursione == null) {
	%>

	<p>Non esiste questa escursione in archivio</p>

	<%
		} else {
	%>

<h1>RIEPILOGO ESCURSIONE</h1>
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
						
					</td> 
			</tr>
		</tbody>
	</table>

			<%
				}
			%>

	<h2>PAGA CON:</h2>


	<%
		if (cartePagamento == null || cartePagamento.isEmpty()) {
	%>

	<p>Non è stato inserito nessun metodo di pagamamento</p>

	<%
		} else {
	%>
	<table>
		<thead>
			<tr>
				<th></th>
				<th>TIPO</th>
				<th>NUMERO</th>
				<th>CVV</th>

			</tr>
		</thead>

		<tbody>
			<%
				for (CartaPagamento cartaPagamento : cartePagamento) {
			%>

			<tr>

				<td><label class="container"><input type="checkbox"
						checked="checked"><span class="checkmark"></span> </label></td>
				<td><%=cartaPagamento.getTipo()%></td>
				<td><%=cartaPagamento.getNumero_carta()%></td>
				<td><%=cartaPagamento.getCvv()%></td>

			</tr>

			<%
				}
				}
			%>
		</tbody>
	</table>
</body>
</html>