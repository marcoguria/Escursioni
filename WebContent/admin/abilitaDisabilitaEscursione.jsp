<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.Escursione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" type="text/css"
	href="../css/elencoEscursioni.css">

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Abilita/Disabilita Escursione</title>
</head>
<body background="../ImgSource/bgImg/sfondo.jpg">



	<div class="navbar-wrapper">
		<div class="container">
			<div class="navbar navbar-inverse navbar-static-top">

				<div class="navbar-header">
					<a class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-collapse"> <span class="icon-bar"></span>
						<span class="icon-bar"></span> <span class="icon-bar"></span>
					</a> <a class="navbar-brand">Sardinia Experience</a>
				</div>
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="allign-right"><a
							href="../utenteregistrato/home.jsp">Home</a></li>

					</ul>
				</div>

			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /navbar wrapper -->

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