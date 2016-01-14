 
 <!-- QUESTA LIBRERIA CONSENTE DI USARE IL tag 'c', UTILE PER I CICLI E ALTRO -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>
	
	<head>
		<title> HOME </title>	
				
		<!-- IMPORTO I CSS Bootstrap: -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">		
		<!-- AGGIUNGO IL RIFERIMENTO AL FILE CSS (percorso assoluto, dalla root...) -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/Stili_Ricette.css" />" />
	</head>
	
	
	<body>	
		<div class="container">  <!-- 'container' e una classe di stili di Bootstrap -->
			<div id="header">
				<h1> Home page </h1>
			</div>
			
			<div class="menu">
				<a href="ricettario/homericette"> Vai alla home ricette </a>
			</div>
		</div>
						
						
		<!-- INFINE INSERISCO LE LIBRERIE (ma inutili qui!) (qui in fondo cosi in caso di errori nel resto della pagina non le scarica prima):
		<!-- LIBRERIA Jquery (CON LINK DA GOOGLE): -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>		
		<!-- LIBRERIA Javascript DI Bootstrap: -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	</body>
	
</html>


