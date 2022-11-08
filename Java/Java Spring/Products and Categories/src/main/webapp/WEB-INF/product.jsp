<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <title> Product </title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <script type="text/javascript" src="js/app.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
<h1>Product</h1>
<a href="/">Home Page</a>
<div>
    <%--@elvariable id="product" type=""--%>
    <form:form action="/product/new" method="post" modelAttribute="product">
        <div>
        </div>
        <div>
            <form:label path="name">Name</form:label>
            <form:errors path="name"/>
            <form:input path="name"/>
        </div>
        <div>
            <form:label path="description">Description</form:label>
            <form:errors path="description"/>
            <form:input path="description"/>
        </div>
        <div>
            <form:label path="price">Price</form:label>
            <form:errors path="price"/>
            <form:input path="price" />
        </div>
        <input type="submit" value="Submit"/>
    </form:form>
</div>
</body>
</html>
