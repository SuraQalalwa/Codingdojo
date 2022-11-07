<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title>Dojo</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
<h1>New Dojo</h1>
<div>
<%--@elvariable id="dojo" type=""--%>
<form:form action="/dojos/new" method="post" modelAttribute="dojo">
    <div>
    <form:label path="name">Name</form:label>
    <form:input path="name"/>
    </div>
    <input type="submit" value="Submit"/>
</form:form>
</div>
</body>
</html>
