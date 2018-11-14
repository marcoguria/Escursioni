<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.Escursione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="../css/elencoEscursioni.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Abilita/Disabilita Escursione</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a href="#" class="navbar-brand">ABILITA/DISABILITA <br>
			ESCURSIONE
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
		Collection<Escursione> escursioni = (Collection<Escursione>) request.getAttribute("escursioni");
	%>

	<%
		if (escursioni == null || escursioni.isEmpty()) {
	%>

	<p>Non esistono escursioni in archivio</p>

	<%
		} else {
	%>

	<div class="container">

		<table class="table table-hover">
			<thead>

				<tr>
					<th>LUOGO</th>
					<th>TIPO</th>
					<th>DATA</th>
					<th>DURATA</th>
					<th>DIFFICOLTA</th>
					<th>PREZZO</th>
					<th>GUIDA</th>
					<th>MAX PARTECIPANTI</th>
					<th>DISPONIBILITA</th>
					<th class="text-center">Action</th>
				</tr>
			</thead>

			<%
				for (Escursione escursione : escursioni) {
			%>


			<tr>

				<td><%=escursione.getLuogo()%></td>
				<td><%=escursione.getTipo()%></td>
				<td><%=escursione.getData()%></td>
				<td><%=escursione.getDurata()%></td>
				<td><%=escursione.getDifficolta()%></td>
				<td><%=escursione.getPrezzo()%></td>
				<td><%=escursione.getGuida()%></td>
				<td><%=escursione.getMaxPartecipanti()%></td>
				<td>
					<%
						if (escursione.getDisponibile() == 0)
									out.println("NON DISPONIBILE");
								else
									out.println("DISPONIBILE");
					%>
				</td>


				<!-- srthrtshwrhthwt -->
				<td>
					<%
						if (escursione.getDisponibile() == 0) {
					%>
					<form method="POST" action="AbilitaEscursioneServlet">
						<input type="hidden" name="idEscursione"
							value="<%=escursione.getId()%>" /> <input type="submit"
							class="btn btn-success" value="Abilita" />
					</form> <%
 	}
 %> <%
 	if (escursione.getDisponibile() == 1) {
 %>
					<form method="POST" action="DisabilitaEscursioneServlet">
						<input type="hidden" name="idEscursione"
							value="<%=escursione.getId()%>" /> <input type="submit"
							class="btn btn-danger" value="Disabilita" />
					</form> <%
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