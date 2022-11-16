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
    <title>Project Manager</title>
</head>
<body>
<%--@elvariable id="newUser" type=""--%>
<form:form action="/register" method="post" modelAttribute="newUser">
    <h1>Registration</h1>
    <div class="form-group">
        <form:label path="userName">User Name: </form:label>
        <form:input path="userName"/>
        <form:errors path="userName"/>
        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>

    <div class="form-group">
        <form:label path="email">Email: </form:label>
        <form:input path="email"/>
        <form:errors path="email"/>
    </div>

    <div class="form-group">
        <form:label path="password">Password: </form:label>
        <form:input type="password" path="password"/>
        <form:errors path="password"/>
    </div>

    <div class="form-group">
        <form:label path="confirm">Confirm PW: </form:label>
        <form:input type="password" path="confirm"/>
        <form:errors path="confirm"/>
    </div>
    <input type="submit" value="Registration" class="btn btn-primary">
</form:form>

<%--@elvariable id="newLogin" type=""--%>
<form:form action="/login" method="post" modelAttribute="newLogin">
    <h1>Log In</h1>
    <div class="form-group">
        <form:label path="email">Email: </form:label>
        <form:input path="email"/>
        <form:errors path="email"/>
        <small  class="form-text text-muted">We'll never share your email with anyone else.</small>
    </div>
    <div class="form-group">
        <form:label path="password">Password: </form:label>
        <form:input type="password" path="password"/>
        <form:errors path="password"/>
    </div>
    <input type="submit" value="Log In" class="btn btn-primary">
</form:form>
</body>
</html>
