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
<title>Book Listing</title>
</head>
<body>
	<header class="text-center">
		<nav class="navbar navbar-light bg-light">
			<div class="container-fluid">
				<h1>Library Management System</h1>
				<div class="d-flex">
					<form action="" method="post">
						<span>Hi <c:out value="${session.username}" /> </span> <input class="btn btn-sm btn-outline-secondary"
							type="submit" value="Logout">
					</form>
				</div>
			</div>
		</nav>
	</header>
	<div class="container">
		<main>
			<div class="text-center">
				<h2>Book Listing</h2>
			</div>
			<form action="addBookForm" method="post">
			<input class="btn btn-primary" type="submit" value="Add a Book">
			</form>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Book Code</th>
						<th>Book Name</th>
						<th>Author</th>
						<th>Date Added</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${requestScope.bookList}" var="book">
						<tr>
							<td><c:out value="${book.bookCode}" /></td>
							<td><c:out value="${book.bookName}" /></td>
							<td><c:out value="${book.author}" /></td>
							<td><c:out value="${book.dateAdded}" /></td>
							<td>
								<form action="edit/${book.bookCode}" method="post">
									<input class="btn btn-link" type="submit" value="edit">
								</form>
								<form action="delete/${book.bookCode}" method="post">
									<input class="btn btn-link" type="submit" value="delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</div>
</body>
</html>