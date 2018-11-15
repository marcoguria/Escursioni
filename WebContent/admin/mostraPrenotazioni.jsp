<%@page import="it.ats.modello.Escursione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="it.ats.modello.Prenotazione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Insert title here</title>
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

	<br>
	<%
		Collection<Prenotazione> prenotazioni = (Collection<Prenotazione>) request.getAttribute("prenotazioni");
		Escursione escursione = null;
	%>

	<%
		for (Prenotazione prenotazione : prenotazioni) {
			escursione = prenotazione.getEscursione();
		}
	%>

	<div class="container">
		<div class="row">
			<div class="col-xs-10">
				<div class="panel panel-primary">
					<!-- Default panel contents -->
					<div class="panel-heading">
						<h2 class="panel-title">ELENCO PRENOTAZIONI ESCURSIONE</h2>
					</div>

					<div class="panel-body">
						<h3><%=escursione.getLuogo()%></h3>
					</div>


					<ul class="list-group">

						<li class="list-group-item">

							<table class="table table-hover">
								<thead>
									<tr>
										<th>DATA</th>
										<th>NOME</th>
										<th>COGNOME</th>
										<th>EMAIL</th>

									</tr>
								</thead>
								<tbody>
									<%
										for (Prenotazione prenotazione : prenotazioni) {
									%>

									<tr>
										<td><%=prenotazione.getData_prenotazione()%></td>
										<td><%=prenotazione.getUtenteRegistrato().getNome()%></td>
										<td><%=prenotazione.getUtenteRegistrato().getCognome()%></td>
										<td><%=prenotazione.getUtenteRegistrato().getEmail()%></td>

										<%
											}
										%>
									
								</tbody>
							</table>
						</li>




					</ul>
				</div>
			</div>
		</div>
	</div>

</body>
</html>