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
	<div class="container-fluid">
		<h1>Welcome to the Group!</h1>
		<div class="row">
			<div class="col">
				<h3 class="fs-3">Register</h3>
				<form:form action="/register" method="POST" modelAttribute="registerUser">
					<div class="row my-4">
						<form:label path="username" class="col-3">UserName:</form:label>
						<form:input path="username" class="col-8"/>
						<form:errors path="username" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="email" class="col-3">Email:</form:label>
						<form:input type="email" path="email" class="col-8"/>
						<form:errors path="email" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="password" class="col-3">Password:</form:label>
						<form:password path="password" class="col-8"/>
						<form:errors path="password" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="confirm" class="col-3">Confirm Password:</form:label>
						<form:password path="confirm" class="col-8"/>
						<form:errors path="confirm" class="text-danger offset-3"/>
					</div>
					<div>
						<input type="submit" class="btn btn-primary offset-3 col-3" value="Register"/>
					</div>
				</form:form>
			</div>
			<div class="col">
				<h3 class="fs-3">User Login</h3>
				<form:form action="/login" method="POST" modelAttribute="loginUser">
				<div class="row my-4">
						<form:label path="email" class="col-3">Email:</form:label>
						<form:input type="email" path="email" class="col-8"/>
						<form:errors path="email" class="text-danger offset-3"/>
					</div>
					<div class="row my-4">
						<form:label path="password" class="col-3">Password:</form:label>
						<form:password path="password" class="col-8"/>
						<form:errors path="password" class="text-danger offset-3"/>
					</div>
					<div class="row">
					<input type="submit" class="btn btn-primary offset-3 col-3" value="Sign In"/>
					</div>
				</form:form>
			</div>
		</div>	
	</div>
</body>
</html>