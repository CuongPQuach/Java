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
<title>Insert title here</title>
</head>
<body>
	<!-- Where The Main Page is -->
	<div>
	<div class="d-flex justify-content-between">
	<h1>Dojo Detail</h1>
	<h5><a href="/ninja/detail">Create Ninja</a></h5>
	</div>
	<table class="table table-hover">
	<thead>
	<tr>
	<th>Action</th>
	<th>Dojo Name</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="dojo" items="${dojos}">
	<tr>
	<th>
	<form action="/dojo/delete/${dojo.id}" method="post">
	<input type="hidden" name="_method" value="delete"/>
	<input type="submit" value="Delete" />
	</form>  </th>
	<th>
	<a href="/dojo/detail/${dojo.id}">
	<c:out value="${dojo.dojoname}"></c:out>
	</a>
	</th>
	</tr>
	</c:forEach>
	
	
	</tbody>
	</table>
	
	</div>
	
	<div>
	
	<div class="container">
		<div>
				<form:form action="/dojo/create" method="POST" modelAttribute="dojo">
					<div class="mb-2">
						<form:label path="dojoname" class="dojoname">Dojo Name:</form:label>
						<form:errors path="dojoname"/>
						<form:input type="text" path="dojoname" class="form-control"></form:input>
					</div>

					<input type="submit" value="New Dojo Establish" class="btn btn-primary"/>
				</form:form>
			
			</div>
	
	</div>
	
	
	</div>
</body>
</html>