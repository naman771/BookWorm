<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>IAdd Book Details</title>
</head>
<body>
	<div class="container-fluid">
		<header class="text-center">
			<h1>Library Management System</h1>
			<nav></nav>
		</header>
		<main>
			<div class="text-center">
				<h2>Add a book</h2>
			</div>
			<form action="add" method="post">
				<div class="ms-5">
					<div class="mb-3">
						<label class="col-3" for="bookCode">Book Code</label> <input
							type="number" name="bookCode">
					</div>
					<div class="mb-3">
						<label class="col-3" for="bookName">Book Name</label>
						<input type="text" name="bookName">
					</div>
					<div class="mb-3">
						<label class="col-3" for="author">Author</label>
						<select name="author">
							<c:forEach items="${requestScope.authorList }" var="author">
								<option value="${author.name}"><c:out value="${author.name}"/></option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label class="col-3" for="dateAdded">Date Added</label>
						<input type="text" id="createdDate" readonly>
					</div>
				</div>
				<div class="text-center">
					<input class="btn btn-primary" type="submit" value="Add Book">
				</div>
			</form>
		</main>
	</div>
	<script type="text/javascript">
		var today = new Date();
		var year = today.getFullYear();
		var month = today.getMonth()+1;
		var date = today.getDate();
		var currentDate = year + "-" + month + "-" + date;
		document.getElementById("createdDate").value = currentDate;
	</script>
</body>
</html>