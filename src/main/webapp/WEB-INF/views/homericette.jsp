 
 <!-- QUESTA LIBRERIA CONSENTE DI USARE IL tag 'c', UTILE PER I CICLI E ALTRO -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<html>
	
	<head>
		<title> Home Ricettario </title>
		
			<!-- IMPORTO I CSS Bootstrap VIA LINK (cosi funzionano solo se c'e rete pero!): -->
			<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> -->
		
		<!-- IMPORTO I CSS Bootstrap LOCALMENTE: -->		
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/Bootstrap/dist/css/bootstrap.css" />" />		
		
			<!-- <link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/bootstrap-theme.css" />" /> -->	
			<!-- <link rel="stylesheet" href="{{asset('/resources/CSS/bootstrap-theme.min.css')}}">
			<link href="{{ URL::to('/resources/CSS/bootstrap.min.css') }}" media="screen" rel="stylesheet"> -->
				
		<!-- AGGIUNGO IL RIFERIMENTO AL MIO FILE CSS: -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/Stili_Ricette.css" />" />
		
		<!-- AGGIUNGO IL RIFERIMENTO AL FILE DI FONTS...: -->
		
	</head>
	
	
	<body>
		<!-- TITOLO PAGINA: -->
		<div id="header">
			<h3> RICETTARIO </h3>
		</div>
				
				<!-- CREO UN LINK CHE PUNTA A UNA PAGINA/FORM PER CREAZIONE DI NUOVE RICETTE: -->
				<!-- <div class="menu">
					<a class="creanuovaricetta" href="formricetta"> Aggiungi nuova ricetta </a>
				</div> -->
		
		</br>
		
		
		<!-- PRESENTO TUTTE LE RICETTE PRESENTI NELLA TABELLA ricette DEL DB: -->
		<div class="content">
			<ul class="list-unstyled" id="ricettelist">  <!-- associo un id per identificarlo via jQuery... -->
			
			<!-- USO GLI OGGETTI ricetta PASSATI DAL CONTROLLER E VISUALIZZO CIO CHE MI SERVE -->
			<c:forEach var="ricet" items="${ricettecollection}">
				<li>
						<!-- <a href= "ricetta/${ricet.id}"> ${ricet.id} </a> -->
					<a href= "ricetta/${ricet.id}"> ${ricet.nomeric} </a>  <!-- richiamo per id ma mostro per nomeric... -->
									
					<!-- <a href= "/admin/delete/${ricet.id}"> <button type="button" class="btn btn-default" aria-label="Left Align"> <span class=" glyphicon glyphicon-trash"></span> </button> </a>
					<a href= "/admin/edit/${ricet.id}"> <button type="button" class="btn btn-default" aria-label="Left Align"> <span class=" glyphicon glyphicon-pencil"></span> </button> </a> -->
				</li>
			</c:forEach>
			</ul>
		</div>
		
		
		<!-- INFINE AGGIUNGO IL RIFERIMENTO AI FILE jQuery (importa solo se serve nella pagina!): -->
		<!-- <script src="js/bootstrap.min.js"> </script> -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"> </script>	
	</body>
	
</html>


