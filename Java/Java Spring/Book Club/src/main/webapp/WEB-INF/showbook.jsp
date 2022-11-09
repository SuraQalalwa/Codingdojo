<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login And Registration</title>
</head>
<body>
<a href="/home">Dashboard</a>
<div class="form-group">
    <h1>${thisbook.title}</h1>
    <h5>${thisbook.user.userName} read ${thisbook.title} by ${thisbook.author}</h5>
    </div>
    <h6>Here are ${thisbook.user.userName} thought: </h6>
<div>
    <p>${thisbook.thought} </p>

</div>
<a href="/books/${thisbook.id}/edit">Edit</a>
<a href="/delete/${thisbook.id}">Delete</a>
</body>
</html>
