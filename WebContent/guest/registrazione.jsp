<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form method="POST" action="RegistrazioneServlet">
		
		Nome: <input type="text" name="nome" required/>
		
		<br>	<br>
		
		Cognome: <input type="text" name="cognome" required/>
		
		<br>	<br>
		CodFiscale: <input type="text" name="codf" required/>
		
		<br>	<br>
		
		Email: <input type="text" name="email" required />
		
		<br>	<br>
		
		DataNascita: <input type="date" name="dataNascita" required />
		
		<br>	<br>
		
		
		Username: <input type="text" name="username" required />
		
		
		<br>	<br>
		
		Password: <input type="password" name="password" required/>
		
		<br>	<br>
		
		<input type="submit" value="REGISTRATI" />
		
	</form>
</body>
</html>