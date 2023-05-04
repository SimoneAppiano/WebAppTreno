<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
<%@
include file="Style.css"%>
</style>
<title>Insert title here</title>
</head>
<body>

	<h1>Costruisci il tuo treno</h1>
	<div class="form">
		<form method="GET" action="./costruisci">
			<input type="text" name="sigla">
			<button type="submit" value="Costruisci">Costruisci Treno</button>
			<%
			request.getSession().getAttribute("username");
			%>
		</form>

		<div class="treno">
			<h4>Inserire:</h4>
			<p>
				<strong>H</strong> per Locomotiva - <strong>P</strong> per
				Passeggeri - <strong>R</strong> per Ristorante - <strong>C</strong>
				per Cargo
			</p>
		</div>
		<ul>

			<li>Il Treno deve necessariamente iniziare con una Locomotiva
				'H'</li>
			<li>Il Treno non puo' contenere sia vagoni Cargo sia vagoni
				Passeggeri</li>
			<li>Il Treno non puo' contenere sia vagoni Cargo sia vagoni
				Ristorante</li>
			<li>Ci puo' essere un solo vagone Ristorante e non puo' essere
				posizionato al fondo</li>

		</ul>
	</div>
		<div class="treno">
			<h3>${sigla}
				<span class="errore">${errore}</span>
			</h3>
			${trenoSigla}
		</div>

</body>
</html>