
<!-- QUESTA LIBRERIA CONSENTE DI USARE IL tag  c, UTILE PER I CICLI E ALTRO -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page session="false" %>

<!-- QUESTA ALTRA LIBRERIA PERMETTE DI EVITARE SCRITTURE DI CODICE COMPLESSE (mappando in qualche modo la classe Book) -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
		<link rel="stylesheet" type="text/css" href='<c:url value="/resources/CSS/Stili_Ricette.css"/>'/>
		
		<title> Nuova ricetta </title>
	</head>
	
	
	<body>
		<!-- TITOLO PAGINA: -->
		<div id="header">
			<h1> Form ricetta </h1>
		</div>
		
		
			<!-- <a class="pippo"> asas </a> -->
		
		
		<!-- PREDISPONGO IL FORM DI INSERIMENTO DI NUOVI Book: -->
				<!-- <form action="newcreatedbook" method="GET"> -->
				<!-- <form action="newcreatedbook" method="POST"> -->       
				
        <div class="formricetta">
		       					
			<form action="formricetta" method="POST" enctype="multipart/form-data" modelAttribute="ricetta">		 				
						
				<!-- CAMPO HIDDEN PER PASSARE L'id (e decidere se updatare o creare nuova ricetta) -->											
				<div>
					<input type="hidden" name="id" value="${ricetta.id}" />
				</div>				
				
				
			    <div> NOME: </div>
			    	<input type="text" style="width:500px;" name="title" value="${ricetta.nomeric}" required />
			    </br>
			    
			    <div> PREPARAZIONE: </div> 
			    	<!-- <input type="text" style="width:500px;" name="author" value="${ricetta.preparazione}" required /> -->
			    	<textarea cols="80" rows="10" name="description">${ricetta.preparazione}</textarea>
			    </br>
			    
			    <div> INGREDIENTI RICETTA: </div>
			    <div>
			       <select name="ricetta.">
			       	   <c:forEach var="publ" items="${publishers}">
			       	   	   <!-- METODO SENZA IL TAG 'form'   ---   UN PO PIU INTRICATO MA BASICO E CHIARO -->
			       	   	   <option value="${publ.id}" ${book.publisher.id == publ.id?"selected":""}> ${publ.name} </option>
			       	   </c:forEach>
				   </select>
				</div>
			    </br>
			    
			   	<div> CARICA IMMAGINE: </div>
					<input id="image" type="file" name="image" value="" />
				</br>
				</br>
				
				 		
				<!-- PULSANTE INVIO DATI INSERITI NEL FORM: -->
		        <div> 
		        	<input type="submit" style="width:200px;" value="INVIA" /> 
		        </div>			
			</form>
		</div>		
	</body>
	
</html>


