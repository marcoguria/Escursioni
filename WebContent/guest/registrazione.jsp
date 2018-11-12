<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/registrazioneCss.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Registrazione</title>
</head>
<body>
	
	<%
		Map<String, String> map = (Map) request.getAttribute("mappaErrori");
	%>
	
	<div class="row">

  <div class="col-lg-4" align="center" id="panel">
	

	<form method="POST" action="RegistrazioneServlet">
	
	

		Nome: <input type="text" name="nome" required />
		<%
			if (map != null && map.containsKey("nome")) {
		%>
		<p><%=map.get("nome")%></p>
		<%
			}
		%>
		<br> <br> Cognome: <input type="text" name="cognome"
			required />
		<%
			if (map != null && map.containsKey("cognome")) {
		%>
		<p><%=map.get("cognome")%></p>
		<%
			}
		%>
		<br> CodFiscale: <input type="text" name="codf" required />
		<%
			if (map != null && map.containsKey("codf")) {
		%>
		<p><%=map.get("codf")%></p>
		<%
			}
		%>
		<br>  E-mail: <input type="email" name="email" required />
		<%
			if (map != null && map.containsKey("email")) {
		%>
		<p><%=map.get("email")%></p>
		<%
			}
		%>
		<br> DataNascita: <input type="date" name="dataNascita" min="1920-01-01" max="2000-01-01" required />

		<br> Username: <input type="text" name="username" required />
		<%
			if (map != null && map.containsKey("username")) {
		%>
		<p><%=map.get("username")%></p>
		<%
			}
		%>

		<br> Password: <input type="password" name="password" required />
		<%
			if (map != null && map.containsKey("password")) {
		%>
		<p><%=map.get("password")%></p>
		<%
			}
		%>
		
		<br> Conferma Password: <input type="password" name="conferma" required />
		<%
			if (map != null && map.containsKey("conferma")) {
		%>
		<p><%=map.get("conferma")%></p>
		<%
			}
		%>
		 <input type="hidden" name="contesto" value="registrazione" />
		<br> <input type="submit" value="REGISTRATI" />

	</form>
		</div>
		</div>
	
</body>
</html>