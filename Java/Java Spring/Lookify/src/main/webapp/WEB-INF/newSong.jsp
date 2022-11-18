<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<h1>Add Song</h1>
<table class="table col-6">
    <%--@elvariable id="song" type=""--%>
    <form:form action="/songs/new" method="post" modelAttribute="song">
        <div>
            <form:label path="title">Name</form:label>
            <form:errors path="title"/>
            <form:input path="title"/>
        </div>
        <div>
            <form:label path="artist">Creator</form:label>
            <form:errors path="artist"/>
            <form:input path="artist"/>
        </div>
        <div>
            <form:label path="rating">Rating</form:label>
            <form:errors path="rating"/>
            <form:input class="input" type="number" path="rating"/>
        </div>
        <input type="submit" value="Add Song"/>
    </form:form>
</table>
</body>
</html>
