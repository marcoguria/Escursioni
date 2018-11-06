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


	<form method="POST" action="EliminaCartaServlet">
		<select id="carta" name="numero_carta">
			<%
				for (CartaPagamento cartaPagamento : cartePagamenti) {
			%>


			<option value="<%=cartaPagamento.getNumero_carta()%>"><%=cartaPagamento.getTipo()%>
				<%=cartaPagamento.getNumero_carta()%>
			</option>

			<%
				}
			%>
		</select>
		 <input type="submit" value="ELIMINA CARTA" />
	</form>
</body>
</html>