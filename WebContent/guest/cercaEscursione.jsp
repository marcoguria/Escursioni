<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Booking Form HTML Template</title>

<!-- Google font -->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet" href="../css/bootstrap.min.css" />

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="../css/cercaEscursione.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>

<body>
	<form method="GET" action="FindEscursioniBySearchServlet">
		<div id="booking" class="section">
			<div class="section-center">
				<div class="container">
					<div class="row">
						<div class="col-md-7 col-md-push-5">
							<div class="booking-cta">
								<h1>Cerca la tua escursione</h1>
								<p>La Sardegna è un'isola dalle straordinarie bellezze,
									ricca di storia e paesaggi da sogno. Cerca la tua escursione
									preferita e diventa protagonista</p>
							</div>
						</div>
						<div class="col-md-4 col-md-pull-7">
							<div class="booking-form">
								<form>
									<div class="form-group">
										<span class="form-label">Destinazione</span> <input
											class="form-control" type="text" name="luogo"
											placeholder="Enter a destination or excursion name">
									</div>
									<div class="row">
										<div class="col-sm-6">
											
										</div>
										<div class="col-sm-6"></div>
									</div>
									<div class="row">
										<div class="col-sm-4">
											<div class="form-group">
												<span class="form-label">Difficolta</span> <select
													class="form-control" id="difficolta" name="difficolta">
													<option value=''>----</option>
													<option value="BASSA">Bassa</option>
													<option value="MEDIA">Media</option>
													<option value="ALTA">Alta</option>
												</select> <span class="select-arrow"></span>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<span class="form-label">Tipo</span> <select
													class="form-control" id="tipo" name="tipo">
													<option value=''>----</option>
													<option value="MARE">Mare</option>
													<option value="MONTAGNA">Montagna</option>
													<option value="LAGO">Lago</option>
												</select> <span class="select-arrow"></span>
											</div>
										</div>
										<div class="col-sm-4">
											<div class="form-group">
												<span class="form-label">Durata</span> <input type="number"
													class="form-control" name="durata" min="1" max="25" /> <span
													class="select-arrow"></span>
											</div>
										</div>
									</div>
									<div class="form-btn">
										<button class="submit-btn">Cerca disponibilità</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>