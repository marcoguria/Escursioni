<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			<form method="GET" action="LogoutServlet">
			<input type="submit" value="Logout" />
			</form>
			<form method="GET" action="home.jsp">
			<input type="submit" value="Home" />
			</form>
			
			<%	
			if((int)request.getSession().getAttribute("ruolo")==1){
		%>
			<ul type="square">
  			<li><a href="VisualizzaMiePrenotazioniServlet">Visualizza le mie prenotazioni</a></li>
  			</ul>				
		<%
	}
%>
			<ul type="square">
  			<li><a href="modificaProfilo.jsp">Modifica il mio profilo</a></li>
  			</ul>	
			

</body>
</html>