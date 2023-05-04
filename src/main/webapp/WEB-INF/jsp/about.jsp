<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
		<%@ include file = "Style.css"%>
</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
<title>About</title>
</head>
<body>
<!--  navbar -->
<nav>
<div class="topnav" id="myTopnav">
  <a href="/ " class="active"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>
  <a href="treni">Lista treni</a>
  <a href="CreazioneTreno">Crea Treno</a>
  <a href="about">About</a>
  <a href="treni" id="user" href="/treno"><i class="fa-solid fa-user" style="color: #ffffff;"></i> ${username} </a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
<%request.getSession().setAttribute("username", request.getParameter("username")); %>
  
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
</script>
</nav>

<div class="container-login">
<div class="main-about">

<h3>About</h3>
<p>Questo progetto sviluppato con linguaggio Java e tecnologia Spring MVC, nasce allo scopo di testare e mettere in pratica gli argomenti affrontati durante il corso java Idm consulnting. In questo progetto in particolare sono utilizzate le seguenti tecnologie:

<ul>
<li>L’ambiente di sviluppo scelto e’ l’ IDE Eclipse molto utile per lo sviluppo con linguaggio Java</li>

<li>Server Tomcat versione 9.0 con l’aiuto di Eclipse</li>

<li>MySQL Workbench per lo sviluppo delle tabelle nel Database</li>

<li>HTML,CSS,Javascript per la parte Front End</li>

<li>Utilizzo di Maven per la gestione dei progetti dei vari file JAR</li>

<li>Framework Spring MVC  per la realizzazione del progetto Web</li>

<li>JPA per la gestione della persistenza dei dati sul database attraverso la rappresentazione e il mantenimento su database relazionale di un sistema di oggetti Java</li>
</ul>

Progetto creato da: Simone Appiano, Eleonora Pisacane, Antonio Badalamenti, Giovanni Ciotta. 
</p>
</div>
</div>



</body>
</html>