<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.Collection"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Collection<CartaPagamento> cartePagamenti = (Collection<CartaPagamento>) request
				.getAttribute("cartePagamenti");
	%>
	<select id="carta" name="carta">
		<%
			for (CartaPagamento cartaPagamento : cartePagamenti) {
		%>


		<option value="<%=cartaPagamento.getId()%>"><%=cartaPagamento.getTipo()%>
			<%=cartaPagamento.getNumero_carta()%>
		</option>



		<%
			}
		%>
	</select>

	<form method="POST" action="EliminaCartaPagamentoServlet">
		<!-- DEvo dare come input la carta selezionata -->
		<input type="submit" value="ELIMINA CARTA" />
	</form>
</body>
</html>