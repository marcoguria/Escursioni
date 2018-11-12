<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/registrazione.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<title>Registrazione</title>
</head>
<body>

	
	<span class="align-middle">
	<%
		Map<String, String> map = (Map) request.getAttribute("mappaErrori");
	%>
	<div class= "conteiner">
	
	<div class="row">
   <div class="col-lg-6 col-lg-offset-3 col-md-6 col-md-offset-3 col-sm-6 col-sm-offset-3 col-xs-6 col-xs-offset-3" align="center" id="panel">
	

	<form method="POST" action="RegistrazioneServlet">
	
	<div class="row">
	<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">

		Nome: <input type="text" name="nome" required />
		<%
			if (map != null && map.containsKey("nome")) {
		%>
		<p><%=map.get("nome")%></p>
		<%
			}
		%><br>
		</div>
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		 Cognome: <input type="text" name="cognome"
			required />
		<%
			if (map != null && map.containsKey("cognome")) {
		%>
		<p><%=map.get("cognome")%></p>
		<%
			}
		%>
		</div>
		</div>
		
		<div class="row">
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		
		<br> CodFiscale: <input type="text" name="codf" required />
		<%
			if (map != null && map.containsKey("codf")) {
		%>
		<p><%=map.get("codf")%></p>
		<%
			}
		%>
		</div>
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		<br> E-mail: <input type="email" name="email" required />
		<%
			if (map != null && map.containsKey("email")) {
		%>
		<p><%=map.get("email")%></p>
		<%
			}
		%>
		</div>
		</div>
		
		<div class="row">
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		<br> DataNascita: <input type="date" name="dataNascita" min="1920-01-01" max="2000-01-01" required />
		</div>
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		<br> Username: <input type="text" name="username" required />
		<%
			if (map != null && map.containsKey("username")) {
		%>
		<p><%=map.get("username")%></p>
		<%
			}
		%>
		</div>
		</div>
		
		<div class="row">
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		<br> Password: <input type="password" name="password" required />
		<%
			if (map != null && map.containsKey("password")) {
		%>
		<p><%=map.get("password")%></p>
		<%
			}
		%>
		</div>
		<div class="col-lg-2 col-lg-offset-2 col-md-2 col-md-offset-2">
		<br>ConfermaPassword: <input type="password" name="conferma" required />
		<%
			if (map != null && map.containsKey("conferma")) {
		%>
		<p><%=map.get("conferma")%></p>
		<%
			}
		%>
		</div>
		</div>
		 <input type="hidden" name="contesto" value="registrazione" />
		<br><br> <input type="submit" value="REGISTRATI" />

	</form>
		</div>
		</div>
		</div>
		
		</span>
			
</body>
</html>