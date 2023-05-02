<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
<%@ include file = "Style.css"%>
</style>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  navbar -->
<div class="topnav" id="myTopnav">
  <a href="#home" class="active"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>
  <a href="treni">Lista treni</a>
  <a href="CreazioneTreno">Crea Treno</a>
  <a href="#about">About</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
<%request.getSession().setAttribute("username", request.getParameter("username")); %>
  Ciao ${username}
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
<h1>Pagina Principale</h1>

</body>
</html>
