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
		Long id_escursione = Long.parseLong(request.getParameter("idEscursione"));
		out.println("id del cazzo "+ id_escursione);
	%>
	<form method="POST" action="AggiungiMetodoPagamentoServlet">
		Tipo carta: <input type="text" name="tipoCarta" /> <br> 
		Numero carta: <input type="text" name="numeroCarta" /> <br> 
		CVV: <input	type="password" name="cvv" /> <br> 
		<input type="hidden" name="idEscursione" value="<%=id_escursione%>" />		
		<input type="submit" value="Inserisci" />
	</form>

</body>
</html>