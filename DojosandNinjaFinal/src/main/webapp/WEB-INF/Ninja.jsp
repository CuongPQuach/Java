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
	<h1>Ninja Detail</h1>
	<table class="table table-hover">
	<thead>
	<tr>
		<th>Name</th>
		<th>Age</th>
		<th>Dojo</th>

	</tr>
	</thead>
	<tbody>
	<c:forEach var="ninja" items="${ninjas}">
	<tr>
		<th><c:out value="${ninja.firstname}"></c:out> <c:out value="${ninja.lastname}"></c:out></th>
		<th><c:out value="${ninja.ages}"></c:out></th>
		<th><c:out value="${ninja.dojo.dojoname}"></c:out></th>
	</tr>
	</c:forEach>
	</tbody>

	</table>
	
	
</div>		
	
	
	<div>
	<h1> New Ninja</h1>
	<div class="container">
				<form:form action="/ninja/create" method="POST" modelAttribute="ninja">
					<div>
					<form:select path="dojo.id">
					<c:forEach var="dojo" items="${dojos}">
						<option value="${dojo.id}" > <c:out value="${dojo.dojoname}"/></option>
					</c:forEach>					
					</form:select>
					
					</div>
					<div class="mb-2">
						<form:label path="firstname" class="form-label">First Name:</form:label>
						<form:errors path="firstname"/>
						<form:input type="text" path="firstname" class="form-control"></form:input>
					</div>
					<div class="mb-2">
						<form:label path="lastname" class="form-label">Last Name :</form:label>
						<form:errors path="lastname"/>
						<form:input type="text" path="lastname" class="form-control"></form:input>
					</div>
					<div class="mb-2">
						<form:label path="ages" class="form-label">Age:</form:label>
						<form:errors path="ages"/>
						<form:input type="number" path="ages" class="form-control"></form:input>
					</div>
					<input type="submit" value="Ninja Enroll" class="btn btn-primary"/>
				</form:form>
			
			</div>
	
	</div>	
	
	
	
	
</body>
</html>