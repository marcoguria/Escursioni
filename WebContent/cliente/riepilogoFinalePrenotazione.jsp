<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="it.ats.modello.Escursione"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Escursioni in sardegna</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		href="#" class="navbar-brand">CONFERMA <br> PRENOTAZIONE
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
		Escursione escursione = (Escursione) request.getAttribute("escursione");
		CartaPagamento cartaPagamento = (CartaPagamento) request.getAttribute("carta");

		if (escursione == null || cartaPagamento == null) {
	%>

	<p>Non esiste questa escursione in archivio</p>

	<%
		} else {
	%>

	
		<div class="container">

			<div class="jumbotron">
				<div class="row">
					<div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
						<img
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
									<span class="glyphicon glyphicon-euro one" style="width: 50px;"></span>Prezzo:
									<%=escursione.getPrezzo()%></p> </a>
						</ul>
					</div>
				</div>
			</div>

			<!--TERMINE RIEPILOGO ESCURSIONE  -->



			<div class="container">
				<div class="row">
					<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
					<div class="col-xs-12 col-md-4">


						<!-- CREDIT CARD FORM STARTS HERE -->
						<div class="panel panel-default credit-card-box">
							<div class="panel-heading display-table">
								<div class="row display-tr">
									<h3 class="panel-title display-td">Payment Details</h3>
									<div class="display-td">
										<img class="img-responsive pull-right"
											src="http://i76.imgup.net/accepted_c22e0.png">
									</div>
								</div>
							</div>

							<div class="panel-body">
								<div class="row">
									<div class="col-xs-12">
										<div class="form-group">
											<label for="cardNumber">CARD NUMBER</label>

											<div class="input-group">

												<%=cartaPagamento.getTipo()%>
												<%=cartaPagamento.getNumero_carta()%>
											</div>

										</div>
									</div>
								</div>

								<div class="row">
									<div class="col-xs-12">

										<div class="form-group">

											<form method="POST" action="ConfermaPrenotazioneServlet">
												<input type="hidden" name="idEscursione"
													value="<%=escursione.getId()%>" /> <input
													class="subscribe btn btn-success btn-lg btn-block"
													type="submit" value="Conferma e paga" />
											</form>
										</div>


									</div>
								</div>

								<div class="row"></div>
								<div class="row" style="display: none;">
									<div class="col-xs-12">
										<p class="payment-errors"></p>
									</div>
								</div>

							</div>

						</div>

					</div>
					<!--TERMINE RIEPILOGO CARD  -->
				</div>
			</div>
		</div>
	
	<%
		}
	%>


	<br>
	<br>
	<br>
</body>
</html>