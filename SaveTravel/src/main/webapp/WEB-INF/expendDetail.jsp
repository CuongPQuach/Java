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
	<div>
		<div>
		<h1>Expend Details</h1>
		<h2><a href="/expends">Go Back</a></h2>
		</div>
		<h3>Expend Name: <c:out value="${expend.expendname}"></c:out></h3>
		<h3>Vendor Name: <c:out value="${expend.vendor}"></c:out></h3>
		<h3>Description: <c:out value="${expend.description}"></c:out></h3>
		<h3>Amount: <c:out value="${expend.amount}"></c:out></h3>		
		
	</div>


	<!-- Where The Main Page is -->
</body>
</html>