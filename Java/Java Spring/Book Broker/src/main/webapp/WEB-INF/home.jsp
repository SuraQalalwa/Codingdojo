<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Main Page</title>
</head>
<body>
<h1>Welcome, <span>${currentUser.userName}</span></h1>
<h2>Available Books to Borrow</h2>
<table class="table table-striped mx-auto mt-2">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Title</th>
        <th scope="col">Author Name</th>
        <th scope="col">Owner</th>
        <th scope="col">Actions</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${notBorrowed}">
        <tr>

            <td>${book.id}</td>
            <td><a href="/books/${book.id}">${book.title}</a></td>
            <td>${book.author}</td>
            <td>${book.postedby.userName}</td>
            <c:choose>
            <c:when test="${book.postedby.id == currentUser.id}">
                <td><a href="/edit/${book.id}">edit</td>
                <td><a href="/delete/${book.id}">delete</td>
            </c:when>
            <c:otherwise>

                <td><a href="/borrow/${book.id}">borrow</td>

            </c:otherwise>
            </c:choose>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table class="table table-striped mx-auto mt-2">
    <thead>
    <tr>
        <th scope="col">ID</th>
        <th scope="col">Title</th>
        <th scope="col">Author Name</th>
        <th scope="col">Owner</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
        <c:if test="${currentUser.id == book.borrowedby.id}">
            <tr>
                <td>${book.id}</td>
                <td><a href="/books/${book.id}">${book.title}</a></td>
                <td>${book.author}</td>
                <td>${book.postedby.userName}</td>
                <td>
                    <a href="/return/${book.id}">Return</a>
                </td>
            </tr>
        </c:if>
    </c:forEach>
    </tbody>
</table>
<a href="/logout">Log Out</a>
<a href="/books/new">Add to Shelf</a>
</body>
</html>
