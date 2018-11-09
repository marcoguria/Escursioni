<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="POST" action="FindEscursioniBySearchServlet">
		Tipo : <select id="tipo" name="tipo" multiple>
			<option value="mare">Mare</option>
			<option value="montagna">Montagna</option>
			<option value="lago">Lago</option>
		</select>

		<%
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
		%>

		Data Escursione: <input type="date" name="dataEscursione"  min="<%=date%>" /> 
		Luogo: <input type="text" name="luogo" />
		
		Durata: <input type="number" name="durata" min="1" max="25" /> 
		Difficoltà:
		 <select id="difficolta" name="difficolta" multiple>
			<option value="bassa">Bassa</option>
			<option value="media">Media</option>
			<option value="alta">Alta</option>
		</select> 
			
		<input type="submit" value="CERCA" />
	</form>

</body>
</html>