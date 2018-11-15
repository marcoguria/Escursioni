<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.UtenteRegistrato"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<link rel="stylesheet" type="text/css" href="../css/utenti.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>



<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Mostra Utenti</title>
</head>
<body background="../ImgSource/bgImg/adminBg.jpg">


	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a href="#" class="navbar-brand">ABILITA/DISABILITA <br>
			UTENTI
		</a>
		<button class="navbar-toggler" data-target="#navigation"
			data-control="navigation" data-toggle="collapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navigation">
			<ul class="nav navbar-nav">
				<li class="nav-item active"><a
					href="../utenteregistrato/home.jsp" class="nav-link">Home</a></li>

			</ul>
		</div>
	</nav>

	<%
		Collection<UtenteRegistrato> utenti = (Collection<UtenteRegistrato>) request.getAttribute("utenti");
	%>

	<%
		if (utenti == null || utenti.isEmpty()) {
	%>

	<p>Non esistono utenti in archivio</p>

	<%
		} else {
	%>
	<div class="container">

		<table class="table table-hover">
			<thead>

				<tr>
					<th>NOME</th>
					<th>COGNOME</th>
					<th>CODF</th>
					<th>EMAIL</th>
					<th>DATA_NASCITA</th>
					<th>RUOLO</th>
					<th>STATO_UTENTE</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>

			<%
				for (UtenteRegistrato utenteRegistrato : utenti) {
			%>


			<tr>

				<td><%=utenteRegistrato.getNome()%></td>
				<td><%=utenteRegistrato.getCognome()%></td>
				<td><%=utenteRegistrato.getCodf()%></td>
				<td><%=utenteRegistrato.getEmail()%></td>
				<td><%=utenteRegistrato.getData_nascita()%></td>
				<td>
					<%
						if (utenteRegistrato.getFlag_ruolo() == 0) {
									out.println("AMMINISTRATORE");
					%> <%
 	}
 			if (utenteRegistrato.getFlag_ruolo() == 1) {
 				out.println("CLIENTE");
 			}
 %>
				</td>
				<td>
					<%
						if (utenteRegistrato.getAttivo() == 0) {
									out.println("DISATTIVO");
					%> <%
 	}
 			if (utenteRegistrato.getAttivo() == 1) {
 				out.println("ATTIVO");
 			}
 %>
				</td>
				<!-- srthrtshwrhthwt -->
				<td>
					<%
						if (utenteRegistrato.getFlag_ruolo() == 1) {
					%> <%
 	if (utenteRegistrato.getAttivo() == 0) {
 %>
					<form method="POST" action="SbloccaUtenteServlet">
						<input type="hidden" name="idCliente"
							value="<%=utenteRegistrato.getID()%>" /> <input type="submit"
							class="btn btn-success" value="SBLOCCA" />
					</form> <%
 	}
 				if (utenteRegistrato.getAttivo() == 1) {
 %>
					<form method="POST" action="BloccaUtenteServlet">
						<input type="hidden" name="idCliente"
							value="<%=utenteRegistrato.getID()%>" /> <input type="submit"
							class="btn btn-danger" value="BLOCCA" />
					</form> <%
 	}
 %> <%
 	}
 %>

				</td>
			</tr>

			<%
				}
			%>
			</tbody>
		</table>

		<%
			}
		%>
	</div>



</body>
</html>