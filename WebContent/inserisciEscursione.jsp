<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci Escursione</title>
</head>
<body>
	<form method="POST" action="InserisciEscursioneServlet">

		Luogo: <input type="text" name="luogo" /> <br> 
		Tipo: <input type="text" name="tipo" /> <br> 
		Data Escursione: <input type="date" name="dataEscursione" /> <br> 
		Durata: <input type="text" name="durata" /> <br> 
		Difficoltà: <input type="text" name="difficolta" /> <br> 
		Prezzo: <input type="text" name="prezzo" /> <br> 
		Guida Escursione: <input type="text" name="guida" /> <br> 
		Max Partecipanti: <input type="text" name="maxPartecipanti" /> <br> 
		
		
		<input type="submit" value="Inserisci" /> 

	</form>
	
</body>
</html>