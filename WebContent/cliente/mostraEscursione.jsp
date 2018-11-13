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
<meta charset="ISO-8859-1">
<title>Escursioni Ajò in Sardegna</title>
</head>
<body>


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
		<div class="row">
			<div class="col-lg-12 my-3"></div>
		</div>

		<div id="products" class="row view-group">

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
						<p class="group inner list-group-item-text">
							<%=escursione.getDescrizione()%></p>
						<br>
						<h6 class="group card-title inner list-group-item-heading">
							Guida</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getGuida()%></p>

						<h6 class="group card-title inner list-group-item-heading">
							Localita</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getTipo()%></p>

						<h6 class="group card-title inner list-group-item-heading">
							Durata</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getDurata()%></p>

						<h6 class="group card-title inner list-group-item-heading">
							Difficolta</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getDifficolta()%></p>

						<h6 class="group card-title inner list-group-item-heading">
							Data</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getData()%></p>

						<h6 class="group card-title inner list-group-item-heading">
							Massimo numero partecipanti</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getMaxPartecipanti()%></p>

						<h6 class="group card-title inner list-group-item-heading">
							Posti disponibili</h6>
						<p class="group inner list-group-item-text">
							<%=escursione.getMaxPartecipanti() - escursione.getNumPrenotati()%></p>

						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">
									Prezzo:
									<%=escursione.getPrezzo()%>E
								</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<form method="POST" action="FindCarteByIdSessioneServlet">
									<input type="hidden" name="idEscursione"
										value="<%=escursione.getId()%>" /> <input type="submit"
										class="btn btn-primary" value="Prosegui" />
								</form>

							</div>
						</div>
					</div>
				</div>
				<br> <br>
			</div>

			<%
				}
			%>
		
</body>
</html>