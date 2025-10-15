<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Library Management</title>
</head>
<body>
	<div class="fluid-container">
		<header class="text-center">
			<h1>Library Management System</h1>
		</header>
		<main>
			<div class="m-auto mt-5" style="width: 35%;">
				<form action="login" method="post">
					<div class="text-center">
						<h3>Login</h3>
					</div>
					<div class="form-floating mt-5">
						<input class="form-control" type="text" name="username"
							id="username" placeholder="uname"> <label for="username">Username</label>
					</div>
					<div class="form-floating border-top-0">
						<input class="form-control" type="password" name="password"
							id="passwd" placeholder="passwd"> <label for="passwd">Password</label>
					</div>
					<div class="text-center mt-2">
						<input class="btn btn-dark btn-lg" type="submit"
							value="Login">
					</div>
				</form>
			</div>
		</main>
	</div>
</body>
</html>