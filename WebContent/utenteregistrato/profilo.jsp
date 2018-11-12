<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="../css/profilo.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<title>Profile</title>
</head>
<body>
        <nav class="navbar navbar-default" role="navigation">
    	  <div class="container">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-brand-centered">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <div class="navbar-brand navbar-brand-centered">Profilo</div>
		    </div>

		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="navbar-brand-centered">
		      <ul class="nav navbar-nav">
		        <br> <li><form method="GET" action="home.jsp">
 	 <div class="btn-group" role="group"><button class="" type="submit">Home</button></div>
	</form>  <br> </li> 
		        
		      </ul>
		      <ul class="nav navbar-nav navbar-right">
		         <br> <li><form method="GET" action="LogoutServlet">
		 <div class="btn-group" role="group"><button class="" type="submit">Logout</button></div>
	</form></li>
		        
		        
                  </ul>
              
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>

           


  <!--  <form method="GET" action="home.jsp">
 	 <div class="btn-group" role="group"><button class="" type="submit">Home</button></div>
	</form>
	
	<form method="GET" action="LogoutServlet">
		 <div class="btn-group" role="group"><button class="" type="submit">Logout</button></div>
	</form>
	
	-->

	<%
		if ((int) request.getSession().getAttribute("ruolo") == 1) {
	%>

	<form method="POST" action="../cliente/VisualizzaMiePrenotazioniServlet">
		<input type="submit" value="Visualizza mie prenotazioni" />
	</form>
	
	<form method="POST" action="../cliente/VisualizzaCarteDaEliminareServlet">
		<input type="submit" value="Le mie carte" />
	</form>


	<%
		}
	%>


	<form method="POST" action="GetMyProfileServlet">
		<input type="submit" value="Modifica Profilo" />
	</form>

	
	


</body>
</html>