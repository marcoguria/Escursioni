<%@page import="it.ats.modello.UtenteRegistrato"%>
<%@page import="it.ats.modello.CartaPagamento"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update profilo</title>

<link rel="stylesheet" type="text/css" href="../css/modificaProfilo.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

</head>
<body>

	<span class="align-middle" > <%
 	UtenteRegistrato utenteRegistrato = (UtenteRegistrato) request.getAttribute("utente");
 	Map<String, String> map = (Map) request.getAttribute("mappaErrori");
 %>

		<form method="POST" action="UpdateUtenteRegistratoServlet"
			onsubmit="return(validate());">
			<div class="container-fluid">
				<div class="row">
					<div class="well center-block">
						<div class="well-header">
							<h3 class="text-center text-success">Modifica il tuo profilo
							</h3>
							<hr>
						</div>

						<div class="row">
							<div class="col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-user"></i>
										</div>
										<input type="text" name="nome"
											value="<%=utenteRegistrato.getNome()%>" placeholder="nome">

									</div>
									<%
										if (map != null && map.containsKey("nome")) {
									%>
									<p><%=map.get("nome")%></p>
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
											<i class="glyphicon glyphicon-user"></i>
										</div>
										<input type="text" name="cognome"
											value="<%=utenteRegistrato.getCognome()%>"
											placeholder="cognome">

									</div>
									<%
										if (map != null && map.containsKey("cognome")) {
									%>
									<p><%=map.get("cognome")%></p>
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
											<i class="glyphicon glyphicon-list-alt"></i>
										</div>


										<input type="text" name="codf"
											value="<%=utenteRegistrato.getCodf()%>"
											placeholder="codice fiscale">

									</div>
									<%
										if (map != null && map.containsKey("codf")) {
									%>
									<p><%=map.get("codf")%></p>
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
											<i class="glyphicon glyphicon-envelope"></i>
										</div>
										<input type="email" name="email"
											value="<%=utenteRegistrato.getEmail()%>" placeholder="email">

									</div>
									<%
										if (map != null && map.containsKey("email")) {
									%>
									<p><%=map.get("email")%></p>
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
										<input type="date" name="dataNascita"
											value="<%=utenteRegistrato.getData_nascita()%>"
											placeholder="dataNascita">
									</div>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<div class="form-group">
									<div class="input-group">
										<div class="input-group-addon">
											<i class="glyphicon glyphicon-user"></i>
										</div>
										<input type="text" name="username"
											value="<%=utenteRegistrato.getUsername()%>"
											placeholder="username" readonly>

									</div>
									<%
										if (map != null && map.containsKey("username")) {
									%>
									<p><%=map.get("username")%></p>
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
											<i class="glyphicon glyphicon-lock"></i>
										</div>
										<input type="password" name="password" value="<%=utenteRegistrato.getPassword()%>">

									</div>
									<%
										if (map != null && map.containsKey("password")) {
									%>
									<p><%=map.get("password")%></p>
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
											<i class="glyphicon glyphicon-lock"></i>
										</div>
										<input type="password" name="conferma" value="<%=utenteRegistrato.getPassword()%>">

									</div>
									<%
										if (map != null && map.containsKey("conferma")) {
									%>
									<p><%=map.get("conferma")%></p>
									<%
										}
									%>
								</div>
							</div>
						</div>

						<div class="row widget">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<input type="hidden" name="contesto" value="modificaProfilo" class="btn btn-warning btn-block" />
								<button class="btn btn-warning btn-block" type=submit>Aggiorna</button>
								
								<input type=reset value="Reset" class="btn btn-classic btn-block">
									
							</div>
						</div>
					</div>
				</div>
			</div>


		</form>
	</span>

</body>
</html>