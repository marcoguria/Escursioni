<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		Long id_escursione = Long.parseLong(request.getParameter("idEscursione"));

		Map<String, String> map = (Map) request.getAttribute("mappaErrori");
	%>



	<form method="GET" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>
	<br>

	<form method="POST" action="AggiungiMetodoPagamentoServlet">
		Tipo carta: <input type="text" name="tipoCarta" required /> <br>
		<%
			if (map != null && map.containsKey("tipoCarta")) {
		%>
		<p><%=map.get("tipoCarta")%></p>
		<%
			}
		%>
		Numero carta: <input type="number" name="numeroCarta" required /> <br>
		<%
			if (map != null && map.containsKey("numeroCarta")) {
		%>
		<p><%=map.get("numeroCarta")%></p>
		<%
			}
		%>
		CVV: <input type="number" name="cvv" required /> <br>
		<%
			if (map != null && map.containsKey("cvv")) {
		%>
		<p><%=map.get("cvv")%></p>
		<%
			}
		%>
		<input type="hidden" name="idEscursione" value="<%=id_escursione%>" />
		<input type="submit" value="Inserisci" />
	</form>

</body>
</html>