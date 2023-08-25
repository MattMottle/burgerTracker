<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Burger</title>
</head>
<body>
	<h1>Burger Name: ${burger.name}</h1>
	<h3>Restaurant: ${burger.restaurant}</h3>
	<h3>Rating: ${burger.rating}</h3>
	<h3>Notes: ${burger.notes}</h3>
	<a href="http://localhost:8080/">All Burgers</a>
</body>
</html>