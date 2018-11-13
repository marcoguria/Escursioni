<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="it.ats.modello.Prenotazione"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mie escursioni</title>
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
	
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a href="#" class="navbar-brand">LE MIE <br> PRENOTAZIONI</a>
		<button class="navbar-toggler" data-target="#navigation"
			data-control="navigation" data-toggle="collapse">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navigation">
			<ul class="nav navbar-nav">
				<li class="nav-item active"><a href="../utenteregistrato/home.jsp" class="nav-link">Home</a>
				</li>
				
			</ul>
		</div>
	</nav>

	<%
		Collection<Prenotazione> prenotazioni = (Collection<Prenotazione>) request.getAttribute("prenotazioni");
	%>

	<%
		if (prenotazioni == null || prenotazioni.isEmpty()) {
	%>

	<p>Non esistono prenotazioni in archivio</p>

	<%
		} else {
	%>
	
	  <div class="container"> 
	  <%
				for (Prenotazione prenotazione : prenotazioni) {
						
			%>   
                <div class="jumbotron">
                  <div class="row">
                      <div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
                          <img src="https://www.svgimages.com/svg-image/s5/man-passportsize-silhouette-icon-256x256.png" alt="stack photo" class="img">
                      </div>
                      <div class="col-md-8 col-xs-12 col-sm-6 col-lg-8">
                          <div class="container" style="border-bottom:1px solid black">
                            <h2><%=prenotazione.getEscursione().getLuogo()%></h2>
                          </div>
                            <hr>
                          <ul class="container details">
                            <li><p><span class="glyphicon glyphicon-calendar" style="width:50px;"></span>Data escursione: <%=prenotazione.getEscursione().getData()%></p></li>
                            <li><p><span class="glyphicon glyphicon-info-sign" style="width:50px;"></span>Durata: <%=prenotazione.getEscursione().getDurata()%></p></li>
                            <li><p><span class="glyphicon glyphicon-map-marker one" style="width:50px;"></span>Luogo: <%=prenotazione.getEscursione().getLuogo()%></p></li>
                            <li><p><span class="glyphicon glyphicon-euro one" style="width:50px;"></span>Prezzo: <%=prenotazione.getEscursione().getPrezzo()%></p></a>
                          </ul>
                      </div>
                  </div>
                </div>

	<%
		}
	%>
	<%
		}
	%>


</body>
</html>