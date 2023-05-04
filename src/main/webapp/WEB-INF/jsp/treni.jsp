<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page import="dto.TrenoDTO"%>

<!DOCTYPE html>
<html>

<head>
<style type="text/css">

<%@ include file = "Style.css"%>
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
  <a href="treni" id="user" href="/treno"><i class="fa-solid fa-user" style="color: #ffffff;"></i> ${username} </a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>


<h1>Lista Treni creati da ${username}</h1>


 ${sigla}
${trenoSigla}
  

 <%request.getSession().getAttribute("listaTreni");
 request.getSession().getAttribute("username");
 %>

</body>
</html>