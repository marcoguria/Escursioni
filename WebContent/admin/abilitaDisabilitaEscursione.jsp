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
		<div class="row">
			<div class="col-lg-12 my-3"></div>
		</div>


		<div id="products" class="row view-group">
			<%
				for (Escursione escursione : escursioni) {
			%>

			<div class="item col-xs-4 col-lg-4">

				<div class="thumbnail card">
					<div class="img-event">
						<img class="group list-group-image img-fluid"
							src="../ImgSource/bgImg/<%out.println(escursione.getLuogo());%>.jpg"
							alt="" />
					</div>
					<div class="caption card-body">
						<h4 class="group card-title inner list-group-item-heading">
							<%=escursione.getLuogo()%></h4>
						<ul class="container details">
							<li><p>
									<span class="glyphicon glyphicon-calendar" style="width: 50px;"></span>Data
									escursione:
									<%=escursione.getData()%></p></li>
							<li><p>
									<span class="glyphicon glyphicon-info-sign"
										style="width: 50px;"></span>Durata:
									<%=escursione.getDurata()%></p></li>
							<li><p>
									<span class="glyphicon glyphicon-map-marker one"
										style="width: 50px;"></span>Luogo:
									<%=escursione.getLuogo()%></p></li>


							<li><p>
									<span class="glyphicon glyphicon-calendar" style="width: 50px;"></span>Difficolta:
									<%=escursione.getDifficolta()%></p></li>
							<li><p>
									<span class="glyphicon glyphicon-info-sign"
										style="width: 50px;"></span>Numero prenotati:
									<%=escursione.getNumPrenotati()%></p></li>
							<li><p>
									<span class="glyphicon glyphicon-euro one" style="width: 50px;"></span>Prezzo:
									<%=escursione.getPrezzo()%></p>
								</a>
						</ul>
						<div class="row">
							<div class="col-xs-12 col-md-6"></div>
							<div class="col-xs-12 col-md-6">

								<%
									if (escursione.getDisponibile() == 0) {
								%>
								<form method="POST" action="AbilitaEscursioneServlet">
									<input type="hidden" name="idEscursione"
										value="<%=escursione.getId()%>" /> <input type="submit"
										class="btn btn-success" value="Abilita" />
								</form>
								<%
									}
								%>
								<%
									if (escursione.getDisponibile() == 1) {
								%>
								<form method="POST" action="DisabilitaEscursioneServlet">
									<input type="hidden" name="idEscursione"
										value="<%=escursione.getId()%>" /> <input type="submit"
										class="btn btn-danger" value="Disabilita" />
								</form>

								<%
									}
								%>

							</div>
						</div>
					</div>
				</div>
				<br> <br>
			</div>


			<%
				}
			%>

			<%
				}
			%>
			<div class="container">
				<div class="row">
					<div class="col-lg-12 my-3"></div>
				</div>
</body>
</html>