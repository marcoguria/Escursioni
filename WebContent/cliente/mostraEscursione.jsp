<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.Escursione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">

<link
	href="../css/mostraEscursione.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<title>Escursioni Ajò in Sardegna</title>
</head>
<body background="../ImgSource/bgImg/cieloD.jpg">

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
		Escursione escursione = (Escursione) request.getAttribute("escursione");
	%>

	<%
		if (escursione == null) {
	%>

	<p>Non esiste questa escursione in archivio</p>

	<%
		} else {
	%>

	
	<div class="container">
		<div class="jumbotron">
			<div class="row">
				<div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
					<br> <br> <br> <img
						src="../ImgSource/bgImg/<%out.println(escursione.getLuogo());%>.jpg"
						alt="stack photo" class="img" width="100%">
				</div>
				<div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
					<div class="container" style="border-bottom: 1px solid black">
						<h2><%=escursione.getLuogo()%></h2>
					</div>
					<hr>
					<ul class="container details">
						<li><p>
								<span class="glyphicon glyphicon-info-sign" style="width: 50px;"></span>Descrizione:
								<%=escursione.getDescrizione()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-map-marker one"
									style="width: 50px;"></span>Luogo:
								<%=escursione.getLuogo()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-calendar" style="width: 50px;"></span>Data
								escursione:
								<%=escursione.getData()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-user" style="width: 50px;"></span>Guida:
								<%=escursione.getGuida()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-info-sign" style="width: 50px;"></span>Durata:
								<%=escursione.getDurata()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-info-sign" style="width: 50px;"></span>Difficolta:
								<%=escursione.getDifficolta()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-info-sign" style="width: 50px;"></span>Posti
								Disponibili:
								<%=escursione.getMaxPartecipanti() - escursione.getNumPrenotati()%></p></li>
						<li><p>
								<span class="glyphicon glyphicon-euro one" style="width: 50px;"></span>Prezzo:
								<%=escursione.getPrezzo()%></p>
					</ul>

					<div class="col-xs-12 col-md-6">
						<form method="POST" action="FindCarteByIdSessioneServlet">
							<input type="hidden" name="idEscursione"
								value="<%=escursione.getId()%>" /> <input type="submit"
								class="btn btn-primary btn-lg" value="Prosegui" />
						</form>

					</div>
				</div>
			</div>
		</div>

	</div>

	<%
		}
	%>

</body>
</html>