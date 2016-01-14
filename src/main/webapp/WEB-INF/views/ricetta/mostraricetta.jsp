
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<html>

	<head>
		<title> Ricetta </title>
	</head>
	
	
	<body>
		<div id="header">
			<h1> Ecco la ricetta </h1>
		</div>
			
		<!-- PULSANTE TORNA A HOME RICETTE -->
		<div> <a href= "/ricette/"> Torna alla home ricette </a> </div>
		
		</br>
		
		<div class="formlibri">
			<div> NOME: </div>
		    <div> ${ricetta.nomeric} </div>
		    </br>
		    </br>
		    <div> PREPARAZIONE: </div>
		    <div> ${ricetta.preparazione} </div>
		    </br>
		    </br>
		    <div> INGREDIENTI RICETTA (lista): </div>
		    <!-- <div> ${ricetta} </div> -->
		    </br>
		    </br>
		    <!-- <div> DOSI: </div>
		    <div> ${ricetta} </div>
		    </br>
		    </br> -->
		    		    			
			<div> IMMAGINE DI PRESENTAZIONE RICETTA </div>
			<!-- Vedere come fare l'upload dell'immagine ecc -->
		</div>		
	</body>

</html>
