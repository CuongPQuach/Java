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
<title>Dojo Detail</title>
</head>
<body>
	<!-- Where The Main Page is -->
	<div>
		<h1><c:out value="${dojo.dojoname}"></c:out></h1>
		<div class="container">
		<h1><c:out value="${dojo.dojoname}"></c:out> Update:</h1>
		
		<div class="container">
				<form:form action="/dojo/edit/${dojo.id}" method="put" modelAttribute="dojo">
					<div class="mb-2">
						<form:label path="dojoname" class="form-label">Dojo Name:</form:label>
						<form:errors path="dojoname"/>
						<form:input type="text" path="dojoname" class="form-control"></form:input>
					</div>
					
					<input type="submit" value="Update Dojo" class="btn btn-primary"/>
				</form:form>								
		</div>
		</div>	
		</div>
	<div>
		<h2>Dojo Ninja Detail</h2>
		<table class="table table-hover">
			<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>			
			</thead>
			<tbody>
			<c:forEach var="ninja" items="${Ninjas}">
			<tr>
				<th><c:out value="${ninja.firstname }"></c:out></th>
				<th><c:out value="${ninja.lastname }"></c:out></th>
				<th><c:out value="${ninja.ages }"></c:out></th>
			</tr>
			</c:forEach>
			</tbody>
		
		
		</table>
		
			

	</div>


</body>
</html>