<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/registrazione.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Registrazione</title>
</head>
<body>

	<span class="align-middle"> <%
 	Map<String, String> map = (Map) request.getAttribute("mappaErrori");
 %>

		<form action="RegistrazioneServlet" name="registrazione" method="post"
			onsubmit="return(validate());">
			<div class="container-fluid">
				<div class="row">
					<div class="well center-block">
						<div class="well-header">
							<h3 class="text-center text-success">Benvenuto, registrati!
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
										<input type="text" placeholder="nome" name="nome"
											class="form-control" required>

									</div>
									<%
										if (map != null && map.containsKey("nome")) {
									%>
									<div class="alert alert-danger" role="alert">
										<%=map.get("nome")%>
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
											<i class="glyphicon glyphicon-user"></i>
										</div>
										<input type="text" placeholder="cognome" name="cognome"
											class="form-control" required>

									</div>
									<%
										if (map != null && map.containsKey("cognome")) {
									%>
									<div class="alert alert-danger" role="alert">

										<%=map.get("cognome")%>
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
											<i class="glyphicon glyphicon-list-alt"></i>
										</div>
										<textarea class="form-control" name="codf"
											placeholder="Codice Fiscle" required></textarea>

									</div>
									<%
										if (map != null && map.containsKey("codf")) {
									%>
									<div class="alert alert-danger" role="alert">
										<%=map.get("codf")%>
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
											<i class="glyphicon glyphicon-envelope"></i>
										</div>
										<input type="email" class="form-control" name="email"
											placeholder="E-Mail" required>

									</div>
									<%
										if (map != null && map.containsKey("email")) {
									%>
									<div class="alert alert-danger" role="alert">
										<%=map.get("email")%>
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
										<input type="date" name="dataNascita"
											placeholder="Data di nascita" class="form-control"
											id="datepicker" min="1920-01-01" max="2000-01-01" required>
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
										<input type="text" minlength="2" maxlength="20"
											class="form-control" name="username" placeholder="Username"
											required>

									</div>
									<%
										if (map != null && map.containsKey("username")) {
									%><div class="alert alert-danger" role="alert">
										<%=map.get("username")%>
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
											<i class="glyphicon glyphicon-lock"></i>
										</div>
										<input type="password" minlength="8" maxlength="20"
											placeholder="Password" name="password" class="form-control"
											required>

									</div>
									<%
										if (map != null && map.containsKey("password")) {
									%>
									<div class="alert alert-danger" role="alert">
										<%=map.get("password")%></div>
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
										<input type="password" minlength="8" maxlength="20"
											placeholder="Conferma password" name="conferma"
											class="form-control" required>
										
									</div>
									<%
											if (map != null && map.containsKey("conferma")) {
										%>
										<div class="alert alert-danger" role="alert">
										<%=map.get("conferma")%></div>
										<%
											}
										%>
								</div>
							</div>
						</div>

						<div class="row widget">
							<div class="col-md-12 col-xs-12 col-sm-12">
								<input type="hidden" name="contesto" value="registrazione" />
								<button class="btn btn-warning btn-block">Registrati</button>
							</div>
						</div>
					</div>
				</div>
			</div>


		</form>
	</span>

</body>
</html>