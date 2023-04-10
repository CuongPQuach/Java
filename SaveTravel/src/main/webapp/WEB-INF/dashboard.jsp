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
		<div class="row">
			<div class="col-12">
			
			<h1> Expend DashBoard</h1>

			<table 	class="table table-hover">
			<thead>
				<tr>
					<th>Expend Name</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="expend" items="${expends}">
				<tr>
					<th><a href="/expend/detail/${expend.id}"><c:out value="${expend.expendname}"></c:out></a></th>	
					<th><c:out value="${expend.vendor}"></c:out></th>
					<th><c:out value="${expend.amount}"></c:out></th>
					<th class="d-flex justify-content-evenly"><a href="/expend/edit/${expend.id}">Edit</a>
					<form action="/expend/delete/${expend.id}" method="post">
					<input type="hidden" name="_method" value="delete"/>
					<input type="submit" value="Delete" />
					</form> 
					
					</th>
					
					

				</tr>
				</c:forEach>
			</tbody>
			
			</table>
			
			
			
			
			
			
			
			
			
			<div class="container">
				<form:form action="/create" method="POST" modelAttribute="expend">
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
						<form:input type="number" step="0.01" path="amount" class="form-control"></form:input>
					</div>
					<input type="submit" value="Add Expend" class="btn btn-primary"/>
				</form:form>
			
			</div>
			
			
			</div>
		
		</div>
	</div>
	
	
	
</body>
</html>