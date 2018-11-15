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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<!-- non toccare -->


<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<title>Escursioni Ajo in Sardegna</title>
</head>
<body background="../ImgSource/bgImg/bgEscursioni.jpg">








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
						<p class="group inner list-group-item-text">
							<%=escursione.getDescrizione()%></p>
						<div class="row">
							<div class="col-xs-12 col-md-6">
								<p class="lead">
									Prezzo:
									<%=escursione.getPrezzo()%>E
								</p>
							</div>
							<div class="col-xs-12 col-md-6">
								<form method="POST"
									action="../cliente/FindByIdEscursioneServlet">
									<input type="hidden" name="idEscursione"
										value="<%=escursione.getId()%>" /> <input type="submit"
										class="btn btn-primary" value="Prenota" />
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

			<%
				}
			%>
			<div class="container">
				<div class="row">
					<div class="col-lg-12 my-3"></div>
				</div>
</body>
</html>







