<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Formating Date -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- Formating Form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!-- For rendering out put with Errors -->
<%@ page isErrorPage="true" %>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
</head>
<body>
	<!-- Where The Main Page is -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-9">
			<h1>Welcome ${loggedUser.username }</h1>
			</div>
			<div class="col-1">
				<p><a href="/myBooks"> Your Book </a> <a href="/logout">SignOut</a></p>				
			</div>
			</div>
		<div class="row">
			<div class="fs-1"> <h3> All Books</h3></div>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Id</th>
						<th>Tittle</th>
						<th>Author</th>
						<th>Posted By</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="thisBook" items="${allBooks }">
					<tr>
						<td><c:out value="${thisBook.id }"/></td>
						<td><a href="/Book/${thisBook.id}"><c:out value="${thisBook.tittle }"/></a></td>
						<td><c:out value="${thisBook.though }"/></td>
						<td><c:out value="${thisBook.creator.username }"/></td>							
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="row">
			<p> <a href="/books/new"> Add New Book</a> </p>
		</div>
		
	</div>
</body>
</html>