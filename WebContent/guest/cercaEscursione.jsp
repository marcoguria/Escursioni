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

	<form method="GET" action="FindEscursioniBySearchServlet">
		Tipo : <select id="tipo" name="tipo">
			<option value=''>Select a thing</option>
			<option value="MARE">Mare</option>
			<option value="MONTAGNA">Montagna</option>
			<option value="LAGO">Lago</option>
		</select>
		<br>
		<%
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
		%>

		Data Escursione: <input type="date" name="dataEscursione" min="<%=date%>" /> <br>
		Luogo: <input type="text" name="luogo" /><br>
		
		Durata: <input type="number" name="durata" min="1" max="25" /> <br>
		Difficoltà:
		 <select id="difficolta" name="difficolta"> 
		 <option value=''>Select a thing</option>
			<option value="BASSA">Bassa</option>
			<option value="MEDIA">Media</option>
			<option value="ALTA">Alta</option>
		</select> <br>
			
		<input type="submit" value="CERCA" />
	</form>

</body>
</html>