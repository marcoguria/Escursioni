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
			<br><br>
				<!-- It can be fixed with bootstrap affix http://getbootstrap.com/javascript/#affix-->
				<div id="sidebar" class="well sidebar-nav">
					<%
						if ((int) request.getSession().getAttribute("ruolo") == 1) {
					%>
					<div class="row">
						<div class="col-md-12 ">
					<h3><center><i class="glyphicon glyphicon-home" ></i> <b>GESTIONE PRENOTAZIONI</b></center></h3>
					
					</div>
					</div>
					<br>
					<div class="row">
						<div class="col-md-12">
						
						<form method="POST"
								action="../cliente/VisualizzaMiePrenotazioniServlet">
								
								<button type="submit" class="btn btn-info center-block">Visualizza le mie prenotazioni</button>
							</form>
							
							
					<%
						}
					%>


						</div>
					</div>
					<br><br>
					<div class="row">
						<div class="col-md-12 ">
					
					<h3><center><i class="glyphicon glyphicon-user"></i> <b>GESTIONE PROFILO</b></center></h3>
					</div>
					</div>
					
					<br>
					<div class="row">
						<div class="col-md-6 ">
							<form method="POST" action="GetMyProfileServlet">
								<button type="submit" class="btn btn-info pull-left"/>Modifica Profilo</button>
							</form>
						
					</div>
						<div class="col-md-6 ">
						<%
							if ((int) request.getSession().getAttribute("ruolo") == 1) {
						%>
						<form method="POST"
								action="../cliente/VisualizzaCarteDaEliminareServlet">
								<button type="submit" class="btn btn-info pull-right"/>Elimina carte</button>
							</form>
						<%
							}
						%>
						
							</div>
				
				</div>
				
			</div>
			<div class="col-md-8">
				<!-- Content Here -->
			</div>
		</div>
	</div>





</body>
</html>