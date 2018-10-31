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
		if ((int) request.getSession().getAttribute("ruolo") == 1) {
	%>
	
	<form  name="submitForm" method="POST" action="VisualizzaMiePrenotazioniServlet">
       <A HREF="javascript:document.submitForm.submit()">Visualizza le mie prenotazioni</A>
    </form>
	<%
		}
	%>

	
	<form  name="submitForm" method="POST" action="GetMyProfileServlet">
       <A HREF="javascript:document.submitForm.submit()">Modifica Profilo</A>
    </form>
	
	

</body>
</html>