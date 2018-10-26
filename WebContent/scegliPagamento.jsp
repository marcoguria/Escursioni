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

	<% Collection<CartaPagamento> cartePagamento = (Collection<CartaPagamento>) request.getAttribute("cartePagamento"); %>


	<h1>PAGA CON:</h1>


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

				<td>
					<label class="container"><input type="checkbox"
						   checked="checked"><span class="checkmark"></span> 
					</label>
				</td>
				<td><%= cartaPagamento.getTipo() %></td>
				<td><%= cartaPagamento.getNumero_carta() %></td>
				<td><%= cartaPagamento.getCvv() %></td>

			</tr>

			<%
				}
		}
			%>
		</tbody>
	</table>
</body>
</html>