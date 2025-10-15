# BookNest - A library Management System

This project consists of two separate applications designed for managing books and authors in a library.
Overview:

Application 1 (Library Management Web Application): A Spring MVC and JSP-based web application that allows librarians to manage books. It provides a login interface for librarians, and once authenticated, they can view, add, update, and delete books. This application communicates with Application 2, which handles the data related to books and authors.

Application 2 (Book Management RESTful Service): A Spring Boot application that exposes RESTful web services to handle CRUD operations on books and authors. This service manages book and author data and allows Application 1 to interact with it via REST APIs.
