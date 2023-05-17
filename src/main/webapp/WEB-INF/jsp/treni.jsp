<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="dto.TrenoDTO"%>
<%@page import="dao.TrenoDao"%>
<!DOCTYPE html>
<html>

<head>

<style type="text/css">

<%@ include file = "Style.css" %>

</style>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
<meta charset="UTF-8">
<title>Lista Treni ${username}</title>
</head>
<body>
<!--  navbar -->
<nav>
<div class="topnav" id="myTopnav">

  <a href="Menu" class="active"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>

  <a href="treni">Lista treni</a>
  <a href="CreazioneTreno">Crea Treno</a>
  <a href="about">About</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
  <div class="dropdown">
  <a class="dropbtn" href="#"> <i class="fa-solid fa-user" style="color: #ffffff;"></i> ${username}</a> 
  
  <div class="dropdown-content">
 	<a href="Home">Cambio Utente</a>
	<a href="logout">Logout</a>
  </div>
</div>
</div>


<h1>Lista Treni creati da ${username}</h1>
<div>
  <form action="treni" method="post">
    <select id="select_type" name="filtro">
      <option value="null">Tutti</option>
      <option value="TN">Trenord</option>
      <option value="FR">Frecciarossa</option>
    </select>
    <button type="submit">Applica filtro</button>
  </form>
</div>

<div class="lista_treni">


 <% 
 List<TrenoDTO> listaTreni = (List<TrenoDTO>) request.getSession().getAttribute("listaTreni");
 String filtro = request.getParameter("filtro");
 System.out.println(filtro);
 for (TrenoDTO t : listaTreni){ 
	 
	if (t.getUtente().getUsername().equals(request.getSession().getAttribute("username"))) {
		if (filtro == null || filtro.equals("null") || (t.getTipo() != null && t.getTipo().equals(filtro))){%>
	   <div class="scheda">
 		<h3> <%= t.getSigla() %> </h3>
	 	<% if (t.getTipo() == null) {
			for (int i = 0; i < t.getSigla().length(); i++) {
				switch (t.getSigla().charAt(i)) {
				case 'H':%>
					<img class='main-treno' src='./img/locomotivaV.png' width='150'>
				<%	break;
				case 'P': %>
					<img class='main-treno' src='./img/passeggeriV.png' width='150'>
				<%	break;
				case 'R':  %>
					<img class='main-treno' src='./img/ristoranteV.png' width='150' >
				<% break;
				case 'C':  %>
					<img class='main-treno' src='./img/cargoV.png' width='150'>
				<%	break;
				} 
			}
			}
	 	if ("TN".equals(t.getTipo())) {
			for (int i = 0; i < t.getSigla().length(); i++) {
				switch (t.getSigla().charAt(i)) {
			case 'H':%>
				<img class='main-treno' src='./img/locomotiva.png' width='150'>
			<%	break;
			case 'P': %>
				<img class='main-treno' src='./img/passeggeri.png' width='150'>
			<%	break;
			case 'R':  %>
				<img class='main-treno' src='./img/ristorante.png' width='150' >
			<% break;
			case 'C':  %>
				<img class='main-treno' src='./img/cargo.png' width='150'>
			<%	break;
			} 
		}
		}
		else if ("FR".equals(t.getTipo())) {
			for (int i = 0; i < t.getSigla().length(); i++) {
		
			switch (t.getSigla().charAt(i)) {
			case 'H':%>
				<img class='main-treno' src='./img/locomotivaFR.png' width='150'>
			<%	break;
			case 'P': %>
				<img class='main-treno' src='./img/passeggeriFR.png' width='150'>
			<%	break;
			case 'R':  %>
				<img class='main-treno' src='./img/ristoranteFR.png' width='150' >
			<% break;
			case 'C':  %>
				<img class='main-treno' src='./img/cargoFR.png' width='150'>
			<%	break;
			}	
		}
		}	
 	
 	%> 
 	
 	<p>Peso: <%= t.getPeso() %> </p>
<p>Tipo: 
    <% if (t.getTipo() == null) { %> 
        Non specificato
    <% } else if ("FR".equals(t.getTipo())) { %> 
        Frecciarossa
    <% } else if ("TN".equals(t.getTipo())) { %>
        Trenord
    <%
     }%>
</p>

<form action='elimina'>
<input class='elimina' type='submit' value='Elimina'>
<input type='hidden' name='id' value= <%= t.getId()%> >
</form>

 <% 
 }
 } 
 }%>



</div>

 </div> 

</body>
</html>