 
 <!-- QUESTA LIBRERIA CONSENTE DI USARE IL tag 'c', UTILE PER I CICLI E ALTRO -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
	
	<head>
		<title> Buy Book </title>
		
		<!-- IMPORTO I CSS Bootstrap: -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
		
		<!-- AGGIUNGO IL RIFERIMENTO AL FILE CSS -->
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/CSS/style.css" />" />
	</head>
		
	
	<body>	
		<div id="header">
			<a href="book/buybook"> <h3> BUY BOOK: add to chart </h3> </a>
		</div>		
	</body>
	
</html>


