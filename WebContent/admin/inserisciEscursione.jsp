<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Escursione</title>
</head>
<body>

	<%
		Map<String, String> map = (Map) request.getAttribute("mappaErrori");
	%>
	
	<form method="POST" action="../utenteregistrato/home.jsp">
		<input type="submit" value="Home" />
	</form>
	
	
	<form method="POST" action="InserisciEscursioneServlet">

		Luogo: <input type="text" name="luogo"  required/> <br>
		<%
			if (map != null && map.containsKey("luogo")) {
		%>
		<p><%=map.get("luogo")%></p>
		<%
			}
		%>
		
		 Tipo: <input type="text" name="tipo" required /> <br> 
		 <%
			if (map != null && map.containsKey("tipo")) {
		%>
		<p><%=map.get("tipo")%></p>
		<%
			}
		%>
		
		<%
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		
		%>
		Data Escursione: <input type="date" name="dataEscursione" min="<%=date %>" required /> <br> 
		  <%
			if (map != null && map.containsKey("dataEscursione")) {
		%>
		<p><%=map.get("dataEscursione")%></p>
		<%
			}
		%>
		Durata: <input 	type="number" name="durata"  min="1" max="25" required /> <br>
		  <%
			if (map != null && map.containsKey("durata")) {
		%>
		<p><%=map.get("durata")%></p>
		<%
			}
		%> 
		Difficoltà: <input 	type="text" name="difficolta" required /> <br> 
	  <%
			if (map != null && map.containsKey("difficolta")) {
		%>
		<p><%=map.get("difficolta")%></p>
		<%
			}
		%> 
		Prezzo: <input	type="number" name="prezzo"  required/> <br> 
		  <%
			if (map != null && map.containsKey("prezzo")) {
		%>
			<p><%=map.get("prezzo")%></p>
		<%
			}
		%> 
		
		Guida Escursione: <input type="text" name="guida" required /> <br> 
	 	 <%
			if (map != null && map.containsKey("guida")) {
		%>
			<p><%=map.get("guida")%></p>
		<%
			}
		%> 
		Max Partecipanti: <input type="number" name="maxPartecipanti" required /> <br>
			 <%
			if (map != null && map.containsKey("maxPartecipanti")) {
		%>
			<p><%=map.get("maxPartecipanti")%></p>
		<%
			}
		%> 
		
		 <input type="submit" value="Inserisci" />
	
	</form>

</body>
</html>