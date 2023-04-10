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
	<div class="container">
		<h1><c:out value="${expend.expendname}"></c:out> Update:</h1>
		
		<div class="container">
				<form:form action="/expend/edit/${expend.id}" method="put" modelAttribute="expend">
					<div class="mb-2">
						<form:label path="expendname" class="form-label">Expend Name:</form:label>
						<form:errors path="expendname"/>
						<form:input type="text" path="expendname" class="form-control"></form:input>
					</div>
					<div class="mb-2">
						<form:label path="vendor" class="form-label">Vendor :</form:label>
						<form:errors path="vendor"/>
						<form:input type="text" path="vendor" class="form-control"></form:input>
					</div>
					<div class="mb-2">
						<form:label path="description" class="form-label">Description :</form:label>
						<form:errors path="description"/>
						<form:textarea path="description" rows="5" cols="30" class="form-control"></form:textarea>
					</div>
					<div class="mb-2">
						<form:label path="amount" class="form-label">Amount:</form:label>
						<form:errors path="amount"/>
						<form:input type="number" path="amount" class="form-control"></form:input>
					</div>
					<input type="submit" value="Update Expend" class="btn btn-primary"/>
				</form:form>
		
		
		
		
		</div>
	</div>	
</body>
</html>