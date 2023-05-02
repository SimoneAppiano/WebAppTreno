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
<meta charset="UTF-8">
<title>Lista Treni ${username}</title>
</head>
<body>
<h1>Lista Treni creati da ${username}</h1>

 ${sigla}
${trenoSigla}
 <%request.getSession().getAttribute("listaTreni");%>
</body>
</html>