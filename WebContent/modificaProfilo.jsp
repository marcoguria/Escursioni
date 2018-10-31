<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@page import="it.ats.modello.UtenteRegistrato"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%
		Collection<CartaPagamento> cartePagamenti = (Collection<CartaPagamento>) request
				.getAttribute("cartePagamenti");
		UtenteRegistrato utenteRegistrato = (UtenteRegistrato) request.getAttribute("utente");
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
</body>
</html>