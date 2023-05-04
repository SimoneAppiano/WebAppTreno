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
<title>Home</title>
</head>
<body onload = myFunction1()>
<!--  navbar -->
<%request.getSession().setAttribute("username", request.getParameter("username"));
request.getSession().setAttribute("flag", request.getParameter("flag"));
String username;
username = request.getParameter("username");
boolean flag = true;
%>
<div class="topnav" id="myTopnav">
  <a href="#home" class="active"><i class="fa-solid fa-house" style="color: #ffffff;"></i></a>
  <template>
  <a href="treni">Lista treni</a>
  <a href="CreazioneTreno">Crea Treno</a>
  </template>
  <a id="user" href="Home"><i class="fa-solid fa-user" style="color: #ffffff;"></i> ${username} </a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
</div>
<a hidden = "true">
<input id="flag" name="prova" value="${flag}"></input>
</a>
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}
function myFunction1() {
	var flag = document.getElementById("flag").value;
	if (flag == 1) {
	var temp = document.getElementsByTagName("template")[0];
	  var clon = temp.content.cloneNode(true);
	  document.getElementById("myTopnav").appendChild(clon);
	}
	} 
</script>

</body>
</html>
