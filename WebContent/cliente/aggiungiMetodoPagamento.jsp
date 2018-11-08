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
	
	%>
	
	<form method="GET" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>
	<br>
	
	<form method="POST" action="AggiungiMetodoPagamentoServlet">
		Tipo carta: <input type="text" name="tipoCarta" /> <br> 
		Numero carta: <input type="number" size="10" required /> <br> 
		CVV: <input	type="number" size="3" required/> <br> 
		<input type="hidden" name="idEscursione" value="<%=id_escursione%>" />		
		<input type="submit" value="Inserisci" />
	</form>

</body>
</html>