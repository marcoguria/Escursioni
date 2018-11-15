<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/profilo.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
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
<title>Profile</title>
</head>
<body background="../ImgSource/bgImg/bgProfilo.jpg">

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

	<div class="container" >
		<div class="row">
			<div class="col-md-6 col-md-offset-3">
				<!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
				<div id="sidebar" class="well sidebar-nav">
					<%
						if ((int) request.getSession().getAttribute("ruolo") == 1) {
					%>
					<h3>
						<i class="glyphicon glyphicon-home" ></i> <b>
								GESTIONE PRENOTAZIONI</b>
					</h3>
					<ul class="nav nav-pills nav-stacked">
						
						<li><form method="POST"
								action="../cliente/VisualizzaMiePrenotazioniServlet">
								
								<button type="submit" class="btn btn-info">Visualizza le mie prenotazioni</button>
							</form></li>

					</ul>
					<br> 
					<%
						}
					%>

					<h3>
						<i class="glyphicon glyphicon-user"></i> <b>GESTIONE PROFILO</b>
					</h3>
					
					
					<ul class="nav nav-pills nav-stacked">
					<li>
							<form method="POST" action="GetMyProfileServlet">
								<button type="submit" class="btn btn-info"/>Modifica Profilo</button>
							</form>
						
					
						
						<%
							if ((int) request.getSession().getAttribute("ruolo") == 1) {
						%>
						<form method="POST"
								action="../cliente/VisualizzaCarteDaEliminareServlet">
								<button type="submit" class="btn btn-info"/>Elimina carte</button>
							</form>
						<%
							}
						%>
						
						
						</li>
					</ul>
				</div>
			</div>
			<div class="col-md-8">
				<!-- Content Here -->
			</div>
		</div>
	</div>





</body>
</html>