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
			
			<form method="POST" action="profilo.jsp">
			<input type="submit" value="Profilo" />
			</form>
<%
	if((int)request.getSession().getAttribute("ruolo")==0){
		%>
			<form method="POST" action="gestisciSito.jsp">
			<input type="submit" value="GestisciSito" />
			</form>					
		<%
	}
%>

</body>
</html>