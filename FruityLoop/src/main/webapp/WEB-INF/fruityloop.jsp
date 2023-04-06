
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>


<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>


    
    
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>FruityLoops</title>
    </head>
<body>
    <h1>Welcome To The loop</h1>
    
    <div class="container">
     <h2> Fruit Store</h2>
     </div>
     <table class ="table"> 
     <tbody>
     <tr>
     	<th>Name</th>
     	<th>Price</th>
     </tr>
     
     
     <c:forEach var="fruit" items="${fruitsFromFruityloopController}">
     <tr>
     	<td><c:out value="${fruit.getName()}"></c:out></td>
     	<td><c:out value="${fruit.getPrice()}"></c:out></td>
     </tr>
     </c:forEach>
     
     
     
     </tbody>
     
     
     </table>
    
    
    
    
    
    
    
   

</body>
</html>
