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
<h1></h1>
<a href="/showbook/${book.id}">back to the shelve</a>

<%--@elvariable id="book" type=""--%>
<form:form action="/books/${book.id}" method="post" modelAttribute="book">
<%--    <input type="hidden" name="_method" value="put">--%>

    <div>
        <form:label path="title">Title</form:label>
        <form:errors path="title"/>
        <form:input path="title"/>
    </div>
    <div>
        <form:label path="author">Author</form:label>
        <form:errors path="author"/>
        <form:input path="author"/>
    </div>
    <div>
        <form:label path="thought">Thought</form:label>
        <form:errors path="thought"/>
        <form:input path="thought" />
    </div>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
