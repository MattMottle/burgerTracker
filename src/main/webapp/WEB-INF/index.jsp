<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger Tracker</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container"> 
		<h1>Burger Tracker</h1>
		<table class="table table-striped">
		  <thead>
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Restaurant</th>
		      <th scope="col">Rating (out of 5)</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach var="burger" items="${burgers}">
			    <tr>
			      <td><a href="http://localhost:8080/${burger.id}"><c:out value="${burger.name}"/></a></td>
			      <td><c:out value="${burger.restaurant}"/></td>
			      <td><c:out value="${burger.rating}"/></td>
			    </tr>
			</c:forEach>
		  </tbody>
		</table>
		<h3>Add a Burger:</h3>
		<div class="form">
			<form:form action="/process" method="post" modelAttribute="burger">
				<div style="color: red;"><form:errors path="name"/></div>
				<div style="color: red;"><form:errors path="restaurant"/></div>
				<div style="color: red;"><form:errors path="rating"/></div>
				<div style="color: red;"><form:errors path="notes"/></div>
				<p>
			        <form:label path="name">Name:</form:label>
			        <form:input path="name"/>
			    </p>
			    <p>
			        <form:label path="restaurant">Restaurant:</form:label>
			        <form:input path="restaurant"/>
			    </p>
			    <p>
			        <form:label path="rating">Rating:</form:label>
			        <form:input type="number" path="rating"/>
			    </p>
			    <p>
			        <form:label path="notes">Notes</form:label>
			        <form:textarea path="notes"/>     
			    </p>    
			    <button>Submit</button>
			</form:form>
		</div>   
	</div>
</body>
</html>