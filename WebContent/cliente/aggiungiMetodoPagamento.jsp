<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>

<!-- If you're using Stripe for payments -->
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<title>aggiungiMetodoPagamento</title>
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



	<%
		Long id_escursione = Long.parseLong(request.getParameter("idEscursione"));

		Map<String, String> map = (Map) request.getAttribute("mappaErrori");
	%>




	<div class="container">
		<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
			<div class="col-xs-12 col-md-6 col-md-offset-3">


				<!-- CREDIT CARD FORM STARTS HERE -->
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table">
						<div class="row">
							<div class="col-xs-4">
								<h2 class="text-center" style="margin: 0px;">Payment
									Details</h2>
							</div>
							<div class="col-xs-8">
								<img class="img-responsive pull-right"
									src="http://i76.imgup.net/accepted_c22e0.png">
							</div>
						</div>
					</div>

					<div class="panel-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group text-center">


									<div class="input-group" style="width: 100%">
										<form method="POST" action="AggiungiMetodoPagamentoServlet">

											<br> <br> <label for="cardNumber">TYPE CARD
											</label> <input class="form-control" type="text" name="tipoCarta"
												required />

											<%
												if (map != null && map.containsKey("tipoCarta")) {
											%>
											<div class="alert alert-danger" role="alert">
												<%=map.get("tipoCarta")%>
											</div>
											<%
												}
											%>

											<br> <br> <label for="cardNumber">CARD
												NUMBER</label> <input class="form-control" type="number"
												name="numeroCarta" required /> <br>
											<%
												if (map != null && map.containsKey("numeroCarta")) {
											%>
											<div class="alert alert-danger" role="alert">
												<%=map.get("numeroCarta")%>
											</div>
											<%
												}
											%>
											<br> <br> <label for="cardNumber">CVV</label> <input
												class="form-control" type="number" name="cvv" required /> <br>
											<%
												if (map != null && map.containsKey("cvv")) {
											%>
											<div class="alert alert-danger" role="alert">
												<%=map.get("cvv")%>
											</div>
											<%
												}
											%>
										
									</div>

								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">

								<div class="form-group">

									<input type="hidden" name="idEscursione"
										value="<%=id_escursione%>" /> <input
										class="subscribe btn btn-primary btn-lg btn-block"
										type="submit" value="Inserisci" />

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
				<!-- CREDIT CARD FORM ENDS HERE -->
			</div>
		</div>
	</div>



</body>
</html>