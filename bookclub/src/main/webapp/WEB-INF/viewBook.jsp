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
<title>View Book</title>
</head>
<body>
	<!-- Where The Main Page is -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-9">
				<h1 class="fs-1"><c:out value="${thisBook.tittle }"/></h1>
			</div>
			<div class="col">
				<p><a href="/allBooks">ALL Books</a> <a href="/logout">SignOut</a></p>
			</div>
		</div>
		<div class="row">
			<h4>
			 <c:out value="${thisBook.creator.username }"/>
			  Read <c:out value="${thisBook.tittle }"/> 
			  By <c:out value="${thisBook.author }"/> 
			 </h4 >
			  <p class="mb-4 mt-4 border border-top-10 border border-bottom-10">${thisBook.though }</p>	 
		</div>
		<c:if test="${loggedUser.id == thisBook.creator.id}">
		<div class="row">
			<p><a href="/books/${thisBook.id }/edit">Edit Book</a> </p>
			<form action="/Books/${thisBook.id }/delete" method="POST">
				<input type="hidden" name="_method" value="delete"/>
				<input type="submit" value="Delete Book" class="btn btn-danger" />
			</form>
		 </div>
		 </c:if>
	</div>
	
</body>
</html>