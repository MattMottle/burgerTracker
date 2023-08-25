<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
    <%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Burger</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
	<h1>Edit Burger</h1>
		<div class="form">
				<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
				 <input type="hidden" name="_method" value="put">
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
				    <button class="button">Submit</button>
				</form:form>
			</div>
		<a href="http://localhost:8080/">Home</a>
		</div>   
</body>
</html>