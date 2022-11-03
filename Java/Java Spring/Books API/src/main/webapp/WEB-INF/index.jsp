<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="/style.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<%--    <script type="text/javascript" src="js/app.js"></script>--%>
</head>
<body>
<h1>All Books</h1>
<table class="table col-6">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Language</th>
        <th>Number of Pages</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach var="book" items="${books}">
    <tr>
        <td><c:out value="${book.id}"></c:out></td>
        <td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
        <td><c:out value="${book.language}"></c:out></td>
        <td><c:out value="${book.numberOfPages}"></c:out></td>
    </tr>
    </c:forEach>

    <!-- loop over all the books to show the details as in the wireframe! -->
    </tbody>
</table>


</body>
</html>
