<%@page import="it.ats.modello.Escursione"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../css/scegliCarta.css">
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
<title>scegliPagamento</title>
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
		Collection<CartaPagamento> cartePagamento = (Collection<CartaPagamento>) request
				.getAttribute("cartePagamento");
	%>

	<%
		Escursione escursione = (Escursione) request.getAttribute("escursione");
	%>



	<div class="container">
		<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
			<div class="col-xs-12 col-md-6 col-md-offset-3">


				<!-- CREDIT CARD FORM STARTS HERE -->
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table" style="width:100%">
						<div class="row">
							<div class="col-xs-4">
								<h2 class="text-center" style="margin: 0px;">Payment Details</h2>
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
									<label for="cardNumber">CARD NUMBER</label>

									<div class="input-group" style="width:100%">
										<form method="POST" action="RiepilogoFinalePrenotazione">

											<select type="tel" class="form-control" id="carta"
												name="numero_carta">  
												<%
													for (CartaPagamento cartaPagamento : cartePagamento) {
												%>
												<option value="<%=cartaPagamento.getNumero_carta()%>"><%=cartaPagamento.getTipo()%>
													<%=cartaPagamento.getNumero_carta()%>
												</option>

												<%
													}
												%>

											</select>  
											
											 <input type="hidden" name="idEscursione"
												value="<%=escursione.getId()%>" /> 
									</div>

								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12">

								<div class="form-group">

									<input type="hidden" name="idEscursione"
										value="<%=escursione.getId()%>" /> <input
										class="subscribe btn btn-success btn-lg btn-block"
										type="submit" value="Prosegui">

									</form>

								</div>

								<div class="form-group">
									<form method="POST" action="aggiungiMetodoPagamento.jsp">
										<input type="hidden" name="idEscursione"
											value="<%=escursione.getId()%>" /> <input
											class="subscribe btn btn-primary btn-lg btn-block"
											type="submit" value="Aggiungi carta">

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