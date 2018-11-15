<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Home</title>
</head>
<body >
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

						<li class="allign-right"><a href="profilo.jsp">Profilo</a></li>
						<%
							if ((int) request.getSession().getAttribute("ruolo") == 0) {
						%>

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Gestisci clienti <b class="caret"></b></a>
							<ul class="dropdown-menu">
								
								<li>

									<form class="dropdown" method="POST"
										action="../admin/MostraUtentiRegistratiServlet">
										<input type="submit" value=" mostra clienti"
											style="border: none; background: none" />
									</form>
								</li>
								

							</ul></li>
							
							
							

						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Gestisci escursioni <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="../admin/inserisciEscursione.jsp">Inserisci
										escursione</a></li>
								<li>

									<form class="dropdown" method="POST"
										action="../admin/AbiltaDisabilitaEscursioneServlet">
										<input type="submit" value=" Abilita/Disabilita Escursione"
											style="border: none; background: none" />
									</form>
								</li>
								<li><form class="dropdown" method="POST"
										action="../admin/ReportEscursioniServlet">
										<input type="submit" value="   Report Escursioni"
											style="border: none; background: none" />
									</form></li>

							</ul></li>
						<%
							}
						%>
						<li class="allign-right"><a href="LogoutServlet">Logout</a></li>
					</ul>
				</div>

			</div>
		</div>
		<!-- /container -->
	</div>
	<!-- /navbar wrapper -->


	<!-- Carousel
================================================== -->
	<div class="container">
		<h2>Carousel Example</h2>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->

			<div class="carousel-inner">
				<div class="item active">
					<img src="../ImgSource/bgImg/sentiero.jpg" style="width: 100%;">
					<div class="container">
						<div class="carousel-caption">
							<br>
							<%
								if ((int) request.getSession().getAttribute("ruolo") == 1) {
							%>
							<h1 id="slideA">Sardinia Experience</h1>
							<br> <br> <br> <br> <br> <br>



							<div>

								<div class="signinup">
									<div>
										<form method="GET"
											action="../guest/FindEscursioniDisponibiliServlet">
											<input type="submit" value="Visualizza escursioni"
												class="btn btn-lg btn-primary active" />
										</form>
									</div>

								</div>
							</div>
							<%
								}
							%>

						</div>
					</div>
				</div>
				<div class="item">
					<img src="../ImgSource/bgImg/MONTE_LIMBARA.jpg"
						style="width: 100%;">
					<div class="container">
						<div class="carousel-caption">

							<%
								if ((int) request.getSession().getAttribute("ruolo") == 1) {
							%>
							<br>
							<h1 id="slideB">Cerca l'escursione su misura per te</h1>
							<br> <br> <br>
							<div>

								<div class="signinup">
									<div>
										<form method="GET" action="../guest/cercaEscursione.jsp">
											<input type="submit" value="Cerca escursione"
												class="btn btn-lg btn-primary active" />
										</form>
									</div>

								</div>
							</div>
							<%
								}
							%>

						</div>
					</div>

				</div>

				<div class="item">
					<img src="../ImgSource/bgImg/CALA_LUNA.jpg" style="width: 100%;">
					<div class="container">
						<div class="carousel-caption">
							<%
								if ((int) request.getSession().getAttribute("ruolo") == 1) {
							%>

							<br>
							<h1 id="slideB">La Sardegna esplorata con lo zaino in spalla</h1>
							<br> <br> <br>

						
							<%
								}
							%>

						</div>
					</div>

				</div>


			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>
	<!-- /.carousel -->


	<!-- Marketing messaging and featurettes
================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<!--  <div class="container marketing">
	<%if ((int) request.getSession().getAttribute("ruolo") == 1) {%>

		<!-- Three columns of text below the carousel -->
	<div class="row">
		<div class="col-md-4 text-center">
			<img class="img-circle" src="../ImgSource/bgImg/PAN_DI_ZUCCHERO.jpg"
				width="140px" height="140px">
			<h2></h2>
			<p>Visualizza subito tutte le escursioni disponibili</p>
			<p>
				<a class="btn btn-warning"
					href="../guest/FindEscursioniDisponibiliServlet">Escursioni</a>
			</p>
		</div>
		<
		<div class="col-md-4 text-center">
			<img class="img-circle" src="../ImgSource/bgImg/TAVOLARA.jpg"
				width="140px" height="140px">
			<h2></h2>
			<p>Cerca l'escursione piu' adatta a te...</p>
			<p>
				<a class="btn btn-warning" href="../guest/cercaEscursione.jsp">Cerca</a>
			</p>
		</div>
		<div class="col-md-4 text-center">
			<img class="img-circle" src="../ImgSource/bgImg/logo_taxi.png"
				width="140px" height="140px">
			<h2>DAO Taxi</h2>
			<p>Il piacere del viaggio senza la fatica di viaggiare</p>
			<p>
				<a class="btn btn-warning"
					href="http://172.22.169.57:8081/GitDAOTaxi">Prenota subito</a>
			</p>
		</div>
	</div>
	<!-- /.row -->





	<!-- FOOTER 
	<footer>
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>

	</footer>
-->
	</div>
	<%
		}
	%>

	<!-- /.container -->



</body>
</html>