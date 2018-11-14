<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/inserisciEscursione.css">
<!-- Cambia Link! -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Inserisci Escursione</title>
</head>
<body>

	<span class="align-middle"> <%
 	Map<String, String> map = (Map) request.getAttribute("mappaErrori");
 %>

		<form method="POST" action="../utenteregistrato/home.jsp">
			<input type="submit" value="Home" />
		</form>

		<form method="POST" action="InserisciEscursioneServlet"
			onsubmit="return(validate());">
			<div class="container-fluid">
				<div class="row">
					<div class="well center-block">
						<div class="well-header">
							<h3 class="text-center text-success">Inserisci nuova
								escursione</h3>
							<hr>
						</div>

						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-map-marker"></i>
										</div>
										<input input type="text" name="luogo" class="form-control" placeholder="Luogo escursione"
											required>

									</div>
									<%
										if (map != null && map.containsKey("luogo")) {
									%>
									<div class="alert alert-danger" role="alert">
										<p><%=map.get("luogo")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-info-sign"></i>
										</div>
										<input type="text" name="tipo" class="form-control" placeholder="tipo: mare, montagna o lago" required>

									</div>
									<%
										if (map != null && map.containsKey("tipo")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("tipo")%></p>
									</div>
									<%
										}
									%>

								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-calendar"></i>
										</div>
										<%
											String pattern = "yyyy-MM-dd";
											SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
											String date = simpleDateFormat.format(new Date());
										%>

										<input type="date" name="dataEscursione" min="<%=date%>" class="form-control"
											required>

									</div>
									<%
										if (map != null && map.containsKey("dataEscursione")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("dataEscursione")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-time"></i>
										</div>
										<input type="number" name="durata" min="1" max="25" class="form-control" placeholder="Durata espressa in ore" required>

									</div>
									<%
										if (map != null && map.containsKey("durata")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("durata")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-info-sign"></i>
										</div>
										<input type="text" name="difficolta" class="form-control" placeholder="Difficolta: alta, media o bassa"required>
									</div>
									<%
										if (map != null && map.containsKey("difficolta")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("difficolta")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-euro"></i>
										</div>
										<input type="number" name="prezzo" class="form-control" placeholder="Prezzo escursione" required>

									</div>
									<%
										if (map != null && map.containsKey("prezzo")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("prezzo")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-user"></i>
										</div>
										<input type="text" name="guida" class="form-control" placeholder="Nome della guida" required>

									</div>
									<%
										if (map != null && map.containsKey("guida")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("guida")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-user"></i>
										</div>
										<input type="number" name="maxPartecipanti" class="form-control" placeholder="Numero massimo partecipanti" required>

									</div>
									<%
										if (map != null && map.containsKey("maxPartecipanti")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("maxPartecipanti")%></p>
									</div>
									<%
										}
									%>
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-info-sign"></i>
										</div>
										<textarea name="descrizione" class="form-control" placeholder="Descrizione escursione" required></textarea>

									</div>
									<%
										if (map != null && map.containsKey("descrizione")) {
									%>
									<div class="alert alert-danger" role="alert">
									<p><%=map.get("descrizione")%></p>
									</div>
									<%
										}
									%>

								</div>
							</div>
						</div>

						<div class="row widget">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<input type="hidden" name="contesto" value="registrazione" />
								<button class="btn btn-warning btn-block">Aggiungi</button>
							</div>
						</div>
					</div>
				</div>
			</div>


		</form>
	</span>


</body>
</html>