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
<title> Edit ${editBook.tittle }</title>
</head>
<body>
	<!-- Where The Main Page is -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-9">
				<h1 class="fs-1">Edit <c:out value="${editBook.tittle }"/></h1>
			</div>
			<div class="col">
				<p><a href="/allBooks">ALL Books</a> <a href="/logout">Sign Out</a></p>
			</div>
		</div>
		<div class="row">
		<form:form action="/books/${editBook.id }/edit" method="POST" modelAttribute="editBook">
			<input type="hidden" name="_method" value="PUT"/>
			<div class="row my-4">
				<form:label path="tittle" class="col-2">Tittle: </form:label>
				<form:input path="tittle" class="col-3"/>
				<form:errors path="tittle" class="text-danger offset-2"/>
			</div >	
			<div class="row my-4">
				<form:label path="Author" class="col-2">Author: </form:label>
				<form:input path="Author" class="col-3"/>
				<form:errors path="Author" class="text-danger offset-2"/>
			</div>
			<div class="row my-4">
				<form:label path="though" class="col-2">Tittle: </form:label>
				<form:textarea path="though" class="col-3"/>
				<form:errors path="though" class="text-danger offset-2"/>
			</div>
			<form:input type="hidden" path="creator" value="${loggedUser.id }"/>
			<div >
				<input type="submit" value="Edit Book" class="btn btn-primary"/>
			</div>
		</form:form>
		</div>
	</div>
</body>
</html>