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
<%--    <link rel="stylesheet" href="style.css">--%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login And Registration</title>
</head>
<body>
<div style="display: block">
<h1>Welcome, ${currentUser.userName}</h1>
<div><a href="/logout">logout</a></div>
</div>
<div><a href="/books/new"> + add a to my shelf</a></div>
<div  class="form-group">
<table class="table">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Author</th>
        <th scope="col">Posted By</th>
        <th scope="col">Actions</th>

    </tr>
    </thead>
    <tbody>

    <c:forEach var="userNotborrow" items="${userNotborrow}">
    <c:if test="${userNotborrow.borrower.id != currentUser.id}">
        <tr>
            <td>${userNotborrow.id}</td>
            <td><a href="/book/${userNotborrow.id}">${userNotborrow.title}</a></td>
            <td>${userNotborrow.author}</td>
            <td>${userNotborrow.user.userName}</td>
            <td><a href="/borrow/${userNotborrow.id}">borrow</a></td>
            </c:if>
    </c:forEach>

    </tbody>
</table>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Title</th>
            <th scope="col">Author</th>
            <th scope="col">Posted By</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="userborrow" items="${userborrow}">
            <c:if test="${userborrow.borrower.id == currentUser.id}">
                <tr>
                    <td>${userborrow.id}</td>
                    <td><a href="/showbook/${userborrow.id}">${userborrow.title}</a></td>
                    <td>${userborrow.author}</td>
                    <td>${userborrow.borrower.userName}</td>
                    <td><a href="/book/${userborrow.id}/edit">edit</a></td>
                    <td><a href="/delete/${userborrow.id}">delete</a></td>
                </tr>
            </c:if>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>