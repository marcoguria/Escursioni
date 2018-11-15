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
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Profile</title>
</head>
<body background="../ImgSource/bgImg/bgProfilo.jpg">
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a href="#" class="navbar-brand">PROFILO</a>
		<button class="navbar-toggler" data-target="#navigation"
			data-control="navigation" data-toggle="collapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navigation">
			<ul class="nav navbar-nav">
				<li class="nav-item active"><a href="home.jsp" class="nav-link">Home</a>
				</li>
				<li class="nav-item"><a href="LogoutServlet" class="nav-link">Logout</a>
				</li>

			</ul>
		</div>
	</nav>

	<div class="container" >
		<div class="row">
			<div class="col-md-4">
				<!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
				<div id="sidebar" class="well sidebar-nav">
					<%
						if ((int) request.getSession().getAttribute("ruolo") == 1) {
					%>
					<h5>
						<i class="glyphicon glyphicon-home" ></i> <small><b>
								GESTIONE PRENOTAZIONI</b></small>
					</h5>
					<ul class="nav nav-pills nav-stacked">
						<li></li>
						<li><form method="POST"
								action="../cliente/VisualizzaMiePrenotazioniServlet">
								<input type="submit" value="Visualizza mie prenotazioni" />
							</form></li>

					</ul>
					<br> <br>
					<%
						}
					%>

					<h5>
						<i class="glyphicon glyphicon-user"></i> <small><b>GESTIONE
								PROFILO</b></small>
					</h5>
					<ul class="nav nav-pills nav-stacked">
						<li>
							<form method="POST" action="GetMyProfileServlet">
								<input type="submit" value="Modifica Profilo" />
							</form>
						</li>
						<br>
						<br>
						<%
							if ((int) request.getSession().getAttribute("ruolo") == 1) {
						%>
						<li><form method="POST"
								action="../cliente/VisualizzaCarteDaEliminareServlet">
								<input type="submit" value="Le mie carte" />
							</form></li>
						<%
							}
						%>
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