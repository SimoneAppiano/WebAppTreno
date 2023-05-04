<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
		<%@ include file = "Style.css"%>
</style>

</head>
<body>
<div class="container-login">
<div class="main">  	
		<input type="checkbox" id="chk" aria-hidden="true">
			<div class="signup">
				<form method="GET" action="./register">
					<label for="chk" aria-hidden="true">Sign up</label>
					<input type="text" name="username" placeholder="Username" required="">
					
					<input type="password" name="password" placeholder="Password" required="">
					<button>Sign up</button>
				</form>
			</div>
			<div class="login" >
				<form method="GET" action="./login">
					<label for="chk" aria-hidden="true">Login</label>
					<input type="text" name="username" placeholder="username" required="">
					<input type="password" name="password" placeholder="Password" required="">
					<button>Login</button>
				</form>
			</div>
	</div>
</div>
</body>
</html>
